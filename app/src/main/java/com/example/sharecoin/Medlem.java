/*
        package com.example.sharecoin;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;


public class Medlem implements MedlemImpl {

    private String virksomhedsnavn;
    private int cvr;

    private FirebaseAuth mAuth;
    private String email;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(int telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    private String adresse;
    private int telefonNummer;

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    private int password;

    public String getVirksomhedsnavn() {
        return virksomhedsnavn;
    }

    public void setVirksomhedsnavn(String virksomhedsnavn) {
        this.virksomhedsnavn = virksomhedsnavn;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }



    @Override
    public void opretMedlemmer(String virksomhedsnavn, int cvr)
    {

    }

    @Override
    public void opdatereMedlemmer(String virksomhedsnavn, int cvr)
    {

    }

    @Override
    public void sletMedlemmer(int cvr)
    {

    }
    
    public void createNewMember(String username,String password)
    {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }

                    private void updateUI(Object o) {
                    }
                });
    }

    


}
*/