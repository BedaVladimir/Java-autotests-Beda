package manager;

import org.openqa.selenium.By;

public class LoginHelper {
    private final ApplicationManager manager;
    public LoginHelper(ApplicationManager manager) {
        this.manager = manager;
    }
    void login(String user, String password) {
        manager.driver.findElement(By.xpath("//input[@name='user']")).sendKeys(user);
        manager.driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
        manager.driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}
