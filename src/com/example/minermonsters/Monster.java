package com.example.minermonsters;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

import org.xmlpull.v1.XmlSerializer;

import android.R.string;
import android.app.Activity;
import android.content.*;
import android.util.Xml;

public class Monster
{
	int type, hp, str, def, spd, exp, lvl, slot, ele;
	String imagePath, name, element, data=null;
	float test, test2;
	byte[] byteArray;

	public Monster(File file, Context context)
	{
		FileInputStream fIn;
		try{
			//fIn = context.getApplicationContext().openFileInput(path);
			fIn = new FileInputStream(file);
			InputStreamReader isr = null;

			char[] inputBuffer = new char[1024];
			isr = new InputStreamReader(fIn);
			isr.read(inputBuffer);
			data = new String(inputBuffer);

			isr.close();
			fIn.close();
		}catch(IOException e){
			e.printStackTrace(System.err);
		}

		System.out.print(data);

		if(ele == 1)
			element = "Fire";
		else if(ele == 2)
			element = "Ice";
		else
			element = "Electric";
	}

	public Monster(String type, String hp, String str, String def, String spd, String exp, String lvl, int slot, String ele, String name, String element, String imagePath)
	{
		this.imagePath = imagePath;
		this.name = name;
		this.element = element;
		this.slot = slot;
		this.type = Integer.valueOf(type);
		this.hp = Integer.valueOf(hp);
		this.str = Integer.valueOf(str);
		this.def = Integer.valueOf(def);
		this.spd = Integer.valueOf(spd);
		this.exp = Integer.valueOf(exp);
		this.lvl = Integer.valueOf(lvl);
		this.ele = Integer.valueOf(ele);
	}
	
	public Monster(String type, String hp, String str, String def, String spd, String exp, String lvl, int slot, String ele, String name)
	{
		this.name = name;
		this.slot = slot;
		this.type = Integer.valueOf(type);
		this.hp = Integer.valueOf(hp);
		this.str = Integer.valueOf(str);
		this.def = Integer.valueOf(def);
		this.spd = Integer.valueOf(spd);
		this.exp = Integer.valueOf(exp);
		this.lvl = Integer.valueOf(lvl);
		this.ele = Integer.valueOf(ele);
		
		if(this.ele == 1)
			this.element = "Fire";
		else if(this.ele == 2)
			this.element = "Ice";
		else
			this.element = "Electric";
	}

	public Monster(int l)
	{
		name = "a";
		lvl = 1;
		exp = 0;
		slot = 0;
		type = l;

		if(type == 1 || type == 2 || type == 3)
		{
			ele = 1;
		}
		else if(type == 4 || type == 5 || type == 6)
		{
			ele = 2;
		}
		else
		{
			ele = 3;
		}

		if(ele == 1)
			element = "Fire";
		else if(ele == 2)
			element = "Ice";
		else
			element = "Electric";

		if(type == 1 || type == 4 || type == 7)
		{
			hp = 43;
			str = 52;
			def = 45;
			spd = 35;

			if(type == 1)
			{
				imagePath = "sprites/FireStr.png";
			}
			else if(type == 4)
			{
				imagePath = "sprites/IceStr.png";
			}
			else
			{
				imagePath = "sprites/ElecStr.png";
			}
		}
		else if(type == 2 || type == 5 || type == 8)
		{
			hp = 44;
			str = 45;
			def = 55;
			spd = 43;

			if(type == 1)
			{
				imagePath = "sprites/FireDef.png";
			}
			else if(type == 4)
			{
				imagePath = "sprites/IceDef.png";
			}
			else
			{
				imagePath = "sprites/ElecDef.png";
			}
		}
		else
		{

			hp = 45;
			str = 49;
			def = 49;
			spd = 45;

			if(type == 1)
			{
				imagePath = "sprites/FireStr.png";
			}
			else if(type == 4)
			{
				imagePath = "sprites/IceStr.png";
			}
			else
			{
				imagePath = "sprites/ElecStr.png";
			}

		}


	}

	public Monster(InputStream input)
	{
		int x=0;
		String parsed;
		ByteArrayOutputStream b = new ByteArrayOutputStream();

		try{
			x = input.read();
			while(x!= -1){
				b.write(x);
				x = input.read();
			}
			input.close();
		}
		catch(Exception e){}

		byteArray = b.toByteArray();		

		parsed = convertByteArrayToString(byteArray);

		StringTokenizer st = new StringTokenizer(parsed,"\n");

		//System.out.print(parsed);

		name = st.nextToken();
		type = (int)Float.parseFloat(st.nextToken());
		hp = (int)Float.parseFloat(st.nextToken());
		str = (int)Float.parseFloat(st.nextToken());
		def = (int)Float.parseFloat(st.nextToken());
		spd= (int)Float.parseFloat(st.nextToken());
		ele= (int)Float.parseFloat(st.nextToken());
		exp= (int)Float.parseFloat(st.nextToken());
		lvl = (int)Float.parseFloat(st.nextToken());
		slot = (int)Float.parseFloat(st.nextToken());
		imagePath = st.nextToken();


		if(ele == 1)
			element = "Fire";
		else if(ele == 2)
			element = "Ice";
		else
			element = "Electric";

	}

