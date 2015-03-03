package com.example.minermonsters;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ImageView startImage = (ImageView) findViewById(R.id.startImage);
        
        startImage.setOnClickListener(new View.OnClickListener() {
     
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), MainMenuActivity.class);
				startActivity(i);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
