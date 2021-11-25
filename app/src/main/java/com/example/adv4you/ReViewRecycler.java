package com.example.adv4you;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adv4you.pojos.pojos_for_review.ReviewConsistent;
import com.example.adv4you.pojos.pojos_for_review.ReviewFlight;
import com.example.adv4you.pojos.pojos_for_review.ReviewImpulsive;
import com.example.adv4you.pojos.pojos_for_review.ReviewSeasonal;

import java.util.List;

public class ReViewRecycler extends RecyclerView.Adapter<ReViewRecycler.ViewHolder> {

    List<ReviewConsistent> mValues1;
    List<ReviewFlight> mValues2;
    List<ReviewImpulsive> mValues3;
    List<ReviewSeasonal> mValues4;

    private final int TYPE_ITEM1 = 0;
    private final int TYPE_ITEM2 = 1;

    public ReViewRecycler(List<ReviewConsistent> mValues1,
                          List<ReviewFlight> mValues2,
                          List<ReviewImpulsive> mValues3,
                          List<ReviewSeasonal> mValues4) {
        this.mValues1 = mValues1;
        this.mValues2 = mValues2;
        this.mValues3 = mValues3;
        this.mValues4 = mValues4;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case TYPE_ITEM1:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.review_item_left, parent, false);
                return new ViewHolder(view);
            case TYPE_ITEM2:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.review_item_right, parent, false);
                return new ViewHolder(view);
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int type = getItemViewType(position);

        switch (type) {
            case TYPE_ITEM1:
            case TYPE_ITEM2:
                if (mValues2 != null) {
                    holder.reviewersName.setText(mValues2.get(position).getName());
                    holder.review.setText(mValues2.get(position).getReview());
                } else if (mValues3 != null) {
                    holder.reviewersName.setText(mValues3.get(position).getName());
                    holder.review.setText(mValues3.get(position).getReview());
                } else if (mValues4 != null) {
                    holder.reviewersName.setText(mValues4.get(position).getName());
                    holder.review.setText(mValues4.get(position).getReview());
                } else {
                    holder.reviewersName.setText(mValues1.get(position).getName());
                    holder.review.setText(mValues1.get(position).getReview());
                }
                break;
        }
    }

    @Override
    public int getItemCount() {

        if (mValues2 != null) {
            return mValues2.size();

        } else if (mValues3 != null) {
            return mValues3.size();

        } else if (mValues4 != null) {
            return mValues4.size();

        } else {
            return mValues1.size();
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position % 2 == 0) {
            return TYPE_ITEM1;
        } else {
            return TYPE_ITEM2;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView reviewersName;
        TextView review;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            review = itemView.findViewById(R.id.review_tw);
            reviewersName = itemView.findViewById(R.id.reviewers_name);
        }
    }
}
