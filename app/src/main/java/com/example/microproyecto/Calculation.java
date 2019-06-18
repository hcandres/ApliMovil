package com.example.microproyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Calculation extends AppCompatActivity {

    //Button buttonRegresar = (Button) findViewById(R.id.btRegresarCalculation);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculation);

        listCalculation();
    }

    public void listCalculation() {
        final ListView Lista = (ListView) findViewById(R.id.listViewCalculation);
        String[] list = {"Derivadas", "Integrales", "metodos de integracion"};


        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);
        Lista.setAdapter(adapter);

    }

    public void onClick(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
