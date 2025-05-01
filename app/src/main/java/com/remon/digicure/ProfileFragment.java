package com.remon.digicure;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class ProfileFragment extends Fragment {

  MainDashboard mainActivity;

    public ProfileFragment() {
        // Required empty public constructor
    }

    Button logout;
    TextView Names, typsz, usernames, titles, categs, natios, regisN, gends, emails;
    EditText inputUser;
    ImageView searched;
    String pat = "Patient";
    String doc = "Doctor";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


       // logout Button..................................
        logout = view.findViewById(R.id.logoutz_button);
        mainActivity = (MainDashboard) getActivity();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MainActivity.class));
            }
        });
        //........................................

        // Set Data on Profile
        searched = view.findViewById(R.id.search_Icon);

        Names = view.findViewById(R.id.Namesz_Text);
        typsz = view.findViewById(R.id.typs_Name_Text);
        usernames = view.findViewById(R.id.userName_text);
        titles = view.findViewById(R.id.Title_text);
        categs = view.findViewById(R.id.category_text);
        natios = view.findViewById(R.id.NationalID_text);
        regisN = view.findViewById(R.id.RegistrationID_text);
        gends = view.findViewById(R.id.gender_text);
        emails = view.findViewById(R.id.Email_text);

        searched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputUser = view.findViewById(R.id.input_User_Text);
                String userNames = inputUser.getText().toString();

                if(userNames.isEmpty()){
                    Toast.makeText(mainActivity, "Username is Empty", Toast.LENGTH_SHORT).show();
                }
                else{

                    final String username_data =  inputUser.getText().toString();
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference = firebaseDatabase.getReference("datauser");

                    Query checkUser = databaseReference.orderByChild("lname").equalTo(username_data);
                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()) {
                                String TypeCheck = snapshot.child(username_data).child("type").getValue(String.class);

                                if (pat.equals(TypeCheck)){

                                    String Namex = snapshot.child(username_data).child("fname").getValue(String.class);
                                String typex = TypeCheck;
                                String userzx = snapshot.child(username_data).child("lname").getValue(String.class);
                                String GendX = snapshot.child(username_data).child("gender").getValue(String.class);
                                String EmailX = snapshot.child(username_data).child("email").getValue(String.class);

                                    typsz.setText(typex);
                                    Names.setText(Namex);
                                    usernames.setText(userzx);
                                    gends.setText(GendX);
                                    emails.setText(EmailX);
                                    titles.setText("N/A");
                                    categs.setText("N/A");
                                    natios.setText("N/A");
                                    regisN.setText("N/A");
                                    inputUser.setText("");

                                 }

                                else if(doc.equals(TypeCheck)){
                                    String Namex = snapshot.child(username_data).child("fname").getValue(String.class);
                                    String typex = TypeCheck;
                                    String userzx = snapshot.child(username_data).child("lname").getValue(String.class);
                                    String GendX = snapshot.child(username_data).child("gender").getValue(String.class);
                                    String EmailX = snapshot.child(username_data).child("email").getValue(String.class);
                                    String titlex = snapshot.child(username_data).child("tittle").getValue(String.class);
                                    String categx = snapshot.child(username_data).child("category").getValue(String.class);
                                    String nationX = snapshot.child(username_data).child("natioNo").getValue(String.class);
                                    String registX = snapshot.child(username_data).child("regiNo").getValue(String.class);

                                    typsz.setText(typex);
                                    Names.setText(Namex);
                                    usernames.setText(userzx);
                                    gends.setText(GendX);
                                    emails.setText(EmailX);
                                    titles.setText(titlex);
                                    categs.setText(categx);
                                    natios.setText(nationX);
                                    regisN.setText(registX);
                                    inputUser.setText("");
                                }

                            }
                            else{
                                Toast.makeText(mainActivity, "Wrong Input", Toast.LENGTH_SHORT).show();
                                inputUser.setText("");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }
        });

        return view;
    }
}
