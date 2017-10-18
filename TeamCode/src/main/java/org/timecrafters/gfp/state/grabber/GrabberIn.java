package org.timecrafters.gfp.state.grabber;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by t420 on 9/14/2017.
 */

public class GrabberIn extends Config {

    private double power;
    private int position;
    private int oldPosition;
    private int total;
    private int i;

    public GrabberIn(Engine engine, double power, int position){
        super(engine);
        this.power = power;
        this.position = position;
    }

    @Override
    public void init(){
        super.init();
        dcGrabberOne.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void exec(){
        dcGrabberOne.setPower(power);
        dcGrabberOne.setTargetPosition(position);

        if(dcGrabberOne.getCurrentPosition() >= dcGrabberOne.getTargetPosition()){
            setFinished(true);
        }


    }

    @Override
    public void stop(){
        dcGrabberOne.setTargetPosition(0);
    }

}