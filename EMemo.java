package pageObjects;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.FileInputStream;
import java.io.IOException;

public class EMemo extends baseClass {

    public void Select_Form() {
        Select drpForm = new Select(driver.findElement(By.id("ctl00_PlaceHolderMain_ClaimsLogonSelector")));
        drpForm.selectByVisibleText("Forms Authentication");
    }

    public void GetLogin() throws IOException {

        String filePath = "./Data/LoginTest.xlsx";

        //I have placed an excel file 'Test.xlsx' in my D Driver
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Assuming the first row contains headers
            Row row = sheet.getRow(i);

            // Get the email and password from the current row
            String email = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).toString();

            // Find the email and password fields on the website
            WebElement emailField = driver.findElement(By.id("ctl00_PlaceHolderMain_signInControl_UserName"));
            WebElement passwordField = driver.findElement(By.id("ctl00_PlaceHolderMain_signInControl_password"));

            // Input the email and password
            emailField.sendKeys(email);
            passwordField.sendKeys(password);

            System.out.println("Email: "+email+ " || Password: "+password);
        }
        fis.close();
    }

    public void Signin_Btn() {
        WebElement login = driver.findElement(By.id("ctl00_PlaceHolderMain_signInControl_login"));
        click(login);
    }

    public void New_EMemo() {
        WebElement newMemo = driver.findElement(By.xpath("//*[@id=\"mySidenav\"]/ul/li[3]"));
        click(newMemo);
    }
    public void Submit_Btn(){
        WebElement submit = driver.findElement(By.id("ctl00_PlaceHolderMain_Button1"));
        click(submit);
        Accept_Alert();

    }
    public void ProcessMultipleRecords() throws IOException {
        String filePath = "./Data/TestFile.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

            // Assuming the first row contains headers
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                // Get the data from the current row
                String To = row.getCell(0).getStringCellValue();
                String Other = row.getCell(1).toString();
                String From = row.getCell(2).toString();
                String SelectBranch = row.getCell(3).toString();
                String Subject = row.getCell(4).toString();
                String Detail = row.getCell(5).toString();
                String RecName = row.getCell(6).toString();
                String RecDesig = row.getCell(7).toString();
                String AppName = row.getCell(8).toString();
                String AppDesig = row.getCell(9).toString();
                String Comment = row.getCell(10).toString();

                // Click on the "NewEMemo" link
                New_EMemo();

                // Fill the NewEMemo form
                Fill_New_EMemo_Form(To, Other, From, SelectBranch, Subject, Detail, RecName, RecDesig, AppName, AppDesig, Comment);

                // Submit the form
                Submit_Btn();
            }
            fis.close();
        }

    public void Fill_New_EMemo_Form(String To, String Other, String From, String SelectBranch, String Subject, String Detail, String RecName, String RecDesig, String AppName, String AppDesig, String Comment) {
        ///// To
        Select drpTo = new Select(driver.findElement(By.id("ctl00_PlaceHolderMain_tolistddl")));
        drpTo.selectByVisibleText(To);

        ///// Other
        WebElement otherr = driver.findElement(By.id("ctl00_PlaceHolderMain_toothertxt"));
        enter(otherr, Other);

        ///// From
        WebElement fromm = driver.findElement(By.id("ctl00_PlaceHolderMain_sndfrom"));
        enter(fromm, From);

        ///// Dept/Branch
        WebElement DepBrnch = driver.findElement(By.id("ctl00_PlaceHolderMain_flexRadioDefault2"));
        click(DepBrnch);

        ///// select Branch
        Select drpBranch = new Select(driver.findElement(By.id("ctl00_PlaceHolderMain_ddlbranch")));
        drpBranch.selectByVisibleText(SelectBranch);

        ///// Subject
        WebElement sub = driver.findElement(By.id("ctl00_PlaceHolderMain_subject"));
        enter(sub, Subject);

        ///// Details
        WebElement details = driver.findElement(By.xpath("//*[@id=\"form data\"]/div[5]/div/div/div/div/div[3]/div[2]"));
        enter(details, Detail);

        //// Add Recommender
        WebElement newRec_btn = driver.findElement(By.id("recbtn"));
        click(newRec_btn);

        //// Rec Name
        WebElement recom = driver.findElement(By.id("recname0"));
        enter(recom, RecName);

        //// Rec Desig
        WebElement recDesignation = driver.findElement(By.id("recdepartment0"));
        enter(recDesignation, RecDesig);

        //// Rec Act
        WebElement recAction = driver.findElement(By.id("recadd"));
        click(recAction);

        //// Add Approver
        WebElement newApp_btn = driver.findElement(By.id("approvalbtn"));
        click(newApp_btn);
        Alert();

        //// App Name
        WebElement appr = driver.findElement(By.id("appname0"));
        enter(appr, AppName);

        //// App Desig
        WebElement appDesignation = driver.findElement(By.id("appdepartment0"));
        enter(appDesignation, AppDesig);

        //// App Act
        WebElement appAction = driver.findElement(By.id("approvaladd"));
        click(appAction);

        //// Comment
        WebElement comment = driver.findElement(By.id("ctl00_PlaceHolderMain_commentag"));
        enter(comment, Comment);
    }
        public void My_EMemo(){
            WebElement ememo = driver.findElement(By.id("Status_tab"));
            click(ememo);
        }
}
