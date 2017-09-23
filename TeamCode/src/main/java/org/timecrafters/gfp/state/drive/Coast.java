package org.timecrafters.gfp.state.drive;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by t420 on 9/23/2017.
 */

public class Coast extends Config {

    double expectedPower;
    double currentPower;

    int coastTicks;
    int distanceTicks;

    int changeTime;
    int lastChangeTime = 0;

    boolean firstRun = true;

    int initalEncoderPosition;

    int encoderPosition;

    double powerInc = 0.01;

    public Coast(Engine engine, double power, int distanceTicks, int coastTicks){
        super(engine);
        this.expectedPower = power;
        this.coastTicks = coastTicks;
        this.distanceTicks = distanceTicks;

        changeTime = coastTicks/(int)(expectedPower/0.01);
    }

    public void exec(){
        if(firstRun){
            initalEncoderPosition = dcFrontRight.getCurrentPosition();
            firstRun = false;
        }

        encoderPosition = dcFrontRight.getCurrentPosition() - initalEncoderPosition;

        if(encoderPosition < distanceTicks) {
            if (encoderPosition >= lastChangeTime + changeTime) {
                lastChangeTime += changeTime;
                currentPower += powerInc;
            }
        }




    }

}
