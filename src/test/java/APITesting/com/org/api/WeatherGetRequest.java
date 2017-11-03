package APITesting.com.org.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class WeatherGetRequest {

	//get request for weather by city name
	/*	@Test
	public void getreq()
	{
		Response resp = when().
				get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=9f6e5e4158868a58923cca0d3f5d0d77");

		System.out.println("Response Code :" +resp.getStatusCode());

		Assert.assertEquals(resp.getStatusCode(), 200);
	}

	//using parameters with rest assured
	@Test
	public void getreqparam()
	{
		Response resp = given().
				param("q", "London").
				param("appid","9f6e5e4158868a58923cca0d3f5d0d77").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");

		System.out.println("Response Code :" +resp.getStatusCode());

		Assert.assertEquals(resp.getStatusCode(), 200);
	}

	//using assert true  with rest assured
	@Test
	public void getreqassert()
	{
		given().
		param("q", "London").
		param("appid","9f6e5e4158868a58923cca0d3f5d0d77").
		when().
		get("http://api.openweathermap.org/data/2.5/weather").
		then().
		assertThat().statusCode(200);

	}
	// Printing the API response
	@Test
	public void getreqresp()
	{
		Response resp = given().
				param("q", "London").
				param("appid","9f6e5e4158868a58923cca0d3f5d0d77").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");

		System.out.println(resp.asString());
	}

	// API using cityid
	@Test
	public void getreqcityid()
	{
		Response resp = given().
				param("id", "2172797").
				param("appid","9f6e5e4158868a58923cca0d3f5d0d77").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");

		System.out.println(resp.asString());
	}

	@Test
	public void printweather()
	{
		String str = given().
				parameter("id", "2172797").
				parameter("appid", "9f6e5e4158868a58923cca0d3f5d0d77").
				when().
				get("http://api.openweathermap.org/data/2.5/weather").
				then().
				contentType(ContentType.JSON).extract().path("weather[0].description");

		System.out.println("Weather Desc :" + str);
	}*/

	@Test
	public void convertAPI()
	{
		Response resp = given().
				parameter("id", "2172797").
				parameter("appid", "9f6e5e4158868a58923cca0d3f5d0d77").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");

		String respbyID = resp.
				then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description");
		
		System.out.println("Weather Desc :" + respbyID);
		
		String lat =String.valueOf(resp.
				then().
				contentType(ContentType.JSON).
				extract().
				path("coord.lat"));

		System.out.println("lat :" + lat);
		
		String lon = String.valueOf(resp.
				then().
				contentType(ContentType.JSON).
				extract().
				path("coord.lon"));

		System.out.println("lon :" + lon);
		
		
		String reportbydesc = given().
				parameter("lat", lat).
				parameter("lon", lon).
				parameter("appid", "9f6e5e4158868a58923cca0d3f5d0d77").
				when().
				get("http://api.openweathermap.org/data/2.5/weather").
				then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description");
		
		System.out.println("Weather reportbydesc :" + reportbydesc);
		
		
		Assert.assertEquals(respbyID, reportbydesc);
		
		

	}



}
