package com.imuons.shopntrips.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.imuons.shopntrips.R;
import com.imuons.shopntrips.fragments.DashboardFragment;

import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, DashboardFragment.newInstance()).commit();
    }
}
