package com.example.nounours.Favorites;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nounours.Favorites.FavoritesContent.FavoritesItem;
import com.example.nounours.databinding.FragmentFavoritesBinding;

import java.util.List;


public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

    private final List<FavoritesItem> mValues;

    public interface OnFilmClickListener {
        void onFilmClick(FavoritesItem mItem);
    }
    private OnFilmClickListener listener;
    public void setListener(OnFilmClickListener listener) {
        this.listener = listener;
    }

    public FavoritesAdapter(List<FavoritesItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentFavoritesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.mItem = mValues.get(position);
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
        public final TextView mContentView;
        public FavoritesItem mItem;

        public ViewHolder(FragmentFavoritesBinding binding) {
            super(binding.getRoot());
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