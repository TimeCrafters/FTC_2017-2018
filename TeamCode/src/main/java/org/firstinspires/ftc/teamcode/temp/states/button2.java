package org.firstinspires.ftc.teamcode.temp.states;

import com.qualcomm.robotcore.hardware.TouchSensor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 5/7/2018.
 */

public class button2 extends State{
    private boolean Buttonpressed;
    private boolean doingSomthingOrNotDoingSomthing;
    private TouchSensor touchSensor;
    private double touchsensorvalue;
    private double touchsensorpast;
    public button2(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void init() {
        super.init();
        touchSensor = engine.hardwareMap.touchSensor.get("touch");
    }

    @Override
    public void exec() {

    touchsensorvalue = touchSensor.getValue();

    if (touchsensorvalue == touchsensorpast){
        //no transition do nothing
    }else{
        if (touchsensorvalue == 1.0){
            //do something
            doingSomthingOrNotDoingSomthing = !doingSomthingOrNotDoingSomthing;

        }else{
            //do nothing
        }
    }
    touchsensorpast = touchsensorvalue;
    engine.telemetry.addData("PushVuttonValue",touchsensorvalue);
    engine.telemetry.addData("do?",doingSomthingOrNotDoingSomthing);
    engine.telemetry.update();

    }
}
