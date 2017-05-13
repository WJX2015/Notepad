package com.example.lenovo_g50_70.notepad.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.lenovo_g50_70.notepad.model.Notepad;
import com.example.lenovo_g50_70.notepad.R;

/**
 * 更新Note
 */
public class NoteEditActivity extends AppCompatActivity {
    private String str;
    private String content;
    private EditText mEditText;
    private FloatingActionButton mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);
        initView();
    }

    private void initView() {
        content = getIntent().getStringExtra(NoteDetailActivity.NOTE_CONTENT);
        mEditText = (EditText) findViewById(R.id.edtNote);
        mEditText.setText(content);
        mEditText.setSelection(content.length());
        mButton = (FloatingActionButton) findViewById(R.id.fab);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str =mEditText.getText().toString().trim();
                if(str==content|str.length()==0){
                    finish();
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                }else {
                    NoteUpdate(str);
                    finish();
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                }
            }
        });
    }

    private void NoteUpdate(String str) {
        Notepad note =new Notepad();
        note.setNode(str);
        note.updateAll("date=?",getIntent().getStringExtra(NoteDetailActivity.NOTE_DATE));
    }
}