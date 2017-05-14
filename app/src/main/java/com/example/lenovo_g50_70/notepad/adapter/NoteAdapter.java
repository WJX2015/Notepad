package com.example.lenovo_g50_70.notepad.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo_g50_70.notepad.R;
import com.example.lenovo_g50_70.notepad.model.Notepad;
import com.example.lenovo_g50_70.notepad.activity.NoteDetailActivity;
import com.example.lenovo_g50_70.notepad.activity.NoteEditActivity;
import com.example.lenovo_g50_70.notepad.view.NoteChangeListener;

import java.util.List;

/**
 * Created by lenovo-G50-70 on 2017/5/12.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>{
    private Context context;
    private List<Notepad> mNotepads;
    private NoteChangeListener mListener;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View noteView;
        TextView curDate;
        TextView curContent;
        ImageView btnEdt;
        ImageView btnDel;
        public ViewHolder(View view){
            super(view);
            noteView=view;
            curContent= (TextView) view.findViewById(R.id.tvContent);
            curDate= (TextView) view.findViewById(R.id.tvTime);
            btnEdt = (ImageView) view.findViewById(R.id.btnEdt);
            btnDel = (ImageView) view.findViewById(R.id.btnDel);

        }
    }

    public NoteAdapter(List<Notepad> mNotepads,NoteChangeListener mListener){
        this.mNotepads=mNotepads;
        this.mListener=mListener;
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(context==null){
            context=parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

        final ViewHolder holder=new ViewHolder(view);
        holder.btnEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Notepad note =mNotepads.get(position);
                Intent intent =new Intent(context,NoteEditActivity.class);
                intent.putExtra(NoteDetailActivity.NOTE_DATE,note.getDate());
                intent.putExtra(NoteDetailActivity.NOTE_CONTENT,note.getNode());
                context.startActivity(intent);
            }
        });
        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Notepad note =mNotepads.get(position);
                note.delete();
                mListener.refresh();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Notepad notepad =mNotepads.get(position);
        holder.curContent.setText(notepad.getNode());
        holder.curDate.setText(notepad.getDate());
    }

    @Override
    public int getItemCount() {
        return mNotepads.size();
    }

    public void changeNote(List<Notepad> notepads) {
        this.mNotepads = notepads;
        notifyDataSetChanged();
    }
}
