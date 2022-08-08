package aut.testcreation.steps;
import aut.testcreation.pages.GoogleHomePage;
import aut.testplan.sprint.GoogleTestRunner;
import io.cucumber.java8.En;
import org.junit.jupiter.api.Assertions;


public class GoogleSteps extends GoogleTestRunner implements En{

    public GoogleSteps(){

        GoogleHomePage googleHomePage;

        Before(2, GoogleTestRunner::setUp);
        After(GoogleTestRunner::tearDown);

        Given("que estoy en el Home de Google", () -> Assertions.assertTrue(true));

        When("busco la palabra {string} en el navegador", (String string) -> {
            // Write code here that turns the phrase above into concrete actions
            Assertions.assertTrue(true);
        });

        When("presiono el boton buscar", () -> {
            // Write code here that turns the phrase above into concrete actions
            Assertions.assertTrue(true);
        });

        Then("me lleva a la pagina de resultados", () -> {
            // Write code here that turns the phrase above into concrete actions
            Assertions.assertTrue(true);
        });
    }
}
