package com.princejbn.android.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    char player1 = 'X';
    char player2 = 'O';
    int boardFull=0;

    char player = player1;
    Button b00, b01, b02, b10, b11, b12, b20, b21, b22;
    TextView status;
    public int chance = 0;
    public char[] board = new char[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clearBoard();
        status = (TextView) findViewById(R.id.status);
        status.setText("Player1 First");
        b00 = (Button) findViewById(R.id.P00);
        b00.setOnClickListener(this);

        b01 = (Button) findViewById(R.id.P01);
        b01.setOnClickListener(this);

        b02 = (Button) findViewById(R.id.P02);
        b02.setOnClickListener(this);

        b10 = (Button) findViewById(R.id.P10);
        b10.setOnClickListener(this);

        b11 = (Button) findViewById(R.id.P11);
        b11.setOnClickListener(this);

        b12 = (Button) findViewById(R.id.P12);
        b12.setOnClickListener(this);

        b20 = (Button) findViewById(R.id.P20);
        b20.setOnClickListener(this);

        b21 = (Button) findViewById(R.id.P21);
        b21.setOnClickListener(this);

        b22 = (Button) findViewById(R.id.P22);
        b22.setOnClickListener(this);


    }

    void display() {
        b00.setText(board, 0, 1);
        b01.setText(board, 1, 1);
        b02.setText(board, 2, 1);
        b10.setText(board, 3, 1);
        b11.setText(board, 4, 1);
        b12.setText(board, 5, 1);
        b20.setText(board, 6, 1);
        b21.setText(board, 7, 1);
        b22.setText(board, 8, 1);
    }

    public void nextPlayer() {
        if (player == player1)
            player = player2;
        else if (player == player2)
            player = player1;
    }

    public char checkWin() {
        if (board[0] != ' ') {
            if (board[0] == board[1] && board[1] == board[2])
                return board[0];
            if (board[0] == board[3] && board[3] == board[6])
                return board[0];
            if (board[0] == board[4] && board[4] == board[8])
                return board[0];
        }

        if (board[3] != ' ' && board[3] == board[4] && board[4] == board[5])
            return board[3];

        if (board[8] != ' ') {
            if (board[6] == board[7] && board[7] == board[8])
                return board[8];
            if (board[2] == board[5] && board[5] == board[8])
                return board[8];
        }
        if (board[1] != ' ' && board[1] == board[4] && board[4] == board[7])
            return board[1];

        if (board[2] != ' ' && board[2] == board[4] && board[4] == board[6])
            return board[2];
        return '!';
    }


    public void clearBoard() {
        for (int i = 0; i < 9; i++)
            board[i] = ' ';
    }

    public void displayPlayer()
    {
        if(player==player1)
            status.setText("Player1 chance");
        else if(player==player2)
            status.setText("Player2 chance");
    }

    public void checkIfDraw()
    {
        checkIfWon();
        int flag=0;
        for(int i=0;i<9;i++)
            if(board[i]==' ')
                flag=1;
        if(flag==1)
            return;
        status.setText("GAME DRAW");
        boardFull=1;
    }

    public void checkIfWon() {
        char win = checkWin();
        if (win != '!') {
            if (win == player1)
                status.setText("Player 1 won");
            else
                status.setText("Player 2 won");
            boardFull=1;
        }
        return;
    }


    @Override
    public void onClick(View view) {
        if(boardFull==1) {
            clearBoard();
            boardFull = 0;
        }
        switch (view.getId()) {

            case R.id.P00:
                if (board[0] == ' ')
                    board[0] = player;
                break;

            case R.id.P01:
                if (board[1] == ' ')
                    board[1] = player;
                break;

            case R.id.P02:
                if (board[2] == ' ')
                    board[2] = player;
                break;

            case R.id.P10:
                if (board[3] == ' ')
                    board[3] = player;
                break;

            case R.id.P11:
                if (board[4] == ' ')
                    board[4] = player;
                break;

            case R.id.P12:
                if (board[5] == ' ')
                    board[5] = player;
                break;

            case R.id.P20:
                if (board[6] == ' ')
                    board[6] = player;
                break;

            case R.id.P21:
                if (board[7] == ' ')
                    board[7] = player;
                break;

            case R.id.P22:
                if (board[8] == ' ')
                    board[8] = player;
                break;
        }
        nextPlayer();
        displayPlayer();
        display();
        checkIfWon();
        checkIfDraw();

    }

}
