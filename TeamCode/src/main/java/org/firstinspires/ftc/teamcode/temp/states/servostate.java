package org.firstinspires.ftc.teamcode.temp.states;

import com.qualcomm.robotcore.hardware.Servo;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 4/7/2018.
 */

public class servostate extends State {
    private Servo servo;
    private double position;
    private double random;

    public servostate(Engine engine){this.engine=engine;
    }
    public servostate(Engine engine, double position){
        this.engine= engine;
        this.position = position;
    }

    @Override
    public void init (){
        servo = engine.hardwareMap.servo.get("servo");
        servo.setDirection(Servo.Direction.FORWARD);

    }
    @Override
    public void exec() {
        random = Math.random();
        servo.setPosition(random);
        sleep(250);
        servo.setPosition(0);
        sleep(250);




    }
}
