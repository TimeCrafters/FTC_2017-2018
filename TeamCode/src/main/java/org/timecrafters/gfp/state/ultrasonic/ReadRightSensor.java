package org.timecrafters.gfp.state.ultrasonic;

import org.timecrafters.engine.Engine;

/**
 * Created by goldfishpi on 11/30/17.
 */

public class ReadRightSensor extends UltraSonic {
    public ReadRightSensor(Engine engine, int readings) {
        super(engine, readings);
    }
    public void init(){
        super.init();
    }
}
