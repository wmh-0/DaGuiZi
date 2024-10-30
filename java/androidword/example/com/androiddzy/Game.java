package androidword.example.com.androiddzy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Game extends AppCompatActivity {
    private ScoreModel mScoreModel;
    private MediaPlayer backmusic;
    private MediaPlayer correct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        backmusic = MediaPlayer.create(this,R.raw.background_music);
        correct =MediaPlayer.create(this,R.raw.correct);
        mScoreModel = new ScoreModel(this);
        mScoreModel.open();
        backmusic.setLooping(true);
        backmusic.start();

        Strat();
        Time();
    }

    int score = 0;
    int i = 0;
    Button arr[] = new Button[100];
    private Random random = new Random();
    TextView txt;

    public void Strat() {
//        将按钮进行绑定为数组
        arr[0] = (Button) findViewById(R.id.b1);
        arr[1] = (Button) findViewById(R.id.b2);
        arr[2] = (Button) findViewById(R.id.b3);
        arr[3] = (Button) findViewById(R.id.b4);
        arr[4] = (Button) findViewById(R.id.b5);
        arr[5] = (Button) findViewById(R.id.b6);
        arr[6] = (Button) findViewById(R.id.b7);
        arr[7] = (Button) findViewById(R.id.b8);
        arr[8] = (Button) findViewById(R.id.b9);
        arr[9] = (Button) findViewById(R.id.b10);
        arr[10] = (Button) findViewById(R.id.b11);
        arr[11] = (Button) findViewById(R.id.b12);
        arr[12] = (Button) findViewById(R.id.b13);
        arr[13] = (Button) findViewById(R.id.b14);
        arr[14] = (Button) findViewById(R.id.b15);
        arr[15] = (Button) findViewById(R.id.b16);

        txt=findViewById(R.id.scoreTextView);

//对每个按钮绑定侦听事件
        arr[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[0].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[0].setText("地洞");
                    arr[0].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[1].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[1].setText("地洞");
                    arr[1].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[2].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[2].setText("地洞");
                    arr[2].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[3].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[3].setText("地洞");
                    arr[3].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[4].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[4].setText("地洞");
                    arr[4].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[5].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[5].setText("地洞");
                    arr[5].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[6].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[6].setText("地洞");
                    arr[6].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[7].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[7].setText("地洞");
                    arr[7].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[8].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[8].setText("地洞");
                    arr[8].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[9].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[9].setText("地洞");
                    arr[9].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[10].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[10].setText("地洞");
                    arr[10].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[11].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[11].setText("地洞");
                    arr[11].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[12].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[12].setText("地洞");
                    arr[12].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[13].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[13].setText("地洞");
                    arr[13].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[14].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[14].setText("地洞");
                    arr[14].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
        arr[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arr[15].getText().equals("鬼子")) {
                    score=score+10;
                    txt.setText(""+score);
                    arr[15].setText("地洞");
                    arr[15].setTextColor(Color.BLACK);
                    correct.start();
                } else {
                    score=score-20;
                    txt.setText(""+score);
                }
            }
        });
//        创建线程，随机让地洞生成鬼子
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    final int index = random.nextInt(16);
                    Button button = null;
                    switch (index) {
                        case 0:
                            button = arr[0];
                            break;
                        case 1:
                            button = arr[1];
                            break;
                        case 2:
                            button = arr[2];
                            break;
                        case 3:
                            button = arr[3];
                            break;
                        case 4:
                            button = arr[4];
                            break;
                        case 5:
                            button = arr[5];
                            break;
                        case 6:
                            button = arr[6];
                            break;
                        case 7:
                            button = arr[7];
                            break;
                        case 8:
                            button = arr[8];
                            break;
                        case 9:
                            button = arr[9];
                            break;
                        case 10:
                            button = arr[10];
                            break;
                        case 11:
                            button = arr[11];
                            break;
                        case 12:
                            button = arr[12];
                            break;
                        case 13:
                            button = arr[13];
                            break;
                        case 14:
                            button = arr[14];
                            break;
                        case 15:
                            button = arr[15];
                            break;
                    }
                    button.post(new Runnable() {
                        @Override
                        public void run() {
                            arr[index].setText("鬼子");
                            arr[index].setTextColor(Color.parseColor("#EABDA4"));
                        }
                    });
                    try {
                        Thread.sleep(1200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    button.post(new Runnable() {
                        @Override
                        public void run() {
                            arr[index].setText("地洞");
                            arr[index].setTextColor(Color.BLACK);
                        }
                    });
                }
            }
        }).start();
    }
//    设定游戏结束时的条件，即计数达到15时结束，每次隔1000ms运行一次
    public void Time() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                count++;
                if (count == 15) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            builder.setTitle("GAMEOVER");
                            builder.setMessage("你的得分为" + score);
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(Game.this, MainActivity.class);
                                    startActivity(intent);
                                    if (backmusic != null) {
                                        backmusic.stop();
                                        backmusic.release();
                                        backmusic = null;
                                    }

                                    int newScoreValue = score;
                                    long newRowId = mScoreModel.addScore(newScoreValue);
                                    if (newRowId != -1) {
                                        Log.i("OtherActivity", "New score added with id: " + newRowId);
                                    } else {
                                        Log.e("OtherActivity", "Failed to add new score");
                                    }
                            return;
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
//释放资源
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mScoreModel.close();
        if (backmusic != null) {
            backmusic.stop();
            backmusic.release();
            backmusic = null;
        }
    }
}






