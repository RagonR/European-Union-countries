package com.example.European.Union.countries;

import com.example.European.Union.countries.Controller.EuropeanUnionController;
import com.example.European.Union.countries.dto.EUCountry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EuropeanUnionCountriesTop10ApplicationTests {

	@Autowired
	private EuropeanUnionController europeanUnionController;

	@Test
	@DisplayName("Controller loader works")
	public void contextLoads() throws Exception {
		assertThat(europeanUnionController).isNotNull();
	}

//	@Test
//	@DisplayName("Display EU countries work")
//	public void displayEUCountriesOutput(){
//
//		List<EUCountry>	expected =
//		assertEquals()
//
//	}
}