	public void testSave()
	{

	}

	public String convertByteArrayToString(byte[] byteArray) {

		String value = new String(byteArray);

		return value;
	}

	public void setType(int t)
	{
		this.type = t;
	}

	public void setHp(int h)
	{
		this.hp = h;
	}

	public void setStr(int s)
	{
		this.str = s;
	}

	public void setDef(int d)
	{
		this.def = d;
	}

	public void setSpd(int s)
	{
		this.spd = s;
	}

	public void setEle(int e)
	{
		this.ele = e;
		if(ele == 1)
			element = "Fire";
		else if(ele == 2)
			element = "Ice";
		else
			element = "Electric";

	}

	public void setExp(int e)
	{
		this.exp = e;
	}

	public void setLvl(int l)
	{
		this.lvl = l;
	}

	public void setImage(String p)
	{
		this.imagePath = p;
	}

	public void setSlot(int s)
	{
		this.slot = s;
	}

	public int getSlot()
	{
		return slot;
	}

	public void gainExp(int e)
	{
		exp += e;
	}

	public int getStr()
	{
		return str;
	}

	public int getHp()
	{
		return hp;
	}

	public int getDef()
	{
		return def;
	}

	public int getSpd()
	{
		return spd;
	}

	public int getExp()
	{
		return exp;
	}

	public int getType()
	{
		return type;
	}

	public int getLvl()
	{
		return lvl;
	}

	public int getEle()
	{
		return ele;
	}

	public String getElement()
	{
		return element;
	}

	public String getImagePath()
	{
		return imagePath;
	}

	public void setName(String n)
	{
		name =n;
	}

	public String getName()
	{
		return name;
	}


	public void save()
	{
		if(slot ==1)
		{
			try{
				PrintWriter outFile = new PrintWriter("saveslot1.txt");
				outFile.println(name);
				outFile.println(type);
				outFile.println(hp);
				outFile.println(str);
				outFile.println(def);
				outFile.println(spd);
				outFile.println(ele);
				outFile.println(exp);
				outFile.println(lvl);
				outFile.println(slot);
				outFile.println(imagePath);
				outFile.close();
			}
			catch(Exception e)
			{
			}
		}
		else
		{
			try{
				PrintWriter outFile = new PrintWriter("saveslot2.txt");
				outFile.println(name);
				outFile.println(type);
				outFile.println(hp);
				outFile.println(str);
				outFile.println(def);
				outFile.println(spd);
				outFile.println(ele);
				outFile.println(exp);
				outFile.println(lvl);
				outFile.println(slot);
				outFile.println(imagePath);
				outFile.close();
			}
			catch(Exception e)
			{
			}
		}
	}

	public void levelUp()
	{
		lvl++;
		System.out.println("Level up");
		if(type==1 || type == 4 || type == 7)
		{
			hp *= 1.1;
			str *= 1.1;
			def *= 1.05;
			spd *= 1.05;
		}
		if(type==2 || type == 5 || type == 8)
		{
			hp *= 1.1;
			str *= 1.05;
			def *= 1.1;
			spd *= 1.05;
		}
		if(type == 3 || type == 6 || type == 9)
		{
			hp *= 1.1;
			str *= 1.05;
			def *= 1.05;
			spd *= 1.1;
		}
	}

	public void checkExp()
	{
		if(lvl ==1 && exp >= 100)
		{
			levelUp();
		}
		if(lvl == 2 && exp >= 300)
		{
			levelUp();
		}
		if(lvl == 3 && exp >= 900)
		{
			levelUp();
		}
		if(lvl == 4 && exp >= 2100)
		{
			levelUp();
			if(exp > 2100)
				exp = 2100;
		}
		//         if(lvl == 5 && exp >= 3600)
		//         {
		//             levelUp();  
		//         }
	}

	public void deleteMonster()
	{
		if(slot == 1)
		{
			try
			{
				PrintWriter outFile = new PrintWriter("saveslot1");
				outFile.println("x");
				outFile.close();
			}
			catch (Exception e){}
		}
		else
		{
			try
			{
				PrintWriter outFile = new PrintWriter("saveslot2");
				outFile.println("x");
				outFile.close();
			}
			catch (Exception e){}
		}
	}

	public void stats()
	{
		System.out.println("");
		System.out.println("NAME: " + name);
		System.out.println("TYPE: " + type);
		System.out.println("HP: " + hp);
		System.out.println("STR: " + str);
		System.out.println("DEF: " + def);
		System.out.println("SPD: " + spd);
		System.out.println("ELE: " + element);
		System.out.println("EXP: " + exp);
		System.out.println("LVL: " + lvl);
		System.out.println("IMAGE: " + imagePath);
	}
}
