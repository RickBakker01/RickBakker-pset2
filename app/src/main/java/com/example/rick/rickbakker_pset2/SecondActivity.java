package com.example.rick.rickbakker_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static com.example.rick.rickbakker_pset2.R.id.bSimple;

public class SecondActivity extends AppCompatActivity {
    public String file = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.bSimple).setOnClickListener(new myListener());
        findViewById(R.id.bTarzan).setOnClickListener(new myListener());
        findViewById(R.id.bUniversity).setOnClickListener(new myListener());
        findViewById(R.id.bClothes).setOnClickListener(new myListener());
        findViewById(R.id.bDance).setOnClickListener(new myListener());
        findViewById(R.id.bRandom).setOnClickListener(new myListener());
    }

    public class myListener implements View.OnClickListener {
        Random random = new Random();
        int randomnum = random.nextInt(5);
        @Override
        public void onClick(View view) {
            try{
                switch (view.getId()) {
                    case R.id.bSimple:
                        file = "madlib0_simple.txt";
                        goToThird();
                        break;
                    case R.id.bTarzan:
                        file = "madlib1_tarzan.txt";
                        goToThird();
                        break;
                    case R.id.bUniversity:
                        file = "madlib2_university.txt";
                        goToThird();
                        break;
                    case R.id.bClothes:
                        file = "madlib3_clothes.txt";
                        goToThird();
                        break;
                    case R.id.bDance:
                        file = "madlib4_dance.txt";
                        goToThird();
                        break;
                    case R.id.bRandom:
                        switch (randomnum) {
                            case 0:
                                file = "madlib0_simple.txt";
                                goToThird();
                                break;
                            case 1:
                                file = "madlib1_tarzan.txt";
                                goToThird();
                                break;
                            case 2:
                                file = "madlib2_university.txt";
                                goToThird();
                                break;
                            case 3:
                                file = "madlib3_clothes.txt";
                                goToThird();
                                break;
                            case 4:
                                file = "madlib4_dance.txt";
                                goToThird();
                                break;
                        }
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

        public Story createStory() throws IOException {
            InputStream stream = getAssets().open(file);
            Story story = new Story(stream);
            return story;
        }

    public void goToThird() throws IOException {
        Story story = createStory();
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        intent.putExtra("story", story);
        startActivity(intent);
        finish();
    }
}