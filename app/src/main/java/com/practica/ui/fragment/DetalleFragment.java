package com.practica.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.practica.R;


public class DetalleFragment extends Fragment {

    public String name;
    public String details;
    public static final String TAG = "DetalleFragment";


    public DetalleFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey("name")) {
            name = getArguments().getString("name");
        }
        if (getArguments().containsKey("details")) {
            details = getArguments().getString("details");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View root = inflater.inflate(R.layout.user_detail, container, false);
        TextView textViewuser = (TextView)root.findViewById(R.id.username_detail);
        TextView textViewdetails = (TextView)root.findViewById(R.id.details);
        textViewuser.setText(name);
        textViewdetails.setText(details);
        return root;
    }

}