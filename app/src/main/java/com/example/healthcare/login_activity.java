package com.example.healthcare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_activity extends AppCompatActivity {
    TextView tv_log,tv_reg;
    Button btn_login;
    private ImageView img;
    EditText et_email_login,et_pas_login;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    //    CheckBox cb_remember;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;

    //ViewPager viewPager;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);





//        SharedPreferences preferences= getSharedPreferences("checkbox",MODE_PRIVATE);
//        String checkbox= preferences.getString("remember","");
//        if(checkbox.equals("true")){
//            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
//            startActivity(intent);
//
//        }
//        else{
//
//        }

        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null){
            //profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }

        tv_log=(TextView) findViewById(R.id.tv_log);
        tv_reg=(TextView) findViewById(R.id.tv);
        btn_login=(Button) findViewById(R.id.btn_login);
        et_email_login=(EditText) findViewById(R.id.et_email_login);
        et_pas_login=(EditText) findViewById(R.id.et_pas_login);
        img=(ImageView)findViewById((R.id.imageView2));

//        cb_remember=(CheckBox) findViewById(R.id.cb_remember);
//
//        cb_remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(compoundButton.isChecked()){
//                    SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE );
//                    SharedPreferences.Editor editor=preferences.edit();
//                    editor.putString("remember","true");
//                    editor.apply();
//
//                }
//                else{
//                    SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE );
//                    SharedPreferences.Editor editor=preferences.edit();
//                    editor.putString("remember","false");
//                    editor.apply();
//
//                }
//
//
//
//            }
//        });
        saveLoginCheckBox = (CheckBox)findViewById(R.id.cb_remember);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            et_email_login.setText(loginPreferences.getString("username", ""));
            et_pas_login.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_user();
            }
        });

        tv_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg=new Intent(getApplicationContext(),register.class);
                startActivity(reg);
            }
        });
    }


    private void login_user() {
        String email=et_email_login.getText().toString().trim();
        String password=et_pas_login.getText().toString().trim();
        if (saveLoginCheckBox.isChecked()) {
            loginPrefsEditor.putBoolean("saveLogin", true);
            loginPrefsEditor.putString("username", email);
            loginPrefsEditor.putString("password", password);
            loginPrefsEditor.commit();
        } else {
            loginPrefsEditor.clear();
            loginPrefsEditor.commit();
        }

//              if email is empty do not proceed further

        if(TextUtils.isEmpty(email)){
            Toast.makeText(login_activity.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
            return;
        }
//              if password is empty
        if(TextUtils.isEmpty(password)){
            Toast.makeText(login_activity.this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Logging in...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    if(firebaseAuth.getCurrentUser()!=null){
                        //profile activity here
                        finish();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
//                                direct to the profile of user
//                                or display message of success

                    Toast.makeText(login_activity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(login_activity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

