package org.timecrafters.gfp.state.jewelBump;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by goldfishpi on 1/12/18.
 */

public class Beam extends Config {
    int power;
    public Beam(Engine engine, int power) {
        super(engine);
        this.power = power;
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void exec() {
        crBeam.setPower(power);
        if(beamTouch.isPressed()){
            crBeam.setPower(0);
            setFinished(true);
        }
    }
}
