package org.timecrafters.gfp.Teleop;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by t420 on 10/19/2017.
 */

public class Grabbers extends Config {


    double power;
    boolean b=false;
    boolean x=false;
    boolean joystick=true;
    public Grabbers(Engine engine,double power){
        super(engine);
        this.power = power;
    }

    @Override
    public void exec(){

        //Right Grabber
        /*if(engine.gamepad2.right_bumper) {
            dcRightGrabber.setPower(upPower);

        }else if (engine.gamepad2.right_trigger > 0){
            dcRightGrabber.setPower(-upPower);
        }else{
            dcRightGrabber.setPower(0);
        }

        if(engine.gamepad2.left_bumper){
            dcLeftGrabber.setPower(-upPower);
        }else if(engine.gamepad2.left_trigger > 0){
            dcLeftGrabber.setPower(upPower);
        }else{
            dcLeftGrabber.setPower(0);
        }
*/
        dcRightGrabber.setPower(engine.gamepad2.right_stick_x);
        dcLeftGrabber.setPower(engine.gamepad2.left_stick_x);

        if (Math.abs(engine.gamepad2.right_stick_x) >= 0.1 || Math.abs(engine.gamepad2.left_stick_x) >= 0.1){
            joystick=false;

        }else{
            joystick=true;
        }

        if(engine.gamepad2.b){
            if(!b){
                dcRightGrabber.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
                dcRightGrabber.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                dcRightGrabber.setTargetPosition(dcRightGrabber.getCurrentPosition()+500);
                dcRightGrabber.setPower(1.0);
                b=true;
            }
        }else{

            b=false;
            if (joystick){
                dcRightGrabber.setPower(0.0);
            }
        }
        if(engine.gamepad2.x){
            if(!x){
                dcLeftGrabber.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
                dcLeftGrabber.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                dcLeftGrabber.setTargetPosition(dcLeftGrabber.getCurrentPosition()-500);
                dcLeftGrabber.setPower(-1.0);
                x=true;
            }
        }else{

            x=false;
            if (joystick){
                dcLeftGrabber.setPower(0.0);
                }
        }
    }
}