package br.com.inmetrics.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import br.com.edsoft.framework.base.BasePage;
import br.com.edsoft.framework.base.DriverContext;

public class UsuarioPage extends BasePage {

	public String valorRandom = "";

	@FindBy(how = How.NAME, using = "title")
	public WebElement preencherTitle;

	@FindBy(how = How.NAME, using = "text")
	public WebElement preencherTell;

	public UsuarioPage btnAddTask() {
		clicarElement("a", "class", "waves-effect waves-light red darken-2 btn");
		return new UsuarioPage();
	}

	public UsuarioPage addTask() {
		clicarElementXpath("/html/body/div[1]/div/div/div[2]/button");
		return new UsuarioPage();
	}

	public UsuarioPage preemcherTitle() {
		gerarValor();
		preencherTitle.sendKeys(valorRandom);
		return new UsuarioPage();
	}

	public UsuarioPage selecionarData() {
		try {
			Thread.sleep(3000);
			Actions action = new Actions(DriverContext.Driver);
			WebElement element = DriverContext.Driver
					.findElement(By.xpath("//input[@placeholder='What is the maximum date to do it?']"));
			clicarElement("input", "placeholder", "What is the maximum date to do it?");
			action.doubleClick(element).perform();
			Thread.sleep(3000);
			clicarElement("button", "class", "btn-flat picker__today waves-effect");
			Thread.sleep(3000);
			DriverContext.Driver.findElement(By.cssSelector(".picker__close")).click();
		} catch (Exception e) {
			System.out.println("Erro date: " + e.getMessage());
		}
		return new UsuarioPage();
	}

	public UsuarioPage selecionarHorario() {
		try {
			Thread.sleep(3000);
			WebElement element = DriverContext.Driver
					.findElement(By.xpath("//input[@placeholder='What is the maximum time to do it?']"));
			Actions builder = new Actions(DriverContext.Driver);
			builder.moveToElement(element).clickAndHold().perform();
			clicarElementXpath("//*[@id=\"addtask\"]/div[1]/div[3]/div[2]/div/div/div/div/div/div[2]/div[2]/button[3]");
		} catch (Exception e) {
			System.out.println("Erro ao selecionar horário: " + e.getMessage());
		}
		return new UsuarioPage();
	}

	public UsuarioPage digiteTell() {
		gerarValor();
		preencherTell.sendKeys(valorRandom);
		return new UsuarioPage();
	}

	public UsuarioPage notOrDone() {
		clicarElement("select", "name", "done");
		selecionarCombo("done", "Yes");
		return new UsuarioPage();
	}

	public UsuarioPage saveTask() {
		clicarElement("a", "class", "modal-action waves-effect waves-green btn-flat");
		return new UsuarioPage();
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
