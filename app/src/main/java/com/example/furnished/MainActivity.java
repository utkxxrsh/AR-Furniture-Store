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

public class MainActivity extends AppCompatActivity {
    EditText email, pass;
    Button loginbutt;
    TextView mcreateBtn;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.editText);
        pass = findViewById(R.id.editText2);
        fAuth = FirebaseAuth.getInstance();
        loginbutt = findViewById(R.id.button);
        mcreateBtn = findViewById(R.id.textView);
        loginbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString().trim();
                String password = pass.getText().toString().trim();
                if (TextUtils.isEmpty(mail)) {
                    email.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty((password))) {
                    pass.setError("Password is Required");
                    return;
                }
                if (password.length() < 6) {
                    pass.setError("Password must be >= 6 Characters");
                    return;
                }
                fAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                            startActivity((new Intent(getApplicationContext(), Store.class)));


                        } else {
                            Toast.makeText(MainActivity.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }


                    }
                });


            }
        });
        mcreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(getApplicationContext(), register.class)));

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
