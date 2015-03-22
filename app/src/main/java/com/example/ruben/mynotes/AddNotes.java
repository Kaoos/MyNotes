package com.example.ruben.mynotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class AddNotes extends Activity {

   public boolean update = false;
   public Integer idNOTA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);


        Intent DiccionarioNombre = getIntent();//recuperarmos el diccionario Nombre
        String titulo = DiccionarioNombre.getStringExtra(MyNotes.NOTA_TITULO); // Assignamos el valor del nombre
        TextView eltitulo = (TextView) findViewById(R.id.notaTitulo); // buscamos el view donde introducioremos los datos
        eltitulo.setText(titulo); //  asignamos el valor al view


        String body = DiccionarioNombre.getStringExtra(MyNotes.NOTA_BODY); // Assignamos el valor del nombre
        TextView elcuerpo = (TextView) findViewById(R.id.notaCuerpo); // buscamos el view donde introducioremos los datos
        elcuerpo.setText(body); //  asignamos el valor al view

        if (titulo!=null)
        {update = true;
         idNOTA = DiccionarioNombre.getExtras().getInt(MyNotes.NOTA_ID);
        }


    }


    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.menu_add_notes, menu);
        //return true;
    //}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //public static DBProxy db;

    @Override
    protected void onPause() {
        super.onPause();

        if (update == true) {

            EditText TituloNota = (EditText) findViewById(R.id.notaTitulo);
            String updateTitulo = TituloNota.getText().toString();

            EditText BodyNota = (EditText) findViewById(R.id.notaCuerpo);
            String updateNote = BodyNota.getText().toString();

            MyNotes.db.updateNote(idNOTA, updateTitulo, updateNote);

        } else {


            EditText TituloNota = (EditText) findViewById(R.id.notaTitulo);
            String addTitulo = TituloNota.getText().toString();

            EditText BodyNota = (EditText) findViewById(R.id.notaCuerpo);
            String addNote = BodyNota.getText().toString();
            MyNotes.db.AddNote(addTitulo, addNote);

        }
    }

    public void delNote(View myText)
    {
        Intent newView = new Intent(this, MyNotes.class); //preparamos la view que queremos lanzar
        startActivity(newView ); //abrimos la nueva view, mirar mainactivity2.java funcion onCreate
        MyNotes.db.DelNote(idNOTA);


    }
    public void saveNote(View myText)
    {
        Intent newView = new Intent(this, MyNotes.class); //preparamos la view que queremos lanzar
        startActivity(newView ); //abrimos la nueva view, mirar mainactivity2.java funcion onCreate
    }





}
