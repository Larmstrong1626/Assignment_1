package com.oc.assignment_1;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotaktoActivity extends Activity {


    int x,y,z=0;
    boolean OnesTurn = true;
    boolean TwosTurn = false;
    int count = 0;
    String myarr;
    ImageButton b[][];
    int[][] choice = new int[3][3];
    int[] choice2 = new int[9];

    ImageView one, two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String restoredText = prefs.getString("text", null);

        setContentView(R.layout.activity_notakto);
        one = findViewById(R.id.one_image);
        one.setImageResource(R.drawable.one_row);


        two = findViewById(R.id.two_image);
        two.setImageResource(R.drawable.two_row);

        if (restoredText != null) {

            OnesTurn = prefs.getBoolean("p_one", true);
            TwosTurn = prefs.getBoolean("p_two", false);
            // Toast.makeText(NotaktoActivity.this, Boolean.toString(TwosTurn), Toast.LENGTH_LONG).show();
            if (OnesTurn) {
                TextView tv1 = findViewById(R.id.my_turn);
                tv1.setText("Player 1 is up");
                one.setVisibility(View.VISIBLE);
                two.setVisibility(View.INVISIBLE);
            }
            if (TwosTurn) {
                TextView tv1 = findViewById(R.id.my_turn);
                tv1.setText("Player 2 is up");
                one.setVisibility(View.INVISIBLE);
                two.setVisibility(View.VISIBLE);
            }
        } else {
            TextView tv1 = findViewById(R.id.my_turn);
            tv1.setText("Player 1 is up");
            one.setVisibility(View.VISIBLE);

        }

        //setContentView(R.layout.activity_notakto);


        int x, y;
        x = 0;
        y = 0;


        //   one = findViewById(R.id.one_image);
        // one.setImageResource(R.drawable.one_row);
        //one.setVisibility(View.VISIBLE);

        //two = findViewById(R.id.two_image);
        //two.setImageResource(R.drawable.two_row);

        b = new ImageButton[3][3];

//row1
        b[0][0] = (ImageButton) findViewById(R.id.one);
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
        public MyListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void onClick(View v) {
            TextView my_turn = findViewById(R.id.my_turn);
            int winner_id;
            TextView winner_text = findViewById(R.id.tv4);

            for (x = 0; x <= 2; x++) {
                for (y = 0; y <= 2; y++) {
                    if (b[x][y].isPressed()) {
                        b[x][y].setEnabled(false);
                        b[x][y].setBackgroundResource(R.drawable.x_key);
                        choice[x][y] = 1;

                    }
                }
                if (OnesTurn == true) {
                    OnesTurn = false;
                    TwosTurn = true;
                    my_turn.setText("Player 2 is up");
                    two.setVisibility(View.VISIBLE);
                    one.setVisibility(View.INVISIBLE);
                    winner_id = checkWin();
                    if (winner_id == 1) {
                        winner_text.setText("Player Two Wins!");
                        disappear();
                        winner_text.setVisibility(View.VISIBLE);
                        my_turn.setVisibility(View.INVISIBLE);
                    }
                } else {
                    OnesTurn = true;
                    TwosTurn = false;
                    my_turn.setText("Player 1 is up");
                    one.setVisibility(View.VISIBLE);
                    two.setVisibility(View.INVISIBLE);
                    winner_id = checkWin();
                    if (winner_id == 1) {
                        winner_text.setText("Player One Wins!");
                        disappear();
                        winner_text.setVisibility(View.VISIBLE);
                        my_turn.setVisibility(View.INVISIBLE);

                    }

                }

            }


        }
    }


    public int checkWin() {
        int row = 0;
        int column = 0;
        //vertical check
        for (column = 0; column < 3; column++) {
            count = 0;
            for (row = 0; row < 3; row++) {

                if (choice[row][column] == 1) {
                    count++;

                } else {
                    count = 0;

                }
                if (count == 3) {

                    return 1;

                }
            }
        }

        //Horizontal check
        for (row = 0; row < 3; row++) {
            count = 0;
            for (column = 0; column < 3; column++) {

                if (choice[row][column] == 1) {
                    count++;

                } else {
                    count = 0;

                }
                if (count == 3) {

                    return 1;

                }
            }
        }
        //Diagonal Check
        column = 0;
        count = 0;
        for (row = 0; row < 3; row++) {
            if (choice[row][column] == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                return 1;
            }
            column++;
        }


        // ReverseDiagonal Check
        column = 0;
        count = 0;
        for (row = 2; row >= 0; row--) {
            if (choice[row][column] == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                return 1;
            }
            column++;
        }
        return 0;
    }

    public void disappear() {
        int x = 0;
        int y = 0;
        for (x = 0; x <= 2; x++) {
            for (y = 0; y <= 2; y++) {

                b[x][y].setVisibility(View.INVISIBLE);


            }
        }

    }


    public void main_menu(View view) {
        count = 0;
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);

    }

    public void newGame(View view) {
        count = 0;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = preferences.edit();
        //editor.putString("text", mSaved.getText().toString());
        //SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor.remove("p_one");
        editor.remove("p_two");
        editor.putString("text", null);
        editor.apply();
        OnesTurn = true;
        TwosTurn = false;
        recreate();

    }

    protected void onStop() {
        super.onStop();


        //SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("text", "saved");
        editor.putBoolean("p_one", OnesTurn);
        editor.putBoolean("p_two", TwosTurn);

        for(x=0;x<3;x++){
            for(y=0;y<3;y++){

               choice2[z]=choice[x][y];
               z++;
            }


        }
        myarr=Arrays.toString(choice2);
        editor.putString("values",myarr);
        Toast.makeText(NotaktoActivity.this, myarr, Toast.LENGTH_LONG).show();


        editor.apply();


    }


}

