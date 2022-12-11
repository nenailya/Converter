package com.example.converter;


import com.example.converter.interfaces.impl.ConverterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.converter.controller.ConverterController;


@WebMvcTest(controllers = ConverterController.class)
public class ControllerTests {

    @Test
    public void test() {
        ConverterImpl converter = new ConverterImpl();
        Assertions.assertEquals(converter.getConversionRate("USD","EUR").getClass(),Double.class);
    }

    @Test
    public void test2() {
        ConverterImpl converter = new ConverterImpl();

        StringIndexOutOfBoundsException thrown = Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
            converter.getConversionRate("U","E");
        });
        Assertions.assertEquals("begin 1, end -3, length 0", thrown.getMessage());
    }




  //  @Test
  //  public void testConvertCelsiusToKelvin() throws Exception {
  //      Double temperaturaCelsius = 10.0;
//
  //      when(converterController.celsiusToKelvin(temperaturaCelsius)).thenReturn(283.15);
//
  //      this.mockMvc.perform(get("/converter/ctok/{tempCelsius}", temperaturaCelsius)).andExpect(status().isOk())
  //              .andExpect(content().string("283.15"));
  //  }
//
  //  @Test
  //  public void testConvertFarenheitToCelsius() throws Exception {
  //      Double temperaturaFarenheit = 10.0;
//
  //      when(converterController.farenheitToCelsius(temperaturaFarenheit)).thenReturn(-12.22);
//
  //      this.mockMvc.perform(get("/converter/ftoc/{tempFarenheit}", temperaturaFarenheit)).andExpect(status().isOk())
  //              .andExpect(content().string("-12.22"));
  //  }
//
  //  @Test
  //  public void testConvertFarenheitToKelvin() throws Exception {
  //      Double temperaturaFarenheit = 10.0;
//
  //      when(converterController.farenheitToKelvin(temperaturaFarenheit)).thenReturn(260.92);
//
  //      this.mockMvc.perform(get("/converter/ftok/{tempFarenheit}", temperaturaFarenheit)).andExpect(status().isOk())
  //              .andExpect(content().string("260.92"));
  //  }
//
  //  @Test
  //  public void testConvertKelvinToCelsius() throws Exception {
  //      Double temperaturaKelvin = 0.0;
//
  //      when(converterController.kelvinToCelsius(temperaturaKelvin)).thenReturn(-273.15);
//
  //      this.mockMvc.perform(get("/converter/ktoc/{tempKelvin}", temperaturaKelvin)).andExpect(status().isOk())
  //              .andExpect(content().string("-273.15"));
  //  }
//
  //  @Test
  //  public void testConvertKelvinToFareinheit() throws Exception {
  //      Double temperaturaFareinheit = 0.0;
//
  //      when(converterController.kelvinToFarenheit(temperaturaFareinheit)).thenReturn(-459.67);
//
  //      this.mockMvc.perform(get("/converter/ktof/{tempKelvin}", temperaturaFareinheit)).andExpect(status().isOk())
  //              .andExpect(content().string("-459.67"));
  //  }

}



