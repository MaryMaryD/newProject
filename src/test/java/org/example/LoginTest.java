package org.example;
        import org.junit.Assert;
        import org.junit.BeforeClass;
        import org.junit.Test;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static LoginPage loginPage;
    public static PersonalPage personalPage;
    public static EntryPage entryPage;
    public static DeletePage deletePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        personalPage = new PersonalPage(driver);
        entryPage = new EntryPage(driver);
        deletePage = new DeletePage(driver);
        driver.get(ConfProperties.getProperty("loginpage")); }

    @Test
    public void loginTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();

        String expectedMainTitle = "Панель управления";
        String actualMainTitle = personalPage.getMainTitle();
        Assert.assertEquals(expectedMainTitle, actualMainTitle);
        personalPage.addBlog();

        String expectedTitle = "Добавить entry";
        String actualTitle = entryPage.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        entryPage.inputTitle(ConfProperties.getProperty("title"));
        entryPage.inputSlug(ConfProperties.getProperty("slug"));
        entryPage.inputTextMarkdown(ConfProperties.getProperty("slug"));
        entryPage.inputText(ConfProperties.getProperty("slug"));
        entryPage.clickSaveBtn();

        driver.get(ConfProperties.getProperty("blogpage"));
        driver.get(ConfProperties.getProperty("deletepage"));

        deletePage.delete();
        }
    }
