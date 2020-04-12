package br.com.inmetrics.steps;

import org.openqa.selenium.chrome.ChromeDriver;

import br.com.edsoft.framework.base.DriverContext;
import br.com.inmetrics.pages.HomePage;
import br.com.inmetrics.pages.UsuarioPage;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.qameta.allure.Description;

public class RegistrarTaskStep {

	private HomePage homePage;
	private UsuarioPage usuarioPage;
	@Dado("^que estou com o navegador aberto$")
	public void queEstouComONavegadorAberto() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\marionette\\chromedriver.exe");
		DriverContext.Driver = new ChromeDriver();
		DriverContext.Driver.manage().window().maximize();
		homePage = new HomePage();
		usuarioPage = new UsuarioPage();
	}
	@Description("Usuário adiciona contato com sucesso")
	@E("^preencho na barra de endereco o link \"([^\"]*)\"$")
	public void preenchoNaBarraDeEnderecoOLink(String arg1) throws Throwable {
		DriverContext.Driver.navigate().to(arg1);
		homePage.validaTitle();

	}
	@Description("Usuário adiciona contato com sucesso")
	@E("^clico no botao 'OK I WANNA SIGN UP NOW'$")
	public void clicoNoBotaoOKIWANNASIGNUPNOW() throws Throwable {
		homePage.singUp();
	}

	@E("^preemcho o formulario no campo nome$")
	public void preemchoOFormularioNoCampoNome() throws Throwable {
		homePage.preemchoName();
	}

	@E("^preemcho o formulario no campo login$")
	public void preemchoOFormularioNoCampoLogin() throws Throwable {
		homePage.preemchoLogin();
	}

	@Quando("^preemcho o formulario no campo password$")
	public void preemchoOFormularioNoCampoPassword() throws Throwable {
		homePage.preemchoPassword();
	}

	@E("^clico no botao de 'SAVE'$")
	public void clicoNoBotaoDeSAVE() throws Throwable {
		homePage.btnSave();
	}

	@Entao("^na barra superior clico no link Logout$")
	public void naBarraSuperiorClicoNoLinkLogout() throws Throwable {
		try {
			Thread.sleep(3000);
			homePage.linkLogout();
		} catch (Exception e) {
			System.out.println("Erro > " + e.getMessage());
		}
	}

	@E("^clico no link da barra superior 'Sign in'$")
	public void clicoNoLinkDaBarraSuperiorSignIn() throws Throwable {
		homePage.singIn();
	}

	@E("^informo no formulario no campo 'login'$")
	public void informoNoFormularioNoCampoLogin() throws Throwable {
		homePage.informaLogin();
	}

	@E("^informo no formulario no campo 'password'$")
	public void informoNoFormularioNoCampoPassword() throws Throwable {
		homePage.informaPassword();
	}

	@E("^clico no botao 'SIGNIN'$")
	public void clicoNoBotaoSIGNIN() throws Throwable {
		homePage.btnSignIn();
	}

	@Dado("^que estou logado clico no botao '\\+ ADD A TASK'$")
	public void queEstouLogadoClicoNoBotaoADDATASK() throws Throwable {
		try {
			Thread.sleep(3000);
			usuarioPage.btnAddTask();
			usuarioPage.addTask();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

	@Dado("^preemcho no dialogo do campo title$")
	public void preemchoNoDialogoDoCampoTitle() throws Throwable {
		usuarioPage.preemcherTitle();
	}
	
	@E("^seleciono a data de task$")
	public void selecionoADataDeTask() throws Throwable {
        usuarioPage.selecionarData();
	}

	@E("^o horario da task$")
	public void oHorarioDaTask() throws Throwable {
       usuarioPage.selecionarHorario();
	}	

	@E("^preemcho no campo texto 'Tell us, please'$")
	public void preemchoNoCampoTextoTellUsPlease() throws Throwable {
      usuarioPage.digiteTell();
	}

	@Quando("^seleleciono o tipo done$")
	public void selelecionoOTipoDone() throws Throwable {
       usuarioPage.notOrDone();
	}
	
	@Entao("^clico no botao 'SAVE'$")
	public void clicoNoBotaoSAVE() throws Throwable {
       usuarioPage.saveTask();
	}
	
	@After
	public void teaDown() {
		DriverContext.Driver.quit();
	}
}
