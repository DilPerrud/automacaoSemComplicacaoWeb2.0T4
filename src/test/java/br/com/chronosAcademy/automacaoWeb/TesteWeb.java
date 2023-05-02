package br.com.chronosAcademy.automacaoWeb;

import br.com.chronosAcademy.core.Driver;
import br.com.chronosAcademy.core.pages.CursoPage;
import br.com.chronosAcademy.core.pages.PrincipalPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        assertEquals("Porque Tempo É Conhecimento.", titulo);
    }

    @Test
    public void segundoTeste() {
        cursoPage = new CursoPage(driver);
        principalPage.clickBotao();
        WebElement h2Titulo = getTitulo2();
        String titulo = cursoPage.getTitulo2();
        assertEquals("Conheça todos os nossos cursos.", h2Titulo.getText());
    }

    private WebElement getTitulo2() {
        String xpathTitulo = "//section[4]/div//div/div/div[1]/div/div";
        WebElement h2Titulo = driver.findElement(By.xpath(xpathTitulo));
        String titulo = h2Titulo.getText();
        return h2Titulo;
    }


    @After
    public void finalizaTeste() {
        driver.quit();
    }
}




