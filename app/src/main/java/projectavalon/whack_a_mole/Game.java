package projectavalon.whack_a_mole;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Game extends AppCompatActivity implements View.OnClickListener{
    private ImageButton dig1, dig2, dig3, dig4, dig5, dig6, dig7, dig8, dig9;
    private ImageButton[] diglett;
    private TextView scoreShow;
    private TextView timeLeft;
    private MediaPlayer backgroundMusic;
    private MediaPlayer clickMusic;

    private String diff;
    private int[] count;
    private int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        diff = getIntent().getStringExtra("Difficulty");

        backgroundMusic = MediaPlayer.create(getApplicationContext(), R.raw.pokemon);
        backgroundMusic.start();

        dig1 = (ImageButton)findViewById(R.id.diglett1);
        dig2 = (ImageButton)findViewById(R.id.diglett2);
        dig3 = (ImageButton)findViewById(R.id.diglett3);
        dig4 = (ImageButton)findViewById(R.id.diglett4);
        dig5 = (ImageButton)findViewById(R.id.diglett5);
        dig6 = (ImageButton)findViewById(R.id.diglett6);
        dig7 = (ImageButton)findViewById(R.id.diglett7);
        dig8 = (ImageButton)findViewById(R.id.diglett8);
        dig9 = (ImageButton)findViewById(R.id.diglett9);

        diglett = new ImageButton[]{dig1,dig2,dig3,dig4,dig5,dig6,dig7,dig8,dig9};

        scoreShow = (TextView)findViewById(R.id.score);
        timeLeft = (TextView)findViewById(R.id.time);

        dig1.setOnClickListener(this);
        dig2.setOnClickListener(this);
        dig3.setOnClickListener(this);
        dig4.setOnClickListener(this);
        dig5.setOnClickListener(this);
        dig6.setOnClickListener(this);
        dig7.setOnClickListener(this);
        dig8.setOnClickListener(this);
        dig9.setOnClickListener(this);

        count = new int[9];
        startTimer(120000);
    }

    private void moleSwitch() {
        int pick = (int)(Math.random()*9);
        diglett[pick].setImageResource(R.mipmap.diglettout);
        count[pick] = 1;
    }

    private void moleClear(){
        for(int i=0; i<9; i++){
            diglett[i].setImageResource(R.mipmap.diglettin);
            count[i] = 0;
        }
    }
    @Override
    public void onClick(View v) {
        clickMusic = MediaPlayer.create(getApplicationContext(), R.raw.raichu);
        int btId = v.getId();
        if(btId == R.id.diglett1 && count[0] == 1){
            score += 1;
            clickMusic.start();
            moleClear();
        }
        else if(btId == R.id.diglett2 && count[1] == 1) {
            score += 1;
            clickMusic.start();
            moleClear();
        }
        else if(btId == R.id.diglett3 && count[2] == 1) {
            score += 1;
            clickMusic.start();
            moleClear();
        }
        else if(btId == R.id.diglett4 && count[3] == 1) {
            score += 1;
            clickMusic.start();
            moleClear();
        }
        else if(btId == R.id.diglett5 && count[4] == 1) {
            score += 1;
            clickMusic.start();
            moleClear();
        }
        else if(btId == R.id.diglett6 && count[5] == 1) {
            score += 1;
            clickMusic.start();
            moleClear();
        }
        else if(btId == R.id.diglett7 && count[6] == 1) {
            score += 1;
            clickMusic.start();
            moleClear();
        }
        else if(btId == R.id.diglett8 && count[7] == 1) {
            score += 1;
            clickMusic.start();
            moleClear();
        }
        else if(btId == R.id.diglett9 && count[8] == 1) {
            score += 1;
            clickMusic.start();
            moleClear();
        }
        else
            score +=0;
        Log.d("score",score+"");
        //clickMusic.reset();
    }

    private void startTimer(final long time) {
        CountDownTimer counter = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long l) {
                long seconds = l/1000;

                scoreShow.setText("Score: " + score);
                timeLeft.setText("Time: " + l/1000 + "s");

                if(diff.equals("Easy") && seconds%3 == 0) {
                    moleClear();
                    moleSwitch();
                }
                else if(diff.equals("Medium") && seconds%2 == 0) {
                    moleClear();
                    moleSwitch();
                }
                else if(diff.equals("Hard")) {
                    moleClear();
                    moleSwitch();
                }
            }

            @Override
            public void onFinish() {
                backgroundMusic.stop();
                scoreShow.setText("End of Game!");
                Intent intent = new Intent(Game.this, End.class);
                intent.putExtra("score",score+"");
                startActivity(intent);
            }
        }.start();
    }
}
