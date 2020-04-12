package br.com.edsoft.framework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {
	private String valor;

	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public BasePage() {
		PageFactory.initElements(DriverContext.Driver, this);
	}

	public void recuperarElement(String tipoAtributo, String atributo, String texto) {
		String valor = DriverContext.Driver
				.findElement(By.xpath("//" + tipoAtributo + "[@" + atributo + "='" + texto + "']")).getText();
		setValor(valor);
	}

	public void clicarElement(String tipoAtributo, String atributo, String texto) {
		DriverContext.Driver.findElement(By.xpath("//" + tipoAtributo + "[@" + atributo + "='" + texto + "']")).click();
	}

	public void digitarElement(String tipoAtributo, String atributo, String valor, String texto) {
		DriverContext.Driver.findElement(By.xpath("//" + tipoAtributo + "[@" + atributo + "='" + valor + "']")).sendKeys(texto);
	}

	public void digitarElementXpath(String xpath, String texto) {
		DriverContext.Driver.findElement(By.xpath(xpath)).sendKeys(texto);
	}
	
	public void clicarElementXpath(String caminho) {
		DriverContext.Driver.findElement(By.xpath(caminho)).click();
	}
	
	public void selecionarCombo(String name, String selecionado) {
		WebElement element = DriverContext.Driver.findElement(By.name(name));
		Select combo = new Select(element);
		combo.selectByVisibleText(selecionado);
	}
	
	
}
