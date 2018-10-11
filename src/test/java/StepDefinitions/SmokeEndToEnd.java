package StepDefinitions;

import Steps.Hooks;
import com.github.javafaker.Faker;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SmokeEndToEnd {

    private WebDriver driver = new ChromeDriver();
    private PageObjects.PageObjects pageObjects = PageFactory.initElements(driver, PageObjects.PageObjects.class);
    private WebDriverWait wait = new WebDriverWait(driver, 180);

    @After(value = "@smokeendtoend",
            order = 0)
    public void close() {
        Hooks closeBrowser = new Hooks();
        closeBrowser.closeBrowser(driver);
    }

    @After(value = "@smokeendtoend",
            order = 1)
    public void screenshot(Scenario scenario) {

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Sucess\\EndToEnd\\" + scenario.getId() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Dado("^que acesso a home \"([^\"]*)\"$")
    public void que_acesso_a_home(String home) throws Throwable {

        switch (home) {

            case "Avulso":
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                driver.get(Hooks.URLAvulso);
                break;
            case "Assinatura":
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                driver.get(Hooks.URLAssinatura);
                wait.until(ExpectedConditions.urlToBe(Hooks.URLAssinatura));
                break;
            default:

                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Failed\\Carregamento da Home Falhou.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    @Dado("^clico no plano de assinatura \"([^\"]*)\"$")
    public void clico_no_plano_de_assinatura(String botao) throws Throwable {

        switch (botao) {

            case "simples":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.assinaturaSimplesButton));
                pageObjects.assinaturaSimplesButton.click();
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.seuNomeCompletoField));
                break;
            case "essencial":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.assinaturaEssencialButton));
                pageObjects.assinaturaEssencialButton.click();
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.seuNomeCompletoField));
                break;
            case "premium":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.assinaturaPremiumButton));
                pageObjects.assinaturaPremiumButton.click();
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.seuNomeCompletoField));
                break;
            case "35":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.trintaCincoAvulsoButton));
                pageObjects.trintaCincoAvulsoButton.click();
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.seuNomeCompletoField));
                break;
            case "70":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.trintaCincoAvulsoButton));
                pageObjects.setentaAvulsoButton.click();
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.seuNomeCompletoField));
                break;
            case "140":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.trintaCincoAvulsoButton));
                pageObjects.centoeQuarentaAvulsoButton.click();
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.seuNomeCompletoField));
                break;
            default:
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Failed\\Sistema nao encontrou o Botao.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    @Dado("^preencho os campos da tela \"([^\"]*)\" com dados válidos$")
    public void preencho_os_campos_da_tela_com_dados_válidos(String tela) throws Throwable {

        Hooks hooks = new Hooks();

        switch (tela) {

            case "cadastro":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.seuNomeCompletoField));
                Thread.sleep(3000);
                pageObjects.seuNomeCompletoField.click();
                pageObjects.seuNomeCompletoField.sendKeys("Alfredo Dias");
                pageObjects.telefoneCelularField.click();
                pageObjects.telefoneCelularField.sendKeys("119" + hooks.cnpj());
                driver.findElement(By.id("nationalRegistrationId")).sendKeys("21116275000165");
                pageObjects.emailField.click();
                pageObjects.emailField.sendKeys("AlfredoDias" + hooks.cnpj() + "@gmail.com");
                break;
            case "cadastro com CNPJ sem Endereco":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.seuNomeCompletoField));
                Thread.sleep(3000);
                pageObjects.seuNomeCompletoField.click();
                pageObjects.seuNomeCompletoField.sendKeys("Alfredo Dias");
                pageObjects.telefoneCelularField.click();
                pageObjects.telefoneCelularField.sendKeys("119" + hooks.cnpj());
                driver.findElement(By.id("nationalRegistrationId")).sendKeys(hooks.cnpj());
                pageObjects.emailField.click();
                pageObjects.emailField.sendKeys("AlfredoDias" + hooks.cnpj() + "@gmail.com");
                break;
            case "de Pagamento Assinatura":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.numeroCartaoField));
                pageObjects.numeroCartaoField.sendKeys("4111111111111111");
                pageObjects.validadeField.sendKeys("122022");
                pageObjects.nomeImpressoField.sendKeys("Alfredo Dias");
                pageObjects.CVVField.sendKeys("123");
                pageObjects.salvarDadosCartaoCHK.click();
                break;
            case "Endereco CNPJ":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.cepField));
                pageObjects.companyNameField.sendKeys("Empresa Teste");
                pageObjects.cepField.sendKeys("00000000");
                pageObjects.enderecoEmpresaField.sendKeys("Rua Teste");
                pageObjects.numeroField.sendKeys("20");
                pageObjects.complementoField.sendKeys("torre 1A");
                pageObjects.bairroField.sendKeys("Jardim andre");
                new Select(pageObjects.ufField).selectByVisibleText("SP");
                pageObjects.cidadeField.sendKeys("São Paulo");
                pageObjects.finalizarButton.click();
                break;
            default:
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Failed\\Erro no preenchimento da tela de Cadastro.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


    }

    @Dado("^clico no botao \"([^\"]*)\"$")
    public void clico_no_botao(String botao) throws Throwable {

        switch (botao) {

            case "cadastrar":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.cadastrarButton));
                pageObjects.cadastrarButton.click();
                break;
            case "Validar Token":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.validarMinhaContaButton));
                pageObjects.validarMinhaContaButton.click();
                break;
            case "confirmar cadastro":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.confirmarCadastroButton));
                pageObjects.confirmarCadastroButton.click();
                break;
            case "finalizar":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.finalizarButton));
                pageObjects.finalizarButton.click();
                break;
            default:
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Failed\\Erro no Click dos botões.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Dado("^preencho os campos da tela \"([^\"]*)\"$")
    public void preencho_os_campos_da_tela(String campos) throws Throwable {

        switch (campos) {

            case "Token":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.codigoAtivacaoField));
                pageObjects.codigoAtivacaoField.sendKeys("123456");
                break;
            case "De Promote":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.seuNomeCompletoPromoteField));
                pageObjects.seuNomeCompletoPromoteField.sendKeys("Alfredo Dias");
                pageObjects.cpfField.sendKeys("12345678909");
                pageObjects.dataDeNascimentoField.sendKeys("26121999");
                pageObjects.nomeDaMaeField.sendKeys("Maria Dias");
                pageObjects.dadosDaEmpresaField.sendKeys("Alfredo Ltda");
                pageObjects.senhaDeAcessoField.sendKeys("Serasa@1");
                break;
            default:
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Failed\\Foi encontrado algum problema na tela.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


    }


    @E("^clico na opcao \"([^\"]*)\"$")
    public void clicoNaOpcao(String opcaoBoleto) throws Throwable {

        switch (opcaoBoleto) {

            case "Boleto Bancario":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.boletoBancarioButton));
                pageObjects.boletoBancarioButton.click();
                break;
            case "Gerar Boleto":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.gerarBoletoButton));
                pageObjects.gerarBoletoButton.click();
                break;
            default:
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Failed\\Foi encontrado algum problema na tela.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    @Entao("^Boleto é gerado com sucesso$")
    public void boletoÉGeradoComSucesso() throws Throwable {
        Thread.sleep(50000);
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Para concluir, siga os passos abaixo:'])[1]/preceding::span[1]"))));
        assertEquals("Pedido realizado com sucesso", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Para concluir, siga os passos abaixo:'])[1]/preceding::span[1]")).getText());

    }

    @Entao("^sistema conclui compra \"([^\"]*)\"$")
    public void sistemaConcluiCompra(String pagamento) throws Throwable {

        switch (pagamento) {

            case "Cartao Assinatura":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.confirmacaoAssinaturaMessage));
                assertEquals("Parabéns", pageObjects.confirmacaoAssinaturaMessage.getText());
                break;
            case "Cartao Avulso":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.confirmacaoAvulsoMessage));
                //   assertEquals("Alfredo", pageObjects.confirmacaoAvulsoMessage.getText());
                assertEquals("Consulte um CPF ou CNPJ", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Siga os passos abaixo para consultar um CPF ou CNPJ.'])[1]/following::span[3]")).getText());
                break;
            default:
        }

    }
}

