package org.firstinspires.ftc.teamcode.states.motors;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 3/31/2018.
 */

public class DcDrive extends State {
    private DcMotor motor;
public DcDrive (Engine engine){
    this.engine = engine;
}
    @Override
    public void init () {
        motor =this.engine.hardwareMap.dcMotor.get("motor1");
}
    @Override
    public void exec () {
        motor.setPower(0.2);
    }
}
