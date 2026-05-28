package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.BaseClass;

public class Hooks extends BaseClass {

    @Before
    public void start() {
        setup();
    }

    @After
    public void end() {
        tearDown();
    }
}
