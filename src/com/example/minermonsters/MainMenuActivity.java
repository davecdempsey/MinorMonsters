package com.example.minermonsters;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


public class MainMenuActivity extends Activity {
	private ArrayList<Monster> theMonsters = new ArrayList<Monster>();
	private ProgressDialog progressDialog;
	public SharedPreferences card1;
	public SharedPreferences card2;
	private static final String DEBUG_TAG = "MySimpleAppLogging";
	
	public static final String SLOTONE = "slot one";
	public static final String SLOTTWO = "slot two";
	public static final String NAME = "name";
	//public static final String BREED = "breed";
	public static final String TYPE = "type";
	public static final String HP = "hp";
	public static final String STR = "str";
	public static final String DEF = "def";
	public static final String SPD = "spd";
	public static final String EXP = "exp";
	public static final String LEVEL = "lvl";
	public static final String ELE = "ele";
	
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        
        Log.d(DEBUG_TAG, "Here0");
        
        card1 =  getSharedPreferences("com.example.minermonsters.savedstate1", Activity.MODE_PRIVATE);
        
        Log.d(DEBUG_TAG, "Here1");
        
        card2 =  getSharedPreferences("com.example.minermonsters.savedstate2", Activity.MODE_PRIVATE);
        
        Log.d(DEBUG_TAG, "Here2");
        
        new LoadMonsters().execute();
        
        Log.d(DEBUG_TAG, "Here3");
        
        
	    Editor card1PrivateEditor = card1.edit();
	    Editor card2PrivateEditor = card1.edit();
	   
	    
        Button b1 = (Button) findViewById(R.id.scanButton);
        Button b2 = (Button) findViewById(R.id.battleButton);
        Button b3 = (Button) findViewById(R.id.singleButton);
        Button b4 = (Button) findViewById(R.id.manageButton);
        Button b5 = (Button) findViewById(R.id.exitButton);
        
