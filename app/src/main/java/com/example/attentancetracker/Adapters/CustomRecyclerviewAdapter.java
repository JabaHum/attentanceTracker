package com.example.attentancetracker.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.attentancetracker.R;

import java.util.ArrayList;

public class CustomRecyclerviewAdapter extends RecyclerView.Adapter<CustomRecyclerviewAdapter.CardViewHolder> {

    private ArrayList studentNames;
    private ArrayList studentIds;
    private ArrayList studentImages;
    private Context mContext;

    public CustomRecyclerviewAdapter(ArrayList studentNames, ArrayList studentIds, ArrayList studentImages, Context mContext) {
        this.studentNames = studentNames;
        this.studentIds = studentIds;
        this.studentImages = studentImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_layout,viewGroup,false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {

        cardViewHolder.cardName.setText((String) studentNames.get(i));
        cardViewHolder.cardStudentId.setText((String) studentIds.get(i));
        cardViewHolder.imageView.setImageResource((Integer) studentImages.get(i));

    }



    @Override
    public int getItemCount() {
        return studentNames.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView cardName;
        TextView cardStudentId;
        ImageView imageView;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

         cardName  = itemView.findViewById(R.id.cardview_name);
         cardStudentId = itemView.findViewById(R.id.cardview_student_id);
         imageView = itemView.findViewById(R.id.cardview_image);
        }
    }


}
