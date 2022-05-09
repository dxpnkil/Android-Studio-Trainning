package com.example.userdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatePickerDialog datePickerDialog;
    Button bCancel, bProceed;
    TextView date;
    EditText studentID, fullName, id, phone, email, town, place;
    CheckBox c, python, java, js, ts, go, accept;
    RadioButton cs, ce;

    // one boolean variable to check whether all the text fields
    // are filled by the user, properly or not.
    boolean isAllFieldsChecked = false;

    private String studentID1, fullName1, id1, phone1, email1, town1, place1, major1, date1;
    private ArrayList<String> languages = new ArrayList<String>();  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatePicker();
        date = findViewById(R.id.date);

        // register buttons with their proper IDs.
        bProceed = findViewById(R.id.proceedButton);
        bCancel = findViewById(R.id.cancelButton);

        // register all the EditText fields with their IDs.
        studentID = findViewById(R.id.studentId);
        fullName = findViewById(R.id.name);
        id = findViewById(R.id.id);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        town = findViewById(R.id.town);
        place = findViewById(R.id.place);

        c = findViewById(R.id.C);
        python = findViewById(R.id.Python);
        java = findViewById(R.id.Java);
        js = findViewById(R.id.JS);
        ts = findViewById(R.id.TS);
        go = findViewById(R.id.Go);
        accept = findViewById(R.id.accept);

        cs = findViewById(R.id.CS);
        ce = findViewById(R.id.CE);

        c.setOnCheckedChangeListener(m_listener);
        python.setOnCheckedChangeListener(m_listener);
        java.setOnCheckedChangeListener(m_listener);
        js.setOnCheckedChangeListener(m_listener);
        ts.setOnCheckedChangeListener(m_listener);
        go.setOnCheckedChangeListener(m_listener);

//        cs.setChecked(true);
        cs.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                doOnMajorChanged(buttonView,isChecked);
            }
        });
        ce.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                doOnMajorChanged(buttonView,isChecked);
            }
        });

        if(accept.isChecked()){
            bProceed.setEnabled(true);
            bProceed.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary));
        }

        accept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    bProceed.setEnabled(true);
                    bProceed.setBackgroundColor(ContextCompat.getColor(compoundButton.getContext(), R.color.colorPrimary));
                }else {
                    bProceed.setEnabled(false);
                    bProceed.setBackgroundColor(ContextCompat.getColor(compoundButton.getContext(), R.color.colorPrimaryDisable));
                }
            }
        });

        // handle the PROCEED button
        bProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // store the returned value of the dedicated function which checks
                // whether the entered data is valid or if any fields are left blank.
                isAllFieldsChecked = CheckAllFields();

                // the boolean variable turns to be true then
                // only the user must be proceed to the activity2
                if (isAllFieldsChecked) {
                    Bundle bundle = new Bundle();
                    bundle.putString("studentId", studentID1);
                    bundle.putString("fullName", fullName1);
                    bundle.putString("id", id1);
                    bundle.putString("phone", phone1);
                    bundle.putString("email", email1);
                    bundle.putString("town", town1);
                    bundle.putString("place", place1);
                    bundle.putString("major", major1);
                    bundle.putString("date", date1);
                    bundle.putStringArrayList("languages",languages);
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            }
        });

        // if user presses the cancel button then close the
        // application or the particular activity.
        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
                System.exit(0);
            }
        });
    }

    private void doOnMajorChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            RadioButton radio = (RadioButton) buttonView;
            major1 = radio.getText().toString();
        }
    }

    CompoundButton.OnCheckedChangeListener m_listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(compoundButton.isChecked()){
                languages.add(compoundButton.getText().toString());
            }else{
                languages.remove(compoundButton.getText().toString());
            }
        }
    };

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 +1;
                String dateTime = makeDateString(i, i1,i2);
                date.setText(dateTime);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        month = month + 1;

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    private String makeDateString(int i, int i1, int i2) {
        return i2 + " " + i1 + " " + i;
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }

    // function which checks all the text fields
    // are filled or not by the user.
    // when user clicks on the PROCEED button
    // this function is triggered.
    private boolean CheckAllFields() {
        if (studentID.length() == 0) {
            studentID.setError("This field is required");
            return false;
        }

        if (fullName.length() == 0) {
            fullName.setError("This field is required");
            return false;
        }

        if (id.length() == 0) {
            id.setError("This field is required");
            return false;
        }

        if (phone.length() == 0) {
            phone.setError("This field is required");
            return false;
        }
        if (town.length() == 0) {
            town.setError("This field is required");
            return false;
        }
        if (place.length() == 0) {
            place.setError("This field is required");
            return false;
        }
        if (email.length() == 0) {
            email.setError("This field is required");
            return false;
        }
        if (date.length() == 0) {
            date.setError("This field is required");
            return false;
        }
        if (major1.length() == 0) {
            date.setError("This field is required");
            return false;
        }
        studentID1 = studentID.getText().toString();
        fullName1 = fullName.getText().toString();
        id1 = id.getText().toString();
        phone1 = phone.getText().toString();
        email1 = email.getText().toString();
        town1 = town.getText().toString();
        place1 = place.getText().toString();
        date1 = date.getText().toString();

        // after all validation return true.
        return true;
    }


}