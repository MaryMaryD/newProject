package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PersonalPage {

    public WebDriver driver;
    public PersonalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id='content']/h1")
    private WebElement mainTitle;

    @FindBy(xpath = "//a[@href='/admin/blog/entry/add/']")
    private WebElement addBtn;

    public String getMainTitle() {
        String mainTitleH1 = mainTitle.getText();
        return mainTitleH1;
    }

    public void addBlog() {
        addBtn.click(); }
    }
