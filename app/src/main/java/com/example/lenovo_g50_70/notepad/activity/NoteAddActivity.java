package com.example.lenovo_g50_70.notepad.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.lenovo_g50_70.notepad.model.Notepad;
import com.example.lenovo_g50_70.notepad.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**添加Note*/
public class NoteAddActivity extends AppCompatActivity {

    private String str;
    private EditText mEditText;
    private FloatingActionButton mButton;
    private SimpleDateFormat format;
    private Date date;
    private String curDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);
        initView();
    }

    private void initView() {
        format =new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        mEditText = (EditText) findViewById(R.id.edtNote);
        mButton = (FloatingActionButton) findViewById(R.id.fab);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date =new Date(System.currentTimeMillis());
                curDate = format.format(date);
                str =mEditText.getText().toString().trim();
                if(str.length()==0){
                    finish();
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                }else {
                    addNote(str,curDate);
                    finish();
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                }
            }
        });
    }

    private void addNote(String str,String date) {
        Notepad note =new Notepad(str,curDate);
        note.save();
    }
}