        //scan
        b1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), ScanActivity.class);
				startActivity(i);
			}
		});
        
        //multiplayer
        b2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
        
        //singleplayer
        b3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), SinglePlayerActivity.class);
				startActivity(i);
			}
		});

        b4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				if(!card1.getString("type", "NA").equals("NA") || !card2.getString("type", "NA").equals("NA")){
					Toast.makeText(getBaseContext(), "You don't have any monsters saved.", Toast.LENGTH_LONG).show();
				}
				else{
					
					ArrayList<String> type = new ArrayList<String>();
					ArrayList<String> name = new ArrayList<String>();
					//ArrayList<String> breed = new ArrayList<String>();
					ArrayList<String> hp = new ArrayList<String>();
					ArrayList<String> str = new ArrayList<String>();
					ArrayList<String> def = new ArrayList<String>();
					ArrayList<String> spd = new ArrayList<String>();
					ArrayList<String> exp = new ArrayList<String>();
					ArrayList<String> level = new ArrayList<String>();
					ArrayList<String> ele = new ArrayList<String>();
					
					
					Intent manageMonsters = new Intent(getBaseContext(), ManageMonsters.class);
					
					if(!card1.getString("type", "NA").equals("NA")){
						manageMonsters.putExtra(SLOTONE, "empty");
						manageMonsters.putExtra(SLOTTWO, "occupied");
						
					}
					else if(!card2.getString("type", "NA").equals("NA")){
						manageMonsters.putExtra(SLOTONE, "occupied");
						manageMonsters.putExtra(SLOTTWO, "empty");
					
					}
					else{
						manageMonsters.putExtra(SLOTONE, "occupied");
						manageMonsters.putExtra(SLOTTWO, "occupied");
					}
					
					type.add(0, card1.getString("type", "NA"));
					type.add(1, card2.getString("type", "NA"));
					
					name.add(0, card1.getString("name", "NA"));
					name.add(1, card2.getString("name", "NA"));
					
					//breed.add(0, card1.getString("breed", "NA"));
					//breed.add(1, card2.getString("breed", "NA"));
					
					hp.add(0, card1.getString("hp", "NA"));
					hp.add(1, card2.getString("hp", "NA"));
					
					str.add(0, card1.getString("str", "NA"));
					str.add(1, card2.getString("str", "NA"));
					
					def.add(0, card1.getString("def", "NA"));
					def.add(1, card2.getString("def", "NA"));
					
					spd.add(0, card1.getString("spd", "NA"));
					spd.add(1, card2.getString("spd", "NA"));
					
					exp.add(0, card1.getString("exp", "NA"));
					exp.add(1, card2.getString("exp", "NA"));
					
					level.add(0, card1.getString("level", "NA"));
					level.add(1, card2.getString("level", "NA"));
					
					ele.add(0, card1.getString("ele", "NA"));
					ele.add(1, card2.getString("ele", "NA"));

					manageMonsters.putStringArrayListExtra(TYPE, type);
					manageMonsters.putStringArrayListExtra(NAME, name);
					//manageMonsters.putStringArrayListExtra(BREED, breed);
					manageMonsters.putStringArrayListExtra(HP, hp);
					manageMonsters.putStringArrayListExtra(STR, str);
					manageMonsters.putStringArrayListExtra(DEF, def);
					manageMonsters.putStringArrayListExtra(EXP, exp);
					manageMonsters.putStringArrayListExtra(ELE, ele);
					manageMonsters.putStringArrayListExtra(LEVEL, level);
					
					
					startActivity(manageMonsters);
					
				}
			}
		});
        b5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				android.os.Process.killProcess(android.os.Process.myPid());
			}
		});     
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }
    
    public class LoadMonsters extends AsyncTask<Void, Void, Void>{
    	Handler handlerUI = new Handler();
    	InputStream xml = getResources().openRawResource(R.raw.saveslots);
    	    	
    	@Override
    	protected void onPreExecute() {
    		
    		progressDialog = ProgressDialog.show(MainMenuActivity.this, "", "Loading Your Monsters. Please Wait..", true, false);
    	}

    	@Override
		protected Void doInBackground(Void... arg0) {
			
			Log.d(DEBUG_TAG, "doInBackground");
			
    		String type, hp, str, def, spd, exp, lvl, ele;
    		String imagePath, name, breed, element;
    		
    		Log.d(DEBUG_TAG, "execute1");
    		
    		if(!card1.getString("type", "NA").equals("NA")){
    			Log.d(DEBUG_TAG, "execute inside if statement");
    			Log.d(DEBUG_TAG, card1.getString("type", "NA"));
    
    			type = card1.getString("type", "NA");
    			hp = card1.getString("hp", "NA");
    			str = card1.getString("str", "NA");
    			def = card1.getString("def", "NA");
    			spd = card1.getString("spd", "NA");
    			exp = card1.getString("exp", "NA");
    			lvl = card1.getString("lvl", "NA");
    			ele = card1.getString("ele", "NA");
    			imagePath = card1.getString("imagePath", "NA");
    			name = card1.getString("name", "NA");
    			//breed = card1.getString("breed", "NA");
    			element = card1.getString("element", "NA");
    			Monster card1Moster = new Monster(type, hp, str, def, spd, exp, lvl, 1, ele, name, element, imagePath);
    			theMonsters.add(card1Moster);
    		}
    		
    		Log.d(DEBUG_TAG, "execute2");
    		
    		if(!card2.getString("type", "NA").equals("NA")){
    			type = card2.getString("type", "NA");
    			hp = card2.getString("hp", "NA");
    			str = card2.getString("str", "NA");
    			def = card2.getString("def", "NA");
    			spd = card2.getString("spd", "NA");
    			exp = card2.getString("exp", "NA");
    			lvl = card2.getString("lvl", "NA");
    			ele = card2.getString("ele", "NA");
    			imagePath = card2.getString("imagePath", "NA");
    			name = card2.getString("name", "NA");
    			breed = card2.getString("breed", "NA");
    			element = card2.getString("element", "NA");
    			Monster card2Moster = new Monster(type, hp, str, def, spd, exp, lvl, 1, ele, name, element, imagePath);
    			theMonsters.add(card2Moster);
    		}
			
			return null;
		}
    	
    
    	@Override
		protected void onProgressUpdate(Void... progress) {
			
		}

    	@Override
		protected void onPostExecute(Void result) {
    		
    		handlerUI.postDelayed(new Runnable() {
                @Override
                public void run() {
                	progressDialog.setMessage("Finished Loading Your Monsters");
                }
            }, 1000);
    		
    		handlerUI.postDelayed(new Runnable() {
                @Override
                public void run() {
                	
                	progressDialog.dismiss();

                }
            }, 4000);
    		
    	}

    }
}
