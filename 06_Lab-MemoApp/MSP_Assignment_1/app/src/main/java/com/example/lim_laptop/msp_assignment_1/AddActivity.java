package com.example.lim_laptop.msp_assignment_1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lim-laptop on 2018-03-27.
 */

public class AddActivity extends AppCompatActivity {

  //  EditText title;
    EditText content, name, latitude, longitude, radius;
    TextFileManager fileManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

       // title = (EditText)findViewById(R.id.title);
       // content = (EditText)findViewById(R.id.content);
        name = (EditText)findViewById(R.id.name);
        latitude = (EditText)findViewById(R.id.latitude);
        longitude = (EditText)findViewById(R.id.longitude);
        radius = (EditText)findViewById(R.id.radius);

        fileManager = new TextFileManager(getApplicationContext());
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.writeBtn:
                // 1. EditText에 작성된 제목과 내용을 읽어와야
              //  String titleStr = title.getText().toString();
               // String contentStr = content.getText().toString();

                String nameStr = name.getText().toString();

                // 2. 제목을 이름으로 하는 파일 생성, 파일에다가 내용을 write
                // TextFileManager의 메소드 콜 하는 걸로
                fileManager.save(titleStr, contentStr);

                // 4. Toast 메시지 표시
                Toast.makeText(getApplicationContext(), "메모가 저장되었습니다.", Toast.LENGTH_SHORT).show();

                // 5. 액티비티 종료
                finish();

            case R.id.cancelBtn:
                // EditText 작성된 제목, 내용 초기화 --> EditText 값을 빈문자열로 변경
                title.setText("");
                content.setText("");
        }
    }

}
