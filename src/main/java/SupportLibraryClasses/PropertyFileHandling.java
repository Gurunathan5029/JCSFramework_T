package SupportLibraryClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileHandling {
	static Properties prop = new Properties();
	static InputStream input = null;

	public String getProperty(String field) {
		try {
			input = new FileInputStream(new File("./serenity.properties"));
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(field);
	}

}
