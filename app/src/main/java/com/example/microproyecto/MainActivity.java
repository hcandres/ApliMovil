package com.example.microproyecto;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.zxing.Result;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity  implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerview;
    ProgressDialog progressDialog;
    private RequestQueue queue;
    private ArrayList<String> listCategorias = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView Lista;
    private ArrayList<Formula> jsonListFormulas;

    public static ArrayList<Formula> listFormulasOb = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        queue = Volley.newRequestQueue(this);
        listCategories();

    }


    public void listCategories() {
        final ListView Lista = (ListView) findViewById(R.id.listViewFormula);
        //String[] list = {"Calculo", "Fisica", "Trigonometria", "Fisica", "Trigonometria", "Fisica", "Trigonometria", "Fisica", "Trigonometria", "Fisica", "Trigonometria"};

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
                        myIntent.putExtra("name", "Calculo");
                        break;

                    case "Fisica":
                        Toast.makeText(MainActivity.this, R.string.ingresofisica, Toast.LENGTH_SHORT).show();
                        myIntent = new Intent(view.getContext(), ControlCategories.class);
                        myIntent.putExtra("name", "Fisica");
                        break;

                    case "Trigonometria":
                        Toast.makeText(MainActivity.this, R.string.ingresotrigo, Toast.LENGTH_SHORT).show();
                        myIntent = new Intent(view.getContext(), ControlCategories.class);
                        myIntent.putExtra("name", "Trigonometria");
                        break;
                }
                startActivity(myIntent);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        listFormulasOb.clear();
        cargarDatos();
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
    private void cargarDatos() {

        class CargarDatos extends AsyncTask<Void, Void, Void> {

            private static final String TAG = "Aplimovil**";


            @Override
            protected Void doInBackground(Void... voids) {
                Lista = (ListView) findViewById(R.id.listViewFormula);
                ArrayList<String> result = new ArrayList<>(0);

                try {
                    URL url = new URL("http://192.168.56.1:8080/formulas.json");
                    // Create a new HTTP URL connection
                    URLConnection connection = url.openConnection();
                    HttpURLConnection httpConnection = (HttpURLConnection) connection;
                    int responseCode = httpConnection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        InputStream in = httpConnection.getInputStream();
                        jsonListFormulas = new ArrayList<>();

                        //Parse the answer in JSON format
                        parseJSON(in);
                    }else{
                        System.out.println("ERORORORORORR");
                    }
                    httpConnection.disconnect();
                } catch (MalformedURLException e) {
                    Log.e(TAG, "Malformed URL Exception.", e);
                } catch (IOException e) {
                    Log.e(TAG, "IO Exception.", e);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                //Update the tasks list after downloading the content from Internet
                listCategorias.clear();
                for (int i = 0; i < jsonListFormulas.size(); i++) {
                    listCategorias.add(jsonListFormulas.get(i).getCategoria());
                }
                adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, listCategorias);
                Lista.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            private void parseJSON(InputStream in) throws IOException {
                // Create a new Json Reader to parse the input.
                JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
                try {
                    //JSON file starts with an array
                    reader.beginArray();
                    while (reader.hasNext()) {
                        Formula i = new Formula("df","","");
                        //Parse a specific object inside the array
                        reader.beginObject();
                        while (reader.hasNext()) {
                            String value = reader.nextName();
                            //It gets the property value and store it on the correct property of ToDoItem object
                            switch (value) {
                                case "categoria":
                                    i.setCategoria(reader.nextString());
                                    break;
                                case "nombre":
                                    i.setNombre(reader.nextString());
                                    break;
                                case "informacion":
                                    i.setInformacion(reader.nextString());
                                    break;
                                default:
                                    reader.skipValue();
                                    break;
                            }
                        }
                        reader.endObject();
                        jsonListFormulas.add(i);
                        listFormulasOb.add(i);
                    }
                    reader.endArray();
                } finally {
                    reader.close();
                }
            }

        }
        CargarDatos cargarDatos = new CargarDatos();
        cargarDatos.execute();
    }

}