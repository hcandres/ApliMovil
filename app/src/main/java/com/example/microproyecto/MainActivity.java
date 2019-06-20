package com.example.microproyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        listCategories();
    }

    public void listCategories() {
        final ListView Lista = (ListView) findViewById(R.id.listViewFormula);
        String[] list = {"Calculo", "Fisica", "Trigonometria", "Fisica", "Trigonometria", "Fisica", "Trigonometria", "Fisica", "Trigonometria", "Fisica", "Trigonometria"};


        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);
        Lista.setAdapter(adapter);

        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = null;
                int item = position;

                String itemVal = (String)Lista.getItemAtPosition(position);
                switch (itemVal){
                    case "Calculo":
                        Toast.makeText(MainActivity.this, "INGRESÓ A CALCULO", Toast.LENGTH_SHORT).show();
                        myIntent = new Intent(view.getContext(),ControlCategories.class);
                        myIntent.putExtra("name","CALCULATION");
                        break;

                    case "Fisica":
                        Toast.makeText(MainActivity.this, "INGRESÓ A FISICA", Toast.LENGTH_SHORT).show();
                        myIntent = new Intent(view.getContext(),ControlCategories.class);
                        myIntent.putExtra("name","PHYSICAL");
                        break;

                    case "Trigonometria":
                        Toast.makeText(MainActivity.this, "INGRESÓ A TRIGONOMETRIA", Toast.LENGTH_SHORT).show();
                        myIntent = new Intent(view.getContext(),ControlCategories.class);
                        myIntent.putExtra("name","TRIGONOMETRY");
                        break;
                }startActivity(myIntent);
            }
        });

    }

}

