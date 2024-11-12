package com.example.practicacertamen2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nombre, cargo;
    Button agregar,eliminar;
    Spinner combobox;
    ListView caja;
    ArrayList<String> lista;
    ArrayAdapter<String> adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //IDs
        nombre = findViewById(R.id.NombreEmpleado);
        cargo = findViewById(R.id.CargoEmpleado);

        //no se si son necesarios los botones
        agregar = findViewById(R.id.btnAgregar);
        eliminar = findViewById(R.id.btnEliminar);

        combobox = findViewById(R.id.ComboBox);
        caja = findViewById(R.id.ListView);
        lista = new ArrayList<String>();
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        caja.setAdapter(adaptador);
        combobox.setAdapter(adaptador);

    }
    public void AgregarEmpleado (View view){
        //tomo los que necesito
        String Nombre = nombre.getText().toString();
        String Cargo = cargo.getText().toString();

        if (Nombre.isEmpty() || Cargo.isEmpty()){
            Toast.makeText(this, "Porfavor completa todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            //agrego los datos a la lista
            lista.add(Nombre + Cargo);
            adaptador.notifyDataSetChanged();
            //vacio los campos
            nombre.setText("");
            cargo.setText("");
        }
    }

    public void EliminarEmpleado (View view){
        //tomo lo que necesito que es en este caso el spinner porque quiero seleccionarllos desde aqui para eliminarlos
        String Empleado = (String) combobox.getSelectedItem();

        if (Empleado == null){
            Toast.makeText(this, "Selecciona el empleado que desee eliminar", Toast.LENGTH_SHORT).show();
        }else{
            lista.remove(Empleado);
            adaptador.notifyDataSetChanged();
        }

    }

}