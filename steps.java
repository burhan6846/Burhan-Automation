package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.EMemo;
import pageObjects.ESupport;
import pageObjects.bankislamiClass;
import pageObjects.baseClass;

import java.io.IOException;

public class steps extends baseClass {
    protected Scenario scenario;
    bankislamiClass bank = new bankislamiClass();
    EMemo memo = new EMemo();
ESupport sup = new ESupport();
    @Before
    public void Setup(Scenario s){
        this.scenario=s;
        System.out.println("Scenario Start Running");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After
    public void addScreenshot(Scenario scenario){
        //validate if scenario has failed
        if(scenario.isFailed()) {
            System.out.println("Scenario got failed");
            TakesScreenshot tss = (TakesScreenshot) driver;
            final byte[] screenshot =tss.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getClass().getSimpleName());
        }
//        driver.quit();
    }

    //////////////////////// Open bank islami website ////////////////////////

    @When("open url {string}")
    public void open_url(String url) {
        System.out.println(url);
        System.out.println(driver);
        driver.get(url);
    }
    @When("enter keyword in search textbox and click on enter")
    public void enter_keyword_in_search_textbox_and_click_on_enter() {
        bank.Search_Box();
    }

    @Then("search page title should be {string}")
    public void search_page_title_should_be(String string) {
        driver.getTitle();
        System.out.println("Title is :: "+driver.getTitle());
    }
    @Then("click on link")
    public void click_on_link() {
        bank.Search_Result();
    }
    @Then("page title should be {string}")
    public void page_title_should_be(String title) {
        driver.getTitle();
        System.out.println("Title is :: "+driver.getTitle());
    }

    //////////////////////// Login to EMemo website ////////////////////////

    @When("click on dropdown and select form")
    public void click_on_dropdown_and_select_form() throws InterruptedException {
        memo.Select_Form();
        Thread.sleep(5000);
    }

    @Then("enter login details")
    public void enter_login_details() throws IOException {
        memo.GetLogin();
    }

    @Then("click on sign in button")
    public void click_on_sign_in_button() {
        memo.Signin_Btn();
    }

    @Then("open New EMeme and fill the form and click on submit button")
    public void open_new_e_meme_and_fill_the_form_and_click_on_submit_button() throws IOException {
        memo.ProcessMultipleRecords();
    }

    @Then("click on My EMemo")
    public void click_on_my_e_memo() {
        memo.My_EMemo();
    }

    //////////////////////// ESupport website ////////////////////////

    @When("open ESupport url {string}")
    public void open_e_support_url(String url) {
        System.out.println(url);
        System.out.println(driver);
        driver.get(url);
    }
    @When("click on dropdown and select form for ESupport")
    public void click_on_dropdown_and_select_form_for_e_support() {
        sup.Select_Form_ES();
    }
    @Then("enter login details of ESupport")
    public void enter_login_details_of_e_support() throws IOException {
        sup.GetLogin_ES();
    }
    @Then("click on sign in button of ESupport")
    public void click_on_sign_in_button_of_e_support() {
        sup.Signin_Btn_ES();
    }

    @Then("get the total count of previous ES tickets")
    public void get_the_total_count_of_previous_ES_tickets() {
        sup.Count_Before_Ticket();
    }

    @Then("click on create ticket ES menu link")
    public void click_on_create_ticket_ES_menu_link() throws InterruptedException {
        sup.Create_Ticket();
    }

    @Then("open ESupport create ticket and fill the form and click on submit ticket button")
    public void open_create_ticket_and_fill_the_form_and_click_on_submit_ticket_button() throws InterruptedException, IOException {
        sup.ProcessMultipleRecords();
    }
    @Then("click on ESupport Dashboard menu link")
    public void click_on_ESupport_Dashboard_menu_link() {
        sup.Dashboard_ES();
    }
    @Then("get the total count of new ES tickets")
    public void get_the_total_count_of_new_ES_tickets() {
        sup.Count_After_Ticket();
    }

    //////////////////////// Sauce Demo website ////////////////////////

    @When("open SauceDemo url {string}")
    public void open_SauceDemo_url(String url) {
        System.out.println(url);
        System.out.println(driver);
        driver.get(url);
    }
    @Then("enter login details of ESupport")
    public void enter_login_details_of_SauceDemo() throws IOException {
        sup.GetLogin_ES();
    }
}

