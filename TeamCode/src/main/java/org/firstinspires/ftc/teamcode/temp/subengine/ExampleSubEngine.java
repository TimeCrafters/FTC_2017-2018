package org.firstinspires.ftc.teamcode.temp.subengine;

import org.firstinspires.ftc.teamcode.temp.states.motors.MotorDrive3;
import org.firstinspires.ftc.teamcode.temp.states.motors.motorDrive;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.SubEngine;

/**
 * Created by t420-1 on 6/23/2018.
 */

public class ExampleSubEngine extends SubEngine{
    Engine engine;
    public ExampleSubEngine(Engine engine) {
        this.engine = engine;
    }
    @Override
    public void setProcesses() {
        addState(new motorDrive(engine));

    }

    @Override
    public void evaluate() {
        setRunable(true);

    }
}
