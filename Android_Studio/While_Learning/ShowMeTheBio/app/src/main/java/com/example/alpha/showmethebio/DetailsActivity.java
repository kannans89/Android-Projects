package com.example.alpha.showmethebio;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends Activity {

    private ImageView profileImage;
    private TextView bioText;
    private TextView name;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        profileImage = (ImageView) findViewById(R.id.detailsImage);
        bioText = (TextView) findViewById(R.id.bioTextView);
        name = (TextView) findViewById(R.id.name);

        extras = getIntent().getExtras();

        if (extras != null) {
            String name = extras.getString("name");
            showDetails(name);

        }
    }

    public void showDetails(String mName) {
        if (mName.equals("bach")) {
            profileImage.setImageDrawable(getResources().getDrawable(R.drawable.bach_profile));
            name.setText(mName.toUpperCase());
            bioText.setText(extras.getString(mName));
        } else if (mName.equals("mozart")) {
            profileImage.setImageDrawable(getResources().getDrawable(R.drawable.mozart_profile));
            name.setText(mName.toUpperCase());
            bioText.setText(extras.getString(mName));
        }
    }
}
