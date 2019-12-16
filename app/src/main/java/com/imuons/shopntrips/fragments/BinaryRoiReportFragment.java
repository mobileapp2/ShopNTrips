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
public class BinaryRoiReportFragment extends Fragment {


    public BinaryRoiReportFragment() {
        // Required empty public constructor
    }

    public static BinaryRoiReportFragment newInstance() {
        BinaryRoiReportFragment fragment = new BinaryRoiReportFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_binary_roi_report, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
