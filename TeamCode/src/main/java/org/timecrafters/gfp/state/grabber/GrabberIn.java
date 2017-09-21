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
        dcGrabber.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void exec(){
        dcGrabber.setPower(power);
        dcGrabber.setTargetPosition(position);

        if(dcGrabber.getCurrentPosition() >= dcGrabber.getTargetPosition()){
            setFinished(true);
        }


    }

    @Override
    public void stop(){
        dcGrabber.setTargetPosition(0);
    }

}
