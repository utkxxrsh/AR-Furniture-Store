package com.example.furnished;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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
import com.google.firebase.auth.FirebaseUser;


public class register extends AppCompatActivity {
    EditText euser,email,pass;
    Button registerbutt;
    TextView loginbtn;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        euser=findViewById(R.id.editText3);
        email=findViewById(R.id.editText);
        pass=findViewById(R.id.editText2);
        registerbutt=findViewById(R.id.button);
        loginbtn=findViewById(R.id.textView);
        fAuth=FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser() != null) {
            startActivity((new Intent(getApplicationContext(),Store.class)));
            finish();

        }
        registerbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=email.getText().toString().trim();
                String password=pass.getText().toString().trim();
                if(TextUtils.isEmpty(mail)){
                    email.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty((password))){
                    pass.setError("Password is Required");
                    return;
                }
                if (password.length()<6){
                    pass.setError("Password must be >= 6 Characters");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(register.this,"User created",Toast.LENGTH_SHORT).show();
                            startActivity((new Intent(getApplicationContext(),Store.class)));

                        }
                        else{
                            Toast.makeText(register.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(getApplicationContext(),MainActivity.class)));

            }
        });


    }
    public void insta(View view){
        Intent instaIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"));
        startActivity(  instaIntent);


    }
    public void facebook(View view){
        Intent fbIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
        startActivity(  fbIntent);


    }
    public void twitter(View view){
        Intent twitterIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com/"));
        startActivity(  twitterIntent);


    }
}
