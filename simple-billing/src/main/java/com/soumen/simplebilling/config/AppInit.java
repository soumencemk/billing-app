package com.soumen.simplebilling.config;

import com.soumen.simplebilling.entity.Rates;
import com.soumen.simplebilling.entity.RatesRepository;
import com.soumen.simplebilling.model.MeterType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Slf4j
public class AppInit {

    //@Bean
    ApplicationRunner initRates(RatesRepository ratesRepository) {
        return args -> {
            log.info("Initialising Rates");
            Rates electric = new Rates();
            electric.setMeterType(MeterType.ELECTRIC);
            electric.setRate(0.34d);
            electric.setStandingCharge(0.45d);
            Rates gas = new Rates();
            gas.setMeterType(MeterType.GAS);
            gas.setRate(0.1045d);
            gas.setStandingCharge(0.2848d);
            ratesRepository.save(electric);
            ratesRepository.save(gas);
        };
    }
}
