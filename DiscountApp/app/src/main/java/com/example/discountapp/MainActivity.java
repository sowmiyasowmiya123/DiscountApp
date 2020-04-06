package com.example.discountapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText number;
    Button cal;
    TextView discount,amount;
    RadioGroup rg;
    RadioButton rb;
    int valuedis;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number=findViewById(R.id.input);
        cal = (Button)findViewById(R.id.cal);
        discount=findViewById(R.id.discountval);
        amount=findViewById(R.id.ans);
        rg=findViewById(R.id.rg);
        cal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int id=rg.getCheckedRadioButtonId();
                rb=findViewById(id);
                if(number.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"Enter a Value",Toast.LENGTH_LONG).show();
                else {
                    int value = Integer.parseInt(number.getText().toString());
                    valuedis = Integer.parseInt(rb.getText().toString().replace('%', ' ').trim());
                    discount.setText((value / 100) * valuedis + "");
                    amount.setText(value - ((value / 100) * valuedis) + "");
                }
            }
        });
    }
}
