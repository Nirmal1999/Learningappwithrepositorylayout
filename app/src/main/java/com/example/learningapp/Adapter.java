package com.example.learningapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater inflater;
    private String[] sTitles;
    private String[] sContents;
    Adapter(Context context,String[] titles,String[] contents){
        this.inflater=LayoutInflater.from(context);
        this.sTitles=titles;
        this.sContents=contents;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String title = sTitles[i];
        String content = sContents[i];
        viewHolder.storyTitle.setText(title);
        viewHolder.storycontent.setText(content);


    }

    @Override
    public int getItemCount() {
        return sTitles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView storyTitle,storycontent;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            //implementing on clicklistner
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent i = new Intent (v.getContext(),Details.class);
                    //using adopter contents are sent
                    i.putExtra("titleofStory",sTitles[getAdapterPosition()]);
                    i.putExtra("contentofStory",sContents[getAdapterPosition()]);
                    v.getContext().startActivity(i);
                }
            });
            storyTitle=itemView.findViewById(R.id.storytitle);
            storycontent =itemView.findViewById(R.id.storycontent);
        }
    }
}
