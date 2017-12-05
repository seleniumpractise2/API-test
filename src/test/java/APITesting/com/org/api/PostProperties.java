package APITesting.com.org.api;

import static io.restassured.RestAssured.given;
import files.Resources;
import files.ReusableMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class PostProperties {
	Properties prop = new Properties();
	@BeforeTest
	public void beforeTest1() throws IOException
	{

		FileInputStream in = new FileInputStream("C:\\Users\\Prashanth\\workspace_bckup\\api\\com.org.api\\src\\test\\java\\files\\data.properties");
		prop.load(in);

	}
	@Test
	public void test1() throws IOException
	{
		RestAssured.baseURI=prop.getProperty("HOST");
		String postdata = GenerateStringFromResource("C:\\Users\\Prashanth\\workspace_bckup\\api\\com.org.api\\src\\test\\java\\files\\req.xml");
		Response resp=	given().queryParam("key", prop.getProperty("KEY")).
				body(postdata).
				when().post(Resources.postresxml()).then().
				assertThat().
				statusCode(200).and().
				contentType(ContentType.XML).and().extract().response();

		//Get the place_id from the response
		XmlPath x=ReusableMethods.rawtoXML(resp);
		System.out.println(x.get("PlaceAddResponse.place_id"));
		
	}


	public static String GenerateStringFromResource(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}

