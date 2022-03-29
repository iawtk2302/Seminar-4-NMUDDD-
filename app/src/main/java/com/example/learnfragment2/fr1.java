package com.example.learnfragment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fr1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fr1 extends Fragment {

    private MyViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_fr1, container, false);
        EditText text1=v.findViewById(R.id.input1);
        Button btn_add=v.findViewById(R.id.btn_add);
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.selectItem(text1.getText().toString());
            }
        });
        viewModel.getSelectedItem().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                text1.setText(s);
            }
        });
        return v;
    }
}