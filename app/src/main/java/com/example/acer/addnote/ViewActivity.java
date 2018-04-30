package com.example.acer.addnote;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ViewActivity extends AppCompatActivity {
    EditText title,description;
    Db_class dbClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
       title=(EditText)findViewById(R.id.editText3);
        description=(EditText)findViewById(R.id.editText4);

        dbClass=new Db_class(this,"notedb",null,1);
        Intent intent=getIntent();
        int id=intent.getIntExtra("title",-1);
        Cursor cursor=dbClass.readFriendById(id);
        cursor.moveToFirst();
        title.setText(cursor.getString(1));
        description.setText(cursor.getString(2));

    }
}
