package androidword.example.com.androiddzy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {
    private String mRadioValue="";
    private List<String> mCheck=new ArrayList<>();
    public SharedPreferences mPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    public void init(){
        mPreferences = getSharedPreferences("QQ",MODE_PRIVATE);
        Button mregister = (Button)findViewById(R.id.mregister);
        Button fh =(Button)findViewById(R.id.fh);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        RadioGroup sex =(RadioGroup)findViewById(R.id.sex);

        CheckBox hard =(CheckBox)findViewById(R.id.hard);
        CheckBox speed =(CheckBox)findViewById(R.id.speed);
        CheckBox story =(CheckBox)findViewById(R.id.story);

        sex.setOnCheckedChangeListener(new  RadioGroup.OnCheckedChangeListener(){
                    public void onCheckedChanged(RadioGroup group,int checkedId){
                        int radioId =group.getCheckedRadioButtonId();
                        switch(radioId){
                            case R.id.man:
                                mRadioValue="man";
                                break;
                            case R.id.wom: mRadioValue="woman";
                                break;
                            default:mRadioValue="man";
                                break;
                        }
            }
        });
       CompoundButton.OnCheckedChangeListener checkedListener =new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()){
                    case R.id.hard:{if(isChecked){mCheck.add("hard");}else{mCheck.remove("hard");}break;}
                    case R.id.speed:{if(isChecked){mCheck.add("speed");}else{mCheck.remove("speed");}break;}
                    case R.id.story:{if(isChecked){mCheck.add("story");}else{mCheck.remove("story");}break;}
                    default:break;
                }
            }
        };
        hard.setOnCheckedChangeListener(checkedListener);
        speed.setOnCheckedChangeListener(checkedListener);
        story.setOnCheckedChangeListener(checkedListener);

        mregister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText zh = (EditText)findViewById(R.id.zhr);
                EditText mm = (EditText)findViewById(R.id.mmr);

                final String str1 = zh.getText().toString();
                final String str2 = mm.getText().toString();
                final String str5 = mRadioValue;
                final String list = TextUtils.join(", ", mCheck);
                write(str1,str2,str5,list);
                if (str1.equals("")||str2.equals("")){
                    builder.setTitle("注册");
                    builder.setMessage("账号或密码不能为空，请重新输入");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            }
                    }); builder.create().show();
                }else{
                    builder.setTitle("注册");
                    builder.setMessage("注册成功");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent fhlogin = new Intent(Register.this, Login.class);
                            startActivity(fhlogin);
                        }
                    }); builder.create().show();
                }
            }
            private void write(String value,String value1,String value2,String value3){
                SharedPreferences.Editor editor = mPreferences.edit();
                int accountCount = mPreferences.getInt("account_count", 0);
                String accountKey = "account_" + accountCount;
                editor.putString(accountKey+"zh",value);
                editor.putString(accountKey+"mm",value1);
                editor.putString(accountKey+"sex",value2);
                editor.putString(accountKey+"favour",value3);

                editor.putInt("account_count", accountCount + 1);
                editor.apply();
            }


        });

        fh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent fhlogin = new Intent(Register.this, Login.class);
                startActivity(fhlogin);
            }
        });
        }

}
