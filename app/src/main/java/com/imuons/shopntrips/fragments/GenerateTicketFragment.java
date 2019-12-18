package com.imuons.shopntrips.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.imuons.shopntrips.R;
import com.imuons.shopntrips.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GenerateTicketFragment extends Fragment {

    @BindView(R.id.edit_ticketNo)
    EditText edit_ticketNo;
    @BindView(R.id.edit_tittle)
    EditText edit_tittle;
    @BindView(R.id.edit_department)
    EditText edit_department;
    @BindView(R.id.edit_message)
    EditText edit_message;

    @BindView(R.id.uploadImage)
    LinearLayout uploadImage;

    @BindView(R.id.submit)
    Button submit;


    public GenerateTicketFragment() {
        // Required empty public constructor
    }

    public static GenerateTicketFragment newInstance() {
        GenerateTicketFragment fragment = new GenerateTicketFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_generate_ticket, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        if (Utils.checkInternetConnection(GenerateTicketFragment.this.getContext())) {
            
        } else {
            Toast.makeText(GenerateTicketFragment.this.getContext(),
                    getString(R.string.no_internet_connection_message), Toast.LENGTH_SHORT).show();
        }
    }

}
