package net.virtalab.android.locateme;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Application Settings Activity
 * <p/>
 */
public class SettingsActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
    }
}
