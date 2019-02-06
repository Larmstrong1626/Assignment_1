package com.oc.assignment_1;

import android.app.Activity;
import android.content.Intent;
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

/**********Integer Array for 9 Buttons*********/
    int[] gridButtons = {
            R.id.A1_button, R.id.B1_Button, R.id.C1_button, R.id.A2_button, R.id.B2_button, R.id.C2_button,
            R.id.A3_button, R.id.B3_button, R.id.C3_button
    };
/**********2d Array to hold the board status of the 3x3 button Tic Tac Toe board*********/
    int[][] boardStatus = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*****************************************************************************************
 *
 * declared prefs1 Shared Preference to use the key/value of text1 - allows for a game to be either null(new game) or saved(game in progress)
 *
 *
 */
        SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(this);
        String savedGame = prefs1.getString("text1", null);
        String myvals1 = prefs1.getString("values1", null);
        setContentView(R.layout.activity_wild);

/**********Nested for loop to initialize the 2d BoardStatus Array*********/
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardStatus[i][j] = -1;
            }
        }


/**********
 *
 * if statement to check for game in progress. If saved game String is set to Null, this statement will be ignored. Otherwise, a game is in progress and this statement will run and
 * load the saved game.
 *
 **********/
            if (savedGame != null) {

                 String arr1 = myvals1;
                  String[] stringArr = arr1.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

                   int[] results1 = new int[9];

                   for (int i = 0; i < 9; i++) {
                       try {
                          results1[i] = Integer.parseInt(stringArr[i]);
                        } catch (NumberFormatException nfe) {
                             //....
                          }
                      }

                        boardStatus[0][0] = results1[0];
                        boardStatus[0][1] = results1[1];
                        boardStatus[0][2] = results1[2];
                        boardStatus[1][0] = results1[3];
                        boardStatus[1][1] = results1[4];
                        boardStatus[1][2] = results1[5];
                        boardStatus[2][0] = results1[6];
                        boardStatus[2][1] = results1[7];
                        boardStatus[2][2] = results1[8];
                        loadSavedGame();


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
                        RadioButton rb = findViewById(R.id.X_rb);
                        rb.setChecked(true);
                    }
                    if (oPiece == true) {
                        RadioButton rb = findViewById(R.id.O_rb);
                        rb.setChecked(true);
                    }
                }


        RadioGroup radioGroup = findViewById(R.id.XorO_rg);
        radioGroup.setOnCheckedChangeListener(this);

/*********LISTENER*********/
        for (int gridButton : gridButtons) {
            findViewById(gridButton).setOnClickListener(this);
        }
    }

/*********OnCheckedChanged checks the status of the radio button selected********/
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

    /***************************************************************************************************
     * onClick listens for buttons to be pressed and goes through a series of if statements to identify the button and radio button selected,
     * then sets the boardStatus and background accordingly and finally disables the button.
     * @param v
     */
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

    /**************************************************************************************************
     * changeTurns identifies who's turn it is based on the boolean value of left/right arrow. Then swaps those boolean values and changes the arrow image to reflect the change of turns.
     * Afterwards, a check for 3 symbols in a row is checked to identify a winner.
     */
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

/*********checkWinner checks for horizontal, vertical, and diagnal for 3 in a row of x or o to identify a winner.*********/
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


/***********Disables buttons as they are pressed********/
    public void disableButtons() {
        for (int i = 0; i < 9; i++) {


            Button button1 = findViewById(gridButtons[i]);
            button1.setEnabled(false);


        }
    }

    public void mainMenu(View view){
        count = 0;
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
/********When the new game button is pressed, newGame1 clears out any saved Shared Preferences and resets the Tic Tac Toe board.********/
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

/**********When onStop is called, game values are saved in Shared Preferences to be reload upon next startup.*********/
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
        editor.apply();
    }

/***********if saved game does not equal no, loadSavedGame is called and recreates the Tic Tac Toe board based on the shared prefernces saved********/
    public void loadSavedGame() {

        Drawable newX = getDrawable(R.drawable.x_key);
        Drawable newO = getDrawable(R.drawable.o_key);


          for(int i=0; i <=2; i++){
            for(int j=0; j<=2; j++){
                for(int z=0; z<1; z++){
                if(boardStatus[i][j] == 1){
                    if(i == 0) {
                        Button button = findViewById(gridButtons[z + j]);
                        button.callOnClick();
                        button.setEnabled(false);
                        button.setBackgroundResource(R.drawable.x_key);
                    } if(i == 1){
                        Button button = findViewById(gridButtons[z + j + i + 2]);
                        button.callOnClick();
                        button.setEnabled(false);
                        button.setBackgroundResource(R.drawable.x_key);
                    } if(i == 2) {
                        Button button = findViewById(gridButtons[z + j + i+ 4]);
                        button.callOnClick();
                        button.setEnabled(false);
                        button.setBackgroundResource(R.drawable.x_key);
                    }
                }else if(boardStatus[i][j] == 2) {
                        if (i == 0) {
                            Button button = findViewById(gridButtons[z + j]);
                            button.callOnClick();
                            button.setEnabled(false);
                            button.setBackgroundResource(R.drawable.o_key);
                        }  if (i == 1) {
                            Button button = findViewById(gridButtons[z + j + i + 2]);
                            button.callOnClick();
                            button.setEnabled(false);
                            button.setBackgroundResource(R.drawable.o_key);
                        }  if (i == 2) {
                            Button button = findViewById(gridButtons[z + j + i + 4]);
                            button.callOnClick();
                            button.setEnabled(false);
                            button.setBackgroundResource(R.drawable.o_key);
                        }

                }
            }
        }
    }
}

}