package com.oc.assignment_1;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class NotaktoActivity extends Activity {

    boolean isOne, isTwo;
    boolean OnesTurn = true;
    boolean TwosTurn = false;
    int count = 0;
    ImageButton b[][];
    int[][] choice = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notakto);
        int x, y;
        x = 0;
        y = 0;

        b = new ImageButton[3][3];

//row1
        b[0][0] = findViewById(R.id.one);
        b[0][1] = findViewById(R.id.two);
        b[0][2] = findViewById(R.id.three);
//row2
        b[1][0] = findViewById(R.id.four);
        b[1][1] = findViewById(R.id.five);
        b[1][2] = findViewById(R.id.six);
//row3
        b[2][0] = findViewById(R.id.seven);
        b[2][1] = findViewById(R.id.eight);
        b[2][2] = findViewById(R.id.nine);

        b[x][y].setOnClickListener(new MyListener(x, y));
        for (x = 0; x <= 2; x++) {
            for (y = 0; y <= 2; y++) {
                b[x][y].setOnClickListener(new MyListener(x, y));
            }
        }
    }

    public class MyListener implements View.OnClickListener {


        int x, y;

        //Class Constructor
        MyListener(int x, int y) {


            this.x = x;
            this.y = y;


        }

        @Override
        public void onClick(View v) {
            TextView my_turn = findViewById(R.id.my_turn);
            int winner_id;


        }
    }
}
