package androidword.example.com.androiddzy;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    public SharedPreferences mPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    public void init(){
        mPreferences = getSharedPreferences("QQ",MODE_PRIVATE);
        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn3 = (Button)findViewById(R.id.btn3);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        final AlertDialog.Builder builder2 = new AlertDialog.Builder(this);


        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String str3=null;
                String str4=null;
                EditText zh = (EditText)findViewById(R.id.zh);
                EditText mm = (EditText)findViewById(R.id.mm);
                String str1 = zh.getText().toString();
                String str2 = mm.getText().toString();
                Intent Loginin = new Intent(Login.this, MainActivity.class);

                int accountCount = mPreferences.getInt("account_count", 0);
                for (int i = 0; i < accountCount; i++) {
                    String accountKey = "account_" + i;
                    str3 = mPreferences.getString(accountKey + "zh", "");
                    str4 = mPreferences.getString(accountKey + "mm", "");
                    if (str1.equals(str3)&&str2.equals(str4)){
                        Bundle bundle = new Bundle();
                        bundle.putString("accountKey", accountKey);
                        Loginin.putExtras(bundle);
                        startActivity(Loginin);
                        break;
                    }
                }

                if (str1.equals("")||str2.equals("")) {
                    builder2.setTitle("登录");
                    builder2.setMessage("账号或密码不能为空，请重新输入");
                    builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder2.create().show();
                }else
                if (!str1.equals(str3)){
                    builder.setTitle("登录");
                    builder.setMessage("账号错误，请重新输入");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.create().show();

                }else
                if (!str2.equals(str4)){
                    builder1.setTitle("登录");
                    builder1.setMessage("密码错误，请重新输入");
                    builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder1.create().show();
                }

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(Login.this, Register.class);
                startActivity(register);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("取消");
                builder.setMessage("是否退出？");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences.Editor editor = mPreferences.edit();
                        editor.clear();
                        editor.commit();
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            }
        });



    }


}