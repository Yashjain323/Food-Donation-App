package com.yash.fooddonationapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    public class ReciepientRVAdapter extends RecyclerView.Adapter<ReciepientRVAdapter.ViewHolder> {

        // variable for our array list and context
        private ArrayList<RecipientDisplayModal> RecipientModalArrayList;
        private Context context;

        // constructor
        public ReciepientRVAdapter(ArrayList<RecipientDisplayModal> RecipientModalArrayList, Context context) {
            this.RecipientModalArrayList = RecipientModalArrayList;
            this.context = context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // on below line we are inflating our layout
            // file for our recycler view items.
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipient_rv_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            // on below line we are setting data
            // to our views of recycler view item.
            RecipientDisplayModal modal = RecipientModalArrayList.get(position);
            holder.courseNameTV.setText(modal.getCourseName());
            holder.courseDescTV.setText(modal.getCourseDescription());
            holder.courseDurationTV.setText(modal.getCourseDuration());
            holder.courseTracksTV.setText(modal.getCourseTracks());
        }

        @Override
        public int getItemCount() {
            // returning the size of our array list
            return RecipientModalArrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            // creating variables for our text views.
            private TextView courseNameTV, courseDescTV, courseDurationTV, courseTracksTV;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                // initializing our text views
                courseNameTV = itemView.findViewById(R.id.idTVCourseName);
                courseDescTV = itemView.findViewById(R.id.idTVCourseDescription);
                courseDurationTV = itemView.findViewById(R.id.idTVCourseDuration);
                courseTracksTV = itemView.findViewById(R.id.idTVCourseTracks);
            }
        }
    }
