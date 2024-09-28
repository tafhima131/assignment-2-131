package com.example.assignment2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextAddress, editTextAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private RatingBar ratingBar;
    private SeekBar seekBar;
    private Switch switchEnableNotifications;
    private CheckBox checkBoxTerms;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextAge = findViewById(R.id.editTextAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        ratingBar = findViewById(R.id.ratingBar);
        seekBar = findViewById(R.id.seekBar);
        switchEnableNotifications = findViewById(R.id.switchEnableNotifications);
        checkBoxTerms = findViewById(R.id.checkBoxTerms);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    // Process form submission here (e.g., send data to server)
                    Toast.makeText(MainActivity.this, "Form submitted successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateInput() {
        String name = editTextName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();

        if (TextUtils.isEmpty(name) || !name.matches("^[a-zA-Z\\s-]+$")) {
            editTextName.setError("Please enter a valid name");
            return false;
        }


        if (TextUtils.isEmpty(address) || !address.matches("^[a-zA-Z0-9\\s.,'-]+$")) {
            editTextAddress.setError("Please enter a valid address");
            return false;
        }


        if (TextUtils.isEmpty(age) || !age.matches("^\\d+$")) {
            editTextAge.setError("Please enter a valid age");
            return false;
        }



        return true;
    }
}