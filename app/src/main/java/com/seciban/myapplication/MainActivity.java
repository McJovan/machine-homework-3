package com.seciban.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Initialize
    EditText name_field, phone_field, address_field;
    RadioButton rb_beef, rb_chicken;
    CheckBox bacon_addon, pine_addon, lettuce_addon, pickles_addon, cheese_addon, mustard_addon;
    Button add_cart;

    String name_field_value, phone_field_value, address_field_value;
    String typeofburger_value;
    String addons_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb_beef = (RadioButton) findViewById(R.id.radioButton);
        rb_chicken = (RadioButton) findViewById(R.id.radioButton2);
        bacon_addon = (CheckBox) findViewById(R.id.checkbox);
        pine_addon = (CheckBox) findViewById(R.id.checkBox2);
        lettuce_addon = (CheckBox) findViewById(R.id.checkBox3);
        pickles_addon = (CheckBox) findViewById(R.id.checkBox4);
        cheese_addon = (CheckBox) findViewById(R.id.checkBox5);
        mustard_addon = (CheckBox) findViewById(R.id.checkBox6);
        name_field = (EditText) findViewById(R.id.editText);
        phone_field = (EditText) findViewById(R.id.editText2);
        address_field = (EditText) findViewById(R.id.editText3);
        add_cart = (Button) findViewById(R.id.button);
        add_cart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                name_field_value = name_field.getText().toString();
                phone_field_value = phone_field.getText().toString();
                address_field_value = address_field.getText().toString();
                if (rb_beef.isChecked()) {
                    typeofburger_value = "Beef";
                } else {
                    typeofburger_value = "Chicken";
                }

                addons_value = "";
                if (bacon_addon.isChecked()){
                    addons_value += "Bacon; ";
                }
                if (pine_addon.isChecked()){
                    addons_value += "Pineapple; ";
                }
                if (lettuce_addon.isChecked()){
                    addons_value += "Lettuce; ";
                }
                if (pickles_addon.isChecked()){
                    addons_value += "Pickles; ";
                }
                if (cheese_addon.isChecked()){
                    addons_value += "Cheese; ";
                }
                if (mustard_addon.isChecked()){
                    addons_value += "Mustard; ";
                }

                Toast.makeText(this, "Product added to cart", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, revieworder.class);
                intent.putExtra("name_field_value", name_field_value);
                intent.putExtra("phone_field_value", phone_field_value);
                intent.putExtra("address_field_value", address_field_value);
                intent.putExtra("typeofburger_value", typeofburger_value);
                intent.putExtra("addons_value", addons_value);;
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
        super.onBackPressed();
    }
}

