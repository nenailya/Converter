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
    public Double convert(@PathVariable(name = "from") String from,
                          @PathVariable(name = "to") String to,
                          @PathVariable(name = "x") String x
    ) throws IOException {
        Double newX = Double.parseDouble(x.replace(",", "."));
        return converter.getConversionRate(from, to)*newX;
    }


}
