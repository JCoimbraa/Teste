package StepDefinitions;

import Steps.Hooks;
import com.github.javafaker.Faker;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SmokeValidacoes {

    private WebDriver driver = new ChromeDriver();
    private PageObjects.PageObjects pageObjects = PageFactory.initElements(driver, PageObjects.PageObjects.class);
    private WebDriverWait wait = new WebDriverWait(driver, 180);

    @After(value = "@smokevalidacoes",
            order = 0)
    public void close() {
        Hooks closeBrowser = new Hooks();
        closeBrowser.closeBrowser(driver);
    }

    @After(value = "@smokevalidacoes",
            order = 1)
    public void screenshot(Scenario scenario) {

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Sucess\\Validacoes\\" + scenario.getId() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @E("^clico no link \"([^\"]*)\"$")
    public void clicoNoLink(String link) throws Throwable {

        switch (link) {

            case "Entrar":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.entrarLink));
                pageObjects.entrarLink.click();
                break;
            case "Esqueci minha senha":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.esqueciMinhaSenhaLink));
                pageObjects.esqueciMinhaSenhaLink.click();
                break;
            default:
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Failed\\Carregamento da tela Falhou.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }

    }

    @Dado("^que acesso a home de \"([^\"]*)\"$")
    public void queAcessoAHomeDe(String home) throws Throwable {

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

    @E("^informo dados na modal \"([^\"]*)\"$")
    public void informoDadosNaModal(String modal) throws Throwable {

        Hooks hooks = new Hooks();

        switch (modal) {

            case "Para recuperar sua senha":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.emailCelularField));
                pageObjects.emailCelularField.sendKeys("11991738120");
                pageObjects.localizarUsuarioButton.click();
                break;
            case "Enviamos seu codigo":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.tokenField));
                pageObjects.tokenField.sendKeys("123654");
                pageObjects.senhaDeAcessoField.sendKeys("Serasa" + hooks.cnpj());
                pageObjects.validarMinhaContaRecuperarSenhaButton.click();
                break;
            case "Enviamos seu codigo valido":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.tokenField));
                pageObjects.tokenField.sendKeys("123456");
                pageObjects.senhaDeAcessoField.sendKeys("Serasa" + hooks.cnpj());
                pageObjects.validarMinhaContaRecuperarSenhaButton.click();
                break;
            default:
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Failed\\Carregamento da modal Falhou.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    @E("^clicar no plano de assinatura \"([^\"]*)\"$")
    public void clicarNoPlanoDeAssinatura(String botao) throws Throwable {

        switch (botao) {

            case "simples":
                pageObjects.assinaturaSimplesButton.click();
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.seuNomeCompletoField));
                break;
            case "140":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.trintaCincoAvulsoButton));
                pageObjects.centoeQuarentaAvulsoButton.click();
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.seuNomeCompletoField));
                break;
            case "70":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.trintaCincoAvulsoButton));
                pageObjects.setentaAvulsoButton.click();
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

    @E("^informo dados na tela \"([^\"]*)\"$")
    public void informoDadosNaTela(String preencher) throws Throwable {

        Hooks hooks = new Hooks();

        switch (preencher) {

            case "Cadastro":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.telefoneCelularField));
                Thread.sleep(3000);
                pageObjects.seuNomeCompletoField.click();
                pageObjects.seuNomeCompletoField.sendKeys("Alfredo Dias");
                pageObjects.telefoneCelularField.click();
                pageObjects.telefoneCelularField.sendKeys("119" + hooks.cnpj());
                driver.findElement(By.id("nationalRegistrationId")).sendKeys(hooks.cnpj());
                pageObjects.emailField.click();
                pageObjects.emailField.sendKeys("AlfredoDias" + hooks.cnpj() + "@gmail.com");
                break;
            case "Token":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.tokenField));
                pageObjects.tokenField.sendKeys("123654");
                pageObjects.validarMinhaContaButton.click();
                break;
            case "Token valido":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.tokenField));
                pageObjects.tokenField.sendKeys("123456");
                pageObjects.validarMinhaContaButton.click();
                break;
            case "Promote":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.seuNomeCompletoPromoteField));
                pageObjects.seuNomeCompletoPromoteField.sendKeys("Alfredo dias");
                pageObjects.cpfField.sendKeys("12345678909");
                pageObjects.dataDeNascimentoField.sendKeys("26121999");
                pageObjects.nomeDaMaeField.sendKeys("Maria Dias");
                pageObjects.dadosDaEmpresaField.sendKeys("Alfredo LTDA");
                pageObjects.senhaDeAcessoField.sendKeys("Serasa@1");
                break;
            case "Pagamento":
                wait.until(ExpectedConditions.elementToBeClickable(pageObjects.numeroCartaoField));
                pageObjects.numeroCartaoField.sendKeys("4111111111111111");
                pageObjects.validadeField.sendKeys("122025");
                pageObjects.nomeImpressoField.sendKeys("Alfredo do Teste");
                pageObjects.CVVField.sendKeys("123");
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

    @Então("^verifico que sistema apresenta mensagem \"([^\"]*)\" e não habilita o botão cadastrar$")
    public void verificoQueSistemaApresentaMensagemENãoHabilitaOBotãoCadastrar(String menssagem) throws Throwable {

        switch (menssagem) {

            case "de validacao":
                pageObjects.seuNomeCompletoField.clear();
                pageObjects.seuNomeCompletoField.sendKeys("abc");
                pageObjects.seuNomeCompletoField.sendKeys(Keys.TAB);
                assertEquals("Informe seu nome completo.", pageObjects.nomeMessagem.getText());

                WebElement button = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='contrato.'])[1]/following::span[1]"));
                if (button.isDisplayed()) {
                    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='contrato.'])[1]/following::span[1]")).click();
                    System.out.println("the button is enabled");
                } else {
                    System.out.println("the button is disabled");
                }
                break;
            case "de validacao telefone":
                pageObjects.telefoneCelularField.clear();
                pageObjects.telefoneCelularField.sendKeys("00000000");
                pageObjects.telefoneCelularField.sendKeys(Keys.TAB);
                assertEquals("Telefone inválido.", pageObjects.telefoneMessagem.getText());
                break;
            case "de validacao cnpj":
                pageObjects.cnpjField.clear();
                pageObjects.cnpjField.sendKeys("00000000");
                pageObjects.cnpjField.sendKeys(Keys.TAB);
                assertEquals("CNPJ inválido.", pageObjects.cnpjMessagem.getText());
                break;
            case "de validacao email":
                pageObjects.emailField.clear();
                pageObjects.emailField.sendKeys("teste.com");
                pageObjects.emailField.sendKeys(Keys.TAB);
                assertEquals("Email inválido.", pageObjects.emailMessagem.getText());
                break;
            default:
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Failed\\Problemas na tela de cadastro.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    @Entao("^sistema apresenta a mensagem \"([^\"]*)\"$")
    public void sistemaApresentaAMensagem(String mensagemValidacao) throws Throwable {

        switch (mensagemValidacao) {

            case "Validando Token":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.tokenMenssage));
          //      assertEquals("O código digitado é inválido", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ops, algo deu errado!'])[1]/following::div[1]")).getText());
                assertEquals("O código digitado é inválido", pageObjects.tokenMenssage.getText());
                break;
            case "Validando Token Cadastro":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.tokenCadastroMenssage));
                //      assertEquals("O código digitado é inválido", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ops, algo deu errado!'])[1]/following::div[1]")).getText());
                assertEquals("O código digitado é inválido", pageObjects.tokenCadastroMenssage.getText());
                break;
            default:
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Failed\\Problemas na apresentação das mensagens.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }

    }

    @Entao("^sou direcionato para tela \"([^\"]*)\"$")
    public void souDirecionatoParaTela(String direcionamento) throws Throwable {

        switch (direcionamento) {

            case "Area Logada":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.arealogadaMessage));
                assertEquals("Boa tarde,", pageObjects.arealogadaMessage.getText());
                break;
            default:
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Failed\\Problemas no direcionamento.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @E("^clico no botão \"([^\"]*)\"$")
    public void clicoNoBotão(String botao) throws Throwable {

        switch (botao) {

            case "Cadastrar":
                pageObjects.cadastrarButton.click();
                break;
            case "Enviar codigo por email":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.enviarCodigoPorEmailButton));
                pageObjects.enviarCodigoPorEmailButton.click();
                break;
            case "Confirmar Cadastro":
                wait.until(ExpectedConditions.visibilityOf(pageObjects.confirmarCadastroButton));
                pageObjects.confirmarCadastroButton.click();
                break;
            default:
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Failed\\Problema no clique dos botões.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Entao("^sistema apresenta em tela que email foi enviado$")
    public void sistemaApresentaEmTelaQueEmailFoiEnviado() throws Throwable {

        wait.until(ExpectedConditions.visibilityOf(pageObjects.verificacaoEmailMessage));
        assertEquals("Enviamos um código para seu e-mail!", pageObjects.verificacaoEmailMessage.getText());

    }

    @Entao("^Sistema me apresenta a \"([^\"]*)\"$")
    public void sistemaMeApresentaA(String menssage) throws Throwable {

        switch (menssage) {

            case "Mensagem validando nome invalido":
                pageObjects.seuNomeCompletoPromoteField.clear();
                pageObjects.seuNomeCompletoPromoteField.sendKeys("Alfredo");
                pageObjects.seuNomeCompletoPromoteField.sendKeys(Keys.TAB);
                assertEquals("Informe seu nome completo", pageObjects.seuNomecompletoPromoteMessage.getText());
                break;
            case "Mensagem validando cpf invalido":
                pageObjects.cpfField.clear();
                pageObjects.cpfField.sendKeys("12345");
                pageObjects.cpfField.sendKeys(Keys.TAB);
                assertEquals("CPF inválido", pageObjects.cpfPromoteMessage.getText());
                break;
            case "Mensagem validando data de nascimento invalido":
                pageObjects.dataDeNascimentoField.clear();
                pageObjects.dataDeNascimentoField.sendKeys("00000000");
                pageObjects.dataDeNascimentoField.sendKeys(Keys.TAB);
                assertEquals("Data de nascimento inválida", pageObjects.dataNascimentoMessage.getText());
                break;
            case "Mensagem validando nome da mae invalido":
                pageObjects.nomeDaMaeField.clear();
                pageObjects.nomeDaMaeField.sendKeys("mamae");
                pageObjects.nomeDaMaeField.sendKeys(Keys.TAB);
                assertEquals("Informe o nome completo da sua mãe", pageObjects.nomedaMaeMessage.getText());
                break;
            case "Mensagem validando nome do socio invalido":
                pageObjects.dadosDaEmpresaField.clear();
                pageObjects.dadosDaEmpresaField.sendKeys("ltda");
                pageObjects.dadosDaEmpresaField.sendKeys(Keys.TAB);
                assertEquals("Informe o nome completo de um dos sócios", pageObjects.dadosDaEmpresaMessage.getText());
                break;
            case "Sistema nao avanca tela":
                pageObjects.senhaDeAcessoField.clear();
                pageObjects.senhaDeAcessoField.sendKeys("ltda");
                pageObjects.senhaDeAcessoField.sendKeys(Keys.TAB);
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Requisitos mínimos de senha:'])[1]/following::span[1]")).click();
                break;
            case "Mensagem validado cartao invalido":
                pageObjects.numeroCartaoField.clear();
                pageObjects.numeroCartaoField.sendKeys("4111111");
                pageObjects.senhaDeAcessoField.sendKeys(Keys.TAB);
                assertEquals("Digite o número igual ao impresso no cartão", driver.findElement(By.id("numbererror")).getText());
                break;
            case "Mensagem validado data de validade invalida":
                pageObjects.validadeField.clear();
                pageObjects.validadeField.sendKeys("4111111");
                pageObjects.validadeField.sendKeys(Keys.TAB);
                assertEquals("Digite a validade correta", pageObjects.validadeMessage.getText());
                break;
            case "Mensagem validado nome cartao invalido":
                pageObjects.nomeImpressoField.clear();
                pageObjects.nomeImpressoField.sendKeys("4111111");
                pageObjects.nomeImpressoField.sendKeys(Keys.TAB);
                assertEquals("Digite o nome igual ao impresso no cartão", pageObjects.nomeImpressoMessage.getText());
                break;
            case "Mensagem validado CSS invalido":
                pageObjects.CVVField.clear();
                pageObjects.CVVField.sendKeys("1");
                pageObjects.CVVField.sendKeys(Keys.TAB);
                assertEquals("Digite o CVV correto", driver.findElement(By.id("cvverror")).getText());
                break;
            default:
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(file, new File("C:\\Smoking Test\\target\\screenshots\\Failed\\Problema ao verificar mensagens.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    @Entao("^valido que o botão não esta habilitado para finalização sem ter salvo os dados do cartão$")
    public void validoQueOBotãoNãoEstaHabilitadoParaFinalizaçãoSemTerSalvoOsDadosDoCartão() throws Throwable {

        Assert.assertTrue((pageObjects.finalizarButton).isEnabled());
    }

    @Entao("^valido que sistema habilita botão Finalizar mesmo sem clicar no checkbox de gravar cartão$")
    public void validoQueSistemaHabilitaBotãoFinalizarMesmoSemClicarNoCheckboxDeGravarCartão() throws Throwable {

        pageObjects.finalizarButton.click();
        Thread.sleep(5000);
        assertEquals("Suas informações de pagamento",pageObjects.suasInformacoesdePagamentoMessage.getText());
    }

    @Entao("^valido que a opcao de boleto não existe$")
    public void validoQueAOpcaoDeBoletoNãoExiste() throws Throwable {

        wait.until(ExpectedConditions.visibilityOf(pageObjects.numeroCartaoField));

        assertEquals("Cartão de Crédito", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='R$ 70,00'])[1]/following::h3[1]")).getText());
    }

    @E("^nao informo Token$")
    public void naoInformoToken() throws Throwable {

        wait.until(ExpectedConditions.visibilityOf(pageObjects.tokenField));
        //Terminar

    }

    @Entao("^Sistema nao permite que eu feche tela de token enquanto nao informar o mesmo$")
    public void sistemaNaoPermiteQueEuFecheTelaDeTokenEnquantoNaoInformarOMesmo() throws Throwable {
        // construir metodo
    }

    @Entao("^Sistema me apresenta opcao de boleto$")
    public void sistemaMeApresentaOpcaoDeBoleto() throws Throwable {

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cartão de Crédito'])[1]/following::li[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Boleto Bancário'])[1]/following::div[2]")).click();
        assertEquals("Aguarde. Em breve será possível fazer sua assinature por boleto bancário", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Boleto Bancário'])[1]/following::div[3]")).getText());

    }
}
