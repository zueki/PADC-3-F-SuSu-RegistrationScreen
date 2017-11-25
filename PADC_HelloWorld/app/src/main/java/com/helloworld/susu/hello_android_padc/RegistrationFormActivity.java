package com.helloworld.susu.hello_android_padc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by USER on 11/17/2017.
 */

public class RegistrationFormActivity extends AppCompatActivity {


    public static Intent newIntent(Context context) {

        Intent intent = new Intent(context, RegistrationFormActivity.class);
        return intent;


    }

    private EditText etName;
    private EditText etPhoneNo;
    private EditText etEmail;
    private EditText etPwd;
    private EditText etConfimPwd;
    private TextView tvGender;

    private EditText etAddress;
    private CheckBox cbAddress;
    private Button btnLogin;

    private RadioGroup rbGroup;
    private RadioButton rbButton;
    private RadioButton rbMale;
    private RadioButton rbFemale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        etName = findViewById(R.id.et_name);
        etPhoneNo = findViewById(R.id.et_phone_no);
        etEmail = findViewById(R.id.et_email);
        etPwd = findViewById(R.id.et_pwd);
        etConfimPwd = findViewById(R.id.et_confim_pwd);
        rbMale = findViewById(R.id.rb_male);
        rbFemale = findViewById(R.id.rb_female);
        etAddress = findViewById(R.id.et_address);
        cbAddress = findViewById(R.id.cb_address);
        btnLogin = findViewById(R.id.btn_login);
        rbFemale = findViewById(R.id.rb_female);
        rbMale = findViewById(R.id.rb_male);
        rbGroup = findViewById(R.id.rb_group);
        rbGroup = findViewById(R.id.rb_group);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = etName.getText().toString();
                String PhoneNumber = etPhoneNo.getText().toString();
                String Email = etEmail.getText().toString();
                String Pwd = etPwd.getText().toString();
                String Confirmpwd = etConfimPwd.getText().toString();
                String Address = etAddress.getText().toString();

                int selectedId = rbGroup.getCheckedRadioButtonId();
                rbButton = findViewById(selectedId);

                if (null == rbButton && selectedId < -1) {
                    rbButton.setError("Radio Button can not be Empty");
                    return;

                }

                if (TextUtils.isEmpty(Name)) {
                    etName.setError("Name can not be Empty");
                    return;
                }


                if (TextUtils.isEmpty(PhoneNumber)) {
                    etPhoneNo.setError("PhoneNumber can not be Empty");
                    return;
                }


                if (TextUtils.isEmpty(Email)) {
                    etEmail.setError("Email Or Phone can not be Empty");
                    return;
                }


                if (TextUtils.isEmpty(Pwd)) {
                    etPwd.setError("Password can not be Empty");
                    return;
                }


                if (TextUtils.isEmpty(Confirmpwd)) {
                    etConfimPwd.setError("Password can not be Empty");
                    return;
                }


                if ((!TextUtils.isEmpty(Pwd)) && (!TextUtils.isEmpty(Confirmpwd))) {
                    if (!TextUtils.equals(Pwd, Confirmpwd)) {
                        etConfimPwd.setError("Please retype the password");
                        return;

                    }
                }


                if (TextUtils.isEmpty(Address)) {
                    etAddress.setError("Address can not be Empty");
                    return;
                }


                if (!cbAddress.isChecked()) {
                    cbAddress.setError("CheckBox can not be Empty");
                    return;
                }


                if ((etAddress != null) && (etPwd != null) && (etEmail != null) && (etName != null) && (etEmail != null) && (cbAddress != null) && rbButton != null) {
                    Intent intent = RegistrationFormActivity.newIntent(getApplicationContext());
                    startActivity(intent);

                }


            }

        });


    }


}

