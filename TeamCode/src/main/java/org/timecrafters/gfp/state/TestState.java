package org.timecrafters.gfp.state;

import android.util.Log;

import org.timecrafters.engine.State;
import org.timecrafters.gfp.config.Config;

/**
 * Created by t420 on 11/4/2017.
 */

public class TestState extends State {

    int i = 0;

    private volatile boolean burger = false;

    public void init(){
        Log.i(TAG, "MADE IT TO INIT");
    }

    public void exec(){
        Log.i(TAG, "INSIDE EXEC");
        sleep(5000);
        Log.i(TAG, "LEAVING EXEC");
        burger = true;
        setFinished(true);
    }

    public boolean isBurger() {
        return burger;
    }
}
