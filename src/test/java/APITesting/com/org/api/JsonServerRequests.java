package APITesting.com.org.api;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import APITesting.com.org.classes.PostRequest;

import static com.jayway.restassured.RestAssured.*;

public class JsonServerRequests {

	/*@Test
	public void test1()
	{
		Response resp = given().
				when().
				get("http://localhost:3000/posts");

		System.out.println("response is : \n" +resp.asString());
	}

	@Test
	public void test2()
	{
		Response resp = given().
				body(" {\"id\" : \"2\","
						+ " \"title\" : \"dummy\","
						+ " \"author \" :\"Jhansi\" } ").
				when().
				contentType(ContentType.JSON).
				post("http://localhost:3000/posts");

		System.out.println("Respose is :" +resp.asString());


	}


	@Test
	public void test3()
	{
		PostRequest pos = new PostRequest();
		pos.setId("3");
		pos.setTitle("POST request");
		pos.setAuthor("Galma");
		Response resp = given().
						when().
				contentType(ContentType.JSON).
				body(pos).post("http://localhost:3000/posts");

		System.out.println("Respose is :" +resp.asString());


		pos.setId("4");
		pos.setTitle("POST request again");
		pos.setAuthor("Galma Jhansi");
		Response respo = given().
						when().
				contentType(ContentType.JSON).
				body(pos).post("http://localhost:3000/posts");

		System.out.println("Respose is :" +respo.asString());


	}

	@Test
	public void test4()
	{
		Response resp = given().
				when().
				get("http://localhost:3000/posts/4");

		System.out.println("response is : \n" +resp.asString());
	}
	//PUT request
	@Test
	public void test5()
	{
		PostRequest pos = new PostRequest();
		pos.setId("3");
		pos.setTitle("updated");
		pos.setAuthor("updated Author");
		Response resp = given().
				when().contentType(ContentType.JSON).
				body(pos).
				put("http://localhost:3000/posts/3");

		System.out.println("response is : \n" +resp.asString());
	}

	//PATCH request
	@Test
	public void test6()
	{

		Response resp = given().
				body("{\"title\" : \"UPdated by PATCH request\" }").
				when().
				contentType(ContentType.JSON).
				patch("http://localhost:3000/posts/4");

		System.out.println("response is : \n" +resp.asString());
	}*/

	@Test
	public void test7()
	{
		Response resp = given().
				when().delete("http://localhost:3000/posts/4");
		
		System.out.println("Delete Resposne :" +resp.asString());
	}
}
