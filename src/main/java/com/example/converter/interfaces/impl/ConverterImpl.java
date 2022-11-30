package com.example.converter.interfaces.impl;

import com.example.converter.interfaces.Converter;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ConverterImpl implements Converter
{
    public Double getConversionRate() {
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject("https://assets.ino.com/data/quote/?format=json&s=FOREX_USDEUR", String.class);
            assert response != null;
            String[] arr = response.split(" ");
            int i = Arrays.stream(arr)
                    .collect(Collectors.toList())
                    .indexOf("\"open\"");
            String str = arr[i+2].substring(1,arr[i+2].length()-3);
            return Double.parseDouble(str);
    }

}
