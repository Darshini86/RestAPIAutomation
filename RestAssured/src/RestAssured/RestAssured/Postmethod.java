package RestAssured;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Postmethod {

	//Post Http method by passing the Json payload in the Body
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		RestAssured.baseURI=("https://reqres.in");
		RestAssured.basePath=("/api");
				
				String response=given().header("content-Type","application/json").
				body("{\n"
						+ "\"name\": \"morpheus\",\n"
						+ "\"job\": \"leader\"\n"
						+ "}\n"+
						"").
		when().post("/users").
		then().assertThat().statusCode(200).extract().asString();
		System.out.println(response);
	}

}
