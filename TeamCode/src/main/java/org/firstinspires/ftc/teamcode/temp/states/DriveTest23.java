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
    motor1.setPower(engine.gamepad1.right_stick_y*-1);
    motor2.setPower(engine.gamepad1.left_stick_y);
    }
}
