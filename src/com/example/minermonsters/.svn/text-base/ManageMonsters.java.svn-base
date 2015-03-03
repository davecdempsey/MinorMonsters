package com.example.minermonsters;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;

public class ManageMonsters extends Activity {
	
	public SharedPreferences card1;
	public SharedPreferences card2;
	
	private static final String DEBUG_TAG = "MySimpleAppLogging";
	
	public static final String SLOTONE = "slot one";
	public static final String SLOTTWO = "slot two";
	public static final String NAME = "name";
	public static final String BREED = "breed";
	public static final String TYPE = "type";
	public static final String HP = "hp";
	public static final String STR = "str";
	public static final String DEF = "def";
	public static final String SPD = "spd";
	public static final String EXP = "exp";
	public static final String LEVEL = "lvl";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_monsters);
        
        card1 =  getSharedPreferences("com.example.minermonsters.savedstate1", Activity.MODE_PRIVATE);
        card2 =  getSharedPreferences("com.example.minermonsters.savedstate2", Activity.MODE_PRIVATE);
        
        String type, hp, str, def, spd, exp, lvl, ele;
		String imagePath, name, element;
        
		Button card1Btn = (Button) findViewById(R.id.card1_btn);
        Button card2Btn = (Button) findViewById(R.id.card2_btn);
        Button saveBtn = (Button) findViewById(R.id.save_btn);
        //Button deleteBtn = (Button) findViewById(R.id.delete_btn);
		
        saveBtn.setClickable(false);
        //deleteBtn.setClickable(false);
        
        if (getIntent().getStringArrayListExtra(SLOTONE).equals("empty")){
        	card1Btn.setClickable(false);
        	card2Btn.setClickable(true);
        }
        else if(getIntent().getStringArrayListExtra(SLOTTWO).equals("empty")){
        	card1Btn.setClickable(true);
        	card2Btn.setClickable(false);
        }
        else{
        	card1Btn.setClickable(true);
        	card2Btn.setClickable(true);
        }
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_manage_monsters, menu);
        return true;
    }
}
