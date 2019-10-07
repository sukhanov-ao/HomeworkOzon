package HomeworkOzon;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class App {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "D:\\Programs\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://www.ozon.ru");
        WebElement close = driver.findElement(By.className("close"));
        close.click();
        WebElement catalog = driver.findElement(By.xpath("//button[@value = 'Каталог']"));
        catalog.click();
        WebElement books = driver.findElement(By.xpath("//span[contains(text(), 'Книги')]"));
        Actions action = new Actions(driver);
        action.moveToElement(books).build().perform();
        Thread.sleep(1000);
        WebElement category = driver.findElement(By.xpath("//span[contains(text(), 'Компьютерные технологии')]"));
        category.click();
        Thread.sleep(1500);
        WebElement checkboxBestsellers = driver.findElement(By.xpath("//*[contains(text(), 'Бестселлеры')]"));
        checkboxBestsellers.click();
        Thread.sleep(1000);
        WebElement checkboxSoftwareLanguages = driver.findElement(By.xpath("//*[contains(text(), 'Языки программирования')]"));
        checkboxSoftwareLanguages.click();
        Thread.sleep(1000);
        WebElement toChart = driver.findElement(By.xpath("//a[@href ='/context/detail/id/145826480/']//button[@type='button']"));
        toChart.click();
        Thread.sleep(1000);
        WebElement chart = driver.findElement(By.xpath("//a[@href = '/cart']"));
        try {
            toChart.isDisplayed();
            System.out.println("Книга в корзину не добавлена");
        } catch (StaleElementReferenceException e) {
            System.out.println("Книга добавлена в корзину");
            chart.click();
        }
        Thread.sleep(2000);
        WebElement book = driver.findElement(By.xpath("//span[contains(text(), 'Java. Полное руководство')]"));
        if (book.isDisplayed()) {
            System.out.println("Тест прошел успешно. Книга в корзине. Остается оформить покупку");
        }
    }
}