package naman.killtime.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int teamA=0;
    int teamB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pts3_1Inc(View view) {
        teamA=teamA+3;
        teamAdisplay();
    }
    public void pts2_1Inc(View view) {
        teamA=teamA+2;
        teamAdisplay();
    }
    public void pts1_1Inc(View view) {
        teamA=teamA+1;
        teamAdisplay();
    }


    public void pts3_2Inc(View view) {
        teamB=teamB+3;
        teamBdisplay();
    }
    public void pts2_2Inc(View view) {
        teamB=teamB+2;
        teamBdisplay();
    }
    public void pts1_2Inc(View view) {
        teamB=teamB+1;
        teamBdisplay();
    }


    private void teamAdisplay() {
        TextView aScore = findViewById(R.id.team1_score);
        aScore.setText(String.format("%d", teamA));
    }

    public void reset(View view)
    {
        teamA=0;
        teamB=0;
        teamAdisplay();
        teamBdisplay();
    }

    private void teamBdisplay()
    {
        TextView aScore = findViewById(R.id.team2_score);
        aScore.setText(String.format("%d", teamB));
    }
}