package br.com.chronosAcademy.automacaoWeb;

import br.com.chronosAcademy.core.Driver;
import br.com.chronosAcademy.pages.CursoPage;
import br.com.chronosAcademy.pages.PrincipalPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TesteWeb {
    Driver driverWeb;
    WebDriver driver;

    PrincipalPage principalPage;
    CursoPage cursoPage;

    @Before
    public void inicializaTeste() {
        driverWeb = new Driver("chrome");
        driver = driverWeb.getDriver();
        driver.get("https://www.chronosAcademy.com.br");
        principalPage = new PrincipalPage(driver);
    }

    @Test
    public void primeiroTeste() {
        String titulo = principalPage.getTitulo();
        Assert.assertEquals("Porque Tempo É Conhecimento.", titulo);
    }

    @Test
    public void  segundoTeste() {
        cursoPage = new CursoPage(driver);
        principalPage.ClickBotao();
        String titulo = cursoPage.getTitulo2();
        assertEquals("Conheça todos os nossos cursos.", titulo);
    }

    @After
        public void finalizaTeste() {
            driver.quit();

        }

    }

