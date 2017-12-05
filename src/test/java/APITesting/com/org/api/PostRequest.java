package APITesting.com.org.api;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.PayLoad;
import files.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequest {
	
	Properties prop = new Properties();
	@BeforeTest
	public void beforetest() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Prashanth\\workspace_bckup\\api\\com.org.api\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
	}

	@Test
	public void test1()
	{
		RestAssured.baseURI=prop.getProperty("HOST");

		given().queryParam("key", prop.getProperty("KEY")).
		body(PayLoad.getbodydata()).
		when().post(Resources.postres()).then().
		assertThat().
		statusCode(200).and().
		contentType(ContentType.JSON).and().
		body("status", equalTo("OK"));

		//System.out.println("API responses"+resp.asString());
	}

	@Test
	public void test2()
	{
		// Adding the place
		RestAssured.baseURI=prop.getProperty("HOST");

		Response resp=	given().queryParam("key", prop.getProperty("KEY")).
				body(PayLoad.getbodydata()).
				when().post(Resources.postres()).then().
				assertThat().
				statusCode(200).and().
				contentType(ContentType.JSON).and().
				body("status", equalTo("OK")).extract().response();

		//Get the place_id from the response

		String responsestring = resp.asString();
		System.out.println("Add request response :\n" +responsestring);
		JsonPath js = new JsonPath(responsestring);
		String place_id = js.get("place_id");
		System.out.println("Place ID :" +place_id);

		// Place the place_id in delete request

		Response res = given().
		queryParam("key", prop.getProperty("KEY")).
		body(PayLoad.delbody(place_id)).
		when().post(Resources.delres()).
		then().
		assertThat().
		statusCode(200).and().
		contentType(ContentType.JSON).and().
		body("status", equalTo("OK")).extract().response();

		System.out.println("delete req response :\n" +res.asString());

	}

}
