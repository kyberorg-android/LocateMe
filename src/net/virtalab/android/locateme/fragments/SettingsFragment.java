package net.virtalab.android.locateme.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.virtalab.android.locateme.R;

/**
 * Fragment with application Settings
 * <p/>
 */
public class SettingsFragment extends Fragment {
    public static SettingsFragment getSelf(){
        return new SettingsFragment();
    }

    /**
     * Init SettingsFragment. Same as onCreate() for Activity.
     *
     * @param inflater attached view
     * @param container view Group
     * @param savedInstanceState saved Bundle
     * @return attached View
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View settingsView = inflater.inflate(R.layout.settings_fragment,container,false);
        return settingsView;
    }
}
