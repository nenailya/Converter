package com.example.converter.interfaces;

import java.io.IOException;

public interface Converter {
    Double getConversionRate(String from, String to) throws IOException;

}
