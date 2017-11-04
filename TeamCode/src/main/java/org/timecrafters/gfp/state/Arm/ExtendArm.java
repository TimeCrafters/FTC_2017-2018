package org.timecrafters.gfp.state.Arm;

import android.util.Log;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by t420 on 11/2/2017.
 */

public class ExtendArm extends Config {

    int rotations;

    int rotationCount = 0;

    boolean pressed = false;

    double power;

    public ExtendArm(Engine engine,double power, int rotations){
        super(engine);
        this.rotations = rotations;
        this.power = power;
    }

    public void exec(){

        svWinch.setPower(power);
//qwejroiqjewrq;ewjrqew rci1
        if(!pressed && winchTouch.isPressed()){
            pressed = true;
        }else if(pressed && !winchTouch.isPressed()){
            rotationCount ++;
            pressed = false;
        }


        Log.i(TAG,Integer.toString(rotationCount));

        if(rotationCount >= rotations){
            svWinch.setPower(0);
            setFinished(true);
        }

        engine.telemetry.addData("Touch Sensor",winchTouch.isPressed());
        engine.telemetry.update();

    }
}
