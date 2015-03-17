package com.example.ruben.mynotes;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;


public class AddNotes extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
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

    public static DBProxy db;

    @Override
    protected void onPause() {
        super.onPause();
   // public void onBackPressed() {

        EditText TituloNota = (EditText) findViewById(R.id.titulo);
        String addTitulo = TituloNota.getText().toString();

        EditText BodyNota = (EditText) findViewById(R.id.nota);
        String addNote = BodyNota.getText().toString();

        MyNotes.db.AddNote(addTitulo, addNote);
    }
}
