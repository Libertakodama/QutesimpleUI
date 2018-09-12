package com.wildcodeschool.qutesimpleui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonaccept = findViewById(R.id.Accept);
        buttonaccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editFirstname = findViewById(R.id.firstname);
                String firstnameValue = editFirstname.getText().toString();
                EditText editLastname = findViewById(R.id.lastName);
                String lastnameValue = editLastname.getText().toString();
                if (firstnameValue.isEmpty() || lastnameValue.equals("")) {
                    Toast.makeText(MainActivity.this, R.string.enter_your_name , Toast.LENGTH_SHORT).show();
                } else {
                    TextView textcongrats = findViewById(R.id.textInvisible);
                    textcongrats.setVisibility(View.VISIBLE);
                    textcongrats.setText(String.format(getString(R.string.congrats), firstnameValue, lastnameValue));
                }
            }
        });

        CheckBox checkaccept = findViewById(R.id.checkAccept);
        checkaccept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                EditText editFirstname = findViewById(R.id.firstname);
                EditText editLastname = findViewById(R.id.lastName);

                editFirstname.setEnabled(isChecked);
                editLastname.setEnabled(isChecked);
                buttonaccept.setEnabled(isChecked);


            }
        });
    }
}
