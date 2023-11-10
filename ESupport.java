package pageObjects;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.FileInputStream;
import java.io.IOException;

public class ESupport extends baseClass{

    public void Select_Form_ES() {
        Select drpForm = new Select(driver.findElement(By.id("ctl00_PlaceHolderMain_ClaimsLogonSelector")));
        drpForm.selectByVisibleText("Forms Authentication");
    }

    public void GetLogin_ES() throws IOException {

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

    public void Signin_Btn_ES() {
        WebElement login = driver.findElement(By.id("ctl00_PlaceHolderMain_signInControl_login"));
        click(login);
    }

    public void Count_Before_Ticket(){
        WebElement countbt = driver.findElement(By.id("Pending_info"));
        System.out.println("Previous Total Count of Tickets :: " + countbt.getText());

        System.out.println("Before Element");
    }

    public void Create_Ticket() throws InterruptedException {
        WebElement ticket = driver.findElement(By.xpath("//*[@id=\"mySidenav\"]/ul/li[3]/a"));
        click(ticket);
        Thread.sleep(3000);
    }

    public void Submit_Btn(){
        WebElement submit = driver.findElement(By.id("ctl00_PlaceHolderMain_Button1"));
        click(submit);
    }

    public void ProcessMultipleRecords() throws IOException, InterruptedException {
        String filePath = "./Data/CreateTicket_ES.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Assuming the first row contains headers
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            // Get the data from the current row
            String Behalf = row.getCell(0).getStringCellValue();
            String Department = row.getCell(1).toString();
            String Section = row.getCell(2).toString();
            String Category = row.getCell(3).toString();
            String Issue = row.getCell(4).toString();
            String EmployeeCode = row.getCell(5).toString();
            String iMalID = row.getCell(6).toString();
            String BranchCode = row.getCell(7).toString();
            String Designation = row.getCell(8).toString();
        //    String Detail = row.getCell(9).toString();
        //    String Extension = row.getCell(10).toString();
        //    String MemoNum = row.getCell(11).toString();

            // Click on the "New Create Ticket" link
            Create_Ticket();

            // Fill the Create Ticket form
            Fill_Create_Ticket_Form(Behalf, Department, Section, Category, Issue,EmployeeCode,
                    iMalID, BranchCode, Designation);
                    //, Detail, Extension, MemoNum);

            // Submit the form
            Submit_Btn();

            // Go to the Dashboard
            Dashboard_ES();
        }
        fis.close();
    }


    public void Fill_Create_Ticket_Form(String Behalf, String Department, String Section, String Category,
                                        String Issue, String EmployeeCode, String iMalID, String BranchCode,
                                        String Designation)
            //, String Extension, String MemoNum, String Detail)
        throws InterruptedException {
        ///// On Behalf Of
        WebElement behalf = driver.findElement(By.id("_UserNameOnBehalfOf_TopSpan_EditorInput"));
        enter(behalf, Behalf);

        ///// Department
        WebElement drpDept = driver.findElement(By.id("ctl00_PlaceHolderMain_ddldepartment"));
        selectValueFromDropdown(drpDept, Department);
        Thread.sleep(3000);

        ///// Section
        WebElement drpSec = driver.findElement(By.id("ctl00_PlaceHolderMain_ddldivisions"));
        WebElement drpSect = driver.findElement(By.xpath("//*[@id=\"ctl00_PlaceHolderMain_ddldivisions\"]"));
        selectValueFromDropdown(drpSec, Section);
        Thread.sleep(3000);

        ///// Category
        WebElement drpCat = driver.findElement(By.id("ctl00_PlaceHolderMain_ddlcategory"));
        selectValueFromDropdown(drpCat, Category);
        Thread.sleep(3000);

        ///// Issue Topic
        WebElement drpIss = driver.findElement(By.id("ctl00_PlaceHolderMain_ddlissuetopic"));
        selectValueFromDropdown(drpIss, Issue);
        Thread.sleep(3000);

        ///// Issue Details
     //   WebElement detail = driver.findElement(By.xpath("//*[@id=\"DeltaPlaceHolderMain\"]/div/div/div[4]/div/div/div/div/div[3]/div[2]"));
     //   enter(detail, Detail);

        ///// Employee Code
        WebElement ecode = driver.findElement(By.id("ctl00_PlaceHolderMain_chklist_ctl00_txtcustominput"));
        enter(ecode, EmployeeCode);

        ///// iMAL ID
        WebElement imal = driver.findElement(By.id("ctl00_PlaceHolderMain_chklist_ctl01_txtcustominput"));
        enter(imal, iMalID);

        ///// Branch Code
        WebElement bcode = driver.findElement(By.id("ctl00_PlaceHolderMain_chklist_ctl02_txtcustominput"));
        enter(bcode, BranchCode);

        ///// Designation
        WebElement desig = driver.findElement(By.id("ctl00_PlaceHolderMain_chklist_ctl03_txtcustominput"));
        enter(desig, Designation);

        ///// Extension
    //    WebElement ext = driver.findElement(By.id("ctl00_PlaceHolderMain_chklist_ctl01_txtcustominput"));
     //   enter(ext, Extension);

        ///// Memo Number
     //   WebElement memoNo = driver.findElement(By.id("#ctl00_PlaceHolderMain_chklist_ctl02_txtcustominput"));
     //   enter(memoNo, MemoNum);
    }



    public void Dashboard_ES(){
        WebElement dashboard = driver.findElement(By.xpath("//*[@id=\"mySidenav\"]/ul/li[2]"));
        click(dashboard);
    }
    public void Count_After_Ticket(){
        WebElement countat = driver.findElement(By.id("Pending_info"));
        System.out.println("New Total Count of Tickets :: " + countat.getText());
    }
}
