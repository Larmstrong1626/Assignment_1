package com.oc.assignment_1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PlayWildTicTacToe extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    boolean leftArrow = true;
    boolean rightArrow = false;
    int userPiece = 1;
    int count = 0;
    int[] gridButtons = {
            R.id.A1_button, R.id.A2_button, R.id.A3_button, R.id.B1_Button, R.id.B2_button, R.id.B3_button,
            R.id.C1_button, R.id.C2_button, R.id.C3_button
    };


    int[][] boardStatus = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild);

        RadioGroup radioGroup = findViewById(R.id.XorO_rg);
        radioGroup.setOnCheckedChangeListener(this);


        for (int gridButton : gridButtons) {
            findViewById(gridButton).setOnClickListener(this);
        }
        leftArrow = true;
        initializeBoardStatus();

    }


    public void onCheckedChanged(RadioGroup radioGroup, int clickedId) {

        if (radioGroup.getId() == R.id.XorO_rg) {
            if (clickedId == R.id.X_rb) {
                userPiece = 1;
            } else if (clickedId == R.id.O_rb) {
                userPiece = 2;
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
    private void initializeBoardStatus(){
        for (int i = 0; i < 3; i++){
            for (int j=0; j < 3; j++){
                boardStatus[i][j] = -1;
            }
        }
    }

    public void disableButtons(){
        for (int i = 0; i < 9; i++) {


                Button button1 = findViewById(gridButtons[i]);
                button1.setEnabled(false);


            }
        }
    }

