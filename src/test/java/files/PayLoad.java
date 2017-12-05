package files;

public class PayLoad {

	public static String getbodydata()
	{
		String b = "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -33.8669710,\r\n" + 
				"    \"lng\": 151.1958750\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Google Shoes!\",\r\n" + 
				"  \"phone_number\": \"(02) 9374 4000\",\r\n" + 
				"  \"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\",\r\n" + 
				"  \"types\": [\"shoe_store\"],\r\n" + 
				"  \"website\": \"http://www.google.com.au/\",\r\n" + 
				"  \"language\": \"en-AU\"\r\n" + 
				"}";
		
		return b;
		
	}
	
	public static String delbody(String place_id)
	{
		String delb = "{\r\n" + 
				" \"place_id\":\""+place_id+"\"\r\n" + 
				"}";
		
		return delb;
	}
	
	public static String JIRASession()
	{
		String sess = "{ \"username\": \"practiseseleinum5\", \"password\": \"practiseseleinum5\" }";
		return sess;
	}
	
	public static String createJIRAbody()
	{
		String s= "{\r\n" + 
				" \"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"AT\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"first automation defect\",\r\n" + 
				"        \"description\" : \"first automation JIRA API defect\",\r\n" + 
				"        \"issuetype\": {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"        }\r\n" + 
				" }\r\n" + 
				"}";
		
		return s;
	}
	public static String addCommentbody()
	{
		String s= "{\r\n" + 
				"    \"body\": \"Adding 1st comment through rest API\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
		System.out.println("**********In add comment body method*************");
		
		return s;
	}
	
	public static String updateCommentbody()
	{
		String s= "{\r\n" + 
				"    \"body\": \"Updating comment through rest API\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
		System.out.println("**********In update comment body method*************");
		
		return s;
	}
}
