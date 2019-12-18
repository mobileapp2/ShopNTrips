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
public class FundRequestFragment extends Fragment {


    public FundRequestFragment() {
        // Required empty public constructor
    }

    public static FundRequestFragment newInstance() {
        FundRequestFragment fragment = new FundRequestFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fund_request, container, false);

        return view;
    }

}
