package com.wtechweb.assignment3_mad;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class MainScreen extends AppCompatActivity implements UserAdapter.ItemClicked , UserAdapterHor.ItemClicked{

    final static int ADD_USER=1;
    ArrayList<User> user = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    RecyclerView.LayoutManager manager;
    RecyclerView.LayoutManager managers;
    RecyclerView.Adapter myAdapter;
    RecyclerView.Adapter myAdapter2;
    Button adduserbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        adduserbtn= findViewById(R.id.editBtn);
        recyclerView = findViewById(R.id.list);
        recyclerView2 = findViewById(R.id.list2);
        recyclerView2.setHasFixedSize(true);
        recyclerView.setHasFixedSize(true);

        manager = new LinearLayoutManager(this);
        managers = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView2.setLayoutManager(managers);
        readFile();
        myAdapter= new UserAdapter(this, user);
        myAdapter2= new UserAdapterHor(this, user);
        recyclerView.setAdapter(myAdapter);
        recyclerView2.setAdapter(myAdapter2);

        adduserbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, com.wtechweb.assignment3_mad.AddContact.class);
                startActivityForResult(intent,ADD_USER);
            }
        });

    }

    public void readFile(){
        String name,address,email,phone;
        String text;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
//            InputStream is= getAssets().open("data.txt");

//            int size = is.available();
//            byte[] buffer =  new byte[size];
//            is.read(buffer);
//            is.close();
//            text = new String(buffer);
            String line1="";
            while ((line1 = reader.readLine()) != null) {
                String[] word = line1.split(",");
                name = word[0];
                email = word[1];
                address = word[2];
                phone = word[3];
                user.add(new User(name, email, address, phone));
                myAdapter.notifyDataSetChanged();
            }

        }
        catch(IOException ex){

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ADD_USER){
            if(resultCode== RESULT_OK){
                User work= new User();
                work.setName(data.getStringExtra("userName"));
                work.setEmail(data.getStringExtra("userEmail"));
                work.setAddress(data.getStringExtra("userAddress"));
                work.setPhoneNumber(data.getStringExtra("userPhone"));
                user.add(work);
                myAdapter.notifyDataSetChanged();
                Toast.makeText(this,"User Added",Toast.LENGTH_SHORT).show();
            }

        }
    }
    private void init(){
//        txtView=findViewById(R.id.txtView);

    }

    @Override
    public void onItemClick(int index) {
        String phone = user.get(index).getPhoneNumber();
        phone="tel: "+phone;
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(phone));
        startActivity(intent);
        Toast.makeText(this,user.get(index).getPhoneNumber(),Toast.LENGTH_SHORT).show();
    }


}