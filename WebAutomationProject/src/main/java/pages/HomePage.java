package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import net.bytebuddy.dynamic.scaffold.inline.AbstractInliningDynamicTypeBuilder;


import java.time.Duration;
import java.util.List;


import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    private By menuBar = By.cssSelector("div[class='bm-burger-button'] button");
    		//xpath("//button");
    		//cssSelector("div[class='bm-burger-button'] button");
    //private By btnLogout = By.linkText("Logout");
    private By btnLogout = By.xpath("//div[@id='page_wrapper']//div//div//following-sibling::div//div//nav//a[text()='Logout']");



   

    public boolean clickOnMenuBar() throws InterruptedException {
    	Actions actions = new Actions(bpdriver);
    	//Actions actions = new Actions(bpdriver);
    	//moverActions.moveToElement(find(menuBar)).moveByOffset(0,0).click().perform();
    	//moverActions.moveToElement(find(btnLogout)).moveByOffset(0,0).click().perform();
    	//WebDriverWait wait = new WebDriverWait(bpdriver,Duration.ofSeconds(10));
    	//WebElement menuBar = wait.until(
    			//ExpectedConditions.elementToBeClickable(By.cssSelector("div[id='menu_button_container'] div:nth-child(3)")));
    	//((JavascriptExecutor) bpdriver).executeScript("arguments[0].scrollIntoView(true);", menuBar);
    	//WebDriverWait wait= new WebDriverWait(bpdriver, Duration.ofSeconds(30));
    	//wait.until(ExpectedConditions.elementToBeClickable(menuBar));
    	if(isVisible(menuBar)) System.out.println("menuBar button is visible.\n");
    	//if(isVisible(menuBar)) System.out.println("logout button is visible.\n");
    	click(menuBar);
//    	actions.moveToElement(find(btnLogout)); 
//    	actions.click(find(btnLogout)); 
//    	Action action = (Action) actions.build(); 
//    	action.perform();
    	//click(btnLogout);
    	Thread.sleep(2000);
//    	
        //click(btnLogout);
    	if(isVisible(btnLogout)) System.out.println("logout button is visible.\n");
        return isVisible(btnLogout);
    }

    public void clickOnLogout() {
        click(btnLogout);
        System.out.println("Hello From ClickOnLogout Function!");
    }
    public void clickOnMenuButton() {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) bpdriver;
    	String script ="document.querySelector('#menu_button_container > div > div:nth-child(3) > div > button').click()";
    }
}
