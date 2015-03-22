package com.example.ruben.mynotes;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class MyNotes extends Activity implements AdapterView.OnItemClickListener {

    final public static String NOTA_ID = "DicID" ;
    final public static String NOTA_TITULO = "DicTitle";
    final public static String NOTA_BODY= "DicBody";


    public static DBProxy db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes);
        db = new DBProxy(this);

        Cursor c = db.ReadNotes();
        String[] fromColumns = {db.DB_COL_TITLE, db.DB_COL_NOTE};
        int [] toView = {R.id.ElementTitle, R.id.ElementBody};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.activity_list_element,
                c,
                fromColumns,
                toView,
                0
        );
        ListView list = (ListView) findViewById(R.id.listElements);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);


    }


    //@Override
    // public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //   getMenuInflater().inflate(R.menu.menu_my_notes, menu);
       // return true;
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


    public void addNote (View myText){
        Intent newView = new Intent(this, AddNotes.class); //preparamos la view que queremos lanzar
        startActivity(newView ); //abrimos la nueva view, mirar mainactivity2.java funcion onCreate
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {





        Intent i = new Intent(this, AddNotes.class);
       // i.putExtra(NOTA_ID, ((TextView) view.findViewById(R.id.ElementID)).getText().toString());
        i.putExtra(NOTA_TITULO, ((TextView) view.findViewById(R.id.ElementTitle)).getText().toString());
        i.putExtra(NOTA_BODY, ((TextView) view.findViewById(R.id.ElementBody)).getText().toString());
        i.putExtra(NOTA_ID, (int) id);
        startActivity(i);

    }
}
