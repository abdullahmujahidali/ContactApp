package com.wtechweb.assignment3_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContact extends AppCompatActivity {
    EditText etName, etEmail,etPhone, etAddress;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        init();
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String userName=etName.getText().toString();
                String userEmail=etEmail.getText().toString().trim();
                String userAddress=etAddress.getText().toString();
                String userPhone=etPhone.getText().toString();

                Intent intent= new Intent();
                intent.putExtra("userName",userName);
                intent.putExtra("userEmail",userEmail);
                intent.putExtra("userAddress",userAddress);
                intent.putExtra("userPhone",userPhone);
                setResult(RESULT_OK,intent);
                finish();

            }
        });
    }
    private void init(){
        etName= findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etPhone=findViewById(R.id.etPhone);
        etAddress=findViewById(R.id.etAddress);
        btnAdd=findViewById(R.id.submitBtn);
    }
}