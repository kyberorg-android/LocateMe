package net.virtalab.android.locateme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.viewpagerindicator.TabPageIndicator;
import net.virtalab.android.locateme.fragments.CustomLocationFragment;
import net.virtalab.android.locateme.fragments.MainFragment;
import net.virtalab.android.locateme.fragments.SettingsFragment;
import net.virtalab.android.locateme.utils.S;

/**
 * First activity user see in your app
 */
public class MainActivity extends FragmentActivity {
    private static final String TAG = App.TAG+":MainActivity";
    private static String[] TAB_LABELS;
    private static final int START_FRAGMENT = S.SECOND;

    static {
        String settingsTabLabel = App.getContext().getResources().getString(R.string.tab_label_settings);
        String mainTabLabel = App.getContext().getResources().getString(R.string.tab_label_home);
        String customLocationTabLabel = App.getContext().getResources().getString(R.string.tab_label_custom_location);

        TAB_LABELS = new String[]{settingsTabLabel, mainTabLabel, customLocationTabLabel };
    }
    /**
     * Init activity
     *
     * @param savedInstanceState saved Bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //do tab init
        //initTabs();

        //attach adapter
        FragmentPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.main_pager);
        TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.main_tab_indicator);


        if(adapter == null || pager==null || indicator==null){
           //FIXME add to debugUtils
           final String LT = System.getProperty("line.separator");
           //fatal error: Log + Report
           StringBuilder valuesSb = new StringBuilder();
           valuesSb.append("Values"+LT);
           valuesSb.append("Adapter: "+adapter+LT);
           valuesSb.append("Pager: "+pager+LT);
           valuesSb.append("Indicator: "+indicator+LT);

           Log.d(TAG, "FATAL Error."+valuesSb.toString());
           reportApplicationError();
        } else {
           //act as usual
           pager.setAdapter(adapter);
           indicator.setViewPager(pager);
           //setting Tab 2 as starting
           pager.setCurrentItem(START_FRAGMENT);
        }
    }

    /**
     * Hides all existing elements of activity and creates error string
     */
    private void reportApplicationError(){
        //get current layout
        LinearLayout myLayout = (LinearLayout) findViewById(R.id.main_layout);
        //hide all existing elements one-by-one
        try{
            TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.main_tab_indicator);
            ViewPager viewPager = (ViewPager) findViewById(R.id.main_pager);
            indicator.setVisibility(View.GONE);
            viewPager.setVisibility(View.GONE);
        }catch (Exception e){
            Log.e(TAG,"Unable to remove elements "+e.getMessage());
        }
        //create TextView
        TextView errorText = new TextView(this);
        errorText.setText(R.string.app_error_string);
        //attach to layout
        myLayout.addView(errorText);
    }

    /**
     * Triggers when user presses menu button
     *
     * @param menu menu object
     * @return response result
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuActions.createMenu(menu);
        return true;
    }

    /**
     * Triggered when some item of menu selected
     *
     * @param item selected item
     * @return success or fail on response
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int itemSelected = item.getItemId();

        switch (itemSelected){
            case MenuActions.SETTINGS_ITEM:
                startActivity(new Intent(this,SettingsActivity.class));
                break;
            default:
                return false;
        }

        return true;
    }


    /**
     * Pager Adapter for MainActivity. Link between activity and frgaments.
     */
    class MainPagerAdapter extends FragmentPagerAdapter{
        public MainPagerAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            Fragment fragment;
            switch (position){
                case S.FIRST:
                    fragment = SettingsFragment.getSelf();
                    break;
                case S.SECOND:
                    fragment = MainFragment.getSelf();
                    break;
                case S.THIRD:
                    fragment = CustomLocationFragment.getSelf();
                    break;
                default:
                    fragment = MainFragment.getSelf();
            }
            return fragment;
        }

        public CharSequence getPageTitle(int position){
            int maxSize = TAB_LABELS.length;
            //default
            int defaultTabIndex = S.SECOND;

            if(position >= S.FIRST || position <=maxSize ){
                return TAB_LABELS[position];
            } else {
                //position is out of range -> default
                return TAB_LABELS[defaultTabIndex];
            }
        }

        @Override
        public int getCount() {
            return TAB_LABELS.length;
        }
    }
    static class MenuActions{
        private static final int DEFAULT_MENU_GROUP = 0;
        private static final int SETTINGS_ITEM = Menu.FIRST;

        static void createMenu(Menu menu){
            menu.add(DEFAULT_MENU_GROUP,SETTINGS_ITEM,Menu.NONE,R.string.main_menu_settings);
        }
    }

}
