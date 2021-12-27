package com.example.nounours.Research;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nounours.Activity.MainActivity;
import com.example.nounours.R;

public class ResearchFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    String _text;

    ResearchContent CONTENT;

    public ResearchFragment(Context context, String text) {
        CONTENT = new ResearchContent(context);
        _text = text;
    }
    public ResearchFragment(ResearchFragment mainActivity, String text) {
        _text = text;
    }

    public ResearchFragment() {

    }

    public ResearchFragment(ResearchFragment researchFragment) {
    }

    @SuppressWarnings("unused")
    public ResearchFragment newInstance(int columnCount) {
        ResearchFragment fragment = new ResearchFragment(this);
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_research_list, container, false);

        if (view instanceof RecyclerView) {
            Log.d("55", "Dans le if");
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            CONTENT.getItems(_text, recyclerView);
        }
        return view;
    }
}