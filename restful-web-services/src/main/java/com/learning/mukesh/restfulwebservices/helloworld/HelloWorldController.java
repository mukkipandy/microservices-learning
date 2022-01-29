package com.learning.mukesh.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World!!!";
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public String helloWorldPathVariable(@PathVariable String name) {
		return String.format("Hello World, %s ", name);
	}

	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World bean");
	}

	@GetMapping("/hello-world-internationalized1")
	public String helloWorldInternationalized1(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}

	@GetMapping("/hello-world-internationalized2")
	public String helloWorldInternationalized2() {
		return messageSource.getMessage("good.morning.message", null, "Default Message",
				LocaleContextHolder.getLocale());
	}
}
