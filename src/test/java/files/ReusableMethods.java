package files;

import static io.restassured.RestAssured.given;

import APITesting.com.org.api.JIRAApi;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ReusableMethods {

	public static XmlPath rawtoXML(Response resp)
	{
		String respstr = resp.asString();
		System.out.println("xml response :\n" +resp.asString());
		XmlPath x = new XmlPath(respstr);
		return x;
	}

	public static JsonPath rawtoJSON(Response resp)
	{
		String respstr = resp.asString();

		JsonPath x = new JsonPath(respstr);
		return x;
	}

	public static String getSessionID()
	{
		//RestAssured.baseURI= JIRAApi.prop.getProperty("JIRAHOST");
		System.out.println("********In get session ID method**********");
		Response resp = given().header("Content-Type","application/json").
				body(PayLoad.JIRASession()).
				when().post(Resources.Sessionres()).
				then().assertThat().
				statusCode(200).and().
				contentType(ContentType.JSON).
				extract().response();

		JsonPath js = ReusableMethods.rawtoJSON(resp);
		String str = js.get("session.value");
		System.out.println("Session ID : \n" + str);
		System.out.println("********End get session ID method**********");
		return str;
	}
	
	
	/*public static void createIssue()
	{
		Response resp = given().header("Content-Type","application/json").header("Cookie","JSESSIONID="+ReusableMethods.getSessionID()+"").
				body(PayLoad.createJIRAbody()).when().post(Resources.createJIRAres()).then().statusCode(201).extract().response();

		System.out.println("Created Issue response:\n" +resp.asString());

		JsonPath js=ReusableMethods.rawtoJSON(resp);
		String id = js.get("id");
		System.out.println("Issue ID :\t" +id);
		ReusableMethods.addComment(id);

	}*/

	public static String addComment(String id)
	{
		Response resp = given().header("Content-Type","application/json").
				header("Cookie","JSESSIONID="+ReusableMethods.getSessionID()+"").body(PayLoad.addCommentbody()).
				when().post(Resources.addcommentres(id)).then().statusCode(201).extract().response();

		JsonPath jp = ReusableMethods.rawtoJSON(resp);
		String str = jp.get("id");
		System.out.println("Comment ID:\t" +str );
		updateComment(id, str);
		return str;
	}


	

	public static void updateComment(String id1,String id2)
	{

		given().header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+ReusableMethods.getSessionID()+"").body(PayLoad.updateCommentbody()).
		when().put(Resources.updatecommentres(id1, id2)).then().statusCode(200);
	}

}
