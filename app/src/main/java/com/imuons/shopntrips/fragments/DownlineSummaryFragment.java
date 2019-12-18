package com.imuons.shopntrips.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.imuons.shopntrips.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DownlineSummaryFragment extends Fragment {


    public DownlineSummaryFragment() {
        // Required empty public constructor
    }

    public static DownlineSummaryFragment newInstance() {
        DownlineSummaryFragment fragment = new DownlineSummaryFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_downline_summary, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
