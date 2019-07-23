package com.example.tarun;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.view.View.TEXT_ALIGNMENT_GRAVITY;

public class MainActivity extends AppCompatActivity {
    String[] mobileArray =new String[] {"Hi!","Hi!","Do i know you !","No ! ",
            "we met at that party last weakend ","Rahul","ye naam suna hoga !","Sunny."};

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fb=(Button)findViewById(R.id.Firebasebutton);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Activity_firebase.class));
                finish();
            }
        });

        final ListView listView = (ListView) findViewById(R.id.mobile_list);

        final List<String> fruits_list = new ArrayList<String>(Arrays.asList(mobileArray));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, fruits_list){
            @Override
            public View getView(final int position, final View convertView, final ViewGroup parent){
                // Get the current item from ListView
                final View view = super.getView(position,convertView,parent);
                Log.d("position", "getView: "+position);
                Log.d("convertView", "getView: "+convertView);
                Log.d("parent", "getView: "+parent);
                LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lp2.weight = 1.0f;
                View v = super.getDropDownView(position, convertView,parent);

                if(position == 1)
                {
                    lp2.gravity = Gravity.START;
                    ((TextView) view).setGravity(Gravity.RIGHT);

                    view.setBackgroundResource(R.drawable.bubble_in);
                    listView.setLayoutParams(lp2);
                }
                if(position ==4)
                {
                    lp2.gravity = Gravity.END;
                    view.setBackgroundResource(R.drawable.bubble_out);
                    listView.setLayoutParams(lp2);

                }
              //  listView.setLayoutParams(lp2);


                return view;

            }
        };
        int i;
        for(i=0;i<=mobileArray.length;i++){
            listView.setAdapter(arrayAdapter);
        }



//                view.setOnTouchListener(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View v, MotionEvent event) {
//                        if (event.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
//
//
//                        }
//                        return false;
//                    }
//                    });

//
//        ArrayAdapter adapter = new ArrayAdapter<String>(this,
//                R.layout.activity_listview, mobileArray);

//        ListView listView = (ListView) findViewById(R.id.mobile_list);
//        listView.setAdapter(adapter);
//
//        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        lp2.weight = 1.0f;
//
//
//
//            lp2.gravity = Gravity.RIGHT;


//            listView.setBackgroundResource(R.drawable.bubble_out);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

    }
}
