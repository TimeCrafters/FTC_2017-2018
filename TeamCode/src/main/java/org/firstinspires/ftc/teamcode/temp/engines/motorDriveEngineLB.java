package org.firstinspires.ftc.teamcode.temp.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.temp.states.motors.motorDrive;
import org.firstinspires.ftc.teamcode.temp.states.motors.motorDrive2;
import org.timecrafters.engine.Engine;

/**
 * Created by t420-1 on 6/2/2018.
 */
@TeleOp(name = ("luke's best Autonomous"))
public class motorDriveEngineLB extends Engine {
    @Override
    public void setProcesses() {
      addState(new motorDrive(this));
      //addThreadedState(new motorDrive2(this, 0.5));
    }
}
