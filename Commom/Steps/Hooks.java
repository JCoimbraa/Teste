package Steps;


import cucumber.api.Scenario;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Hooks {

    private WebDriver driver;
    private Scenario scenario;

    private PageObjects.PageObjects pageObjects = PageFactory.initElements(driver, PageObjects.PageObjects.class);

    private int randomiza(int n) {
        int ranNum = (int) (Math.random() * n);
        return ranNum;
    }

    private int mod(int dividendo, int divisor) {
        return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
    }

    //Objetos comnuns utilizados em diversas classes do projeto

//    public static String URLAssinatura = "http://localhost:4200/assinatura";
//    public static String URLAvulso = "http://localhost:4200";
   // public static String URLAssinatura = "https://consulta-uat.serasaexperian.com.br/assinatura";
 //   public static String URLAvulso = "https://consulta-uat.serasaexperian.com.br";
    public static String URLAssinatura = "https://sme-credit-reports-frontend-sme-staging.apps.appcanvas.net/assinatura";
    public static String URLAvulso = "https://sme-credit-reports-frontend-sme-staging.apps.appcanvas.net";

    @Before("@smokeendtoend,@smokevalidacoes")
    public void beforeScenario() {
        System.setProperty("webdriver.chrome.driver", "C:\\drives\\chromedriver_win32\\chromedriver.exe");
    }


    //Método responsável por fechar o browser, no fim da execução do teste
    public void closeBrowser(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }

    private boolean comPontos = true;

    public String cnpj() {
        int n = 9;
        int n1 = randomiza(n);
        int n2 = randomiza(n);
        int n3 = randomiza(n);
        int n4 = randomiza(n);
        int n5 = randomiza(n);
        int n6 = randomiza(n);
        int n7 = randomiza(n);
        int n8 = randomiza(n);
        int n9 = 0; //randomiza(n);
        int n10 = 0; //randomiza(n);
        int n11 = 0; //randomiza(n);
        int n12 = 1; //randomiza(n);
        int d1 = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4 + n1 * 5;

        d1 = 11 - (mod(d1, 11));

        if (d1 >= 10)
            d1 = 0;

        int d2 = d1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4 + n2 * 5 + n1 * 6;

        d2 = 11 - (mod(d2, 11));

        if (d2 >= 10)
            d2 = 0;

        String retorno = null;

        retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11 + n12 + d1 + d2;

        return retorno;
    }

}





