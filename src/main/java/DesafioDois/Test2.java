package DesafioDois;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

public class Test2 {
	private static final String ID_DO_FILME = "tt1285016";
	private static final String API_KEY = "52ec71bf";
	
	@Before
	public void preConditions() {baseURI = "http://www.omdbapi.com";}
	
	@Test
	public void givenIdAndKeyThenReturnThisWant() {
	given()
		.param("i", ID_DO_FILME).param("ikey", API_KEY)
	.when()
	.then()
		.body("Title", equalTo("The Social Network"), "Year", equalTo("2010"), "Language", equalTo("English, French") );
}
	@Test
	public void givenKeyIsNotExistThenReturnErrorIncorrectID() {
		given()
			.param("i", "9999").param("ikey", API_KEY)
		.when()
		.then()
			.body("Error", equalTo("Incorrect IMDb ID."));
	}
}