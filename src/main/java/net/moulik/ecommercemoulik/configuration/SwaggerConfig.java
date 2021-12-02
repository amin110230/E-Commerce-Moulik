package net.moulik.ecommercemoulik.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	public static final String DEFAULT_PATH = "/api/.*";
	private final String DESCRIPTION = "ecommercemoulik Api documentation";
	private final String VERSION = "0.0.1-SNAPSHOT";

	@Bean
	public Docket swaggerSpringfoxDocket() {

		Contact contact = new Contact("ecommercemoulik", "", "");

		ApiInfo apiInfo = new ApiInfo("ecommercemoulik", DESCRIPTION, VERSION, "", contact, "", "", new ArrayList<>());

		Docket docket = new Docket(DocumentationType.OAS_30).pathMapping("/").apiInfo(apiInfo).forCodeGeneration(true)
				.genericModelSubstitutes(ResponseEntity.class).ignoredParameterTypes(Pageable.class)
				.ignoredParameterTypes(java.sql.Date.class)
				.directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
				.directModelSubstitute(java.time.LocalDateTime.class, Date.class).useDefaultResponseMessages(false);

		docket = docket.select().paths(regex(DEFAULT_PATH)).build();
		return docket;
	}

}
