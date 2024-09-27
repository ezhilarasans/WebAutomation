package hooks;

import browserFactory.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import pageObjects.PageObject;


public class Hooks {

    @AfterAll
    public static void before_or_after_all() {
        PageObject.quitDriver();
    }
}
