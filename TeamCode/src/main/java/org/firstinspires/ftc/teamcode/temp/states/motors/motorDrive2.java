package org.firstinspires.ftc.teamcode.temp.states.motors;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 6/2/2018.
 */

public class motorDrive2 extends State {
    private DcMotor motor1, motor2;
    public double motorSpeed1, motorSpeed2, motorpower;
    public motorDrive2(Engine engine, double motorpower) {
        this.engine = engine;
        this.motorpower = motorpower;

    }

    @Override
    public void init () {
        motor1 = engine.hardwareMap.dcMotor.get("motor1");
        motor2 = engine.hardwareMap.dcMotor.get("motor2");
        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorSpeed1 = 0.45;
        motorSpeed2 = motorpower;
    }

    @Override
    public void exec() throws InterruptedException {
        int difference = Math.abs (motor1.getCurrentPosition() - motor2.getCurrentPosition());
        motor1.setPower(motorSpeed1);
        motor2.setPower(motorSpeed2);
        engine.telemetry.addData("motor encoder difference",motor1.getCurrentPosition() - motor2.getCurrentPosition());
        engine.telemetry.addData("motor1 power",motor1.getPower());
        engine.telemetry.addData("motor2 power",motor2.getPower());
        engine.telemetry.update();
        sleep(10);
        if (difference<10) {
            motor1.setPower(motorSpeed1);
            motor2.setPower(motorSpeed2);

        }else if (motor1.getCurrentPosition() < motor2.getCurrentPosition()){
            motorSpeed2 = motorSpeed2 - .00005;
        }else if (motor1.getCurrentPosition() > motor2.getCurrentPosition()){
            motorSpeed2 = motorSpeed2 + .00005;
        }

    }
}