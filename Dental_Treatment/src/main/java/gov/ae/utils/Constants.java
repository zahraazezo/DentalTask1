package gov.ae.utils;
import gov.ae.utils.XMLReader;

public class Constants {
	public static String SITE_URL;
	// Admin credentials
	public static String ADMIN_USERNAME;
	public static String ADMIN_PASSWORD;

	public static void setConstants() throws InterruptedException {
		XMLReader xml = new XMLReader("./src/main/resources/Config.xml");

		SITE_URL = xml.getLocator("url.value");
		ADMIN_USERNAME = xml.getLocator("username.value");
		ADMIN_PASSWORD =xml.getLocator("password.value");

	}
}