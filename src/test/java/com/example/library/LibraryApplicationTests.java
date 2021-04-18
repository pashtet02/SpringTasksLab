package com.example.library;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class LibraryApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void restTemplateTest() throws JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl
				= "http://localhost:8082/spring-rest/foos";
		ResponseEntity<String> response
				= restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
		System.out.println(response.getStatusCode());
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode name = root.path("name");
		assertThat(name.asText(), notNullValue());
	}

	/*@Test
	void restTemplateTest2(){
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl
				= "http://localhost:8082/spring-rest/foos";
		Foo foo = restTemplate
				.getForObject(fooResourceUrl + "/1", Foo.class);
		assertThat(foo.getName(), notNullValue());
		System.out.println(foo.getId());
	}*/

	@Test
	void restTemplateTest3(){
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl
				= "http://localhost:8082/spring-rest/foos";
		HttpHeaders httpHeaders = restTemplate.headForHeaders(fooResourceUrl);
		assertTrue(httpHeaders.getContentType().includes(MediaType.APPLICATION_JSON));
	}

}

