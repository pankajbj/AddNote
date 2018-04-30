package com.example.acer.addnote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    EditText title,description;
    Button button;
    Db_class db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        title=(EditText)findViewById(R.id.editText);
        description=(EditText)findViewById(R.id.editText2);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(this);
        db=new Db_class(this,"notedb",null,1);
    }

    @Override
    public void onClick(View v) {
     String s1=title.getText().toString();
        String s2=description.getText().toString();
        db.addnote(s1,s2);
        Toast.makeText(this,"Note Added",Toast.LENGTH_LONG).show();

    }
}
