package com.testinium.step;

import com.testinium.base.BaseTest;
import com.testinium.model.ElementInfo;
import com.thoughtworks.gauge.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class BaseSteps extends BaseTest {


    public BaseSteps() {
        this.driver = BaseTest.getDriver();
        this.actions = BaseTest.getActions();
    }

    public By getElementInfoToBy(ElementInfo elementInfo) {
        By by = null;
        if (elementInfo.getType().equals("css")) {
            by = By.cssSelector(elementInfo.getValue());
        } else if (elementInfo.getType().equals(("name"))) {
            by = By.name(elementInfo.getValue());
        } else if (elementInfo.getType().equals("id")) {
            by = By.id(elementInfo.getValue());
        } else if (elementInfo.getType().equals("xpath")) {
            by = By.xpath(elementInfo.getValue());
        } else if (elementInfo.getType().equals("linkText")) {
            by = By.linkText(elementInfo.getValue());
        } else if (elementInfo.getType().equals(("partialLinkText"))) {
            by = By.partialLinkText(elementInfo.getValue());
        }
        return by;
    }

    @Step({"Go to <url> address",
            "<url> adresine git"})
    public void goToUrl(String url) {
        driver.get(url);
        log.info(url + " adresine gidiliyor.");
    }

    @Step("Şu anki url <url> ile aynı mı")
    public void checkCurrentUrlEquals(String url) {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, url);
        log.info("Şu anki url " + url + " ile aynı.");
    }

    @Step("Scroll down the page")
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Step("Scroll up the page")
    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
    }

}
