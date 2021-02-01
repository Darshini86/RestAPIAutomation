package RestAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class RestAssuredBasics 
{
	public static void main(String[] args) {
	
	RestAssured.baseURI=("http://dummy.restapiexample.com");

	String Response= given().basePath("/api/v1/employee/").pathParam("id",4).
			log().all()
	.when().get("{id}").
	then().log().all().assertThat().header("Content-Type","application/json" ).statusCode(200)
	.extract().response().asString();
	System.out.println(Response);
	JsonPath js= new JsonPath(Response);
	
	String  name=js.get("data.employee_name");
	System.out.println("The name of the employee is " + name);
	String Expected="Cedric Kelly";
	Assert.assertEquals(name, Expected);
		
}

}
