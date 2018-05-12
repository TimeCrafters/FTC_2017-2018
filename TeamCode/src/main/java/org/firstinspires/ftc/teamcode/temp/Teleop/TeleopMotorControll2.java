package org.firstinspires.ftc.teamcode.temp.Teleop;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 5/12/2018.
 */

public class TeleopMotorControll2 extends State {
    DcMotor motor;
    private double leftStickAmount;

    public TeleopMotorControll2(Engine engine) {
        this.engine = engine;

    }

    @Override
    public void init() {
        super.init();
        motor = engine.hardwareMap.dcMotor.get("leftmotor");
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    @Override
    public void exec() {
        leftStickAmount = engine.gamepad2.left_stick_y;
            motor.setPower(leftStickAmount);

    }
}
