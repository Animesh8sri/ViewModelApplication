package com.example.viewmodelapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button start, stop;
    TextView counterTv;
    ViewModelClass viewModelClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        start = (Button)findViewById(R.id.start_button);
        stop = (Button)findViewById(R.id.stop_button);
        counterTv = (TextView)findViewById(R.id.counter_text_view);


        viewModelClass = ViewModelProviders.of(this).get(ViewModelClass.class);
        viewModelClass.getCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                counterTv.setText(Integer.toString(integer));
            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModelClass.startCount();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModelClass.stopCount();
            }
        });
    }

}
