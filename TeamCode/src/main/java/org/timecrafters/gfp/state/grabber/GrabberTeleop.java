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
    private boolean firstStopOne;
    private boolean firstStopTwo;


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



        if(engine.gamepad1.left_trigger > 0){
            position ++;
            dcGrabberOne.setPower(power);
            dcGrabberOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            firstStopOne = true;
        }else if (engine.gamepad1.right_trigger > 0){
            position --;
            dcGrabberOne.setPower(-power);
            dcGrabberOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            firstStopOne = true;
        }else{
            if(firstStopOne) {
                dcGrabberOne.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                dcGrabberOne.setPower(power);
                dcGrabberOne.setTargetPosition(dcGrabberOne.getCurrentPosition());
                firstStopOne = false;
            }

        }

        if(engine.gamepad1.left_bumper ){
            dcGrabberTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            dcGrabberTwo.setPower(power);
            firstStopTwo = true;
        }else if(engine.gamepad1.right_bumper){
            dcGrabberTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            dcGrabberTwo.setPower(-power);
            firstStopTwo = true;
        }else{
            if(firstStopTwo) {
                dcGrabberTwo.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                dcGrabberTwo.setTargetPosition(dcGrabberTwo.getCurrentPosition());
                firstStopTwo = false;

            }

        }





    }

    @Override
    public void stop(){
        dcGrabberOne.setTargetPosition(0);
    }

}
