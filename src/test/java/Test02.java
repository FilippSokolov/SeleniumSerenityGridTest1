import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test02 {


    @BeforeClass
    @Step
    public void some() {
    }


    @Test
    public void action() {

        some();

    }

}
