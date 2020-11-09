package com.steps.ui;

import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class PicoHooks extends DriverFactory {

    @Before
    public void before() throws Exception {
        initializeDriver();
    }

    @After
    public void after()
    {
        destroyDriver();
    }

}
