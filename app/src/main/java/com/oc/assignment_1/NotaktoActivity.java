package com.oc.assignment_1;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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

            if (isOne) {
                for (x = 0; x <= 2; x++) {
                    for (y = 0; y <= 2; y++) {
                        if (b[x][y].isPressed()) {
                            b[x][y].setEnabled(false);
                            b[x][y].setBackgroundResource(R.drawable.xkey);
                            choice[x][y] = 1;
                            if (OnesTurn == true) {
                                OnesTurn = false;
                                TwosTurn = true;
                                my_turn.setText("Player Two is up");
                                winner_id = checkWin();
                                if (winner_id == 2) {
                                    Toast.makeText(NotaktoActivity.this, "Player One Wins, now back to the main menu", Toast.LENGTH_LONG).show();

                                    back();
                                }
                            } else {
                                OnesTurn = true;
                                TwosTurn = false;
                                my_turn.setText("Player One is up");
                                winner_id = checkWin();
                                if (winner_id == 2) {
                                    Toast.makeText(NotaktoActivity.this, "Player One Wins, now back to the main menu", Toast.LENGTH_LONG).show();

                                    back();
                                }
                            }


                        }
                    }
                }
            }


        }
    }

    public int checkWin() {


        int row = 0;
        int column = 0;
        //Reverse Diagonal Check
        for (row = 4; row >= 0; row--) {

            //test_background=a[row][column].getBackground();
            if (choice[row][column] == 2) {
                count++;

            } else {
                count = 0;

            }
            if (count >= 5) {
                //Toast.makeText(GameActivity.this, "Winner test works", Toast.LENGTH_LONG).show();
                return 2;
                //back();
            }
            column++;

        }
        column = 0;
        for (row = 5; row > 0; row--) {

            //test_background=a[row][column].getBackground();
            if (choice[row][column] == 2) {
                count++;

            } else {
                count = 0;

            }
            if (count >= 5) {
                //Toast.makeText(GameActivity.this, "Winner test works", Toast.LENGTH_LONG).show();
                return 2;
                //back();
            }
            column++;

        }
        column = 1;
        for (row = 5; row > 0; row--) {

            //test_background=a[row][column].getBackground();
            if (choice[row][column] == 2) {
                count++;

            } else {
                count = 0;

            }
            if (count >= 5) {
                //Toast.makeText(GameActivity.this, "Winner test works", Toast.LENGTH_LONG).show();
                return 2;
                //back();
            }
            column++;

        }
        column = 1;
        for (row = 4; row >= 0; row--) {

            //test_background=a[row][column].getBackground();
            if (choice[row][column] == 2) {
                count++;

            } else {
                count = 0;

            }
            if (count >= 5) {
                //Toast.makeText(GameActivity.this, "Winner test works", Toast.LENGTH_LONG).show();
                return 2;
                //back();
            }
            column++;

        }
        // Diagonal check
        for (row = 0; row < 5; row++) {


            if (choice[row][row] == 2) {
                count++;

            } else {
                count = 0;

            }
            if (count >= 5) {
                //Toast.makeText(GameActivity.this, "Winner test works", Toast.LENGTH_LONG).show();
                return 2;
                //back();
            }

        }
        column = 1;
        for (row = 0; row < 5; row++) {

            //test_background=a[row][column].getBackground();
            if (choice[row][column] == 2) {
                count++;

            } else {
                count = 0;

            }
            if (count >= 5) {
                //Toast.makeText(GameActivity.this, "Winner test works", Toast.LENGTH_LONG).show();
                return 2;
                //back();
            }
            column++;

        }
        column = 0;
        for (row = 1; row < 6; row++) {

            //test_background=a[row][column].getBackground();
            if (choice[row][column] == 2) {
                count++;

            } else {
                count = 0;

            }
            if (count >= 5) {
                //Toast.makeText(GameActivity.this, "Winner test works", Toast.LENGTH_LONG).show();
                return 2;
                //back();
            }
            column++;

        }
        column = 1;
        for (row = 1; row < 6; row++) {

            //test_background=a[row][column].getBackground();
            if (choice[row][column] == 2) {
                count++;

            } else {
                count = 0;

            }
            if (count >= 5) {
                //Toast.makeText(GameActivity.this, "Winner test works", Toast.LENGTH_LONG).show();
                return 2;
                //back();
            }
            column++;

        }

//Chaos win
        for (row = 0; row < 6; row++) {
            for (column = 0; column < 6; column++) {
                if (choice[row][column] == 1 || choice[row][column] == 2) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == 36) {
                    Toast.makeText(NotaktoActivity.this, "Chaos wins!", Toast.LENGTH_LONG).show();
                    back();
                }
            }
        }
        count = 0;
// Horizontal check
        for (row = 0; row < 6; row++) {
            count = 0;
            for (column = 0; column < 6; column++) {
                //test_background=a[row][column].getBackground();
                if (choice[row][column] == 2) {
                    count++;

                } else {
                    count = 0;

                }
                if (count >= 5) {
                    //Toast.makeText(GameActivity.this, "Winner test works", Toast.LENGTH_LONG).show();
                    return 2;
                    //back();
                }
            }
        }
        // Vertical check
        for (column = 0; column < 6; column++) {
            count = 0;
            for (row = 0; row < 6; row++) {
                //test_background=a[row][column].getBackground();
                if (choice[row][column] == 2) {
                    count++;

                } else {
                    count = 0;

                }
                if (count >= 5) {
                    //Toast.makeText(GameActivity.this, "Winner test works", Toast.LENGTH_LONG).show();
                    return 2;
                    //back();
                }
            }
        }

        return 0;
    }

    public void back() {
        count = 0;
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
