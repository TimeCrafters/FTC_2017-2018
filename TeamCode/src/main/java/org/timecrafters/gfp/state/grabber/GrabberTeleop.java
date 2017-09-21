package org.timecrafters.gfp.state.grabber;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by t420 on 9/14/2017.
 */

public class GrabberTeleop extends Config {

    private double power;
    private int position;


    public GrabberTeleop(Engine engine, double power){
        super(engine);
        this.power = power;
    }

    @Override
    public void init(){
        super.init();

    }

    @Override
    public void exec(){



        if(engine.gamepad1.x){
            position ++;
            dcGrabber.setPower(power);
            dcGrabber.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }else if (engine.gamepad1.b){
            position --;
            dcGrabber.setPower(-power);
            dcGrabber.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }else{
            dcGrabber.setPower(power);
            dcGrabber.setTargetPosition(dcGrabber.getCurrentPosition());
            dcGrabber.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }



    }

    @Override
    public void stop(){
        dcGrabber.setTargetPosition(0);
    }

}
