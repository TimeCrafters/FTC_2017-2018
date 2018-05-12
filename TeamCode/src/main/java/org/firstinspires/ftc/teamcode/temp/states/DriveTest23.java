package org.firstinspires.ftc.teamcode.temp.states;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 5/11/2018.
 */

public class DriveTest23 extends State {
    private DcMotor motor1;
    private DcMotor motor2;
    private double motorSpeed;
    private double lastMotorSpeed = 0.1;
    private double currentmotorspeed;
    public DriveTest23(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void init() {
        super.init();
        motor1 = engine.hardwareMap.dcMotor.get("motor1");
        motor2 = engine.hardwareMap.dcMotor.get("motor2");
        motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    @Override
    public void exec() {
    if (motorSpeed <1.0){
        motorSpeed = lastMotorSpeed+0.1;
        motor1.setPower(motorSpeed);
         sleep(250);
        lastMotorSpeed = motorSpeed;
         }else{
        motor1.setPower(1.0);
    }
    }


}
