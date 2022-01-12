package com.example.loginscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {

    EditText email,password,Name,Lastname ;
    Button register;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mAuth = FirebaseAuth.getInstance();

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        Name=findViewById(R.id.Name);
        Lastname=findViewById(R.id.Lastname);

      register.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String mail = email.getText().toString().trim();
              String pass = password.getText().toString().trim();
              mAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(MainActivity2.this, new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if (task.isSuccessful()) {
                          // Sign in success, update UI with the signed-in user's information
                          Toast.makeText(MainActivity2.this, "Authentication",
                                  Toast.LENGTH_SHORT).show();
                          FirebaseUser user = mAuth.getCurrentUser();
                          Log.d("Auth", "createUserWithEmail:success");
                          Intent i =new Intent(MainActivity2.this,MainActivity.class);
                          startActivity(i);

                      } else {
                          // If sign in fails, display a message to the user.

                          Toast.makeText(MainActivity2.this, "Authentication failed.",
                                  Toast.LENGTH_SHORT).show();

                      }

                      // ...
                  }
              });

          }
      });

    }
}