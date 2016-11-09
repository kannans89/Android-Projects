package com.example.alpha.showmethebio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView bachImage;
    private ImageView mozartImage;

    private String bachBio = "Bach was born in Eisenach, Saxe-Eisenach, into a great musical family. " +
            "His father, Johann Ambrosius Bach, was the director of the town musicians," +
            " and all of his uncles were professional musicians. His father probably taught him to play the violin" +
            " and harpsichord, and his brother, Johann Christoph Bach, taught him the clavichord and exposed him to much" +
            " contemporary music";


    private String mozartBio = "Mozart showed prodigious ability from his earliest childhood. " +
            "Already competent on keyboard and violin, he composed from the age of five and performed before European royalty. " +
            "At 17, he was engaged as a court musician in Salzburg, but grew restless and travelled in search of a better position, " +
            "always composing abundantly.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bachImage = (ImageView) findViewById(R.id.bachImage);
        mozartImage = (ImageView) findViewById(R.id.mozartImage);

        bachImage.setOnClickListener(this);
        mozartImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bachImage:
                Intent bachIntent = new Intent(MainActivity.this, DetailsActivity.class);
                bachIntent.putExtra("bach", bachBio);
                bachIntent.putExtra("name", "bach");
                startActivity(bachIntent);
                break;
            case R.id.mozartImage:
                Intent mozartIntent = new Intent(MainActivity.this, DetailsActivity.class);
                mozartIntent.putExtra("mozart", mozartBio);
                mozartIntent.putExtra("name", "mozart");
                startActivity(mozartIntent);
                break;
        }
    }
}
