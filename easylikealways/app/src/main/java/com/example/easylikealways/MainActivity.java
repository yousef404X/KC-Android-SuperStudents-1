package com.example.easylikealways;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rock, paper, scissors;
    ImageView cpu_images, hm_images;
    TextView score;
    TextView score1;
    TextView link;
    Button pa;
    int hmsc = 0, cpusc = 0;
    String hmChoise,cpuChoise,result;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         rock = findViewById(R.id.rock);
         paper = findViewById(R.id.paper);
         scissors = findViewById(R.id.scissors);
         cpu_images = findViewById(R.id.cpu);
         hm_images = findViewById(R.id.hm);
         score = findViewById(R.id.cscore);
        score1 = findViewById(R.id.pscore);
        link = findViewById(R.id.link);
        pa = findViewById(R.id.button);
        r = new Random();



        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hmChoise = "rock";
                hm_images.setImageResource(R.drawable.rock);
                calculate();


            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hmChoise = "paper";
                hm_images.setImageResource(R.drawable.paper);
                calculate();

            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hmChoise = "scissors";
                hm_images.setImageResource(R.drawable.scissors);
                calculate();

            }
        });
        pa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cpusc = 0;
                hmsc = 0;
                score.setText(Integer.toString(hmsc));
                score1.setText(Integer.toString(cpusc));
                link.setText("");
            }
        });

    }

    @SuppressLint("SetTextI18n")
    public void calculate(){
        int cpu = r.nextInt(3);
        if (cpu == 0){

            cpuChoise = "rock";
            cpu_images.setImageResource(R.drawable.rock);

        } else if (cpu == 1){

            cpuChoise = "paper";
            cpu_images.setImageResource(R.drawable.paper);

        }else if (cpu == 2){

            cpuChoise = "scissors";
            cpu_images.setImageResource(R.drawable.scissors);

        }
        if (hmChoise.equals("rock") && cpuChoise.equals("paper")){
            cpusc++;
            score1.setText(Integer.toString(cpusc));
            result = "you lose";
            link.setText(result);

        } else if (hmChoise.equals("rock") && cpuChoise.equals("scissors")){
            hmsc++;
            result = "you win";
            score.setText(Integer.toString(hmsc));
            link.setText(result);

        }else if (hmChoise.equals("scissors") && cpuChoise.equals("rock")){
            cpusc++;
            result = "you lose";
            score1.setText(Integer.toString(cpusc));
            link.setText(result);

        }else if (hmChoise.equals("scissors") && cpuChoise.equals("paper")){
            hmsc++;
            result = "you win";
            score.setText(Integer.toString(hmsc));
            link.setText(result);
        }else if (hmChoise.equals("paper") && cpuChoise.equals("scissors")){
            result = "you lose";
            cpusc++;
            score1.setText(Integer.toString(cpusc));
            link.setText(result);
        }else if (hmChoise.equals("paper") && cpuChoise.equals("rock")){
            result = "you win";
            hmsc++;
            score.setText(Integer.toString(hmsc));
            link.setText(result);
        }else if (hmChoise.equals("rock") && cpuChoise.equals("rock")){
            result = "draw";
            hmsc++;
            cpusc++;
            score.setText(Integer.toString(hmsc));
            score1.setText(Integer.toString(cpusc));
            link.setText(result);
        }else if (hmChoise.equals("paper") && cpuChoise.equals("paper")){
            result = "draw";
            hmsc++;
            cpusc++;
            score.setText(Integer.toString(hmsc));
            score1.setText(Integer.toString(cpusc));
            link.setText(result);
        }else if (hmChoise.equals("scissors") && cpuChoise.equals("scissors")){
            result = "draw";
            hmsc++;
            cpusc++;
            score.setText(Integer.toString(hmsc));
            score1.setText(Integer.toString(cpusc));
            link.setText(result);

        }

        if (hmsc == 3){
            cpusc = 0;
            hmsc = 0;
            score.setText("0");
            score1.setText("0");
            link.setText("");
            Toast.makeText(MainActivity.this, "you have won", Toast.LENGTH_SHORT).show();



        }else if (cpusc == 3){
            cpusc = 0;
            hmsc = 0;
            score.setText("0");
            score1.setText("0");
            link.setText("");
            Toast.makeText(MainActivity.this, "you have lost", Toast.LENGTH_SHORT).show();

        }


    }
}