package RestAssured;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Jiiraapitesting {

	public static void main(String[] args) {
		
		RestAssured.baseURI=("https://jira.atlassian.com");

		String Response= given().basePath("/rest/api/latest/issue").
				log().all().queryParam("expand", "names","renderedFields")
		.when().get("/JRA-9").
		then().log().all().assertThat().header("Content-Type","application/json;charset=UTF-8" ).statusCode(200)
		.extract().response().asString();
		System.out.println(Response);
		
		
		
	

	}

}
