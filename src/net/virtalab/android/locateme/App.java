package net.virtalab.android.locateme;

import android.app.Application;
import android.content.Context;

/**
 * Application class
 * <p/>
 */
public class App extends Application{
    /**
     * Application Tag for logging purposes
     */
    public static final String TAG = "LocateMe";
    /**
     * Application context
     */
    private static Context context;

    /**
     * Method called when application starts
     */
    public void onCreate(){
       super.onCreate();
       context = this;
    }

    /**
     * Provides App Context
     * @return context
     */
    public static Context getContext(){
       return context;
    }
}
