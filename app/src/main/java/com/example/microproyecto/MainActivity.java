package com.example.microproyecto;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity  implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerview;

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

                String itemVal = (String) Lista.getItemAtPosition(position);
                switch (itemVal) {
                    case "Calculo":
                        Toast.makeText(MainActivity.this, R.string.ingresocalculo, Toast.LENGTH_SHORT).show();
                        myIntent = new Intent(view.getContext(), ControlCategories.class);
                        myIntent.putExtra("name", "CALCULATION");
                        break;

                    case "Fisica":
                        Toast.makeText(MainActivity.this, R.string.ingresofisica, Toast.LENGTH_SHORT).show();
                        myIntent = new Intent(view.getContext(), ControlCategories.class);
                        myIntent.putExtra("name", "PHYSICAL");
                        break;

                    case "Trigonometria":
                        Toast.makeText(MainActivity.this, R.string.ingresotrigo, Toast.LENGTH_SHORT).show();
                        myIntent = new Intent(view.getContext(), ControlCategories.class);
                        myIntent.putExtra("name", "TRIGONOMETRY");
                        break;
                }
                startActivity(myIntent);
            }
        });

    }


    protected void onSaveInstanceState(Bundle instanceState) {
        ListView Lista = (ListView) findViewById(R.id.listViewFormula);
        super.onSaveInstanceState(instanceState);
        instanceState.putInt("visualState", Lista.getVisibility());
    }

    //Use this method to recover EditText/Button status when phone goes to landscape/portrait mode
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        ListView Lista = (ListView) findViewById(R.id.listViewFormula);
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getInt("visualState") == View.VISIBLE) {
            Lista.setVisibility(View.VISIBLE);
            Lista.setVisibility(View.VISIBLE);
        }
    }

    public void btnscanner(View v) {
        mScannerview = new ZXingScannerView(this);
        setContentView(mScannerview);
        mScannerview.setResultHandler(this);
        mScannerview.startCamera();

    }

    @Override
    public void handleResult(Result result) {

        Log.v("HandleResult",result.getText());
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("Su ecuacion es");
        builder.setMessage(result.getText());
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
        mScannerview.resumeCameraPreview(this);


    }

}