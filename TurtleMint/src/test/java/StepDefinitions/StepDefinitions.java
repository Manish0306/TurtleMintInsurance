package StepDefinitions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestRunner.RunnerClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;



public class StepDefinitions extends RunnerClass {
	//public static WebDriver driver; 
	WebDriverWait Wait=new WebDriverWait(driver,400);
  
	@Given("^User land on the turtlemint homepage$")
	public void URLLaunch() {
		
	
	}

	@And("^Select life insurance option$")
	public void InsuranceOption() {
		
		driver.findElement(By.xpath("(//a[@href='/life-insurance'])[3]")).click();
		
		//Alert pop-up handle
		Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='tcb-icon' and @data-name='close']")));
		driver.findElement(By.xpath("//*[@class='tcb-icon' and @data-name='close']")).click();	
		

	}

	@Then("^User select term life Plans from the option and fill in the profile$")
	public void TermLife  () throws InterruptedException {
	//hread.sleep(7000);
Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class='plan-box'])[1]")));
		WebElement element=driver.findElement(By.xpath("(//div[@class='plan-box'])[1]"));
		
		Actions action=new Actions(driver);
		action.moveToElement(element).click().build().perform();
	
		
		//WebElement element1 = driver.findElement(By.xpath("(//div[@class='hover-content'])[1]"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		 //driver.findElement(By.xpath("(//div[@class='plan-box'])[1]")).click();
	}

	@Then("^User select (.*) based on parameter passed$")
	public void GenderSelection(String Gender) {
	//ait.until(ExpectedConditions.
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@id='Radio-M']/span")));
	System.out.println("Page loaded successfully");
		if(Gender.equalsIgnoreCase("Male"))
		{
			driver.findElement(By.xpath("//label[@id='Radio-M']/span")).click();
			System.out.println("Gender Male is Selected");
		}else if(Gender.equalsIgnoreCase("Female"))
		{
			driver.findElement(By.xpath("//label[@id='Radio-F']/span")).click();
			System.out.println("Gender Female is selected ");
			
		}
		else
		{
			System.out.println("Gender is not selected");
		}
	

	}

	@Then("^User select Date of birth$")
	public void DateofBirthSelection() {
		  Calendar cal = Calendar.getInstance();
		   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		   System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

		   cal.add(Calendar.YEAR, -25);
		   System.out.println("25yrs from now date was "+dateFormat.format(cal.getTime())); 
		   String date=dateFormat.format(cal.getTime());
		   //split the date
		   String[] date1 = date.split("/");
		  
		   driver.findElement(By.xpath("//input[@placeholder='Enter Date']")).click();
		   //Store the year 
		   Select year=new Select(driver.findElement(By.xpath("(//select[@class='sc-RefOD eNSAzb'])[1]")));
		   year.selectByValue(date1[2]);
		   
		   List<WebElement> opt = driver.findElements(By.xpath("//div[@class='react-datepicker__week']/div"));
			for(WebElement options:opt)
			{
				if(options.getText().equalsIgnoreCase(date1[0]))
				{
					options.click();
					System.out.println("Date has been selected"+date1[0]);
					break;
					
				}
				
			}		 		   
		   
	}

	@Then("^User select (.*) tobacco smoke based on Parameter$")
	public void TobaccoSmokeSelect(String Smoke) {
		if(Smoke.equalsIgnoreCase("Yes"))
		{
			driver.findElement(By.xpath("//label[@id='Radio-true']")).click();
			System.out.println("Gender Male is Selected");
		}else if(Smoke.equalsIgnoreCase("No"))
		{
			driver.findElement(By.xpath("//label[@id='Radio-false']")).click();
			System.out.println("Gender Female is selected ");
			
		}

	}
	
	@Then("^User select (.*) Annual income based on the parameter passed$")
	public void AnnualIncome(String Income) {
		//Select income=new Select(d));
	driver.findElement(By.xpath("//*[@class='sc-eqIVtm jcGaku']/span")).click();
		
		List<WebElement> opt = driver.findElements(By.xpath("//*[@class='sc-hzDkRC dDbdhS']//li"));
		System.out.println(opt);
	      int s = opt.size();
	      System.out.println(s);
	      // Iterating through the list selecting the desired option
	      for( int j = 0; j< opt.size();j++){
	         // if the option is By Subject click that option
	         if( opt.get(j).getText().equals(Income)){
	            opt.get(j).click();
	            break;
		
	         }
	      }
		
	//ctions act = new Actions(driver);
     // act.sendKeys(Keys.DOWN,Keys.DOWN,Keys.ENTER).build().perform();
		
		

	}
	
	@And("^click on Next button$")
	public void NextButton() {
		
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		System.out.println("Next button is click");
		
		
		
		

	}

	@Then("^User Select(.*) Sum Assured$")
	public void SumAssured(String Sum_Assured) {

		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-eqIVtm jcGaku']")));
		driver.findElement(By.xpath("//div[@class='sc-eqIVtm jcGaku']")).click();
		List<WebElement> opt = driver.findElements(By.xpath("//ul[@class='sc-jhAzac bDmIfQ']//li"));
		System.out.println(opt);
	      int s = opt.size();
	      System.out.println(s);
	      for( int j = 0; j< opt.size();j++){
	         // if the option is By Subject click that option
	         if( opt.get(j).getText().equals(Sum_Assured)){
	            opt.get(j).click();
	            break;
		
	         }
	      }
	

	}
	@Then("^Enter contact details and click Next")
	public void contactdetails()
	{
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Name']")));
		driver.findElement(By.xpath("//*[@name='customerName']")).sendKeys("Manish");
		driver.findElement(By.xpath("//*[@name='paidUserMobile']")).sendKeys("8750009643");
		driver.findElement(By.xpath("//*[@name='paidUserEmail']")).sendKeys("mkm.mourya7@gmail.com");
	}
	@Then("^click on View details button based on(.*)$")
	public void InsuranceName(String Insurance_Name) throws InterruptedException {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Modify']")));
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK, GOT IT!']")));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//button[text()='OK, GOT IT!']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='clients-logo flex layout-align-center-center']/img]")));
		/*List<WebElement> opt = driver.findElements(By.xpath("//div[@class='clients-logo flex layout-align-center-center']/img"));
		System.out.println(opt);
		int s = opt.size();
	      System.out.println("size is"+s);
	      
	      for( int j = 1; j< opt.size();j++){
	    	  
	    	String InsName=  opt.get(j).getAttribute("alt");
	       System.out.println(InsName);
	         if(InsName.equalsIgnoreCase(Insurance_Name)){
	        	 String xPathWithVariable = "(//button[text()='View Details'])" + "[" + j + "]";
	        	 driver.findElement(By.xpath(xPathWithVariable)).click();*/
		
	     if(Insurance_Name.equals("PNBMETLI"))    
	     {
	    	 driver.findElement(By.xpath("(//button[text()='View Details'])[1]")).click();
	     }
	     else if(Insurance_Name.equals("AEGONLI"))    
	     {
	    	 driver.findElement(By.xpath("(//button[text()='View Details'])[2]")).click();
	     }
	     else if(Insurance_Name.equals("BAJAJLI"))    
	     {
	    	 driver.findElement(By.xpath("(//button[text()='View Details'])[3]")).click();
	     }
	     else if(Insurance_Name.equals("MAXLIFELI"))    
	     {
	    	 driver.findElement(By.xpath("(//button[text()='View Details'])[4]")).click();
	     }
	     else if(Insurance_Name.equals("TATAAILI"))    
	     {
	    	 driver.findElement(By.xpath("(//button[text()='View Details'])[5]")).click();
	     }
	     else if(Insurance_Name.equals("HDFCLI"))    
	     {
	    	 driver.findElement(By.xpath("(//button[text()='View Details'])[6]")).click();
	     }
	     else if(Insurance_Name.equals("TATAAIALI"))    
	     {
	    	 driver.findElement(By.xpath("(//button[text()='View Details'])[7]")).click();
	     }
	     else if(Insurance_Name.equals("LICLI"))    
	     {
	    	 driver.findElement(By.xpath("(//button[text()='View Details'])[8]")).click();
	     }
	     Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='shareQuotes']")));
	   System.out.println(driver.getCurrentUrl()); 
	}
}



	
	

