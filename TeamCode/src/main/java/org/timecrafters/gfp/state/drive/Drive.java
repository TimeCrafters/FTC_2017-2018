package org.timecrafters.gfp.state.drive;

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

    private double powerInc = 0.05;
    private int powerChanges;

    private int rampDistance;
    private int rampChangeDistances;

    private double currentPower;
    private int lastChangePosition = 0;


    public Drive(Engine engine){
        super(engine);
    }

    public void init(){
        super.init();
        rampDistance = (int)(distance *.20);
        powerChanges = (int)(power/powerInc);
        rampChangeDistances = (int)rampDistance/powerChanges;
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
            currentPower = powerInc;

        }

        //Average necersary motors
        int motorTickSubtotal = 0;
        int motorTickAverage = 0;
        for(int i = 0; i < motors.length; i ++){
            motorTickSubtotal += Math.abs(motors[i].getCurrentPosition());
            motorTickAverage = motorTickSubtotal/(i+1);
        }

        //check if ramping up
        if(motorTickAverage < rampDistance ){
            if(motorTickAverage >= lastChangePosition+rampChangeDistances){
                lastChangePosition = motorTickAverage;
                currentPower += powerInc;
            }
        }
        //check if ramping down
        else if(motorTickAverage >= distance - rampDistance){
            if(motorTickAverage >= lastChangePosition + rampChangeDistances){
                lastChangePosition = motorTickAverage;
                currentPower -= powerInc;
            }
        }
        //if not ramping up or down set power to absolute
        else{
            currentPower = power;
            lastChangePosition = motorTickAverage;
        }

        //Check if state needs to be finished
        if(motorTickAverage >= distance){
            dcFrontRight.setPower(0);
            dcFrontLeft.setPower(0);
            dcBackRight.setPower(0);
            dcBackLeft.setPower(0);
            setFinished(true);
        }

        dcFrontRight.setPower(frontRight*currentPower);
        dcFrontLeft.setPower(frontLeft*currentPower);
        dcBackRight.setPower(backRight*currentPower);
        dcBackLeft.setPower(backLeft*currentPower);
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
