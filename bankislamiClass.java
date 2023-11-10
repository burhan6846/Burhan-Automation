package pageObjects;

        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebElement;
public class bankislamiClass extends baseClass{

    public void Search_Box(){
        WebElement searchbox = driver.findElement(By.id("APjFqb"));
        searchbox.sendKeys("bankislami");
        searchbox.sendKeys(Keys.ENTER);
    }

    public void Search_Result(){
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/a/h3")).click();
    }

}