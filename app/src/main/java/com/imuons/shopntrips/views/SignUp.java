package com.imuons.shopntrips.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.imuons.shopntrips.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUp extends AppCompatActivity {
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.edit_name)
    EditText edit_name;
    @BindView(R.id.edit_mobile)
    EditText edit_mobile;
    @BindView(R.id.edit_email)
    EditText edit_email;
    @BindView(R.id.edit_state)
    EditText edit_state;
    @BindView(R.id.edit_city)
    EditText edit_city;
    @BindView(R.id.edit_address)
        EditText edit_address;
    @BindView(R.id.edit_pincode)
    EditText edit_pincode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

    }
}
