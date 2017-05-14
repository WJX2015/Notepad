package com.example.lenovo_g50_70.notepad.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lenovo_g50_70.notepad.adapter.NoteAdapter;
import com.example.lenovo_g50_70.notepad.view.NoteChangeListener;
import com.example.lenovo_g50_70.notepad.model.Notepad;
import com.example.lenovo_g50_70.notepad.R;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import static com.example.lenovo_g50_70.notepad.R.id.recyclerView;

public class MainActivity extends AppCompatActivity implements NoteChangeListener {
    private Intent intent;
    private FloatingActionButton mButton;
    private RecyclerView mRecyclerView;
    private NoteAdapter mNoteAdapter;
    private List<Notepad> mNotepads=new ArrayList<>();
    private LinearLayoutManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        intent =new Intent(this,NoteAddActivity.class);
        mNotepads = DataSupport.findAll(Notepad.class);
        mButton = (FloatingActionButton) findViewById(R.id.fab_add);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        mManager = new LinearLayoutManager(this);
        mManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView = (RecyclerView) findViewById(recyclerView);
        mRecyclerView.setLayoutManager(mManager);
        mNoteAdapter=new NoteAdapter(mNotepads,this);
        mRecyclerView.setAdapter(mNoteAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //A跳转B后回到A时刷新信息
        mNotepads = DataSupport.findAll(Notepad.class);
        mNoteAdapter.changeNote(mNotepads);
    }

    @Override
    public void refresh() {
        //刷新Adapter信息
        queryAll();
    }

    private void queryAll() {
        mNotepads = DataSupport.findAll(Notepad.class);
        mNoteAdapter.changeNote(mNotepads);
    }
}
