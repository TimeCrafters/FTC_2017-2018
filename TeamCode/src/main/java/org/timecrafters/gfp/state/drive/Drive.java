package org.timecrafters.gfp.state.drive;

import android.util.Log;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;
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

    private int frontRightStart;
    private int frontLeftStart;
    private int backRightStart;
    private int backLeftStart;

    private boolean runUntillStateFinished = false;
    private volatile State finishedState;

    private boolean[] finished = new boolean[4];


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

            frontRightStart = Math.abs(dcFrontRight.getCurrentPosition());
            frontLeftStart = Math.abs(dcFrontLeft.getCurrentPosition());
            backRightStart = Math.abs(dcBackRight.getCurrentPosition());
            backLeftStart = Math.abs(dcBackLeft.getCurrentPosition());

            currentPower = powerInc;
            firstRun = false;
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

        int dcFrontRightEncoder =   Math.abs(dcFrontRight.getCurrentPosition())-frontRightStart;
        int dcFrontLeftEncoder = Math.abs(dcFrontLeft.getCurrentPosition()) - frontLeftStart;
        int dcBackRightEncoder = Math.abs(dcBackRight.getCurrentPosition()) - backRightStart;
        int dcBackLeftEncoder = Math.abs(dcBackLeft.getCurrentPosition()) - backLeftStart;
        //Chack if running untill state is finished
        //TODO make this a switch statement to account for other runmodes you lazy bum
        if(runUntillStateFinished){

            if(finishedState.getIsFinished()){
                dcFrontRight.setPower(0);
                dcFrontLeft.setPower(0);
                dcBackRight.setPower(0);
                dcBackLeft.setPower(0);

                for(int i = 0; i < finished.length; i ++){
                    finished[i] = true;
                }
            }else{
                dcFrontRight.setPower(currentPower*frontRight);
                dcFrontLeft.setPower(currentPower*frontLeft);

                dcBackLeft.setPower(currentPower*backLeft);
                dcBackRight.setPower(currentPower*backRight);

            }

        }else {
            if (dcFrontRightEncoder >= distance) {
                finished[0] = true;
                dcFrontRight.setPower(0);
            } else {
                dcFrontRight.setPower(power * frontRight);
            }
            if (dcFrontLeftEncoder >= distance) {
                finished[1] = true;
                dcFrontLeft.setPower(0);
            } else {
                dcFrontLeft.setPower(power * frontLeft);
            }
            if (dcBackRightEncoder >= distance) {
                finished[2] = true;
                dcBackRight.setPower(0);
            } else {
                dcBackRight.setPower(power * backRight);
            }
            if (dcBackLeftEncoder >= distance) {
                finished[3] = true;
                dcBackLeft.setPower(0);
            } else {
                dcBackLeft.setPower(power * backLeft);
            }
        }



        Log.i(TAG+".DRIVEMOTORS", "Front Right :" +  Integer.toString(dcFrontRightEncoder));
        Log.i(TAG+".DRIVEMOTORS", "Front Left :" + Integer.toString(dcFrontLeftEncoder));

        Log.i(TAG+".DRIVEMOTORS", "Back Right :" + Integer.toString(dcBackRightEncoder));
        Log.i(TAG+".DRIVEMOTORS", "Back Left :" + Integer.toString(dcBackLeftEncoder));

        Log.i(TAG+".DRIVEMOTORS","---------");

        boolean finishedReturn = true;
        for(int i = 0; i < finished.length; i ++){
            if(finished[i] == false){
                finishedReturn = false;
                break;
            }
        }
        setFinished(finishedReturn);

    }

    public void runUntillStateFinished(State state){
        runUntillStateFinished = true;
        finishedState = state;
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

    public void stop(){
        dcFrontLeft.setPower(0);
        dcFrontRight.setPower(0);
        dcBackLeft.setPower(0);
        dcBackRight.setPower(0);
    }



}
