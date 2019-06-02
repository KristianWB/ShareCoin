package com.example.sharecoin;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 7117; //Any numer is valid
    List<AuthUI.IdpConfig> providers;
    Button btn_sign_out;
    Button btn_message;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sign_out = (Button)findViewById(R.id.btn_sign_out);
        btn_sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Signout
                AuthUI.getInstance()
                        .signOut(MainActivity.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                btn_sign_out.setEnabled(false);
                                showSignInOptions();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        /*
        btn_message = (Button)findViewById(R.id.btn_message);
        btn_message.setOnClickListener(new View.OnClickListener()
                                       {
                                           @Override
                                           public void onClick(View v)
                                           {
                                               startActivity()
                                           }
                                       }
        );
        */



        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build()
        );

        showSignInOptions();
    }

    private void showSignInOptions()   {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setTheme(R.style.MyTheme)
                        .build(),MY_REQUEST_CODE
        );
    }

    // Her kommer login aktivitets svaret
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE) {   // Vi identificerer proceduren via anmodningsId
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK) {  // Hvis brugeren ikke har annulleret processen eller den på anden vis er obstrueret, så fortsætter vi
                FirebaseUser user = FirebaseAuth    // Fetch brugeren
                        .getInstance()
                        .getCurrentUser();
                // Så viser vi brugerens email som visuel bekræftelse på at login er lykkedes
                Toast.makeText(this, "" + user.getEmail(), Toast.LENGTH_SHORT).show();
                // Tillad Button signOut
                btn_sign_out.setEnabled(true);
            }
            else
            {
                // Hvis login fejlede fordi brugeren annullerede login processen
                Toast.makeText(this, ""+response.getError().getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void launchMessageWriter(View view)
    {
        Log.d(LOG_TAG, "Button clicked!");
    }
}