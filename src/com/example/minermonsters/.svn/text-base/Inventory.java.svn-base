package com.example.minermonsters;
import java.util.*;
import java.io.*;

public class Inventory
{
	int slot;
	File file;
	Card c;
	public Inventory()
	{
	}

	public Card useSlot(int s)
	{
		Card c =null;
		String path;
		this.slot =s;
		if(slot == 1)
		{
			path = "inv1.txt";
			try
			{
				file= new File(path);
				Scanner inFile = new Scanner(file);
				if(inFile.next().equals("x"))
				{
					System.out.println("empty slot");
					inFile.close();
				}
				else
				{
					c = new Card(path);
					PrintWriter outFile = new PrintWriter(path);
					outFile.println("x");
					outFile.close();
				}
			}
			catch (Exception e)
			{}
		}
		if(slot == 2)
		{
			path = "inv2.txt";
			try
			{
				file= new File(path);
				Scanner inFile = new Scanner(file);
				if(inFile.next().equals("x"))
				{
					System.out.println("empty slot");
					inFile.close();
				}
				else
				{
					c = new Card(path);
					PrintWriter outFile = new PrintWriter(path);
					outFile.println("x");
					outFile.close();
				}
			}
			catch (Exception e)
			{}
		}
		if(slot == 3)
		{
			path = "inv3.txt";
			try
			{
				file= new File(path);
				Scanner inFile = new Scanner(file);
				if(inFile.next().equals("x"))
				{
					System.out.println("empty slot");
					inFile.close();
				}
				else
				{
					c = new Card(path);
					PrintWriter outFile = new PrintWriter(path);
					outFile.println("x");
					outFile.close();
				}
			}
			catch (Exception e)
			{}
		}
		if(slot == 4)
		{
			path = "inv4.txt";
			try
			{
				file= new File(path);
				Scanner inFile = new Scanner(file);
				if(inFile.next().equals("x"))
				{
					System.out.println("empty slot");
					inFile.close();
				}
				else
				{
					c = new Card(path);
					PrintWriter outFile = new PrintWriter(path);
					outFile.println("x");
					outFile.close();
				}
			}
			catch (Exception e)
			{}
		}
		if(slot == 5)
		{
			path = "inv5.txt";
			try
			{
				file= new File(path);
				Scanner inFile = new Scanner(file);
				if(inFile.next().equals("x"))
				{
					System.out.println("empty slot");
					inFile.close();
				}
				else
				{
					c = new Card(path);
					PrintWriter outFile = new PrintWriter(path);
					outFile.println("x");
					outFile.close();
				}
			}
			catch (Exception e)
			{}
		}
		if(slot == 6)
		{
			path = "inv6.txt";
			try
			{
				file= new File(path);
				Scanner inFile = new Scanner(file);
				if(inFile.next().equals("x"))
				{
					System.out.println("empty slot");
					inFile.close();
				}
				else
				{
					c = new Card(path);
					PrintWriter outFile = new PrintWriter(path);
					outFile.println("x");
					outFile.close();
				}
			}
			catch (Exception e)
			{}
		}
		return c;
	}


	public void saveSlot(Card c)
	{
		int slot;
		slot = findEmptySlot();
		if(slot == 0)
		{
			System.out.println("No empty slot");
		}
		else
		{
			c.saveCard(slot);
		}
	}


	public int findEmptySlot()
	{
		String p;
		Scanner inFile;
		try
		{
			p = "inv1.txt";
			file= new File(p);
			inFile = new Scanner(file);
			if(inFile.next().equals("x"))
			{
				return 1;
			}
			inFile.close();

			p = "inv2.txt";
			file= new File(p);
			inFile = new Scanner(file);
			if(inFile.next().equals("x"))
			{
				return 2;
			}
			inFile.close();

			p = "inv3.txt";
			file= new File(p);
			inFile = new Scanner(file);
			if(inFile.next().equals("x"))
			{
				return 3;
			}
			inFile.close();

			p = "inv4.txt";
			file= new File(p);
			inFile = new Scanner(file);
			if(inFile.next().equals("x"))
			{
				return 4;
			}
			inFile.close();

			p = "inv5.txt";
			file= new File(p);
			inFile = new Scanner(file);
			if(inFile.next().equals("x"))
			{
				return 5;
			}
			inFile.close();

			p = "inv6.txt";
			file= new File(p);
			inFile = new Scanner(file);
			if(inFile.next().equals("x"))
			{
				return 6;
			}
			inFile.close();
		}
		catch(Exception e){}
		return 0;
	}


	public void deleteCard(int s)
	{
		String path;
		if(s == 1)
		{
			path = "inv1.txt";
		}
		else if(s == 2)
		{
			path = "inv2.txt";
		}
		else if(s == 3)
		{
			path = "inv3.txt";
		}
		else if(s == 4)
		{
			path = "inv4.txt";
		}
		else if(s == 5)
		{
			path = "inv5.txt";
		}
		else
		{
			path = "inv6.txt";
		}

		try
		{
			PrintWriter outFile = new PrintWriter(path);
			outFile.println("x");
			outFile.close();
		}
		catch (Exception e){}
	}

	public int monsterSlot()
	{
		String p;
		Scanner inFile;
		try
		{
			p = "saveslot1.txt";
			file= new File(p);
			inFile = new Scanner(file);
			if(inFile.next().equals("x"))
			{
				return 1;
			}
			inFile.close();

			p = "saveslot2.txt";
			file= new File(p);
			inFile = new Scanner(file);
			if(inFile.next().equals("x"))
			{
				return 2;
			}
			inFile.close();

		}
		catch(Exception e){}
		return 0;
	}
}

