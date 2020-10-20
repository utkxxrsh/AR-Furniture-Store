package com.example.furnished;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.furnished.adapter.popularfuradapter;
import com.example.furnished.model.popularfur;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Store extends AppCompatActivity {
    RecyclerView popularRecycler;
    popularfuradapter popularfuradapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        List<popularfur> popularfurList= new ArrayList<>();
        popularfurList.add(new popularfur("Sofa","RS 5000",R.drawable.ysof));
        popularfurList.add(new popularfur("Table","RS 3000",R.drawable.table));
        popularfurList.add(new popularfur("Chair","RS 1000",R.drawable.ch2));
        setPopularRecycler(popularfurList);






    }
    private  void setPopularRecycler(List<popularfur> popularfurList){
        popularRecycler=findViewById(R.id.popular_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        popularRecycler.setLayoutManager(layoutManager);
        popularfuradapter= new popularfuradapter(this,popularfurList);
        popularRecycler.setAdapter(popularfuradapter);
    }

    public void  logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
    public void sofa(View view){
        startActivity(new Intent(getApplicationContext(),SOFA.class));
    }


}
