package com.example.microproyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ControlCategories extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulas);
        controlCateg();

    }

    protected void onSaveInstanceState(Bundle instanceState) {
        ListView myListView = (ListView) findViewById(R.id.listViewFormula);
        TextView nombreCategorie = (TextView) findViewById(R.id.txCategories);
        super.onSaveInstanceState(instanceState);
        instanceState.putInt("visualState", myListView.getVisibility());
        instanceState.putInt("visualState", nombreCategorie.getVisibility());
    }

    //Use this method to recover EditText/Button status when phone goes to landscape/portrait mode
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        ListView myListView = (ListView) findViewById(R.id.listViewFormula);
        TextView nombreCategorie = (TextView) findViewById(R.id.txCategories);
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getInt("visualState") == View.VISIBLE) {
            myListView.setVisibility(View.VISIBLE);
            myListView.setVisibility(View.VISIBLE);
            nombreCategorie.setVisibility(View.VISIBLE);
        }
    }


    private void controlCateg() {

        final ListView myListView = (ListView) findViewById(R.id.listViewFormula);
        final TextView nombreCategorie = (TextView) findViewById(R.id.txCategories);
        ArrayAdapter<String> adapter = null;

        String[] listCalc = {"Derivadas", "Integrales"};
        String[] listPhys = {"Fuerza", "Trabajo"};
        String[] listTrigo = {"Area", "Volumen"};

        Intent i = getIntent();
        //Get the intent information
        Bundle b = i.getExtras();
        String nombCat = b.getString("name");

        nombreCategorie.setText(""+nombCat);

        switch (nombCat){
            case "CALCULATION":
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listCalc);

                break;

            case "PHYSICAL":
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listPhys);

                break;

            case "TRIGONOMETRY":
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listTrigo);

                break;
        }myListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        mostrarformula(myListView,nombCat);

    }

    public void mostrarformula(final ListView listFormu,final String nombCat) {


        listFormu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = null;
                int item = position;

                String itemVal = (String)listFormu.getItemAtPosition(position);
                switch (nombCat){
                    case "CALCULATION":
                        switch (itemVal){
                            case "Derivadas":
                                Toast.makeText(ControlCategories.this, R.string.ingresoderevidas, Toast.LENGTH_SHORT).show();
                                myIntent = new Intent(ControlCategories.this,VistaFormulas.class);
                                myIntent.putExtra("formula","Derivada");
                                break;
                            case "Integrales":
                                Toast.makeText(ControlCategories.this, R.string.ingresointegrables, Toast.LENGTH_SHORT).show();
                                myIntent = new Intent(ControlCategories.this,VistaFormulas.class);
                                myIntent.putExtra("formula","Integral");
                                break;
                        }
                        break;

                    case "PHYSICAL":
                        switch (itemVal){
                            case "Fuerza":
                                Toast.makeText(ControlCategories.this, R.string.ingresofuerza, Toast.LENGTH_SHORT).show();
                                myIntent = new Intent(ControlCategories.this,VistaFormulas.class);
                                myIntent.putExtra("formula","Fuerza");
                                break;
                            case "Trabajo":
                                Toast.makeText(ControlCategories.this, R.string.ingresotrabajo, Toast.LENGTH_SHORT).show();
                                myIntent = new Intent(ControlCategories.this,VistaFormulas.class);
                                myIntent.putExtra("formula","Trabajo");
                                break;
                        }
                        break;

                    case "TRIGONOMETRY":
                        switch (itemVal){
                            case "Area":
                                Toast.makeText(ControlCategories.this, R.string.ingresoarea, Toast.LENGTH_SHORT).show();
                                myIntent = new Intent(ControlCategories.this,VistaFormulas.class);
                                myIntent.putExtra("formula","Area");
                                break;
                            case "Volumen":
                                Toast.makeText(ControlCategories.this, R.string.ingresovolumen, Toast.LENGTH_SHORT).show();
                                myIntent = new Intent(ControlCategories.this,VistaFormulas.class);
                                myIntent.putExtra("formula","Volumen");
                                break;
                        }
                        break;
                }startActivity(myIntent);
            }
        });
    }


}
