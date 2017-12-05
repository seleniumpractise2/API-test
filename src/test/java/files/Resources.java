package files;

public class Resources {
	
	public static String postres()
	{
		String postres="/maps/api/place/add/json";
		return postres;
	}
	
	public static String getres()
	{
		String getres= "/maps/api/place/nearbysearch/json";
		return getres;
	}
	
	public static String delres()
	{
		String delres="/maps/api/place/delete/json";
		return delres;
	}
	
	public static String postresxml()
	{
		String postres="/maps/api/place/add/xml";
		return postres;
	}
	
	public static String delresxml()
	{
		String delresxml="/maps/api/place/delete/xml";
		return delresxml;
	}
	
	public static String Sessionres() {
		String sessionres = "/rest/auth/1/session";
		return sessionres;
	}
	
	public static String createJIRAres()
	{
		String createJIRA = "/rest/api/2/issue";
		return createJIRA;
	}
	
	public static String deleteJIRAres(String id)
	{
		String delJIRA= "/rest/api/2/issue/"+id+"";
		return delJIRA;
	}
	
	public static String addcommentres(String id)
	{
		String addcom= "/rest/api/2/issue/"+id+"/comment";
		System.out.println("********In Add comment res method**********");
		return addcom;
	}
	
	public static String updatecommentres(String id1,String id2)
	{
		String updatecom= "/rest/api/2/issue/"+id1+"/comment/"+id2+"";
		System.out.println("********In update comment res method**********");
		return updatecom;
	}
	
	public static String getIssue(String id)
	{
		String addcom= "/rest/api/2/issue/"+id+"";
		System.out.println("********In get Issue method**********");
		return addcom;
	}
	

}
