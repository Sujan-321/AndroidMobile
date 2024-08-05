package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText editTextName;
    private Switch switchLayout;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private Spinner mySpinner;
    private TextView outputText;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        Button button = findViewById(R.id.buttonOne);
        editTextName = findViewById(R.id.editTextName);
        switchLayout = findViewById(R.id.switch1);
        checkBox = findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);
        mySpinner = findViewById(R.id.spinner);
        outputText = findViewById(R.id.outputText);

        // Set default text for switch
        switchLayout.setText("hello");

        // Set listeners
        button.setOnClickListener(this);
        checkBox.setOnClickListener(this);
        switchLayout.setOnClickListener(this);
        mySpinner.setOnItemSelectedListener(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(MainActivity.this, "Selected Radio Button is : " + radioButton.getText(), Toast.LENGTH_SHORT).show();
                updateOutput();
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.buttonOne) {
            name = editTextName.getText().toString().trim();
            if (name.isEmpty()) {
                editTextName.setError("Name cannot be empty");
                editTextName.requestFocus();
                return;
            }
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
            updateOutput();
        } else if (id == R.id.switch1) {
            Toast.makeText(this, "This is switch", Toast.LENGTH_SHORT).show();
            updateOutput();
        } else if (id == R.id.checkBox) {
            Toast.makeText(this, "Checkbox Clicked", Toast.LENGTH_SHORT).show();
            updateOutput();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show();
        updateOutput();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Not selected", Toast.LENGTH_SHORT).show();
    }

    private void updateOutput() {
        StringBuilder output = new StringBuilder();

        // Get the text from EditText
        name = editTextName.getText().toString().trim();
        output.append("Name: ").append(name).append("\n");

        // Check Switch state
        if (switchLayout != null) {
            if (switchLayout.isChecked()) {
                output.append("Switch is ON\n");
            } else {
                output.append("Switch is OFF\n");
            }
        }

        // Check CheckBox state
        if (checkBox != null) {
            if (checkBox.isChecked()) {
                output.append("Checkbox is Clicked\n");
            } else {
                output.append("Checkbox is not Clicked\n");
            }
        }

        // Get the selected RadioButton from RadioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            output.append("Gender: ").append(selectedRadioButton.getText()).append("\n");
        }

        // Get the selected item from Spinner
        String selectedItem = mySpinner.getSelectedItem().toString();
        output.append("Selected item: ").append(selectedItem).append("\n");

        // Set the output to the TextView
        if (outputText != null) {
            outputText.setText(output.toString());
        }
    }
}
