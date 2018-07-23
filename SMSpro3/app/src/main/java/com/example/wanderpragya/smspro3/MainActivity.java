package com.example.wanderpragya.smspro3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;

//import and

public class MainActivity extends AppCompatActivity {
    Button login;
    Button signup;
    EditText email,password;
    String email2,pass2;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    //Intent intent = new Intent(MainActivity.this, Main2Activity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.button);
        signup = findViewById(R.id.button2);
        email = (EditText)findViewById(R.id.editText);
        password =(EditText) findViewById(R.id.editText2);

        final Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // mAuth.signInWithEmailAndPassword(email2,pass2);
               // startActivity(intent);

                email2 = email.getText().toString();
                pass2 = password.getText().toString();
              mAuth.signInWithEmailAndPassword(email2, pass2)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    //Log.d(TAG, "signInWithEmail:success");
                                  // FirebaseUser user = mAuth.getCurrentUser();
                                    // updateUI(user);
                                    //Toast.makeText(MainActivity.this, "Sign in successful", Toast.LENGTH_LONG).show();
                                    startActivity(intent);
                                    //FirebaseUser user= mAuth.getCurrentUser();
                                   // user.

                                } else {
                                    // If sign in fails, display a message to the user.
                                    // Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(MainActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }

                                // ...
                            }
                        });
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // mAuth.createUserWithEmailAndPassword(email2,pass2);
              //  startActivity(intent);

                email2 = email.getText().toString();
                pass2 = password.getText().toString();
               mAuth.createUserWithEmailAndPassword(email2, pass2).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Toast.makeText(MainActivity.this,"Account created", Toast.LENGTH_LONG).show();
                            //next activity
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Account not created! Try again.", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

    }


    /*protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "restart", Toast.LENGTH_SHORT).show();
        FirebaseAuth.getInstance().signOut();
        email.clearComposingText();
        password.clearComposingText();

    }*/

  /*  @Override
    protected void onPause() {
        super.onPause();
        email.setText("");
        password.setText("");
    }*/

    @Override
    protected void onRestart() {
        super.onRestart();
        email.setText("");
        password.setText("");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //finish();
        finish();
        //System.exit(0);
        //android.os.Process.killProcess(android.os.Process.myPid());
    }
}
