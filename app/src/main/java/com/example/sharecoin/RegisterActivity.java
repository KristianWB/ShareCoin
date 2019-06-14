package com.example.sharecoin;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {

    // Diverse nødvendige variable
    EditText mLokaleNavnView;
    EditText mLokaleAdresseView;
    String mLokaleNavnText;
    String mLokaleAdresseText;

    // TAG variables
    private static final String TAG = MainActivity.class.getSimpleName();

    // KEY variables
    public static final String NAVN_KEY = "lokaleNavn";
    public static final String ADRESSE_KEY = "lokaleAdresse";

    // Opsætning af forbindelse til firestore databasen
    FirebaseFirestore db = FirebaseFirestore.getInstance();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        mLokaleNavnView = findViewById(R.id.lokale_navn);
        mLokaleAdresseView = findViewById(R.id.lokale_adresse);


    }

    public void goRegisterRoom(View view) {
        mLokaleNavnText = mLokaleNavnView.getText().toString();
        mLokaleAdresseText = mLokaleAdresseView.getText().toString();
        if(mLokaleNavnText.isEmpty() || mLokaleAdresseText.isEmpty()) { return; }
        Map<String, Object> room = new HashMap<>();
        room.put("lokaleNavn", mLokaleNavnText);
        room.put("lokaleAdresse", mLokaleAdresseText);
        // Add a new document with a generated ID
        db.collection("MeetingRooms")
                .add(room)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });


        /*
        mLokaleNavnText = mLokaleNavnView.getText().toString();

        mLokaleAdresseText = mLokaleAdresseView.getText().toString();
        if(mLokaleNavnText.isEmpty() || mLokaleAdresseText.isEmpty()) { return; }
        Map<String, Object> dataToSave = new HashMap<String, Object>();
        dataToSave.put(NAVN_KEY, mLokaleNavnText);
        dataToSave.put(ADRESSE_KEY, mLokaleAdresseText);
        mDocRef.set(dataToSave).addOnSuccessListener(new OnSuccessListener<Void>()
        {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "Document has been saved!");
            }
        }).addOnFailureListener(new OnFailureListener()
        {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Document failed to save!");
            }
        });
        */
    }
}
