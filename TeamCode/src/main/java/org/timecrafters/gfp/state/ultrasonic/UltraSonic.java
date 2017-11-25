package org.timecrafters.gfp.state.ultrasonic;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by t420 on 11/16/2017.
 */

public class UltraSonic extends Config {

    private boolean runUntillDistance;
    private int runDistance;

    private int currentDistance;
    private double[] distances;

    private ModernRoboticsI2cRangeSensor sensor;

    public UltraSonic(Engine engine, int readings){
        super(engine);
        distances = new double[readings];
    }

    public void exec(){

        //Take readings to fill distances array
        for(int i = 0; i < distances.length; i ++){
            double distance = sensor.getDistance(DistanceUnit.CM);

            if(distance > 0 && distance < 255) {
                distances[i] = distance;
            }
        }



        if(runUntillDistance){

        }

    }

    public void runUntillDistance(int runDistance){
        this.runDistance = runDistance;
        runUntillDistance = true;
    }

    public void setSensor(ModernRoboticsI2cRangeSensor sensor){
        this.sensor = sensor;
    }

}
