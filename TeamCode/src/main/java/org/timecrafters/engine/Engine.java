package org.timecrafters.engine;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by t420 on 9/29/2016.
 * First sucess ful test was 5:00 6 thur oct 2016
 */
/*

::::::::: ::::::::::: :::        :::
:+:    :+:    :+:     :+:        :+:
+:+    +:+    +:+     +:+        +:+
+#++:++#+     +#+     +#+        +#+
+#+    +#+    +#+     +#+        +#+
#+#    #+#    #+#     #+#        #+#
######### ########### ########## ##########

 */


public abstract class Engine extends OpMode {

    //changed robot prefs
    public State[][] processes = new State[100][100];
    private Thread[] threads = new Thread[100];
    private int threadX = 0;

    private boolean expandingArray;

    private int stateX = 0;
    private int stateY = 0;

    public volatile double[][][] cache = new double[100][100][100];


    private static String TAG = "PROGRAM.ENGINE: ";
    private int x = 0;
    private int currentProcess = 0;
    private boolean machineFinished = false;
    private boolean opFininished = true;

    private int threadIndex;

    //sets processes
    public void init() {
        setProcesses();
        Log.i(TAG, Integer.toString(processes.length));
        if(!expandingArray) {
            for (int i = 0; i < processes.length; i++) {
                for (int y = 0; y < processes.length; y++) {
                    if (processes[i][y] != null) {
                        processes[i][y].init();
                        Log.i(TAG, "INIT" + "[" + Integer.toString(i) + "]" + "[" + Integer.toString(y) + "]");
                    }
                }
            }
        }

    }

    //checks if ops are finished
    public void loop() {
        if (!opFininished && !machineFinished) {

            for (int y = 0; y < processes.length; y++) {

                if (processes[x][y] != null) {
                    if (processes[x][y].getIsFinished()) {
                        opFininished = true;
                        Log.i(TAG, "FINISHED OP : " + "[" + Integer.toString(x) + "]" + "[" + Integer.toString(y) + "]");
                    } else {
                        opFininished = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (opFininished) {
                x++;
            }


        } else {
            if (processes[x][0] != null) {
                //set next state.
                threadIndex = 0;
                for (int i = 0; i < processes.length; i++) {
                    threads[i] = new Thread(processes[x][i]);
                    threads[i].start();
                    threadIndex ++;
                }
                opFininished = false;
                currentProcess = x;
                Log.i(TAG, "Started State : " + Integer.toString(x));


            } else if (processes[x][0] == null && !machineFinished) {
                Log.i(TAG, "MACHINE TERMINATED");
                machineFinished = true;
                stop();
            }

        }


    }

    //kills all processes running when program endes
    @Override
    public void stop() {
        for (int x = 0; x < processes.length; x++) {
            for (int y = 0; y < processes.length; y++) {
                if (processes[x][y] != null) {
                    processes[x][y].setFinished(true);
                    processes[x][y].stop();
                    Log.i(TAG, "KILLED OP : " + "[" + Integer.toString(x) + "]" + "[" + Integer.toString(y) + "]");
                } else {
                    break;
                }
            }
        }
    }

    //set processes in extended classes
    public abstract void setProcesses();

    public int getProcessIndex() {
        return x;
    }

    //adds the ability to add processes inside states
    public void addInLineProcess(State state,boolean init) {
        for(int i = 0; i < processes.length;i ++){
            if(processes[x][i] == null || processes[x][i].getIsFinished()){
                if(init){
                    state.init();
                }
                processes[x][i] = state;
                Thread thread = new Thread(processes[x][i]);
                thread.start();
                Log.i(TAG, "ADDED THREAD AT : " + "[" + Integer.toString(getProcessIndex()) + "]" + "[" + Integer.toString(i) + "]");
                break;
            }
        }

    }

    //Allows other states to end processes on the same index
    private void endProcess(int index, State state) {
        for (int i = 0; i < processes.length; i++) {
            if (processes[index][i] == state) {
                processes[index][i].setFinished(true);
                Log.i(TAG, "FORCED STOP AT : " + "[" + Integer.toString(getProcessIndex()) + "]" + "[" + Integer.toString(i) + "]");
                break;
            }
        }
    }

    public void addState(State state){
        if(processes.length/3 - stateX > 0) {

            stateY = 0;

            processes[stateX][stateY] = state;

            stateY++;
            stateX++;

            Log.i(TAG, "ADDED NEW STATE AT : " + Integer.toString(stateX) );
        }else{
            expandingArray = true;
            Log.i(TAG, "REALOCATED ARRAY!!!! WOOO!!!!");
            State[][] temp = new State[processes.length*3][processes.length*3];
            System.arraycopy(processes,0,temp,0,processes.length);
            processes = temp;
            Log.i(TAG, "FINISHED ALLOCATION, ARRAY SIZE NOW : " + Integer.toString(processes.length));

            stateY = 0;

            processes[stateX][stateY] = state;

            stateY++;
            stateX++;
            expandingArray=false;
        }
    }

    public void addStateProcess(State state){
        processes[stateX-1][stateY] = state;
        stateY ++;
    }

    public void addCacheData(int index, int layer, double data) {
        cache[x][index][layer] = data;
    }

    public double getCacheData(int index, int layer) {
        return cache[0][index][layer];
    }


}
