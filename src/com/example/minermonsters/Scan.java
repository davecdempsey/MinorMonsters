package com.example.minermonsters;
import java.util.*;
import java.io.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Scan
{
	InputStream in;
    int location;
    public Scan()
    {
        location = 1;
    }
    public Scan(int l)
    {
        this.location = l;
    }
    public void setLocation(int l)
    {
        this.location = l;
    }
    public Card scanCard()
    {
        Card scanC;
        scanC = new Card();
        return scanC;
    }

    public Monster scanMonster(int l)
    {
    	Monster scanM = null;
    	if(l >= 1 || l <= 9)
    	{
    		scanM = new Monster(l);
    	}
    	return scanM;
    }
    
    public Monster scanMonster(Context context)
    {
    	InputStream in;
        Monster scanM=null;
        File f;
        if(location ==1)
        {
        	f = new File("monster1.txt");
            scanM = new Monster(f, context);
        	//in = getBaseContext().getResources().openRawResource(R.raw.monster1);
          //  scanM = new Monster(in);
        }
        else if(location ==2)
        {
          //  scanM = new Monster("monster2.txt");
        }
        else if(location ==3)
        {
       //     scanM = new Monster("monster3.txt");
        }
        else if(location ==4)
        {
        //    scanM = new Monster("monster4.txt");
        }
        else if(location ==5)
        {
         //   scanM = new Monster("monster5.txt");
        }
        else if(location ==6)
        {
         //   scanM = new Monster("monster6.txt");
        }
        else if(location ==7)
        {
         //   scanM = new Monster("monster7.txt");
        }
        else if(location ==8)
        {
        //    scanM = new Monster("monster8.txt");
        }
        else if(location ==9)
        {
        //    scanM = new Monster("monster9.txt");
        }
        else
        {
            System.out.println("invalid location");
            return null;
        }
        return scanM;
    }
    
    public Monster scanMonster(InputStream in)
    {
    	this.in = in;
        Monster scanM;
        if(location ==1)
        {
            //scanM = new Monster("MinerMonsters/res/raw/monster1.txt");
        	//in = getBaseContext().getResources().openRawResource(R.raw.monster1);
          scanM = new Monster(in);
        }
        else if(location ==2)
        {
            scanM = new Monster(in);
        }
        else if(location ==3)
        {
        	scanM = new Monster(in);
        }
        else if(location ==4)
        {
        	scanM = new Monster(in);
        }
        else if(location ==5)
        {
            scanM = new Monster(in);
        }
        else if(location ==6)
        {
            scanM = new Monster(in);
        }
        else if(location ==7)
        {
            scanM = new Monster(in);
        }
        else if(location ==8)
        {
            scanM = new Monster(in);
        }
        else if(location ==9)
        {
            scanM =  new Monster(in);
        }
        else
        {
            System.out.println("invalid location");
            return null;
        }
        return scanM;
    }
}
