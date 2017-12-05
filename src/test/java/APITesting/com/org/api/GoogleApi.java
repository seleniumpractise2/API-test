package APITesting.com.org.api;
import files.ReusableMethods;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class GoogleApi {

	private static Logger log = LogManager.getLogger(APILog.class.getName());
	Properties prop= new Properties();

	@BeforeTest
	public void beforetest() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Prashanth\\workspace_bckup\\api\\com.org.api\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
	}

	@Test
	public void test1()
	{
		log.info("Host information : " +prop.getProperty("HOST"));
		RestAssured.baseURI = prop.getProperty("HOST");

		Response resp =given().
		param("location","-33.8670522,151.1957362").
		param("radius","500").
		param("key",prop.getProperty("KEY")).log().all().
		when().
		get(Resources.getres()).
		then().assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
		body("results[0].name",equalTo("Sydney")).and().
		body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
		header("Server", "pablo").log().all().extract().response();
		JsonPath js =ReusableMethods.rawtoJSON(resp);
		
		int count = js.get("results.size()");
		log.info("Count of author names" +count);
		
		for (int i=0;i<20;i++)
		{
			log.info("NAMES :" +js.get("results["+i+"].name"));
		}
		
		
		
		
		
	}

}
