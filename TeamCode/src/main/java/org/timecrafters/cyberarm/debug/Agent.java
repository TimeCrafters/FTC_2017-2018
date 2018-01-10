package org.timecrafters.cyberarm.debug;

/**
 * Created by cyberarm on 1/9/2018.
 */

import android.util.Log;

/**
 * Service for monitoring time of things
 * `
 * ` Agent.setMilliseconds("String for curiousness")
 * ` thingThatYouWantToTrack();
 * ` Agent.reportMilliseconds(); => #{activeTag}: Time in milliseconds #{time_calculation}
 * `
 */
public class Agent {
    static private long activeMilliseconds;
    static private String activeTag;
    static private String[] tags = new String[100]; // complex inner loops
    static private long[] milliseconds = new long[100]; // complex inner loops

    static public void setMilliseconds(String tag) {
        activeTag = tag;
        activeMilliseconds = System.currentTimeMillis();
    }
    static public void setMilliseconds(String tag, int index) {
        tags[index] = tag;
        milliseconds[index] = System.currentTimeMillis();
    }

    static public long getMilliseconds() { return activeMilliseconds;}
    static public long getMilliseconds(int index) { return milliseconds[index];}

    static public void puts(String string) {
        Log.d("[DebugAgent]", string);
    }

    static public void reportMilliseconds() {
        puts(""+activeTag+": Time in milliseconds "+(System.currentTimeMillis()-getMilliseconds()));
    }
    static public void reportMilliseconds(int index) {
        puts(""+tags[index]+": Time in milliseconds "+(System.currentTimeMillis()-getMilliseconds(index)));
    }
}
