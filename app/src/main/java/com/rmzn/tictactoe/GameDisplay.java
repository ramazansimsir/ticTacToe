package com.rmzn.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rmzn.tictactoe.databinding.ActivityGameDisplayBinding;

public class GameDisplay extends AppCompatActivity {

    ActivityGameDisplayBinding design;
    private TicTacToe_Board ticTacToe_board;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        design=ActivityGameDisplayBinding.inflate(getLayoutInflater());
        setContentView(design.getRoot());

        design.button11.setVisibility(View.GONE);
        design.button12.setVisibility(View.GONE);

        String[] playerName=getIntent().getStringArrayExtra("player_names");

        if(playerName!=null){
            design.textView5.setText(playerName[0]+"'s Turn");
        }
        ticTacToe_board=findViewById(R.id.ticTacToe_Board);

        ticTacToe_board.setUpGame(design.button11,design.button12,design.textView5,playerName);
        design.button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            ticTacToe_board.resetGame();
            ticTacToe_board.invalidate();
            }
        });
        design.button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GameDisplay.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}