package RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Utilities.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PostHttpmethod {

	public static void main(String[] args) {
		
		//Post Http method by passing the Json from the Payload.java file
		
		pojo.postrequest pr = new pojo.postrequest();
		
		pr.setName("johnson");
		pr.setJob("automation specialist");
		
	RestAssured.baseURI=("https://reqres.in");
	RestAssured.basePath=("/api");
			
			String response=given().header("content-Type","application/json").
			//body(Payload.AddEmployee()).
					body(pr).
	when()
	.post("/users").
	then().assertThat().statusCode(201).extract().asString();
	System.out.println(response);
	
	JsonPath js = new JsonPath(response);
	int id =js.getInt("id");
	System.out.println(id);
	
	}

}
