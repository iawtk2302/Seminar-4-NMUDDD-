package com.example.learnfragment2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class fr2 extends Fragment {

    private MyViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_fr2, container, false);
        EditText text2=v.findViewById(R.id.input2);
        Button btn_update=v.findViewById(R.id.btn_update);
        viewModel = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        viewModel.getSelectedItem().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                text2.setText(s);
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.selectItem(text2.getText().toString());
            }
        });
        return v;
    }
}