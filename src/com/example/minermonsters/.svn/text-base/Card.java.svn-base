package com.example.minermonsters;
import java.util.*;
import java.io.*;


public class Card
{
	int ele, type, get, pwr;
	String element, name;
	Random rand = new Random();

	public Card()
	{
		get = rand.nextInt(75)+1;
		readCard(get);
	}
	public Card(String read)
	{
		try
		{
			File file = new File(read);
			Scanner inFile = new Scanner(file);
			while(inFile.hasNext())
			{
				type = inFile.nextInt();
				ele = inFile.nextInt();
				pwr = inFile.nextInt();
				element = inFile.next();
				name = inFile.next()+ " " + inFile.next();

			}
			inFile.close();
		}
		catch (Exception e)
		{
		}
	}

	public Card(InputStream input)
	{
		int x=0;
		byte[] byteArray;
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
		
		type = (int)Float.parseFloat(st.nextToken());
		ele = (int)Float.parseFloat(st.nextToken());
		pwr = (int)Float.parseFloat(st.nextToken());
		element = st.nextToken();
		name = st.nextToken()+ " " + st.nextToken();

	}

	public String convertByteArrayToString(byte[] byteArray) {

		String value = new String(byteArray);

		return value;
	}

	public void readCard(int g)
	{
		if( g >= 1 && g <= 15)
		{
			type = 0;
			ele = 0;
			element = "None";
			name = "Healing Card";
			pwr = g + 5;
		}
		else if(g >= 16 && g <= 30)
		{
			type = 1;
			ele = 1;
			element = "Fire";
			name = "Fire Card";
			pwr = 70 + g;
		}
		else if (g >= 31 && g <= 45)
		{
			type = 2;
			ele = 2;
			element = "Ice";
			name = "Ice Card";
			pwr = 55 + g;
		}
		else if (g >= 46 && g <= 60)
		{
			type = 3;
			ele = 3;
			element = "Electric";
			name = "Electric Card";
			pwr = 40 + g;
		}
		else
		{
			type = 4;
			ele = 0;
			element = "None";
			name = "Chaos Card";
			pwr = g - 50;
		}
	}
	public void saveCard(int slot)
	{
		if(slot ==1)
		{
			try{
				PrintWriter outFile = new PrintWriter("inv1.txt");
				outFile.println(type);
				outFile.println(ele);
				outFile.println(pwr);
				outFile.println(element);
				outFile.println(name);
				outFile.close();
			}
			catch(Exception e)
			{
			}
		}
		else if(slot ==2)
		{
			try{
				PrintWriter outFile = new PrintWriter("inv2.txt");
				outFile.println(type);
				outFile.println(ele);
				outFile.println(pwr);
				outFile.println(element);
				outFile.println(name);
				outFile.close();
			}
			catch(Exception e)
			{
			}
		}
		else if(slot ==3)
		{
			try{
				PrintWriter outFile = new PrintWriter("inv3.txt");
				outFile.println(type);
				outFile.println(ele);
				outFile.println(pwr);
				outFile.println(element);
				outFile.println(name);
				outFile.close();
			}
			catch(Exception e)
			{
			}
		}
		else if(slot ==4)
		{
			try{
				PrintWriter outFile = new PrintWriter("inv4.txt");
				outFile.println(type);
				outFile.println(ele);
				outFile.println(pwr);
				outFile.println(element);
				outFile.println(name);
				outFile.close();
			}
			catch(Exception e)
			{
			}
		}
		else if(slot ==5)
		{
			try{
				PrintWriter outFile = new PrintWriter("inv5.txt");
				outFile.println(type);
				outFile.println(ele);
				outFile.println(pwr);
				outFile.println(element);
				outFile.println(name);
				outFile.close();
			}
			catch(Exception e)
			{
			}
		}
		else
		{
			try{
				PrintWriter outFile = new PrintWriter("inv6.txt");
				outFile.println(type);
				outFile.println(ele);
				outFile.println(pwr);
				outFile.println(element);
				outFile.println(name);
				outFile.close();
			}
			catch(Exception e)
			{
			}
		}
	}
	public int getType()
	{
		return type;
	}
	public int getEle()
	{
		return ele;
	}
	public String getElement()
	{
		return element;
	}
	public String getName()
	{
		return name;
	}
	public int getPwr()
	{
		return pwr;
	}
}
