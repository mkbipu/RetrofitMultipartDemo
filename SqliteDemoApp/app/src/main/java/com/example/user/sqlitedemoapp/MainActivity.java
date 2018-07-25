package com.example.user.sqlitedemoapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper mydb;

    EditText mName,mSurname ,mMark, mId;
    Button addBtn;
    Button viewBtn;
    Button updateBtn;
    Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DatabaseHelper(this);

        mName = findViewById(R.id.name);
        mSurname = findViewById(R.id.surname);
        mMark = findViewById(R.id.mark);
        addBtn = findViewById(R.id.saveP_btn);
        mId = findViewById(R.id.Id);
        viewBtn = findViewById(R.id.view_data);
        updateBtn = findViewById(R.id.updateData);
        deleteBtn = findViewById(R.id.deleteData);

        addDAta();
        viewAll();
        UpdateData();
        DeleteData();

    }

    public void addDAta(){

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              boolean isInserted = mydb.inseartDAta(mName.getText().toString(),
                      mSurname.getText().toString(),mMark.getText().toString());

              if (isInserted == true)
                  Toast.makeText(MainActivity.this,"Data inserted", Toast.LENGTH_SHORT).show();
              else
                  Toast.makeText(MainActivity.this,"Data not inseted", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void viewAll(){
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mydb.getAllData();
                if (res.getCount()==0){

                    showMassage("Error", "No data found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){

                    buffer.append("Id:" + res.getString(0)+"\n");
                    buffer.append("Name:" + res.getString(1)+"\n");
                    buffer.append("Surname:" + res.getString(2)+"\n");
                    buffer.append("Marks:" + res.getString(3)+"\n\n");
                }
                showMassage("Data",buffer.toString());
            }
        });
    }

    public void UpdateData(){
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = mydb.updateData(mId.getText().toString(),mName.getText().toString(),
                        mSurname.getText().toString(),mMark.getText().toString());

                if (isUpdate == true){

                    Toast.makeText(MainActivity.this,"Data updated", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(MainActivity.this,"Data not upadated", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void DeleteData(){
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedrow = mydb.DeleteData(mId.getText().toString());

                if (deletedrow >0)
                    Toast.makeText(MainActivity.this,"Data deleted", Toast.LENGTH_SHORT).show();
             else
                    Toast.makeText(MainActivity.this,"Data not deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showMassage(String tittle, String Massage){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(tittle);
        builder.setMessage(Massage);
        builder.show();


    }
}
