package net.virtalab.android.locateme;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.bugsense.trace.BugSenseHandler;
import net.virtalab.android.locateme.utils.S;

/**
 * Application Settings Activity
 * <p/>
 */
public class SettingsActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BugSenseHandler.initAndStartSession(this, S.BUGSENSE_API_KEY);
        setContentView(R.layout.settings);
    }
}
