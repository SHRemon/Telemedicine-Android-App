package com.remon.digicure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class loginPage extends AppCompatActivity {

    private FirebaseAuth auth;
    TextView memberSignUp, forgetPass;
    EditText logEmail, LogPass;
    Button loginBtn;
    String pat = "Patient";
    String doc = "Doctor";

    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait...");

        loginBtn = findViewById(R.id.login1);

        memberSignUp= findViewById(R.id.sign_up_Text);

        memberSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginPage.this, SignUpPage.class));
                finish();
            }
        });

        forgetPass = findViewById(R.id.Forgot_password_Text);
        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginPage.this, ForgetPassword.class));
                finish();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                logEmail = findViewById(R.id.edit_login_Email);
                LogPass = findViewById(R.id.edit_login_pass);

                String email = logEmail.getText().toString();
                String pass = LogPass.getText().toString();

                auth = FirebaseAuth.getInstance();
                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        dialog.dismiss();
                                        Toast.makeText(loginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(loginPage.this, MainDashboard.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialog.dismiss();
                                        Toast.makeText(loginPage.this, "Email or Password is incorrect!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        LogPass.setError("Password is Empty");
                    }
                } else if (email.isEmpty()) {
                    logEmail.setError("Email is Empty");
                } else {
                    logEmail.setError("Please enter correct email");
                }
            }
        });
    }
}
 /* if (logEmail_.isEmpty() || LogPass_.isEmpty()){
                    Toast.makeText(loginPage.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    final String username_data = logEmail.getText().toString();
                    final String password_data = LogPass.getText().toString();

                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference = firebaseDatabase.getReference("datauser");

                    Query checkEmail = databaseReference.orderByChild("lname").equalTo(username_data);
                    checkEmail.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.exists()){
                                    String passCheck = snapshot.child(username_data).child("pass").getValue(String.class);
                                    if(passCheck.equals(password_data)){

                                            Toast.makeText(loginPage.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                                            startActivity(new Intent(loginPage.this, MainDashboard.class));
                                            finish();


                                    }
                                    else{
                                        Toast.makeText(loginPage.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                    }
                            }
                            else {
                                Toast.makeText(loginPage.this, "Username Doesn't Exit", Toast.LENGTH_SHORT).show();
                            }

                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }*/




  /*  String typeCheck = snapshot.child(username_data).child("type").getValue(String.class);
                                        if(pat.equals(typeCheck)){

                                            String Namex = snapshot.child(username_data).child("fname").getValue(String.class);
                                            String typex = typeCheck;
                                            String userzx = snapshot.child(username_data).child("lname").getValue(String.class);
                                            String GendX = snapshot.child(username_data).child("gender").getValue(String.class);
                                            String EmailX = snapshot.child(username_data).child("email").getValue(String.class);


                                            Intent intentz = new Intent(getApplicationContext(), MainDashboard.class);

                                            intentz.putExtra("Namex",Namex);
                                            intentz.putExtra("typex",typex);
                                            intentz.putExtra("userzx",userzx);
                                            intentz.putExtra("GendX",GendX);
                                            intentz.putExtra("EmailX",EmailX);

                                            Toast.makeText(loginPage.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                                            startActivity(new Intent(loginPage.this, MainDashboard.class));
                                            finish();

                                        }

                                        else if(doc.equals(typeCheck)){

                                            String Namex = snapshot.child(username_data).child("fname").getValue(String.class);
                                            String typex = typeCheck;
                                            String userzx = snapshot.child(username_data).child("lname").getValue(String.class);
                                            String GendX = snapshot.child(username_data).child("gender").getValue(String.class);
                                            String EmailX = snapshot.child(username_data).child("email").getValue(String.class);
                                            String titlex = snapshot.child(username_data).child("tittle").getValue(String.class);
                                            String categx = snapshot.child(username_data).child("category").getValue(String.class);
                                            String nationX = snapshot.child(username_data).child("natioNo").getValue(String.class);
                                            String registX = snapshot.child(username_data).child("regiNo").getValue(String.class);



                                            Intent intentz = new Intent(getApplicationContext(), MainDashboard.class);

                                            intentz.putExtra("Namex",Namex);
                                            intentz.putExtra("typex",typex);
                                            intentz.putExtra("userzx",userzx);
                                            intentz.putExtra("GendX",GendX);
                                            intentz.putExtra("EmailX",EmailX);
                                            intentz.putExtra("titlex",titlex);
                                            intentz.putExtra("categx",categx);
                                            intentz.putExtra("nationX",nationX);
                                            intentz.putExtra("registX",registX);  */