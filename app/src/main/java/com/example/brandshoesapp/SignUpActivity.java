package com.example.brandshoesapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.brandshoesapp.model.UserModel;
import com.example.brandshoesapp.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    Button signupBtn;
    EditText name, email,password;
    TextView login;
    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        signupBtn=findViewById(R.id.signupBtn);
        name=findViewById(R.id.name);
        email=findViewById(R.id.emailSignup);
        password=findViewById(R.id.passwordSignUp);
       login=findViewById(R.id.loginBtn_Signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));

            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
                progressBar.setVisibility(View.VISIBLE);

            }
        });
    }

    private void createUser() {
        String userName= name.getText().toString();
        String userEmail= email.getText().toString();
        String userPassword= password.getText().toString();

        if (TextUtils.isEmpty(userName)){
            Toast.makeText(this, "Name is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this, "Email is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(this, "Password is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(userPassword.length()<6){
            Toast.makeText(this, "Password Should Greater Than 6", Toast.LENGTH_SHORT).show();
            return;
        }

        // create user
        auth.createUserWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    // User Database

                    UserModel userModel= new UserModel(userName,userEmail,userPassword);
                    String id= task.getResult().getUser().getUid();
                    database.getReference().child("Users").child(id).setValue(userModel);

                    Toast.makeText(SignUpActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    startActivity(new Intent(SignUpActivity.this, HomeFragment.class));
                } else {
                    Toast.makeText(SignUpActivity.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }

    }
