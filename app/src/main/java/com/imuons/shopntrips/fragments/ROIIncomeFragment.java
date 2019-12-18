package com.imuons.shopntrips.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imuons.shopntrips.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ROIIncomeFragment extends Fragment {


    public ROIIncomeFragment() {
        // Required empty public constructor
    }


    public static ROIIncomeFragment newInstance() {
        ROIIncomeFragment fragment = new ROIIncomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_roiincome, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}