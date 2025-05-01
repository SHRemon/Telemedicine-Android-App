package com.remon.digicure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {

    Button submit;
    EditText email;
    TextView login;
    private FirebaseAuth auth;
    String emailz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        submit = findViewById(R.id.Submit_Btnz);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = findViewById(R.id.edit_EmailF_text);
                emailz = email.getText().toString();
                if(emailz.isEmpty()){
                    email.setError("Required");
                    Toast.makeText(ForgetPassword.this, "Email Field is Empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    auth = FirebaseAuth.getInstance();
                    validate();
                }
            }
        });


        login = findViewById(R.id.login_go_text);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgetPassword.this, loginPage.class));
                finish();
            }
        });

    }
    public void validate(){
        auth.sendPasswordResetEmail(emailz).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ForgetPassword.this, "Check Your Mail", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgetPassword.this, loginPage.class));
                    finish();
                }
                else{
                    Toast.makeText(ForgetPassword.this, "Error : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}