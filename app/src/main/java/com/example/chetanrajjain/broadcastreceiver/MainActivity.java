package com.example.chetanrajjain.broadcastreceiver;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   private  RecyclerView recyclerView;
   private  TextView textView;
   private  RecyclerView.LayoutManager layoutManager;
   private  ArrayList<IncomingNumber> arrayList = new ArrayList<IncomingNumber>();
   private  RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview1);
        textView = (TextView)findViewById(R.id.textview1);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        readfromDb();

    }


    private void readfromDb(){

        arrayList.clear();

        DbHelper dbHelper = new DbHelper(this);

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        Cursor cursor  =  dbHelper.readNumber(database);

        Log.i("curson data", String.valueOf(cursor));

        if(cursor.getCount()>0){


            while(cursor.moveToNext()){

                    String number;
                    int id;

                    number = cursor.getString(cursor.getColumnIndex(DBcontract.INCOMING_NUMBER));
                    id = cursor.getInt(cursor.getColumnIndex("id"));
                    arrayList.add(new IncomingNumber(id,number));
                     }
                        cursor.close();
                        dbHelper.close();


                     adapter.notifyDataSetChanged();
            recyclerView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);






        }



    }
}
