package com.seciban.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class revieworder extends AppCompatActivity implements View.OnClickListener {

    Button submit_button, back_button;

    String name_field_value, phone_field_value, address_field_value;
    String typeofburger_value;
    String addons_value;

    TextView tv_name, tv_phone, tv_address, tv_type_of_burger_value, tv_addons_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revieworder);

        Intent intent = getIntent();

        name_field_value = intent.getStringExtra("name_field_value");
        phone_field_value = intent.getStringExtra("phone_field_value");
        address_field_value = intent.getStringExtra("address_field_value");
        typeofburger_value = intent.getStringExtra("typeofburger_value");
        addons_value = intent.getStringExtra("addons_value");

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_address = (TextView) findViewById(R.id.tv_address);
        tv_type_of_burger_value = (TextView) findViewById(R.id.tv_type_of_burger_value);
        tv_addons_value = (TextView) findViewById(R.id.tv_addons_value);

        submit_button = (Button) findViewById(R.id.submit_button);
        back_button = (Button) findViewById(R.id.back_button);

        tv_name.setText(name_field_value);
        tv_phone.setText(phone_field_value);
        tv_address.setText(address_field_value);
        tv_type_of_burger_value.setText(typeofburger_value);
        tv_addons_value.setText(addons_value);

        submit_button.setOnClickListener(this);
        back_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.submit_button:
                Toast.makeText(this, "Order submitted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.back_button:
                this.finish();
                break;
        }
    }
}
