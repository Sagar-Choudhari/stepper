package com.example.stepper;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stepper.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.stepView.done(false);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        binding.personalDetails.setVisibility(View.GONE);
                        binding.location.setVisibility(View.VISIBLE);
                        position = 1;
                        binding.stepView.done(false);
                        binding.stepView.go(position, true);
                        binding.button.setText("Next");
                        break;
                    case 1:
                        binding.location.setVisibility(View.GONE);
                        binding.usage.setVisibility(View.VISIBLE);
                        position = 2;
                        binding.stepView.done(false);
                        binding.stepView.go(position, true);
                        binding.button.setText("Next");
                        break;
                    case 2:
                        binding.usage.setVisibility(View.GONE);
                        binding.employment.setVisibility(View.VISIBLE);
                        position = 3;
                        binding.stepView.done(false);
                        binding.stepView.go(position, true);
                        binding.button.setText("Next");
                        break;
                    case 3:
                        binding.employment.setVisibility(View.GONE);
                        binding.repayment.setVisibility(View.VISIBLE);
                        position = 4;
                        binding.stepView.done(false);
                        binding.stepView.go(position, true);
                        binding.button.setText("Submit");
                        break;
                    default:
                        position = 0;
                        binding.stepView.done(true);
                        binding.stepView.go(5, true);

                        // Go to another Activity or Fragment

                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        switch (position) {
            case 0:
                super.onBackPressed();
                break;
            case 1:
                binding.location.setVisibility(View.GONE);
                binding.personalDetails.setVisibility(View.VISIBLE);
                position = 0;
                binding.stepView.done(false);
                binding.stepView.go(position, true);
                binding.button.setText("Next");
                break;
            case 2:
                binding.usage.setVisibility(View.GONE);
                binding.location.setVisibility(View.VISIBLE);
                position = 1;
                binding.stepView.done(false);
                binding.stepView.go(position, true);
                binding.button.setText("Next");
                break;
            case 3:
                binding.employment.setVisibility(View.GONE);
                binding.usage.setVisibility(View.VISIBLE);
                position = 2;
                binding.stepView.done(false);
                binding.stepView.go(position, true);
                binding.button.setText("Next");
                break;
            default:
                binding.repayment.setVisibility(View.GONE);
                binding.employment.setVisibility(View.VISIBLE);
                position = 3;
                binding.stepView.done(false);
                binding.stepView.go(position, true);
                binding.button.setText("Next");
                break;
        }
    }
}
