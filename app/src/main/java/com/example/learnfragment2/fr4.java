package com.example.learnfragment2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class fr4 extends Fragment {
    Button rqCamera;
    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    Toast.makeText(getActivity(), "Granted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "Denied", Toast.LENGTH_SHORT).show();
                }
            });
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_fr4, container, false);
        rqCamera = v.findViewById(R.id.rqCamera);
        rqCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
                    return;
                else {
                    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(getActivity(), "Granted", Toast.LENGTH_SHORT).show();
                    } else if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        Toast.makeText(getActivity(), "shouldShowRequestPermissionRationale", Toast.LENGTH_SHORT).show();
                        requestPermissionLauncher.launch(Manifest.permission.CAMERA);
                    }else {
                        requestPermissionLauncher.launch(
                                Manifest.permission.CAMERA);
                    }
                }
            }
        });

        return v;
    }
}