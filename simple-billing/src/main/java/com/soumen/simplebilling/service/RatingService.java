package com.soumen.simplebilling.service;

import com.soumen.simplebilling.entity.PaymentRepository;
import com.soumen.simplebilling.entity.Rates;
import com.soumen.simplebilling.entity.RatesRepository;
import com.soumen.simplebilling.model.Bill;
import com.soumen.simplebilling.model.MeterType;
import com.soumen.simplebilling.model.Usage;
import com.soumen.simplebilling.util.AppUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.soumen.simplebilling.model.MeterType.GAS;

@Service
@RequiredArgsConstructor
@Slf4j
public class RatingService {
    private final RatesRepository ratesRepository;
    private final PaymentRepository paymentRepository;

    public void calculateBills(List<Usage> usageList) {
        List<Rates> rates = findRates();
        usageList.forEach(usage -> {
            try {
                usage.setUnitsUsed((double) (usage.getUsageEndUnit() - usage.getUsageStartUnit()));
                usage.setNoOfDays(AppUtils.noOfDaysBetween(usage.getUsageEndDate(), usage.getUsageStartDate()));
                if (usage.getMeterType().equals(GAS)) {
                    usage.setUnitsUsed(AppUtils.cubicFeetToKwh(usage.getUnitsUsed()));
                }
                Double actualAmount = calculateAmount(usage, rates);
                Double totalPaidAmount = getTotalPaidAmount(usage.getMeterType());
                Bill bill = Bill
                        .builder()
                        .actualAmount(actualAmount)
                        .paidAmount(totalPaidAmount)
                        .balance(Precision.round((totalPaidAmount - actualAmount),2))
                        .message(totalPaidAmount > actualAmount ? "I WILL GET" : "THEY WILL GET")
                        .build();
                usage.setBill(bill);
            } catch (NullPointerException e) {
                log.error("start and or stop meter reading not present");
            }
        });

    }

    private Double getTotalPaidAmount(MeterType meterType) {
        return Precision.round(paymentRepository.findAll()
                .stream()
                .filter(payment -> payment.getMeterType().equals(meterType))
                .map(payment -> payment.getAmount())
                .mapToDouble(value -> value)
                .sum(),2);

    }

    private Double calculateAmount(Usage usage, List<Rates> ratesList) {
        return Precision.round(ratesList.stream()
                .filter(r -> r.getMeterType().equals(usage.getMeterType()))
                .map(rates -> {
                    Double unitsUsed = usage.getUnitsUsed();
                    Integer noOfDays = usage.getNoOfDays();
                    return (unitsUsed * rates.getRate()) + (noOfDays * rates.getStandingCharge());
                }).findFirst().orElse(0d),2);
    }

    public List<Rates> findRates() {
        return ratesRepository.findAll();
    }

    public Double calculateMonthly(Usage usage) {
        Double amount = usage.getBill().actualAmount();
        Integer noOfDays = usage.getNoOfDays();
        double monthlyUsage = (amount / noOfDays) * 30;
        return Precision.round(monthlyUsage,2);
    }
}
