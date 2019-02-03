package com.oc.assignment_1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class PlayWildTicTacToe extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    boolean leftArrow = true;
    boolean rightArrow = false;
    public static final String TAG = "TESTING";
    int userPiece = 1;
    boolean xPiece;
    boolean oPiece;
    int z = 0;
    int count = 0;

    int[] choice4 = new int[9];
    String string;


    int[] gridButtons = {
            R.id.A1_button, R.id.B1_Button, R.id.C1_button, R.id.A2_button, R.id.B2_button, R.id.C2_button,
            R.id.A3_button, R.id.B3_button, R.id.C3_button
    };
    int[][] boardStatus = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(this);
        String restoredText1 = prefs1.getString("text1", null);
        String myvals1 = prefs1.getString("values1", null);
        setContentView(R.layout.activity_wild);

        if (restoredText1 != null) {

            String arr1 = myvals1;
            String[] items1 = arr1.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

            int[] results1 = new int[9];

            for (int i = 0; i < 9; i++) {
                try {
                    results1[i] = Integer.parseInt(items1[i]);
                } catch (NumberFormatException nfe) {
                    //....
                }
            }

            String len2 = Integer.toString(results1.length);
            Toast.makeText(PlayWildTicTacToe.this, len2, Toast.LENGTH_LONG).show();
            boardStatus[0][0] = results1[0];
            boardStatus[0][1] = results1[1];
            boardStatus[0][2] = results1[2];
            boardStatus[1][0] = results1[3];
            boardStatus[1][1] = results1[4];
            boardStatus[1][2] = results1[5];
            boardStatus[2][0] = results1[6];
            boardStatus[2][1] = results1[7];
            boardStatus[2][2] = results1[8];
            refill2();
            String test1 = Arrays.toString(results1);

            Toast.makeText(PlayWildTicTacToe.this, test1, Toast.LENGTH_LONG).show();


            leftArrow = prefs1.getBoolean("p_one1", true);
            rightArrow = prefs1.getBoolean("p_two1", false);
            userPiece = prefs1.getInt("p_three", 1);
            xPiece = prefs1.getBoolean("X", true);
            oPiece = prefs1.getBoolean("O", false);

            if (rightArrow == true) {
                ImageView imageView = findViewById(R.id.TurnView_IV);
                imageView.setImageResource(R.drawable.right_arrow);
            }
            if (leftArrow == true) {
                ImageView imageView = findViewById(R.id.TurnView_IV);
                imageView.setImageResource(R.drawable.left_arrow);
            }
            if (xPiece == true) {
                RadioButton rb = (RadioButton) findViewById(R.id.X_rb);
                rb.setChecked(true);
            }
            if (oPiece == true) {
                RadioButton rb = (RadioButton) findViewById(R.id.O_rb);
                rb.setChecked(true);
            }
        }


        RadioGroup radioGroup = findViewById(R.id.XorO_rg);
        radioGroup.setOnCheckedChangeListener(this);


        for (int gridButton : gridButtons) {
            findViewById(gridButton).setOnClickListener(this);
        }
        initializeBoardStatus();


    }


    public void onCheckedChanged(RadioGroup radioGroup, int clickedId) {

        if (radioGroup.getId() == R.id.XorO_rg) {
            if (clickedId == R.id.X_rb) {
                userPiece = 1;
                xPiece = true;
                oPiece = false;
            } else if (clickedId == R.id.O_rb) {
                userPiece = 2;
                oPiece = true;
                xPiece = false;
            }
        }

    }

    public void onClick(View v) {


        Drawable x = getDrawable(R.drawable.x_key);
        Drawable o = getDrawable(R.drawable.o_key);


        if (v.getId() == R.id.A1_button) {
            Button button = findViewById(R.id.A1_button);
            if (userPiece == 1) {
                button.setBackground(x);
                boardStatus[0][0] = 1;
                button.setEnabled(false);
            } else if (userPiece == 2) {
                button.setBackground(o);
                boardStatus[0][0] = 2;
                button.setEnabled(false);
            } else {
                Toast.makeText(getApplicationContext(), "Please choose 'X' or 'O'.", Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == R.id.B1_Button) {
            Button button = findViewById(R.id.B1_Button);
            if (userPiece == 1) {
                button.setBackground(x);
                boardStatus[0][1] = 1;
                button.setEnabled(false);
            } else if (userPiece == 2) {
                button.setBackground(o);
                boardStatus[0][1] = 2;
                button.setEnabled(false);
            } else {
                Toast.makeText(getApplicationContext(), "Please choose 'X' or 'O'.", Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == R.id.C1_button) {
            Button button = findViewById(R.id.C1_button);
            if (userPiece == 1) {
                button.setBackground(x);
                boardStatus[0][2] = 1;
                button.setEnabled(false);
            } else if (userPiece == 2) {
                button.setBackground(o);
                boardStatus[0][2] = 2;
                button.setEnabled(false);
            } else {
                Toast.makeText(getApplicationContext(), "Please choose 'X' or 'O'.", Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == R.id.A2_button) {
            Button button = findViewById(R.id.A2_button);
            if (userPiece == 1) {
                button.setBackground(x);
                boardStatus[1][0] = 1;
                button.setEnabled(false);
            } else if (userPiece == 2) {
                button.setBackground(o);
                boardStatus[1][0] = 2;
                button.setEnabled(false);
            } else {
                Toast.makeText(getApplicationContext(), "Please choose 'X' or 'O'.", Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == R.id.B2_button) {
            Button button = findViewById(R.id.B2_button);
            if (userPiece == 1) {
                button.setBackground(x);
                boardStatus[1][1] = 1;
                button.setEnabled(false);
            } else if (userPiece == 2) {
                button.setBackground(o);
                boardStatus[1][1] = 2;
                button.setEnabled(false);
            } else {
                Toast.makeText(getApplicationContext(), "Please choose 'X' or 'O'.", Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == R.id.C2_button) {
            Button button = findViewById(R.id.C2_button);
            if (userPiece == 1) {
                button.setBackground(x);
                boardStatus[1][2] = 1;
                button.setEnabled(false);
            } else if (userPiece == 2) {
                button.setBackground(o);
                boardStatus[1][2] = 2;
                button.setEnabled(false);
            } else {
                Toast.makeText(getApplicationContext(), "Please choose 'X' or 'O'.", Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == R.id.A3_button) {
            Button button = findViewById(R.id.A3_button);
            if (userPiece == 1) {
                button.setBackground(x);
                boardStatus[2][0] = 1;
                button.setEnabled(false);
            } else if (userPiece == 2) {
                button.setBackground(o);
                boardStatus[2][0] = 2;
                button.setEnabled(false);
            } else {
                Toast.makeText(getApplicationContext(), "Please choose 'X' or 'O'.", Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == R.id.B3_button) {
            Button button = findViewById(R.id.B3_button);
            if (userPiece == 1) {
                button.setBackground(x);
                boardStatus[2][1] = 1;
                button.setEnabled(false);
            } else if (userPiece == 2) {
                button.setBackground(o);
                boardStatus[2][1] = 2;
                button.setEnabled(false);
            } else {
                Toast.makeText(getApplicationContext(), "Please choose 'X' or 'O'.", Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == R.id.C3_button) {
            Button button = findViewById(R.id.C3_button);
            if (userPiece == 1) {
                button.setBackground(x);
                boardStatus[2][2] = 1;
                button.setEnabled(false);
            } else if (userPiece == 2) {
                button.setBackground(o);
                boardStatus[2][2] = 2;
                button.setEnabled(false);
            } else {
                Toast.makeText(getApplicationContext(), "Please choose 'X' or 'O'.", Toast.LENGTH_SHORT).show();
            }
        }

        changeTurns();


    }

    public void changeTurns() {
        ImageView imageView = findViewById(R.id.TurnView_IV);
        TextView winner = findViewById(R.id.winner_TV);
        int winner_ID;
        if (leftArrow == true) {
            leftArrow = false;
            rightArrow = true;
            winner_ID = checkWinner();
            if (winner_ID == 1) {
                winner.setText("Player 1 Wins!");
                disableButtons();
                return;
            }
            imageView.setImageResource(R.drawable.right_arrow);

        } else if (rightArrow == true) {
            rightArrow = false;
            leftArrow = true;
            winner_ID = checkWinner();
            if (winner_ID == 1) {
                winner.setText("Player 2 Wins!");
                disableButtons();
                return;
            }
            imageView.setImageResource(R.drawable.left_arrow);
        }

    }


    public int checkWinner() {

        int row = 0;
        int column = 0;
        //vertical check for x
        for (column = 0; column < 3; column++) {
            count = 0;
            for (row = 0; row < 3; row++) {

                if (boardStatus[row][column] == 1) {
                    count++;

                } else {
                    count = 0;

                }
                if (count == 3) {


                    return 1;

                }
            }
        }

        //vertical check for o
        for (column = 0; column < 3; column++) {
            count = 0;
            for (row = 0; row < 3; row++) {

                if (boardStatus[row][column] == 2) {
                    count++;

                } else {
                    count = 0;

                }
                if (count == 3) {


                    return 1;

                }
            }
        }

//Horizontal check for x
        for (row = 0; row < 3; row++) {
            count = 0;
            for (column = 0; column < 3; column++) {

                if (boardStatus[row][column] == 1) {
                    count++;

                } else {
                    count = 0;

                }
                if (count == 3) {

                    return 1;

                }
            }
        }


//Horizontal check for o
        for (row = 0; row < 3; row++) {
            count = 0;
            for (column = 0; column < 3; column++) {

                if (boardStatus[row][column] == 2) {
                    count++;

                } else {
                    count = 0;

                }
                if (count == 3) {

                    return 1;

                }
            }
        }
        //Diagonal Check for x
        column = 0;
        count = 0;
        for (row = 0; row < 3; row++) {
            if (boardStatus[row][column] == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                return 1;
            }
            column++;
        }
        //Diagonal Check for o
        column = 0;
        count = 0;
        for (row = 0; row < 3; row++) {
            if (boardStatus[row][column] == 2) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                return 1;
            }
            column++;
        }
        // ReverseDiagonal Check for x
        column = 0;
        count = 0;
        for (row = 2; row >= 0; row--) {
            if (boardStatus[row][column] == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                return 1;
            }
            column++;
        }
        // ReverseDiagonal Check for o
        column = 0;
        count = 0;
        for (row = 2; row >= 0; row--) {
            if (boardStatus[row][column] == 2) {
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

    private void initializeBoardStatus() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardStatus[i][j] = -1;
            }
        }
    }

    public void disableButtons() {
        for (int i = 0; i < 9; i++) {


            Button button1 = findViewById(gridButtons[i]);
            button1.setEnabled(false);


        }
    }

    public void newGame1(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("p_one1");
        editor.remove("p_two1");
        editor.putString("text1", null);
        editor.remove("values1");
        editor.apply();
        leftArrow = true;
        rightArrow = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardStatus[i][j] = 0;
            }
        }
        for (int i = 0; i < 9; i++) {
            choice4[i] = 0;
        }
        recreate();

    }

    protected void onStop() {
        super.onStop();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("text1", "saved");
        editor.putBoolean("p_one1", leftArrow);
        editor.putBoolean("p_two1", rightArrow);
        editor.putInt("p_three", userPiece);
        editor.putBoolean("X", xPiece);
        editor.putBoolean("O", oPiece);

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                choice4[z] = boardStatus[i][j];
                z++;
            }


        }
        String myarr1 = Arrays.toString(choice4);
        editor.putString("values1", myarr1);
        Toast.makeText(PlayWildTicTacToe.this, myarr1, Toast.LENGTH_LONG).show();
        editor.apply();
    }


    public void refill2() {

        Drawable newX = getDrawable(R.drawable.x_key);
        Drawable newO = getDrawable(R.drawable.o_key);

        if (boardStatus[0][0] == 1) {
            Button button = findViewById(gridButtons[0]);
            button.setBackground(newX);
        } if (boardStatus[0][0] == 2) {
            Button button = findViewById(gridButtons[0]);
            button.setBackground(newO);
        } if (boardStatus[0][1] == 1) {
            Button button = findViewById(gridButtons[1]);
            button.setBackground(newX);
        } if (boardStatus[0][1] == 2) {
            Button button = findViewById(gridButtons[1]);
            button.setBackground(newO);
        } if (boardStatus[0][2] == 1) {
            Button button = findViewById(gridButtons[2]);
            button.setBackground(newX);
        } if (boardStatus[0][2] == 2) {
            Button button = findViewById(gridButtons[2]);
            button.setBackground(newO);
        } if (boardStatus[1][0] == 1) {
            Button button = findViewById(gridButtons[3]);
            button.setBackground(newX);
        } if (boardStatus[1][0] == 2) {
            Button button = findViewById(gridButtons[3]);
            button.setBackground(newO);
        } if (boardStatus[1][1] == 1) {
            Button button = findViewById(gridButtons[4]);
            button.setBackground(newX);
        } if (boardStatus[1][1] == 2) {
            Button button = findViewById(gridButtons[4]);
            button.setBackground(newO);
        } if (boardStatus[1][2] == 1) {
            Button button = findViewById(gridButtons[5]);
            button.setBackground(newX);
        } if (boardStatus[1][2] == 2) {
            Button button = findViewById(gridButtons[5]);
            button.setBackground(newO);
        } if (boardStatus[2][0] == 1) {
            Button button = findViewById(gridButtons[6]);
            button.setBackground(newX);
        }if (boardStatus[2][0] == 2) {
            Button button = findViewById(gridButtons[6]);
            button.setBackground(newO);
        }if (boardStatus[2][1] == 1) {
            Button button = findViewById(gridButtons[7]);
            button.setBackground(newX);
        } if (boardStatus[2][1] == 2) {
            Button button = findViewById(gridButtons[7]);
            button.setBackground(newO);
        } if (boardStatus[2][2] == 1) {
            Button button = findViewById(gridButtons[8]);
            button.setBackground(newX);
        }  if (boardStatus[2][2] == 2) {
            Button button = findViewById(gridButtons[8]);
            button.setBackground(newO);

        }
    }
}
