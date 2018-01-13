package org.timecrafters.Liv.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Liv.SubEngines.BlueBackCenter;
import org.timecrafters.Liv.SubEngines.BlueBackLeft;
import org.timecrafters.Liv.SubEngines.BlueBackRight;
import org.timecrafters.Liv.SubEngines.RedBackLeft;
import org.timecrafters.engine.Engine;

/**
 * Created by Liv on 12/21/2017.
 */

@Autonomous(name="Blue Back")
public class BlueBack extends Engine {
    @Override
    public void setProcesses() {
        switch (1) {
            case 1:
                addSubEngine(new BlueBackRight(this));
                break;
            case 2:
                addSubEngine(new BlueBackLeft(this));
                break;
            case 3:
                addSubEngine(new BlueBackCenter(this));
                break;


        }

    }
}










