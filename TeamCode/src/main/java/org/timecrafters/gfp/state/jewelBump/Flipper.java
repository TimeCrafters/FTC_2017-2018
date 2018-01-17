package org.timecrafters.gfp.state.jewelBump;

import android.util.Log;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by goldfishpi on 1/9/18.
 */

public class Flipper extends Config {
    double power;
    boolean runTime;
    int timems;
    boolean firstRun = true;
    long startTime;
    public Flipper(Engine engine, double power) {
        super(engine);
        this.power = power;
    }
    public Flipper(Engine engine, double power,int timems) {
        super(engine);
        this.power = power;
        this.runTime = true;
        this.timems = timems;
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void exec() {
        crFlipper.setPower(power);

        if (!runTime){
            if(firstRun){
                startTime = System.currentTimeMillis();
                firstRun = false;
            }

            if (flipperTouch.isPressed()) {
                crFlipper.setPower(0);
                setFinished(true);
            }else if(System.currentTimeMillis() - startTime >= 1000){
                crFlipper.setPower(0);
                setFinished(true);
            }
        }else{
            crFlipper.setPower(power);
            sleep(timems);
            crFlipper.setPower(0);
            setFinished(true);
        }
    }
}
