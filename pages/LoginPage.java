package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import hooks.TestNgHooks;

public class LoginPage extends TestNgHooks {

	public LoginPage typeUsername(String username) {
		driver.switchTo().frame("gsft_main");
		type(locateElement("xpath", "//input[@id ='user_name']"), username);
		return this;

	}

	public LoginPage typePassword(String password) {
		type(locateElement("id", "user_password"), password);
		return this;
	}

	public HomePage clickLogin() {
		click(locateElement("id", "sysverb_login"));
		return new HomePage();
	}

}
