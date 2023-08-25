package com.rmzn.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rmzn.tictactoe.databinding.ActivitySetupPlayerBinding;

public class setup_player extends AppCompatActivity {

    ActivitySetupPlayerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySetupPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String player1Name=binding.editTextTextPersonName.getText().toString();
                String player2Name=binding.editTextTextPersonName2.getText().toString();
                Intent intent= new Intent(setup_player.this,GameDisplay.class);
                intent.putExtra("player_names",new String[]{player1Name,player2Name});
                startActivity(intent);
            }
        });
    }
}