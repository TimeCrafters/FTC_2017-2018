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
    private SubEngine[] subEngines = new SubEngine[100];

    private State[][] subProcesses;

    private int threadX = 0;

    private boolean expandingArray;

    private int processesX = 0;
    private int processesY = 0;

    private int subX = 0;
    private int subY = 0;


    private boolean checkingStates = true;

    private int subEngineX = 0;
    boolean isSubEngineinit = false;

    public volatile double[][][] cache = new double[100][100][100];


    private static String TAG = "PROGRAM.ENGINE: ";
    private static String SUBTAG = "PROGRAM.SUBENGINE";
    private int x = 0;
    private int currentProcess = 0;
    private boolean machineFinished = false;
    private boolean opFininished = true;

    private boolean subProcessFinished = true;

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
        if(checkingStates) {
            checkStateFinished();
        }else{
            subEngines[x].evaluate();
            if(subEngines[x].isRunable()) {
                checkSubEngines();
            }else{
                Log.i(TAG, "SUB ENGINE NOT RUNNABLE : " + "[" + Integer.toString(x) + "]" + "[0]");
                checkingStates = true;
                x++;
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

    public void checkStateFinished(){
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


            }else if(subEngines[x] != null){
                checkingStates = false;
            }
            else if (processes[x][0] == null && !machineFinished) {
                Log.i(TAG, "MACHINE TERMINATED");
                machineFinished = true;
                stop();
            }

        }
    }

    public void checkSubEngines(){


        if(!isSubEngineinit){
            subEngines[x].setProcesses();
            subProcesses = subEngines[x].getProcesses();

            Log.i(TAG, "CREATED SUB ENGINE : " + "[" + Integer.toString(x) + "]" + "[0]");

            for(int i = 0; i < subProcesses.length; i ++){
                for(int y = 0; y < subProcesses.length; y ++ ){
                    if(subProcesses[i][y] != null){
                        String msg ="INTITALIZED SUBSTATE : " +"[" + Integer.toString(i) +"]" + "["+Integer.toString(y)+"]";
                        Log.i(SUBTAG,msg );
                        subProcesses[i][y].init();
                    }
                }
            }

            isSubEngineinit = true;
        }

        if(subProcessFinished){
            if(subProcesses[subX][0] != null){

                threadIndex = 0;
                for (int i = 0; i < subProcesses.length; i++) {
                    threads[i] = new Thread(subProcesses[subX][i]);
                    threads[i].start();
                    threadIndex ++;
                }
                subProcessFinished = false;
                currentProcess = subX;
                Log.i(SUBTAG, "STARTED SUB STATE : " + Integer.toString(subX));

            }else{
                x++;
                checkingStates = true;
            }
        }else{
            for(int i = 0; i < subProcesses.length; i ++){
                if(subProcesses[subX][i]!= null){
                    if(subProcesses[subX][i].getIsFinished()){
                        subProcessFinished = true;
                        Log.i(SUBTAG, "FINISHED SUB OP : " + "[" + Integer.toString(subX) + "]" + "[" + Integer.toString(i) + "]");
                    }else{
                        subProcessFinished = false;
                    }
                }else{
                    break;
                }

                if(subProcessFinished){
                    subX++;
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
        if(processes.length/3 - processesX > 0) {

            processesY = 0;

            processes[processesX][processesY] = state;

            processesY++;
            processesX++;

            Log.i(TAG, "ADDED NEW STATE AT : " + Integer.toString(processesX) );
        }else{
            expandingArray = true;
            Log.i(TAG, "REALOCATED ARRAY!!!! WOOO!!!!");
            State[][] temp = new State[processes.length*3][processes.length*3];
            System.arraycopy(processes,0,temp,0,processes.length);
            processes = temp;
            Log.i(TAG, "FINISHED ALLOCATION, ARRAY SIZE NOW : " + Integer.toString(processes.length));

            processesY = 0;

            processes[processesX][processesY] = state;

            processesY++;
            processesX++;
            expandingArray=false;
        }
    }

    public void addStateProcess(State state){
        processes[processesX -1][processesY] = state;
        processesY++;
    }

    public void addCacheData(int index, int layer, double data) {
        cache[x][index][layer] = data;
    }

    public double getCacheData(int index, int layer) {
        return cache[0][index][layer];
    }

    public void addSubEngine(SubEngine subEngine){
        subEngines[processesX] = subEngine;
        processesX++;
    }

}
