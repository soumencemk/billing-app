package com.soumen.simplebilling.restcontroller;

import com.soumen.simplebilling.entity.Rates;
import com.soumen.simplebilling.entity.RatesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simple-billing")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RatesRestController {
    private final RatesRepository ratesRepository;

    @GetMapping("/rates")
    public List<Rates> getAllRates() {
        return ratesRepository.findAll();
    }
}
