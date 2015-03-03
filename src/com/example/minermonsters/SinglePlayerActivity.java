package com.example.minermonsters;


import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.*;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

public class SinglePlayerActivity extends Activity {
	private SharedPreferences card1;
	Random rand = new Random();
	private int randy;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
        
        
        randy = rand.nextInt(9) +1;
        
        final String type, hp, str, def, spd, exp, lvl, ele, name;
        final Monster m1, m2;
        final Battle battle;
        
        final ImageView p1Image = (ImageView) findViewById(R.id.p1Image);
        final ImageView p2Image = (ImageView) findViewById(R.id.p2Image);
        final TextView p1Name = (TextView) findViewById(R.id.p1Name);
        final TextView p1Hp = (TextView) findViewById(R.id.p1Hp);
        final TextView p2Name = (TextView) findViewById(R.id.p2Name);
        final TextView p2Hp = (TextView) findViewById(R.id.p2Hp);
        final TextView p1Lvl = (TextView) findViewById(R.id.p1Level);
        final TextView p2Lvl = (TextView) findViewById(R.id.p2Level);

        Button b1 = (Button) findViewById(R.id.attackButton);
        
//        if(!card1.getString("type", "NA").equals("NA")){
//			type = card1.getString("type", "NA");
//			hp = card1.getString("hp", "NA");
//			str = card1.getString("str", "NA");
//			def = card1.getString("def", "NA");
//			spd = card1.getString("spd", "NA");
//			exp = card1.getString("exp", "NA");
//			lvl = card1.getString("lvl", "NA");
//			ele = card1.getString("ele", "NA");
//			name = card1.getString("name", "NA");
//			m1 = new Monster(type, hp, str, def, spd, exp, lvl, 1, ele, name);
//        }
        
        m1 = new Monster(randy);
        randy = rand.nextInt(9) +1;
        m1.setName("Your Monster");
        m2 = new Monster(randy);
        m2.gainExp(m1.getExp());
        m2.setName("Enemy Monster");
        
        switch(m1.getType())
        {
        case 1:
        	p1Image.setImageResource(R.drawable.firestr);
        	break;
        case 2:
        	p1Image.setImageResource(R.drawable.firedef);
        	break;
        case 3:
        	p1Image.setImageResource(R.drawable.firespd);
        	break;
        case 4:
        	p1Image.setImageResource(R.drawable.icestr);
        	break;
        case 5:
        	p1Image.setImageResource(R.drawable.icedef);
        	break;
        case 6:
        	p1Image.setImageResource(R.drawable.icespd);
        	break;
        case 7:
        	p1Image.setImageResource(R.drawable.elecstr);
        	break;
        case 8:
        	p1Image.setImageResource(R.drawable.elecdef);
        	break;
        case 9:
        	p1Image.setImageResource(R.drawable.elecspd);
        	break;
        }
        
        switch(m2.getType())
        {
        case 1:
        	p2Image.setImageResource(R.drawable.firestr);
        	break;
        case 2:
        	p2Image.setImageResource(R.drawable.firedef);
        	break;
        case 3:
        	p2Image.setImageResource(R.drawable.firespd);
        	break;
        case 4:
        	p2Image.setImageResource(R.drawable.icestr);
        	break;
        case 5:
        	p2Image.setImageResource(R.drawable.icedef);
        	break;
        case 6:
        	p2Image.setImageResource(R.drawable.icespd);
        	break;
        case 7:
        	p2Image.setImageResource(R.drawable.elecstr);
        	break;
        case 8:
        	p2Image.setImageResource(R.drawable.elecdef);
        	break;
        case 9:
        	p2Image.setImageResource(R.drawable.elecspd);
        	break;
        }
        
        p1Name.setText(m1.getName());
        p2Name.setText(m2.getName());
        p1Lvl.setText("Level: "+ m1.getLvl());
        p2Lvl.setText("Level: "+ m2.getLvl());
        battle = new Battle(m1,m2);
		p1Hp.setText("Life: " +battle.getM1hp()+ "/"+m1.getHp());
        p2Hp.setText("Life: " +battle.getM2hp()+ "/"+m2.getHp());
        
        b1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				battle.attack();
				p1Hp.setText("Life: " +battle.getM1hp()+ "/"+m1.getHp());
		        p2Hp.setText("Life: " +battle.getM2hp()+ "/"+m2.getHp());
				
				
				double factor;
		        int xp;
				
				if(battle.getM1hp() <= 0)
				{
		            if(m2.getLvl() != 5)
		            {
		                factor = (double)m1.getLvl()/m2.getLvl();
		                xp = (int)((factor)*m1.getHp());
		                m2.gainExp(xp);
		                m2.checkExp();
		                Toast.makeText(getBaseContext(), m2.getName()+" Wins!\nGained " +xp+" Xp.", Toast.LENGTH_LONG).show();
		                //need save here
		                finish();
		            }
				}
				if(battle.getM2hp() <= 0)
				{
					if(m1.getLvl() != 5)
		            {
		                factor = (double)m2.getLvl()/m1.getLvl();
		                xp = (int)((factor)*m2.getHp());
		                m1.gainExp(xp);
		                m1.checkExp();
		                Toast.makeText(getBaseContext(), m1.getName()+" Wins!\nGained " +xp+" Xp.", Toast.LENGTH_LONG).show();
		                //need save here
		                finish();
		            }
				}
				
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_single_player, menu);
        return true;
    }
}
