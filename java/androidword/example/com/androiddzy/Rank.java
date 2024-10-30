package androidword.example.com.androiddzy;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static androidword.example.com.androiddzy.ScoreModel.COLUMN_ID;

public class Rank extends AppCompatActivity {
    private ScoreModel mScoreModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        mScoreModel = new ScoreModel(this);
        mScoreModel.open();
        init();
    }
    public void init() {
        Button btnQ = (Button) findViewById(R.id.Upgrade) ;
        Button btnD =(Button)findViewById(R.id.Delete);
        Button btnJ =(Button)findViewById(R.id.backtomain);
        final TextView t1=(TextView)findViewById(R.id.t1) ;
        final TextView t2=(TextView)findViewById(R.id.t2) ;
        final TextView t3=(TextView)findViewById(R.id.t3) ;
        final TextView t4=(TextView)findViewById(R.id.t4) ;
        final TextView t5=(TextView)findViewById(R.id.t5) ;
        final TextView t6=(TextView)findViewById(R.id.t6) ;
        final TextView t7=(TextView)findViewById(R.id.t7) ;
        final TextView t8=(TextView)findViewById(R.id.t8) ;
        final TextView t9=(TextView)findViewById(R.id.t9) ;
        final TextView t10=(TextView)findViewById(R.id.t10) ;

        final EditText etDelete =findViewById(R.id.stu);
//        点击刷新按钮利用cursor渲染分数与id，以靠前为主
        btnQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = mScoreModel.getAllScores();
                if (cursor != null && cursor.moveToFirst()) {
                    int scoreValue = cursor.getInt(cursor.getColumnIndexOrThrow(ScoreModel.COLUMN_SCORE));
                    int scoreId =cursor.getInt(cursor.getColumnIndexOrThrow(ScoreModel.COLUMN_ID));
                    t1.setText("Score 1: " + scoreValue);
                    t6.setText("ID:"+scoreId);
                }
                if (cursor.moveToNext()) {
                    int scoreValue2 = cursor.getInt(cursor.getColumnIndexOrThrow(ScoreModel.COLUMN_SCORE));
                    int scoreId2 =cursor.getInt(cursor.getColumnIndexOrThrow(ScoreModel.COLUMN_ID));
                    t2.setText("Score 2: " + scoreValue2);
                    t7.setText("ID:"+scoreId2);
                }
                if (cursor.moveToNext()) {
                    int scoreValue3 = cursor.getInt(cursor.getColumnIndexOrThrow(ScoreModel.COLUMN_SCORE));
                    int scoreId3 =cursor.getInt(cursor.getColumnIndexOrThrow(ScoreModel.COLUMN_ID));
                    t3.setText("Score 3: " + scoreValue3);
                    t8.setText("ID:"+scoreId3);
                }
                if (cursor.moveToNext()) {
                    int scoreValue4 = cursor.getInt(cursor.getColumnIndexOrThrow(ScoreModel.COLUMN_SCORE));
                    int scoreId4 =cursor.getInt(cursor.getColumnIndexOrThrow(ScoreModel.COLUMN_ID));
                    t4.setText("Score 4: " + scoreValue4);
                    t9.setText("ID:"+scoreId4);
                }
                if (cursor.moveToNext()) {
                    int scoreValue5 = cursor.getInt(cursor.getColumnIndexOrThrow(ScoreModel.COLUMN_SCORE));
                    int scoreId5 =cursor.getInt(cursor.getColumnIndexOrThrow(ScoreModel.COLUMN_ID));
                    t5.setText("Score 5: " + scoreValue5);
                    t10.setText("ID:"+scoreId5);
                }

                if (cursor != null) {
                    cursor.close();
                }
            }
        });
//        对输入id的该行进行数据删除
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idText = etDelete.getText().toString();
                if (TextUtils.isEmpty(idText)) {
                    // 提示输入ID
                    Toast.makeText(Rank.this, "请输入要删除的分数的ID", Toast.LENGTH_SHORT).show();
                    return;
                }

                int scoreId = Integer.parseInt(idText);
                boolean deleted = mScoreModel.deleteScore(scoreId);
                if (deleted) {
                    Toast.makeText(Rank.this, "删除成功", Toast.LENGTH_SHORT).show();
                    t1.setText("Score 1:");
                    t2.setText("Score 2:");
                    t3.setText("Score 3:");
                    t4.setText("Score 4:");
                    t5.setText("Score 5:");
                } else {
                    Toast.makeText(Rank.this, "删除失败，请检查ID是否正确", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentj = new Intent(Rank.this,MainActivity.class);
                startActivity(intentj);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mScoreModel.close();
    }
}
