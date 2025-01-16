package com.example.secards.app;
import android.os.Bundle;

import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.secards.app.databinding.ActivityMainBinding;
import com.example.secards.lib.Deck;
import com.example.secards.lib.PlaceholderData;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private boolean isShowingFront = true;
    private Deck deck = PlaceholderData.DECK;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_title);

       this.binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.cardText.setText(deck.top().front());

        binding.card.setOnClickListener(v -> {
            isShowingFront = !isShowingFront;
            updateCardText();
        });

        binding.nextButton.setOnClickListener(v -> {
            deck = Deck.forward(deck);
            updateCardText();
        });

        binding.prevButton.setOnClickListener(v -> {
            deck = Deck.backward(deck);
            updateCardText();
        });

        binding.shuffleButton.setOnClickListener(v -> {
            deck = Deck.shuffle(deck);
            updateCardText();
        });

        setContentView(binding.getRoot());
    }

    private void updateCardText() {
        if (isShowingFront) {
            binding.cardText.setText(deck.top().front());
        } else {
            binding.cardText.setText(deck.top().back());
        }
    }
}
