package pageObjects;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.IOException;

import static pageObjects.baseClass.driver;

public class SauceDemo {
    public void GetLogin_ES() throws IOException {

        String filePath = "./Data/LoginTest.xlsx";

        //I have placed an excel file 'Test.xlsx' in my D Driver
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        System.out.println("AA");
        for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Assuming the first row contains headers
            Row row = sheet.getRow(i);
            System.out.println("BB");
            // Get the email and password from the current row
            String email = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).toString();
            System.out.println("CC");
            // Find the email and password fields on the website
            WebElement emailField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));

            // Input the email and password
            emailField.sendKeys(email);
            passwordField.sendKeys(password);

            System.out.println("Email: "+email+ " || Password: "+password);
        }
        fis.close();
    }

    public void Signin_Btn_ES() {
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
    }

}
