package com.imuons.shopntrips.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imuons.shopntrips.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FundTransferReportFragment extends Fragment {


    public FundTransferReportFragment() {
        // Required empty public constructor
    }

    public static FundTransferReportFragment newInstance() {
        FundTransferReportFragment fragment = new FundTransferReportFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fund_transfer_report, container, false);
    }

}
