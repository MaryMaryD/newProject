package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePage {
    public WebDriver driver;
    public DeletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//tr[1]/td[1]/input")
    private WebElement checkBox;

    @FindBy(xpath = "//select")
    private WebElement select;

    @FindBy(xpath = "//option[text()='Удалить выбранные Entries']")
    private WebElement deleteOption;

    @FindBy(xpath = "//button[@title='Выполнить выбранное действие']")
    private WebElement deleteBtn;

    @FindBy(xpath = "//input[@value='Да, я уверен']")
    private WebElement yesBtn;

    public void delete() {
        checkBox.click();
        select.click();
        deleteOption.click();
        deleteBtn.click();
        yesBtn.click();
    }
}
