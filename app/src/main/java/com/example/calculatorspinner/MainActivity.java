package com.example.calculatorspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity<txt1, txt2> extends AppCompatActivity {

    Spinner pilih;
    EditText txt1, txt2;
    TextView txtHasil;
    Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt1 = (EditText) findViewById(R.id.txtBil1);
        txt2 = (EditText) findViewById(R.id.txtBil2);
        txtHasil = (TextView) findViewById(R.id.txtHasil);


        pilih = (Spinner) findViewById(R.id.spinPilih);

        List<String> list = new ArrayList<String>();

        list.add("Tambah");

        list.add("Kurang");

        list.add("Kali");

        list.add("Bagi");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        pilih.setAdapter(dataAdapter);


        Button btnHitung = (Button) findViewById(R.id.Hitung);

        btnHitung.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                String b1 = txt1.getText().toString();
                String b2 = txt2.getText().toString();

                double db1 = Double.parseDouble(b1);
                double db2 = Double.parseDouble(b2);
                double h = 0;


                String pilihan = pilih.getSelectedItem().toString();

                if (pilihan.equalsIgnoreCase("Tambah")) {

                    h = db1 + db2;

                } else if (pilihan.equalsIgnoreCase("Kurang")) {

                    h = db1 - db2;

                } else if (pilihan.equalsIgnoreCase("Kali")) {

                    h = db1 * db2;

                } else if (pilihan.equalsIgnoreCase("Bagi")) {

                    h = db1 / db2;

                }


                String sh = String.valueOf(h);

                txtHasil.setText(sh);

            }
        });
    }
}
