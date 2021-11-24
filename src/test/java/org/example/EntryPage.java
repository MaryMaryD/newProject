package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntryPage {
    public WebDriver driver;
    public EntryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//input[@id='id_title']")
    private WebElement titleField;

    @FindBy(xpath = "//input[@id='id_slug']")
    private WebElement slugField;

    @FindBy(xpath = "//textarea[@id='id_text_markdown']")
    private WebElement textMarkdownField;

    @FindBy(xpath = "//textarea[@id='id_text']")
    private WebElement textField;

    @FindBy(xpath = "//input[@name='_save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//*[@id='content']/h1")
    private WebElement mainTitle;

    public String getTitle() {
        String TitleH1 = mainTitle.getText();
        return TitleH1;
    }

    public void inputTitle(String title) {
        titleField.sendKeys(title); }

    public void inputSlug(String slug) {
        slugField.sendKeys(slug); }

    public void inputTextMarkdown(String textMarkdown) {
        textMarkdownField.sendKeys(textMarkdown); }

    public void inputText(String text) {
        textField.sendKeys(text); }

    public void clickSaveBtn() {
        saveBtn.click(); }
}
