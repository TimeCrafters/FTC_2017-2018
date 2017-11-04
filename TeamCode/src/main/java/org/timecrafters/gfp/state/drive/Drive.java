package org.timecrafters.gfp.state.drive;

import android.util.Log;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by t420 on 11/2/2017.
 */

public abstract class Drive extends Config {

    public int distance;
    public double power;

    private int frontRight;
    private int frontLeft;
    private int backRight;
    private int backLeft;

    private boolean firstRun = true;
    private DcMotor[] motors;

    public Drive(Engine engine){
        super(engine);
    }

    public void exec(){
        if(firstRun){
            dcFrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            dcFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            dcBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            dcBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            dcFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            dcFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            dcBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            dcBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            firstRun = false;
        }

        dcFrontRight.setPower(frontRight*power);
        dcFrontLeft.setPower(frontLeft*power);
        dcBackRight.setPower(backRight*power);
        dcBackLeft.setPower(backLeft*power);

        int motorTickSubtotal = 0;
        int motorTickAverage = 0;
        for(int i = 0; i < motors.length; i ++){
            motorTickSubtotal += Math.abs(motors[i].getCurrentPosition());
            motorTickAverage = motorTickSubtotal/(i+1);
        }

        Log.i(TAG,Integer.toString(motorTickAverage));

        if(motorTickAverage >= distance){
            dcFrontRight.setPower(0);
            dcFrontLeft.setPower(0);
            dcBackRight.setPower(0);
            dcBackLeft.setPower(0);
            setFinished(true);
        }


    }

    public void setMotors(int frontLeft, int backLeft, int frontRight, int backRight){
        this.frontRight = -frontRight;
        this.frontLeft = -frontLeft;

        this.backRight = -backRight;
        this.backLeft = -backLeft;

    }

    public void setReadMotors(DcMotor[] motors){
        this.motors = motors;

    }


}
