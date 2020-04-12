package br.com.inmetrics.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("Fazer uma compra")
@Feature("Fazer uma compra")
@Story("Usuário Adiciona contato")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/br/com/inmetrics/features/RegistrarTask.feature", glue = "br.com.inmetrics.steps", monochrome = true, snippets = SnippetType.CAMELCASE, dryRun = false)
public class RunnerFuncionalTest {

}
