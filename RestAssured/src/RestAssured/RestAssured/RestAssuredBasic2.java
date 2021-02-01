package RestAssured;

import io.restassured.RestAssured;
import  static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.hamcrest.*;

public class RestAssuredBasic2 {

	public static void main(String[] args) {
		
		    RestAssured.baseURI= "https://maps.googleapis.com";

		 String returnGivenData = given().log().all().
		    param("location", "-33.8670522,151.195736").
		    param("radius", "500").
		    param("key", "AIzaSyBde6fW-IAx1j-J5TqNOwmvx-_QPHozqRY").
		    when().
		    get("/maps/api/place/nearbysearch/json").
		    then().assertThat().statusCode(200).and().
		    contentType(ContentType.JSON).and().
		    body("results[0].name",equalTo("Sydney")).and().
		    body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).
		    extract().
		    response().asString();
		 
		    JsonPath responseJson = new JsonPath(returnGivenData);
		    System.out.println(returnGivenData);
		        
		    int count = responseJson.get("results.size()"); //ERROR LINE
		    System.out.println(count);
		}

	}


