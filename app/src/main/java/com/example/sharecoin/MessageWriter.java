package com.example.sharecoin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MessageWriter extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.sharecoin.extra.REPLY";
    private EditText mReply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_writer);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textview =(TextView)findViewById(R.id.text_message);
        textview.setText(message);

        mReply = (EditText)findViewById(R.id.editText_second);


    }

    public void returnReply(View view)
    {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK,replyIntent);

        finish();
    }
}
