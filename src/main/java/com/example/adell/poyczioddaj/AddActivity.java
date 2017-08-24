package com.example.adell.poyczioddaj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void saveItem(){
        EditText nazwa = (EditText)findViewById(R.id.txt_Name);
        EditText ilosc = (EditText)findViewById(R.id.txt_Ilosc);
        EditText data_do = (EditText)findViewById(R.id.txt_Data_Do);
        EditText uwagi = (EditText)findViewById(R.id.txt_Uwagi);

        BaseManager bm = new BaseManager(this);
        bm.addItem(nazwa.getText().toString(),Integer.getInteger(ilosc.getText().toString()),data_do.getText().toString(),uwagi.getText().toString());
    }
}
