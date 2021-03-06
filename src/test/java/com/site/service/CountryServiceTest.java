package com.site.service;

import com.site.model.domain.Country;
import com.site.service.domain.CountryService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountryServiceTest {

	@Autowired
	private CountryService service;

	@Test
	public void test_1_findAll() {
		List<Country> countries = service.findAll();
		assertEquals(countries.size(), 196);
	}

	@Test
	public void test_2_crud() {
		Country country = new Country();
		country.setCountryName("TestCountry");
		country.setLanguage("TestCountryLanguage");
		service.create(country);

		assertNotNull(country.getId());

		Country created = service.findById(country.getId());
		assertEquals(country.getCountryName(), created.getCountryName());
		assertEquals(country.getLanguage(), created.getLanguage());

		created.setCountryName("NewCountry");
		created.setLanguage("NewLanguage");

		service.update(created);

		Country updated = service.findById(created.getId());
		assertEquals(created.getCountryName(), updated.getCountryName());
		assertEquals(created.getLanguage(), updated.getLanguage());

		service.delete(created.getId());

		Country deleted = service.findById(created.getId());
		assertEquals(null, deleted);
	}
}