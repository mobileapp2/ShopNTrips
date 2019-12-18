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
        // getDepartments();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Utils.checkInternetConnection(GenerateTicketFragment.this.getContext())) {
            // getDepartments();
        } else {
            Toast.makeText(GenerateTicketFragment.this.getContext(),
                    getString(R.string.no_internet_connection_message), Toast.LENGTH_SHORT).show();
        }
    }

   /* private void getDepartments() {
        final ProgressDialog pd = ViewUtils.getProgressBar(GenerateTicketFragment.this.getContext(), "Loading...", "Please wait..!");

        ShopNTrips apiService = ApiHandler.getApiService();
        final Call<DepartmentResponseModel> loginCall = apiService.wsGetDepartments("Bearer " + SharedPreferenceUtils.getLoginObject(
                GenerateTicketFragment.this.getContext()).get().getAccess_token());
        loginCall.enqueue(new Callback<DepartmentResponseModel>() {
            @SuppressLint("WrongConstant")
            @Override
            public void onResponse(Call<DepartmentResponseModel> call,
                                   Response<DepartmentResponseModel> response) {
                pd.hide();
                if (response.isSuccessful()) {
                    DepartmentResponseModel DepartmentResponseModel = response.body();
                    if (DepartmentResponseModel.getCode() == Constants.RESPONSE_CODE_OK &&
                            DepartmentResponseModel.getStatus().equals("OK")) {
                     //   setSpinnerAdapter(DepartmentResponseModel.getData());
                    } else {
                        Toast.makeText(GenerateTicketFragment.this.getContext(), DepartmentResponseModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<DepartmentResponseModel> call,
                                  Throwable t) {
                pd.hide();
                Toast.makeText(SupportFragment.this.getContext(), getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
            }
        });
    }*/

}
