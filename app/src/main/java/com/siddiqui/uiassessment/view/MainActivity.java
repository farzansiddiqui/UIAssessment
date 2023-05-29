package com.siddiqui.uiassessment.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.siddiqui.uiassessment.R;
import com.siddiqui.uiassessment.databinding.ActivityMainBinding;
import com.siddiqui.uiassessment.viewmodel.UiViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private UiViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(UiViewModel.class);
    }
}