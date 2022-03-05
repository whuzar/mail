package com.example.mail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ktos, temat, wiadomosc;
    Button przyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ktos = findViewById(R.id.cos);
        temat = findViewById(R.id.temat);
        wiadomosc = findViewById(R.id.wiadomosc);
        przyc = findViewById(R.id.przycisk);

        przyc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ktos.getText().toString().isEmpty() || wiadomosc.getText().toString().isEmpty() || temat.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Puste wartości!", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Intent.ACTION_VIEW
                            , Uri.parse("mailto:" + ktos.getText().toString()));
                    intent.putExtra(Intent.EXTRA_SUBJECT, temat.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, wiadomosc.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}