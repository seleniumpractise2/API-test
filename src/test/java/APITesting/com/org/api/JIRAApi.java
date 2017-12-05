package APITesting.com.org.api;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.PayLoad;
import files.Resources;
import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JIRAApi {
	public static Properties prop = new Properties();
	@BeforeTest
	public void beforeTest1() throws IOException
	{

		FileInputStream in = new FileInputStream("C:\\Users\\Prashanth\\workspace_bckup\\api\\com.org.api\\src\\test\\java\\files\\data.properties");
		prop.load(in);

	}	
	@Test
	public static void createIssue()
	{
		RestAssured.baseURI=prop.getProperty("JIRAHOST");
		
		Response resp = given().header("Content-Type","application/json").header("Cookie","JSESSIONID="+ReusableMethods.getSessionID()+"").
				body(PayLoad.createJIRAbody()).when().post(Resources.createJIRAres()).then().statusCode(201).extract().response();

		System.out.println("Created Issue response:\n" +resp.asString());

		JsonPath js=ReusableMethods.rawtoJSON(resp);
		String id = js.get("id");
		System.out.println("Issue ID :\t" +id);
		ReusableMethods.addComment(id);
		
	}
	
		
	

	/*//@Test
	public void deleteIssue()
	{
		RestAssured.baseURI=prop.getProperty("JIRAHOST");

		given().header("Content-Type","application/json").header("Cookie","JSESSIONID="+ReusableMethods.getSessionID()+"").
				when().delete(Resources.deleteJIRAres(ReusableMethods.createIssue())).then().statusCode(204);

		System.out.println("Created Issue Deleted");

	}
*/
}
