package com.example.registration;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText signUpEmail,signUpPassword,signUpConfirmPassword;
    private Button signUpButton;
    private  TextView alreadyHaveAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        TextView btn=findViewById(R.id.alreadyHaveAccount);
        auth=FirebaseAuth.getInstance();
        signUpEmail=findViewById(R.id.inputEmail);
        signUpPassword=findViewById(R.id.inputPassword);
        signUpConfirmPassword=findViewById(R.id.inputConformPassword);
        signUpButton=findViewById(R.id.btnRegister);
        alreadyHaveAccount=findViewById(R.id.alreadyHaveAccount);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail=signUpEmail.getText().toString().trim();
                String userPassword=signUpPassword.getText().toString().trim();
                String userConfirmPassword=signUpConfirmPassword.getText().toString().trim();

                if(userEmail.isEmpty())
                {
                    signUpEmail.setError("Please provide email id");
                }
                if(userPassword.isEmpty()||userConfirmPassword.isEmpty())
                {
                    signUpPassword.setError("please Enter the password");

                }
                if(!userPassword.equals(userConfirmPassword))
                {
                    signUpConfirmPassword.setError("Password did not match!");
                }
                else {
                    auth.createUserWithEmailAndPassword(userEmail,userConfirmPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(RegisterActivity.this,"Successfully registerd",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                            }
                            else {
                                Toast.makeText(RegisterActivity.this,"Register Failed"+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }
}
