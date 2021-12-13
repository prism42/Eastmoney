package com.tkid.eastmoney;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;

import com.jaeger.library.StatusBarUtil;
import com.tkid.eastmoney.constant.Constant;
import com.tkid.eastmoney.ui.activity.AppDebugActivity;
import com.tkid.eastmoney.ui.fragment.HomeFragment;
import com.tkid.eastmoney.ui.fragment.InformationFragment;
import com.tkid.eastmoney.ui.fragment.MarketFragment;
import com.tkid.eastmoney.ui.fragment.OptionalFragment;
import com.tkid.eastmoney.ui.fragment.TradingFragment;
import com.tkid.eastmoney.widget.BottomControlPanel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private BottomControlPanel bottomPanel = null;
    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction = null;
    public static int currentTab;
    private List<Fragment> fragments = new ArrayList<Fragment>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setColor(MainActivity.this, getColor(R.color.orange_bg2));
        StatusBarUtil.setTransparent(MainActivity.this);
        initUI();
        initFragments();
    }

    private void initUI() {

        bottomPanel = findViewById(R.id.bottom_layout);
        if (bottomPanel != null) {
            bottomPanel.initBottomPanel();
            bottomPanel.setBottonCallback(new MyBottomPanelListener());
            bottomPanel.defaultButtonChecked();
        }

    }
    public void initFragments() {
        fragments.add(new HomeFragment());
        fragments.add(new InformationFragment());
        fragments.add(new OptionalFragment());
        fragments.add(new MarketFragment());
        fragments.add(new TradingFragment());
        currentTab = Constant.BTN_FLAG_HOME;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_content, fragments.get(0));
        fragmentTransaction.commit();
    }


    private void switchFragment(int index) {
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragments.get(index);
        fragments.get(currentTab).onPause();
        if (fragment.isAdded()) {
            fragment.onResume();
        } else {
            fragmentTransaction.add(R.id.fragment_content, fragment);

        }
        showTab(index);
        fragmentTransaction.commit();
    }
    private void showTab(int idx) {
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            if (idx == i) {
                fragmentTransaction.show(fragment);
            } else {
                fragmentTransaction.hide(fragment);
            }
        }
        currentTab = idx;
    }
    class MyBottomPanelListener implements BottomControlPanel.BottomPanelCallback {

        @Override
        public void onBottomPanleClick(int itemID) {
            switchFragment(itemID);
        }
    }
}