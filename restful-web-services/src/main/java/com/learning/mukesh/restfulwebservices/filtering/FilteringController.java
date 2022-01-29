package com.learning.mukesh.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/static-filtering")
	public SomeBean retrieveSomeBeanStatic() {
		return new SomeBean("value1", "value2", "value3", "value4", "value5", "value6");
	}

	@GetMapping("/static-filtering-list")
	public List<SomeBean> retrieveAllSomeBeanStatic() {
		return Arrays.asList(new SomeBean("value11", "value12", "value13", "value14", "value15", "value16"),
				new SomeBean("value21", "value22", "value23", "value24", "value25", "value26"));
	}

	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue retrieveSomeBeanDynamic() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3", "value4", "value5", "value6");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field5");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);

		return mapping;

	}

	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue retrieveAllSomeBeanDynamic() {

		List<SomeBean> someBeanList = Arrays.asList(
				new SomeBean("value11", "value12", "value13", "value14", "value15", "value16"),
				new SomeBean("value21", "value22", "value23", "value24", "value25", "value26"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field5");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(someBeanList);
		mapping.setFilters(filters);
		return mapping;
	}

}
