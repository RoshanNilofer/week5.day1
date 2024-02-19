package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleHW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
	    System.out.println(windowHandles.size());
	    List<String> childWindow=new ArrayList<String>(windowHandles);
	    System.out.println("List "+childWindow.size());
	    driver.switchTo().window(childWindow.get(1));
	    driver.findElement(By.xpath("//a[text()='DemoCustomer']")).click();
	    driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
	    System.out.println(windowHandles1.size());
	    List<String> childWindow1=new ArrayList<String>(windowHandles1);
	    System.out.println("List "+childWindow.size());
	    driver.switchTo().window(childWindow1.get(1));
		driver.findElement(By.xpath("//a[text()='dp1a1contact1']")).click();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		 String title=driver.getTitle();
		 System.out.println(title);
	}

}
