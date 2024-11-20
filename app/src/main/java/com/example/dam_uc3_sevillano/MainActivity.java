package com.example.dam_uc3_sevillano;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias
        EditText editTextDate = findViewById(R.id.editTextDate);
        Spinner spinnerOptions1 = findViewById(R.id.spinnerOptions1);
        Spinner spinnerOptions2 = findViewById(R.id.spinnerOptions2);

        Button btn1 = findViewById(R.id.button2);
        btn1.setOnClickListener(view -> Toast.makeText(this, "ACABA DE BUSCAR UN VUELO", Toast.LENGTH_SHORT).show());

        TextView tv2 = findViewById(R.id.textView7);
        tv2.setOnClickListener(view -> Toast.makeText(this, "Revisión de política de equipaje", Toast.LENGTH_SHORT).show());

        TextView tv3 = findViewById(R.id.textViewRoundTrip);
        tv3.setOnClickListener(view -> Toast.makeText(this, "Vuelto ida y vuelta", Toast.LENGTH_SHORT).show());

        TextView tv4 = findViewById(R.id.textViewOneWay);
        tv4.setOnClickListener(view -> Toast.makeText(this, "Viaje solo de ida", Toast.LENGTH_SHORT).show());



        // Configurar selector de fecha
        editTextDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, selectedYear, selectedMonth, selectedDay) -> {
                String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                editTextDate.setText(date);
            }, year, month, day);
            datePickerDialog.show();
        });

        // Configurar Spinner 1
        String[] options1 = {"Economy", "Business", "Luxury"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptions1.setAdapter(adapter1);

        // Configurar Spinner 2
        String[] options2 = {"1 Adult", "2 Adult", "3 Adult"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptions2.setAdapter(adapter2);
    }
}