package androidword.example.com.androiddzy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;

import static android.os.SystemClock.sleep;

public class SpeedGame extends AppCompatActivity {
    private MediaPlayer backmusic;
    private MediaPlayer correct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_game);
        backmusic = MediaPlayer.create(this,R.raw.background_music);
        correct =MediaPlayer.create(this,R.raw.correct);
        Strat();
        Time();
        backmusic.setLooping(true);
        backmusic.start();
    }
    int scores = 0;
    int scoreT =0;
    int i=0;
    Button arr[]=new Button[100];
    TextView timet;
    TextView hit;

    Random random =new Random();
    int rd = random.nextInt(16);
    public void Strat(){
        arr[0]=(Button)findViewById(R.id.bs1);
        arr[1]=(Button)findViewById(R.id.bs2);
        arr[2]=(Button)findViewById(R.id.bs3);
        arr[3]=(Button)findViewById(R.id.bs4);
        arr[4]=(Button)findViewById(R.id.bs5);
        arr[5]=(Button)findViewById(R.id.bs6);
        arr[6]=(Button)findViewById(R.id.bs7);
        arr[7]=(Button)findViewById(R.id.bs8);
        arr[8]=(Button)findViewById(R.id.bs9);
        arr[9]=(Button)findViewById(R.id.bs10);
        arr[10]=(Button)findViewById(R.id.bs11);
        arr[11]=(Button)findViewById(R.id.bs12);
        arr[12]=(Button)findViewById(R.id.bs13);
        arr[13]=(Button)findViewById(R.id.bs14);
        arr[14]=(Button)findViewById(R.id.bs15);
        arr[15]=(Button)findViewById(R.id.bs16);
        timet=findViewById(R.id.timeTextView);
        hit=findViewById(R.id.hitTextView);
        arr[rd].setText("鬼子");
        arr[rd].setTextColor(Color.parseColor("#EABDA4"));
        setClickListener();
        }
    public void setClickListener() {
        if (scores==20){
            return;
        }
            arr[rd].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    correct.start();
                    arr[rd].setText("地洞");
                    arr[rd].setTextColor(Color.BLACK);
                    arr[rd].setOnClickListener(null);
                    int newRd = random.nextInt(16);
                    arr[newRd].setText("鬼子");
                    arr[newRd].setTextColor(Color.parseColor("#EABDA4"));
                    rd = newRd;
                    scores++;
                    setClickListener();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            final int finalScore = scores;
                            hit.setText(String.valueOf(finalScore));
                        }
                    });
                }
            });

        }

    public void Time() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                count++;
                final int finalCount = count;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        timet.setText(String.valueOf(finalCount));
                    }
                });
                if (scores > 19) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            builder.setTitle("GAMEOVER");
                            builder.setMessage("你花的时间为" + count+"s");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(SpeedGame.this, MainActivity.class);
                                    startActivity(intent);
                                    if (backmusic != null) {
                                        backmusic.stop();
                                        backmusic.release();
                                        backmusic = null;
                                    }
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }
                    });
                    cancel();
                }

            }
        }, 0, 1000);
    }
    protected void onDestroy() {
        super.onDestroy();
        if (backmusic != null) {
            backmusic.stop();
            backmusic.release();
            backmusic = null;
        }
    }
}
