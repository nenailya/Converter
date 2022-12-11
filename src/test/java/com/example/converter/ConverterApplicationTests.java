package com.example.converter;

import com.example.converter.interfaces.impl.ConverterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConverterApplicationTests {

	@Test
	void contextLoads() {
	}
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

}
