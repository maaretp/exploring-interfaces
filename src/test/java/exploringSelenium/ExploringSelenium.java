package exploringSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ExploringSelenium  {
    public static void main(String[] args) throws Exception {
   
        WebDriver driver = new ChromeDriver();

        driver.get("https://maaretp.com/TestThisBox.html");

        WebElement textBox = driver.findElement(By.id("box"));

        textBox.sendKeys("Cheese!");
        
        WebElement okButton = driver.findElement(By.id("button"));
        okButton.click();
        
                
        WebElement output = driver.findElement(By.id("output"));
        String outputText = output.getText();
        System.out.println("You got: " + outputText);
        
        driver.quit();
    }
}