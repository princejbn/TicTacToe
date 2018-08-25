package com.princejbn.android.tictactoe;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class DoublePlayer extends AppCompatActivity implements View.OnClickListener {

    Button[] buttons=new Button[9];
    TextView status;
    TicTacToe newgame;
    TextView dialogView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.double_player);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       dialogView=(TextView) findViewById(R.id.AlertDialog);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setHomeButtonEnabled(false);

        status = (TextView) findViewById(R.id.status);
        status.setText("Player1 First");
        buttons[0] = (Button) findViewById(R.id.P00);
        buttons[0].setOnClickListener(this);

        buttons[1] = (Button) findViewById(R.id.P01);
        buttons[1].setOnClickListener(this);

        buttons[2] = (Button) findViewById(R.id.P02);
        buttons[2].setOnClickListener(this);

        buttons[3] = (Button) findViewById(R.id.P10);
        buttons[3].setOnClickListener(this);

        buttons[4] = (Button) findViewById(R.id.P11);
        buttons[4].setOnClickListener(this);

        buttons[5] = (Button) findViewById(R.id.P12);
        buttons[5].setOnClickListener(this);

        buttons[6] = (Button) findViewById(R.id.P20);
        buttons[6].setOnClickListener(this);

        buttons[7] = (Button) findViewById(R.id.P21);
        buttons[7].setOnClickListener(this);

        buttons[8] = (Button) findViewById(R.id.P22);
        buttons[8].setOnClickListener(this);

        newgame=new TicTacToe(2,status,buttons,this,dialogView);
        newgame.reset();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id==R.id.easyLevel)
        {
        }
        if(id==R.id.mediumLevel)
        {
        }

        else if(id==R.id.hardLevel)
        {
        }

        else if(id==R.id.reset)
        {
            newgame.open(newgame.resetMessage);

        }

        else if(id==R.id.back)
        {
            newgame.back();
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View view) {
        if (newgame.boardFull == 1) {
            newgame.reset();
        }
        switch (view.getId()) {

            case R.id.P00:
                newgame.go(0);
                break;

            case R.id.P01:
                newgame.go(1);
                break;

            case R.id.P02:
                newgame.go(2);
                break;

            case R.id.P10:
                newgame.go(3);
                break;

            case R.id.P11:
                newgame.go(4);
                break;

            case R.id.P12:
                newgame.go(5);
                break;

            case R.id.P20:
                newgame.go(6);
                break;

            case R.id.P21:
                newgame.go(7);
                break;

            case R.id.P22:
                newgame.go(8);
                break;
        }
    }
}
