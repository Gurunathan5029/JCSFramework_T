package SupportLibraryClasses;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParsing {
	
	Hashtable<String, Object> DBValues = new Hashtable<String, Object>();
	File input = new File("C:\\JCS Selenium Automation Framework\\cucumber-webtests\\target\\site\\serenity\\index.html");
	Document doc;			
			

	public void automationHeader() throws IOException
	{
		doc = Jsoup.parse(input, "UTF-8");
		Element content = doc.getElementById("projectname-banner");
		Elements spantag = content.getElementsByTag("span");
		String Haedertext = spantag.text();
		DBValues.put("ts_name", Haedertext);
	}
	
	public void totalCount() throws IOException
	{
		doc = Jsoup.parse(input, "UTF-8");
		System.out.println("Count"+doc);
		Elements content = doc.getElementsByClass("summary-leading-column");
		for(Element parenttag:content)
		{
			if(parenttag.text().equals("Total"))
			{
				Element totalcount = parenttag.siblingElements().get(0);
				System.out.println(totalcount.text());
				DBValues.put("ts_count", totalcount);
				break;
			}
		}
	}
	
	

}
