package com.example.European.Union.countries;

import com.example.European.Union.countries.Controller.EuropeanUnionController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EuropeanUnionCountriesTop10ApplicationTests {

	@Autowired
	private EuropeanUnionController europeanUnionController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(europeanUnionController).isNotNull();
	}
}
