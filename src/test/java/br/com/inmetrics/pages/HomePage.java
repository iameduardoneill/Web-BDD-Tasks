package br.com.inmetrics.pages;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import br.com.edsoft.framework.base.BasePage;

public class HomePage extends BasePage {

	public String login;
	public String senha;

	public String valorRandom = "";

	public HomePage() {
	}

	@FindBy(how = How.ID, using = "signup")
	public WebElement btnSignUp;

	@FindBy(how = How.NAME, using = "name")
	public WebElement preencherName;

	@FindBy(how = How.NAME, using = "login")
	public WebElement preencherLogin;

	@FindBy(how = How.NAME, using = "password")
	public WebElement preencherPassword;

	@FindBy(how = How.LINK_TEXT, using = "Logout")
	public WebElement btnLogout;

	public HomePage validaTitle() {
		recuperarElement("a", "class", "brand-logo");
		assertEquals("Task it!", getValor());
		return new HomePage();
	}

	public HomePage singUp() {
		btnSignUp.click();
		return new HomePage();
	}

	public HomePage preemchoName() {
		gerarValor();
		preencherName.sendKeys(valorRandom);
		return new HomePage();
	}

	public void preemchoLogin() {
		gerarValor();
		login = valorRandom;
		preencherLogin.sendKeys(login);
	}

	public HomePage preemchoPassword() {
		gerarValor();
		senha = valorRandom;
		preencherPassword.sendKeys(valorRandom);
		return new HomePage();
	}

	public HomePage btnSave() {
		clicarElement("a", "class", "modal-action waves-effect waves-green btn-flat");
		return new HomePage();
	}

	public HomePage linkLogout() {
		clicarElementXpath("/html/body/nav/div/div/ul[1]/li[3]/a");
		return new HomePage();
	}

	public void singIn() {
		clicarElement("a", "data-target", "signinbox");
	}

	public HomePage informaLogin() {
		digitarElementXpath("//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[1]/input", login);
		return new HomePage();
	}

	public HomePage informaPassword() {
		digitarElementXpath("//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[2]/input", senha);
		return new HomePage();
	}
	
	public HomePage btnSignIn() {
		clicarElementXpath("//*[@id=\"signinbox\"]/div[2]/a");
		return new HomePage();
	}

	public void gerarValor() {
		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
		Random random = new Random();
		int index = -1;
		for (int i = 0; i < 9; i++) {
			index = random.nextInt(letras.length());
			valorRandom += letras.substring(index, index + 1);
		}
		System.out.println(valorRandom);
	}
}
