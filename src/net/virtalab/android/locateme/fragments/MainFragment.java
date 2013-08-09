package net.virtalab.android.locateme.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.virtalab.android.locateme.R;

/**
 * Main fragment of application
 * <p/>
 */
public class MainFragment extends Fragment {
    public static MainFragment getSelf(){
        return new MainFragment();
    }
    /**
     * Init MainFragment. Same as onCreate() for Activity.
     *
     * @param inflater attached view
     * @param container view Group
     * @param savedInstanceState saved Bundle
     * @return attached View
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View settingsView = inflater.inflate(R.layout.home_fragment,container,false);
        return settingsView;
    }
}
