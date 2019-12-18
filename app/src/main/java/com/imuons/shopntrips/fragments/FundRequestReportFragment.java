package com.imuons.shopntrips.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imuons.shopntrips.R;


public class FundRequestReportFragment extends Fragment {


    public FundRequestReportFragment() {
        // Required empty public constructor
    }

    public static FundRequestReportFragment newInstance() {
        FundRequestReportFragment fragment = new FundRequestReportFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fund_request_report, container, false);

    return view;
    }



}
