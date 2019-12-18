package com.imuons.shopntrips.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.imuons.shopntrips.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DashboardFragment extends Fragment {


    @BindView(R.id.txt_DirectIncome)
    TextView txt_DirectIncome;
    @BindView(R.id.txt_LeftMP)
    TextView txt_LeftMP;
    @BindView(R.id.txt_RightMP)
    TextView txt_RightMP;
    @BindView(R.id.txt_TotalWithdrawal)
    TextView txt_TotalWithdrawal;
    @BindView(R.id.txt_BinaryIncome)
    TextView txt_BinaryIncome;
    @BindView(R.id.txt_RipBinaryIncome)
    TextView txt_RipBinaryIncome;
    @BindView(R.id.txt_BinaryROIIncome)
    TextView txt_BinaryROIIncome;
    @BindView(R.id.txt_DirectROIIncome)
    TextView txt_DirectROIIncome;
    @BindView(R.id.txt_ROIIncome)
    TextView txt_ROIIncome;
    @BindView(R.id.txt_TotalIncome)
    TextView txt_TotalIncome;
    @BindView(R.id.btn_DirectNewJoining)
    ImageView btn_DirectNewJoining;
    @BindView(R.id.btn_GenerateTicket)
    ImageView btn_GenerateTicket;


    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

}
