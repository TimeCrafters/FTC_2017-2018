package org.timecrafters.gfp.state.jewelBump;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by goldfishpi on 1/9/18.
 */

public class Flipper extends Config {
    int power;
    boolean runTime;
    int timems;
    public Flipper(Engine engine, int power) {
        super(engine);
        this.power = power;
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void exec() {
        crFlipper.setPower(power);


        if (flipperTouch.isPressed()) {
            crFlipper.setPower(0);
            setFinished(true);
        }

    }
}
