package com.example.converter.controller;

import com.example.converter.interfaces.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
@RequestMapping("/converter")
public class ConverterController {
    private final Converter converter;

    @Autowired
    public ConverterController(Converter converter) {
        this.converter = converter;
    }

    @GetMapping("/convert/from/{from}/to/{to}/{x}")
    public String convert(@PathVariable(name = "from") String from,
                                 @PathVariable(name = "to") String to,
                                 @PathVariable(name = "x") String x
    ) throws IOException {
        try {
            Double newX = Double.parseDouble(x.replace(",", "."));
            return  (""+converter.getConversionRate(from, to)*newX);
        }catch (NumberFormatException e){
            return "пожалуйста, напишите число правильно";
        }
    }

    @GetMapping("/rate/from/{from}/to/{to}")
    public Double rate(@PathVariable(name = "from") String from,
                       @PathVariable(name = "to") String to
    ) throws IOException {
        return converter.getConversionRate(from, to);
    }

    @GetMapping("/percent/from/{from}/to/{to}/{x}/{percent}")
    public Double withPercent(@PathVariable(name = "from") String from,
                              @PathVariable(name = "to") String to,
                              @PathVariable(name = "x") String x,
                              @PathVariable(name = "percent") String percent
    ) throws IOException {
        Double newX = Double.parseDouble(x.replace(",", "."));
        Double newPercent = Double.parseDouble(percent.replace(",", "."))/100;
        return converter.getConversionRate(from, to)*newX*newPercent;
    }



}
