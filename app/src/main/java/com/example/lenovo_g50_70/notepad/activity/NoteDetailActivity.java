package com.example.lenovo_g50_70.notepad.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lenovo_g50_70.notepad.R;

public class NoteDetailActivity extends AppCompatActivity {
    public static final String NOTE_CONTENT ="note_content";
    public static final String NOTE_DATE ="note_date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
    }
}
