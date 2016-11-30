package com.example.eddy.basketballcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamOneScore = 0;
    int teamTwoScore = 0;
    TextView scoreFirstTeam;
    TextView scoreSecondTeam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Score counter");
        scoreFirstTeam = (TextView) findViewById(R.id.team_one_score);
        scoreSecondTeam = (TextView) findViewById(R.id.team_two_score);
    }

    public void onClickNext(View view) {
        Intent i = new Intent(MainActivity.this, SecondaryActivity.class);
        startActivity(i);
    }

    public void onClickReset(View view) {
        teamOneScore = 0;
        teamTwoScore = 0;
        scoreFirstTeam.setText(String.valueOf(teamOneScore));
        scoreSecondTeam.setText(String.valueOf(teamTwoScore));
    }

    public void plusThreeFirstTeam(View view) {
        teamOneScore += 3;
        scoreFirstTeam.setText(String.valueOf(teamOneScore));
    }

    public void plusThreeSecondTeam(View view) {
        teamTwoScore += 3;
        scoreSecondTeam.setText(String.valueOf(teamTwoScore));
    }

    public void plusTwoFirstTeam(View view) {
        teamOneScore += 2;
        scoreFirstTeam.setText(String.valueOf(teamOneScore));
    }

    public void plusTwoSecondTeam(View view) {
        teamTwoScore += 2;
        scoreSecondTeam.setText(String.valueOf(teamTwoScore));
    }

    public void freeThrowFirstTeam(View view) {
        teamOneScore += 1;
        scoreFirstTeam.setText(String.valueOf(teamOneScore));
    }

    public void freeThrowSecondTeam(View view) {
        teamTwoScore += 1;
        scoreSecondTeam.setText(String.valueOf(teamTwoScore));
    }
}


