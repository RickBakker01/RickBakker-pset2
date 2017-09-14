package com.example.rick.rickbakker_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("story");
        TextView words_left = (TextView) findViewById(R.id.words_left);
        TextView word_type = (TextView) findViewById(R.id.word_type);
        int NoOfPlaceholders = story.getPlaceholderRemainingCount();
        String text_words_left = NoOfPlaceholders + " words left!";
        words_left.setText(text_words_left);
        String PH = story.getNextPlaceholder();

        if (PH.startsWith("a") || PH.startsWith("e") || PH.startsWith("i") || PH.startsWith("o") || PH.startsWith("u")) {
            text_word_type = "Please type an " + story.getNextPlaceholder();
        } else {
            text_word_type = "Please type a " + story.getNextPlaceholder();
        }
        word_type.setText(text_word_type);

    }

    public void fillInStory(View view) {
        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("story");
        EditText FilledInWord = (EditText) findViewById(R.id.word);

        String filledword = FilledInWord.getText().toString();
        if(filledword.matches("")){
            FilledInWord.setHint("Please fill in a word");
        }
        else {
            FilledInWord.setText("");
            story.fillInPlaceholder(filledword);
            if (story.isFilledIn()){
                goToFourth(story);
            }
            createText(story);
        }
    }

    public String text_word_type = "";
    public String text_words_left = "";
    public void createText(Story story){
        TextView words_left = (TextView) findViewById(R.id.words_left);
        TextView word_type = (TextView) findViewById(R.id.word_type);

        int NoOfPlaceholders = story.getPlaceholderRemainingCount();

        if(NoOfPlaceholders == 1){
            text_words_left = NoOfPlaceholders + " word left!";
        } else {
            text_words_left = NoOfPlaceholders + " words left!";
            }

        words_left.setText(text_words_left);


        String PH = story.getNextPlaceholder();
        if (PH.startsWith("a") || PH.startsWith("e") || PH.startsWith("i") || PH.startsWith("o") || PH.startsWith("u")) {
            text_word_type = "Please type an " + story.getNextPlaceholder();
        } else {
            text_word_type = "Please type a " + story.getNextPlaceholder();
        }
        word_type.setText(text_word_type);
    }

    private void goToFourth(Story story) {
        Intent intent = new Intent (this, FourthActivity.class);
        intent.putExtra("story", story);
        startActivity(intent);
        finish();
    }
}

