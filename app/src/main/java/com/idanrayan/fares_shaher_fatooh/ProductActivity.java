package com.idanrayan.fares_shaher_fatooh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProductActivity extends AppCompatActivity {

    EditText name,quantity,price;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        name = findViewById(R.id.product_name);
        quantity = findViewById(R.id.product_quantity);
        price = findViewById(R.id.product_price);
        save = findViewById(R.id.save_product);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("quantity",quantity.getText().toString());
                intent.putExtra("price",price.getText().toString());

                startActivity(intent);



            }
        });

    }
}