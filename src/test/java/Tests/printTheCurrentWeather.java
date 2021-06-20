package Tests;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

@Listeners(Tests.Listeners.class)
public class printTheCurrentWeather extends MainTest {

    @Test(description = "Print the weather in correct location")
    public void printWeather(){
        ynetPage.printWeather();
    }

    @Test (description = "Change the city to Eilat and print the weather")
    public void printWeatherInEilat(){
        ynetPage.changeAreaToEilat();
    }

    @Test (description = "Open the page in resolution 1920*1080")
    public void changeResolution(){
        driver = initChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get(getData("URL"));
        driver.quit();
    }
}
