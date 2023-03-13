package com.soumen.simplebilling.restcontroller;

import com.soumen.simplebilling.entity.Payment;
import com.soumen.simplebilling.entity.PaymentRepository;
import com.soumen.simplebilling.model.ApiResponse;
import com.soumen.simplebilling.model.PaymentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simple-billing")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentRestController extends BaseRestController {
    private final PaymentRepository paymentRepository;

    @GetMapping("/payment")
    public List<Payment> getAllRates() {
        return paymentRepository.findAll();
    }

    @PostMapping("/payment")
    public ApiResponse submitPayment(@RequestBody PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setPaymentDate(paymentRequest.paymentDate());
        payment.setAmount(paymentRequest.amount());
        payment.setMeterType(paymentRequest.meterType());
        paymentRepository.save(payment);
        return successApiResponse();
    }
}
