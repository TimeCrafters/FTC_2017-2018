package org.firstinspires.ftc.teamcode.temp.Teleop;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 5/12/2018.
 */

public class TeleopMotorControll extends State {
    DcMotor motor;
    private double rightStickAmount;

    public TeleopMotorControll(Engine engine) {
        this.engine = engine;

    }

    @Override
    public void init() {
        super.init();
        motor = engine.hardwareMap.dcMotor.get("rightmotor");
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    @Override
    public void exec() {
        rightStickAmount = engine.gamepad2.right_stick_y;
            motor.setPower(-1*rightStickAmount);
    }
}
