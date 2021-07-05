package DesafioUm;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test01 {
	
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializar() {
		driver = new ChromeDriver();
		driver.get("https://www.unimed.coop.br/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dsl = new DSL(driver);
	}

	@After
	public void finalizar() {
		driver.quit();
	}

	@Test
	public void findDoctorAndValidateSpecAndCity() {

		dsl.selectElement(By.id("fragment-oimm-link"));

		dsl.selectElement(By.id("react-tabs-2"));

		dsl.setInputs("react-select-3-input", "Cirurgia Geral");

		dsl.setInputs("react-select-4-input", "Rio de Janeiro");

		dsl.setInputs("react-select-5-input", "Rio de Janeiro");

		dsl.selectElement(By.xpath("//*[@id=\"react-tabs-3\"]/form/div/div[6]/div[1]/button"));

		dsl.MustFindElement("ProviderAddressAsGrid--address-link", "Rio de Janeiro");
		dsl.MustFindElement("ProviderSpecialties--item", "Cirurgia Geral");
	}

	@Test
	public void findDoctorAndValidateInPagesOfCityResults() {

		dsl.selectElement(By.id("fragment-oimm-link"));

		dsl.selectElement(By.id("react-tabs-2"));

		dsl.setInputs("react-select-3-input", "Cirurgia Geral");

		dsl.setInputs("react-select-4-input", "Rio de Janeiro");

		dsl.setInputs("react-select-5-input", "Rio de Janeiro");

		dsl.selectElement(By.xpath("//*[@id=\"react-tabs-3\"]/form/div/div[6]/div[1]/button"));

		dsl.nextPageResults();
		dsl.NotMustFindElement("ProviderAddressAsGrid--address-link", "São Paulo");
	}
}
