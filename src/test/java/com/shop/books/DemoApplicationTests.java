package com.shop.books;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Base64;

import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
class DemoApplicationTests {
	/*
	
	int port = 8080 ;
	
	@Before
	public void setUp() throws Exception {
		RestAssured.port = port;
	}

	@Test
	void contextLoads() {
	}
	
	private static String basicAuth(String username, String password) {
	    return "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
	}
	
	@Test
	void validateUsingHttpClient() throws Exception{
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("user", "password");
		provider.setCredentials(AuthScope.ANY, credentials);
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().
				uri(URI.create("http://localhost:8080/books/hello")).header("Authorization", basicAuth("user", "password")).build();
		HttpResponse response = client.send(request, BodyHandlers.ofString());
		
		String output = (String)response.body();
		System.out.println("validate() response: " +output);
		
		
//		CredentialsProvider provider = new BasicCredentialsProvider();
//		UsernamePasswordCredentials credentials
//		 = new UsernamePasswordCredentials("user1", "user1Pass");
//		provider.setCredentials(AuthScope.ANY, credentials);
		 
		org.apache.http.client.HttpClient apacheHttpClient = HttpClientBuilder.create()
		  .setDefaultCredentialsProvider(provider)
		  .build();

		org.apache.http.HttpResponse apacheResponse = apacheHttpClient.execute(
		  new HttpGet("http://localhost:8080/books/hello"));
		System.out.println("Apache Response :" + apacheResponse);
		int statusCode = apacheResponse.getStatusLine()
		  .getStatusCode();
		 
		assertThat(statusCode, equalTo(HttpStatus.SC_OK));
		
		//Assertions.assertTrue(output.equals("Hello World"));
		//Assert.assertEquals(" Test Failure", response.body(), "Hello World");
	}
	
	@Test
	void validateUsingRestAssured() throws Exception {
		
		//when().get("/books/hello").then().assertThat().body(is("Hello World"));
		
		//given().auth().preemptive().basic("user","password").header("Accept", ContentType.JSON.getAcceptHeader()).
		//contentType(ContentType.JSON).get("/books/hello").then().assertThat().body(is("Hello World"));
		
		given().auth().basic("user", "password").get("/books/hello").then().assertThat().body(is("Hello World!"));
		
		
		
		
	}
	
	 @Autowired
	    private TestRestTemplate restTemplate;

	    @Test
	    public void helloTest() throws Exception {
	    
//	    restTemplate.getInterceptors().add(
//	    			  new BasicAuthorizationInterceptor("username", "password"));
	    	
	    String str = restTemplate.getForObject("/hello", String.class);
	   //     ResponseEntity<String> responseEntity = restTemplate.exchange(
	   //            "/hello", HttpMethod.GET, null,
	   //            new ParameterizedTypeReference<String>(){});
	    //   String str = responseEntity.getBody();
	     //
	        System.out.println("helloTest() Response: " + str);
	        Assertions.assertFalse("Hello World!".equals(str));
	    }

*/
}
