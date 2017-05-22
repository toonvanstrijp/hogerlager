package com.toonvanstrijp.hogerlager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by toonvanstrijp on 5/22/17.
 */

public class MainActivity extends AppCompatActivity {

    //initialize variables
    private TextView textViewNumber;
    private Button buttonLower, buttonHigher;
    private Random random = new Random();
    private Integer current_number = 0;
    private Integer score = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //tell which layout to use for this screen
        setContentView(R.layout.main_activity);

        //link layout elements to objects
        textViewNumber = (TextView) findViewById(R.id.textViewNumber);
        buttonLower = (Button) findViewById(R.id.buttonLower);
        buttonHigher = (Button) findViewById(R.id.buttonHigher);

        //set listener on lower button, this is fired when button is clicked
        buttonLower.setOnClickListener((v) -> {
            Integer next_number = random.nextInt(100)+1;
            if(next_number < current_number){
                score++;
                current_number = next_number;
                textViewNumber.setText(current_number.toString());
            }else{
                gameOver();
            }
        });

        //set listener on higher button, this is fired when button is clicked
        buttonHigher.setOnClickListener((v) ->{
            Integer next_number = random.nextInt(100)+1;
            if(next_number > current_number){
                score++;
                current_number = next_number;
                textViewNumber.setText(current_number.toString());
            }else{
                gameOver();
            }
        });

        //starts the game
        start();
    }

    /**
     * starting the game
     */
    private void start(){
        current_number = random.nextInt(100)+1;
        textViewNumber.setText(current_number.toString());
    }

    /**
     * showing gameover message, and reset game
     */
    private void gameOver(){
        Toast.makeText(this, "Je bent game over, je score is "+score, Toast.LENGTH_LONG).show();
        score = 0;
        current_number = random.nextInt(100)+1;
        textViewNumber.setText(current_number.toString());
    }
}
