package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class CreateEventPage extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, 120);

    private By login = By.id("txtEmail");
    private By passWord = By.id("txtPassword");
    private By loginBtn= By.id("submitBtn");
    private By institute = By.cssSelector("div.institution-details__content > div:nth-child(1) > div.data-cell.title-cell.list__item-row > div");
    private By calendarTab = By.id("calendarTab");
    private By createEventBtn = By.cssSelector("span.picon.picon-new-calendar.icon-btn__icon");
    private By eventTitle = By.id("eventTitle");
    private By recipient = By.cssSelector("#Recipients > div > div > div.ng-input > input[type=text]");
    private By calendar = By.cssSelector("div.event__content > form > div > div > prt-date-picker > div > div");
    private By date = By.cssSelector("div.bs-datepicker-body tr:nth-child(4) > td:nth-child(5)");
    private By startTime = By.cssSelector("#timepickerStartTime");
    private By time = By.cssSelector("form > div > div > div.row > div:nth-child(1)  perfect-scrollbar  div.ps-content  span:nth-child(1)");
    private By endTime = By.cssSelector("#timepickerEndTime");
    private By submitEventBtn = By.cssSelector("#submitCreateEventBtn");
    private By createSuccessMsg = By.cssSelector("div[aria-label='Calendar event registered']");
    private By event = By.cssSelector("prt-calendar-week:nth-child(1)  prt-calendar-day:nth-child(1)  prt-calendar-day-item:nth-child(2) > div:nth-child(1) div:nth-child(1) div:nth-child(1) > div.d-flex.event-title");
    private By editBtn = By.cssSelector(" div.event-details__options-item.event-details__options-item--edit > button");
    private By deleteBtn = By.cssSelector("div.event-details__options-item.event-details__options-item--delete > button");
    private By confirmDeleteBtn= By.cssSelector("#modalMainBtn");
    private By menu = By.cssSelector("li.nav-item.p-relative.v-aligned.avatar-wrapper.open.show");
    private By logoutBtn = By.id("logoutBtn");
    private By header = By.cssSelector("#auth-page  span.picon.picon-parent-logo-text.logo-text");
    private By company = By.cssSelector("div.company-name");
    private By recipientName = By.cssSelector("#option_0 > div");




    @Given("^Navigate web site$")
    public void navigateWebSite() {
        driver.navigate().to("https://portal-staging.parent.cloud/login");

    }

    @And("^Login using user name \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void loginUsingUserNameAndPassword(String username, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
    driver.findElement(login).sendKeys(username);
    driver.findElement(passWord).sendKeys(password);
    driver.findElement(loginBtn).click();

    }

    @And("^click on kids palace$")
    public void clickOnKidsPalace() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(institute).click();

    }

    @And("^Click on calendar$")
    public void clickOnCalendar() {
        driver.findElement(calendarTab).click();
    }

    @And("^Click on create event$")
    public void clickOnCreateEvent() {
        driver.findElement(createEventBtn).click();
    }

    @And("^Add the required fields and save$")
    public void addTheRequiredFieldsAndSave() {
        driver.findElement(eventTitle).sendKeys("test event created");
        driver.findElement(recipient).sendKeys("kids");
        driver.findElement(recipientName).click();
        driver.findElement(calendar).click();
        driver.findElement(date).click();
        driver.findElement(startTime).click();
        driver.findElement(time).click();
        driver.findElement(submitEventBtn).click();
    }

    @Then("^Assert that event is created successfully$")
    public void assertThatEventIsCreatedSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createSuccessMsg));
       String eventCreated= driver.findElement(createSuccessMsg).getText();
       Assert.assertEquals(eventCreated,"Calendar event registered");
    }

    @And("^Click on event$")
    public void clickOnEvent() {
     wait.until(ExpectedConditions.visibilityOfElementLocated(event));
    driver.findElement(event).click();

    }

    @And("^Click on edit$")
    public void clickOnEdit() {
        driver.findElement(editBtn).click();

    }

    @And("^Edit event name and save$")
    public void editEventNameAndSave() {
        driver.findElement(eventTitle).sendKeys(" edited");
        driver.findElement(submitEventBtn).click();
    }

    @Then("^Assert that event is edited successfully$")
    public void assertThatEventIsEditedSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createSuccessMsg));
        String eventCreated= driver.findElement(createSuccessMsg).getText();
        Assert.assertTrue(eventCreated.contains("calendar event registered"));
    }

    @And("^Click on Delete$")
    public void clickOnDelete() {
        driver.findElement(deleteBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteBtn));
        driver.findElement(confirmDeleteBtn).click();
    }

    @Then("^Assert that event is deleted successfully$")
    public void assertThatEventIsDeletedSuccessfully() {
        String eventCreated= driver.findElement(createSuccessMsg).getText();
        Assert.assertTrue(eventCreated.contains("calendar event registered"));
    }

    @Then("^Click on logout$")
    public void clickOnLogout() {
        driver.findElement(menu).click();
        driver.findElement(logoutBtn).click();
    }
}
