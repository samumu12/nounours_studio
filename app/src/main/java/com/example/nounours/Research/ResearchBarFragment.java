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

public class ResearchBarFragment extends Fragment {
    final String[] text = {""};
    private EditText Search;
    private Button search_button;
    private Context _context;

    public ResearchBarFragment(Context context) {
        _context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_research_bar, container, false);
        Search = view.findViewById(R.id.research_input);
        Search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("42", "ma bite");
                text[0] = s.toString();
            }
        });

        search_button = view.findViewById(R.id.research_button);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("41", "ma bite");
                getFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.placeholder, new ResearchFragment(_context, text[0]))
                    .commit();
                // CONTENT.getItems(text[0], recyclerView);
            }
        });
        return view;
    }
}