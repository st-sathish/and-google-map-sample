package com.extras;

import android.util.Log;

public class Loggr {

    private static final boolean IS_ERROR_ENABLED = false;

    private static final boolean IS_DEBUG_ENABLED = true;

    private static final String APP_NAME_TAG = "Spot";

    public static void debug(String aMessage) {
        if (IS_DEBUG_ENABLED) {
            Log.d(APP_NAME_TAG, aMessage);
        }
    }

    public static void error(String aMessage) {
        if (IS_ERROR_ENABLED) {
            Log.e(APP_NAME_TAG, aMessage);
        }
    }
}
