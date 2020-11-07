package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserReg extends AppCompatActivity {

    Button btn_register;
    EditText et_email,et_password,ayush_id;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    TextView tv_signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_user_reg);


        Intent intent = getIntent();


        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        btn_register = (Button) findViewById (R.id.btn_login);
        et_email=(EditText) findViewById(R.id.et_email_login);
        et_password=(EditText) findViewById(R.id.et_pas_login);
        tv_signin=(TextView) findViewById(R.id.tv_signin);
        ayush_id=(EditText)findViewById (R.id.ayush_id);

        tv_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login=new Intent(getApplicationContext(),login_activity.class);
                startActivity(login);
            }
        });



        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register_user();
                Intent login=new Intent(getApplicationContext(),login_activity.class);
                startActivity (login);
            }
        });
    }

    private void register_user() {
        String ayushmanID=ayush_id.getText().toString().trim();
        String email=et_email.getText().toString().trim();
        String password=et_password.getText().toString().trim();

//              if email is empty do not proceed further

        if(TextUtils.isEmpty(ayushmanID)){
            Toast.makeText(UserReg.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(UserReg.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
            return;
        }
//              if password is empty
        if(TextUtils.isEmpty(password)){
            Toast.makeText(UserReg.this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult> () {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
//                                direct to the profile of user
//                                or display message of success
                    Toast.makeText(UserReg.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                }
                else{
                    progressDialog.dismiss();
                    Toast.makeText(UserReg.this, "Could not Register", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}

