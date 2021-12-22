package com.example.nounours.Discover;

import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nounours.Discover.DiscoverContent.DiscoverItem;
import com.example.nounours.databinding.FragmentDiscoverBinding;

import java.util.List;

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.ViewHolder> {

    private final List<DiscoverItem> mValues;

    public interface OnFilmClickListener {
        void onFilmClick(DiscoverItem mItem);
    }
    private OnFilmClickListener listener;
    public void setListener(OnFilmClickListener listener) {
        this.listener = listener;
    }

    public DiscoverAdapter(List<DiscoverItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentDiscoverBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.mItem = mValues.get(position);
        // holder.mIdView.setText(mValues.get(position).title);
        holder.mContentView.setText(mValues.get(position).desc);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onFilmClick(mValues.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // public final TextView mIdView;
        public final TextView mContentView;
        public DiscoverItem mItem;

        public ViewHolder(FragmentDiscoverBinding binding) {
            super(binding.getRoot());
            // mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public void onClick(View v) {
            int id = mItem.id;
            // Redirect to page Film with this id
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}