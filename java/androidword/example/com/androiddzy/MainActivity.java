package androidword.example.com.androiddzy;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public SharedPreferences mPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
    }
    private void initWidget(){
        Button btn=(Button)findViewById(R.id.jump);
        Button btn1=(Button)findViewById(R.id.jump1);
        Button btn2=(Button)findViewById(R.id.jump2);
        Button btn3=(Button)findViewById(R.id.jump3);
        Button btn4=(Button)findViewById(R.id.jump4);
        TextView pref =(TextView)findViewById(R.id.prefer) ;
        mPreferences = getSharedPreferences("QQ",MODE_PRIVATE);
        pref.setText(mPreferences.getString( "accountKey_1favour", ""));

//        各种页面跳转
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,Game.class);
                startActivity(intent1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,SpeedGame.class);
                startActivity(intent2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this,Rank.class);
                startActivity(intent3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this,Video.class);
                startActivity(intent4);
            }
        });

    }
}
