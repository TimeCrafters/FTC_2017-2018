package org.timecrafters.gfp.state;

import android.util.Log;

import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/4/2017.
 */

public class TestState extends State {

    int i = 0;

    public void init(){
        Log.i(TAG, "MADE IT TO INIT");
    }

    public void exec(){
        Log.i(TAG, "INSIDE EXEC");
        if(i >= 5){
            setFinished(true);
        }
        i ++;
    }
}
