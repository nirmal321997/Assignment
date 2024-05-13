package assigment;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class Unittesting {
	static WebDriver browser;

	@BeforeSuite
	public void Launch() {
	browser = new ChromeDriver();
	browser.manage().window().maximize();
	browser.get("https://en.wikipedia.org/wiki/Test_automation");
	WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
	}
	@Test
	public void Assignment2(){
		
		WebElement heading = browser.findElement(By.id("Unit_testing_frameworks"));
		heading.click();
		System.out.println(heading.getText());
		String wordings = browser.findElement(By.xpath("//div[@id='mw-content-text']//p[28]")).getText();
	    String[] splitthetext = wordings.split(" ");
		 List<String> unique=new ArrayList<String>(Arrays.asList(splitthetext));
		  for(int i=1; i<unique.size();i++) {
			  for(int j=0;j<i;j++) {
				  if(unique.get(i).equals(unique.get(j))) {
					  unique.remove(i);
					  i--;
					  break;
				  }
			  }
		  }
	
	
	for(String unit:unique) {
		unit=unit.toLowerCase().replaceAll("\\[.*?\\]", " ").replaceAll("\\s+","").replaceAll("[^a-zA-Z0-9]"," ");
		System.out.println(unit);
	}
	
		// Split the text into words
		  String[] answer = wordings.trim().split("\\s+");
	  
		  // Count the occurrences of each word
		  Map<String, Integer> wordCount = new HashMap<>();
		  for (String word : answer) {
		   wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		  }
	
		  // Print the word occurrences
		  for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
		   System.out.println("Word: " + entry.getKey() + ", Occurrences: " + entry.getValue());
		  }
	
		 }
	
	public static void main(String[] args) {
		
		Unittesting ut = new Unittesting();
		ut.Assignment2();
	}
		@AfterSuite
		public void close() {
			browser.quit();
		}
}