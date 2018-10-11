package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageObjects {

    //Objects Home V1

    @FindBy(how = How.ID, using = "credit-0")
    public WebElement trintaCincoAvulsoButton;

    @FindBy(how = How.ID, using = "credit-1")
    public WebElement setentaAvulsoButton;

    @FindBy(how = How.ID, using = "credit-2")
    public WebElement centoeQuarentaAvulsoButton;

    @FindBy(how = How.LINK_TEXT, using = "Entrar")
    public WebElement entrarLink;

    //Objects Home V2

    @FindBy(how = How.ID, using = "subscription-0")
    public WebElement assinaturaSimplesButton;

    @FindBy(how = How.ID, using = "subscription-1")
    public WebElement assinaturaEssencialButton;

    @FindBy(how = How.ID, using = "subscription-2")
    public WebElement assinaturaPremiumButton;

    //Modal Login Acesse o Consulta Serasa

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Senha obrigatória'])[1]/following::div[2]")
    public WebElement esqueciMinhaSenhaLink;

    @FindBy(how = How.ID, using = "emailOrPhone")
    public WebElement emailCelularField;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Revise o que foi digitado'])[1]/following::button[1]")
    public WebElement localizarUsuarioButton;

    @FindBy(how = How.ID, using = "token")
    public WebElement tokenField;

    @FindBy(how = How.ID, using = "password")
    public WebElement SenhaField;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Requisitos mínimos de senha:'])[1]/following::span[1]")
    public WebElement validarMinhaContaRecuperarSenhaButton;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Ops, algo deu errado!'])[1]/following::div[1]")
    public WebElement tokenMenssage;

    @FindBy(how = How.XPATH, using = "")
    public WebElement tokenCadastroMenssage;

    //Objects Fluxo de Adesão - Cadastro

    @FindBy(how = How.ID, using = "name")
    public WebElement seuNomeCompletoField;

    @FindBy(how = How.ID, using = "celPhone")
    public WebElement telefoneCelularField;

    @FindBy(how = How.ID, using = "nationalRegistrationId")
    public WebElement cnpjField;

    @FindBy(how = How.ID, using = "emailSub")
    public WebElement emailField;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='contrato.'])[1]/following::span[1]")
    public WebElement cadastrarButton;

    @FindBy(how = How.ID, using = "nameerror")
    public WebElement nomeMessagem;

    @FindBy(how = How.ID, using = "celPhoneerror")
    public WebElement telefoneMessagem;

    @FindBy(how = How.ID, using = "nationalRegistrationIderror")
    public WebElement cnpjMessagem;

    @FindBy(how = How.ID, using = "emailSuberror")
    public WebElement emailMessagem;

    //Objects Fluxo de Adesão - Token

    @FindBy(how = How.ID, using = "token")
    public WebElement codigoAtivacaoField;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Espere um pouco!'])[1]/following::span[1]")
    public WebElement validarMinhaContaButton;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Validar minha conta'])[1]/following::span[1]")
    public WebElement enviarCodigoPorEmailButton;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='acesse em até 24 horas'])[1]/preceding::span[1]")
    public WebElement verificacaoEmailMessage;



    //Objects Fluxo de Adesão - Promote

    @FindBy(how = How.ID, using = "fullName")
    public WebElement seuNomeCompletoPromoteField;

    @FindBy(how = How.ID, using = "cpf")
    public WebElement cpfField;

    @FindBy(how = How.ID, using = "birthDate")
    public WebElement dataDeNascimentoField;

    @FindBy(how = How.ID, using = "motherName")
    public WebElement nomeDaMaeField;

    @FindBy(how = How.ID, using = "ownerName")
    public WebElement dadosDaEmpresaField;

    @FindBy(how = How.ID, using = "password")
    public WebElement senhaDeAcessoField;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Requisitos mínimos de senha:'])[1]/following::span[1]")
    public WebElement confirmarCadastroButton;

    @FindBy(how = How.ID, using = "fullNameerror")
    public WebElement seuNomecompletoPromoteMessage;

    @FindBy(how = How.ID, using = "cpferror")
    public WebElement cpfPromoteMessage;

    @FindBy(how = How.ID, using = "birthDateerror")
    public WebElement dataNascimentoMessage;

    @FindBy(how = How.ID, using = "motherNameerror")
    public WebElement nomedaMaeMessage;

    @FindBy(how = How.ID, using = "ownerNameerror")
    public WebElement dadosDaEmpresaMessage;

    //Objects Fluxo de Adesão - Pagamento

    @FindBy(how = How.ID, using = "number")
    public WebElement numeroCartaoField;

    @FindBy(how = How.ID, using = "expiration")
    public WebElement validadeField;

    @FindBy(how = How.ID, using = "cardholder")
    public WebElement nomeImpressoField;

    @FindBy(how = How.ID, using = "cvv")
    public WebElement CVVField;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Digite o CVV correto'])[1]/following::label[1]")
    public WebElement salvarDadosCartaoCHK;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Salvar dados desse cartão para futuras compras em minha conta'])[1]/following::span[1]")
    public WebElement finalizarButton;

    @FindBy(how = How.ID, using = "expirationerror")
    public WebElement validadeMessage;

    @FindBy(how = How.ID, using = "cardholdererror")
    public WebElement nomeImpressoMessage;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Pagamento'])[1]/following::h1[1]")
    public WebElement suasInformacoesdePagamentoMessage;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Cartão de Crédito'])[1]/following::li[1]")
    public WebElement boletoBancarioButton;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Boleto Bancário'])[1]/following::span[1]")
    public WebElement gerarBoletoButton;


    //Area Logada

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Sair'])[1]/following::div[4]")
    public WebElement arealogadaMessage;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Comprar Créditos'])[1]/following::span[1]")
    public WebElement confirmacaoAvulsoMessage;

    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Sair'])[1]/following::div[7]")
    public WebElement confirmacaoAssinaturaMessage;

    // Tela de Endereço

    @FindBy(how = How.ID, using = "companyName")
    public WebElement companyNameField;

    @FindBy(how = How.ID, using = "zipCode")
    public WebElement cepField;

    @FindBy(how = How.ID, using = "addressLine1")
    public WebElement enderecoEmpresaField;

    @FindBy(how = How.ID, using = "numberAddress")
    public WebElement numeroField;

    @FindBy(how = How.ID, using = "complement")
    public WebElement complementoField;

    @FindBy(how = How.ID, using = "addressLine2")
    public WebElement bairroField;

    @FindBy(how = How.ID, using = "state")
    public WebElement ufField;

    @FindBy(how = How.ID, using = "city")
    public WebElement cidadeField;

}
