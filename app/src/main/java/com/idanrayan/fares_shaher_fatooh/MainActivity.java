package com.idanrayan.fares_shaher_fatooh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button addNewProduct;
    ListView product;
    ArrayAdapter adapter;
    String productName;
    String productPrice;
    String productQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNewProduct = findViewById(R.id.btn_addNew_product);
        product = findViewById(R.id.product_list);
        ArrayList<String> listProduct = new ArrayList<String>();

        listProduct = new ArrayList();


         productName = getIntent().getStringExtra("name");
         productPrice = getIntent().getStringExtra("quantity");
         productQuantity = getIntent().getStringExtra("price");

        if (productName != null) {
            listProduct.add(productName);
        }
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, listProduct);
        product.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        product.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DataActivity.class);
                intent.putExtra("productName",productName);
                intent.putExtra("productPrice",productPrice);
                intent.putExtra("productQuantity",productQuantity);
                startActivity(intent);
            }
        });


        addNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
                startActivity(intent);
            }
        });
    }
    

}