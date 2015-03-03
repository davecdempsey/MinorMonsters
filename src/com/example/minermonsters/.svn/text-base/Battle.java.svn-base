package com.example.minermonsters;
import java.util.*;

import android.widget.Toast;
public class Battle
{
    Monster m1, m2;
    int hp1, hp2, damage, order, c1, c2, m1ele, m2ele;
    Random rand = new Random();
    int multi, add, ele1=0, ele2=0, priority, totalSpeed;
    Scanner kb = new Scanner(System.in);
    Inventory inv =new Inventory();

    public Battle(Monster m1, Monster m2)
    {
        this.m1 = m1;
        this.m2 = m2;
        hp1 = m1.getHp();
        hp2 = m2.getHp();
        m1ele = m1.getEle();
        m2ele = m2.getEle();
        checkElements(m1ele, m2ele);
        status();
    }

    public void attack()
    {
        totalSpeed = m1.getSpd() + m2.getSpd();
        priority = rand.nextInt(totalSpeed)+1;
        
        c1 = 0;
        c2 = 0;

//        System.out.println("M1 action 0-attack 1-6 card:");
//        c1 = kb.nextInt();
//
//        System.out.println("M2 action 0-attack 1-6 card:");
//        c2 = kb.nextInt();

        if(priority <= m1.getSpd())
        {
            if(c1 == 0)
            {
                m1Attack();
            }
            else if(c1 >= 1 && c1 <= 6)
            {
                m1Card(c1);
            }
            if(hp2 <=0)
            {
                hp2 =0;
                return;
            }
            if(c2 == 0)
            {
                m2Attack();
            }
            else if(c2 >= 1 && c2 <= 6)
            {
                m2Card(c2);
            }
            if(hp1 <=0)
            {
                hp1 =0;
                return;
            }
        }
        else
        {
            if(c2 == 0)
            {
                m2Attack();
            }
            else if(c2 >= 1 && c2 <= 6)
            {
                m2Card(c2);
            }
            if(hp1 <=0)
            {
                hp1 =0;
                return;
            }
            if(c1 == 0)
            {
                m1Attack();
            }
            else if(c1 >= 1 && c1 <= 6)
            {
                m1Card(c1);
            }
            if(hp2 <=0)
            {
                hp2 =0;
                return;
            }
        }
    }

    public void m1Attack()
    {
        //multi = rand.nextInt(3)+m2.getLvl();
        //damage = (m1.getStr() * multi) - (m2.getDef() * m2.getLvl()) + m1.getLvl();
        checkElements(m1ele, m2ele);
        multi = rand.nextInt(15)+85;
        add = rand.nextInt(3)+m1.getLvl();
        damage = (((((2*m1.getLvl()/5+2)*m1.getStr()*multi/m2.getDef())/50)+2)*multi/100)+add+ele1;
        System.out.println("m1 deals damage " + damage);
        hp2 -= damage;
    }

    public void m1Card(int c)
    {
        Card card;
        card = inv.useSlot(c);

        System.out.println("m1 used " + card.getName() + " power " + card.getPwr());
        if(card.getType() == 0)
        {
            hp1 += card.getPwr();
            if(hp1 > m1.getHp())
            {
                hp1 = m1.getHp();
            }
        }
        if(card.getType()>=1 && card.getType() <=3)
        {
            checkElements(card.getEle(), m2.getEle());
            add = rand.nextInt(3)+m1.getLvl();
            damage = (((((2*m1.getLvl()/5+2)*m1.getStr()*card.getPwr()/m2.getDef())/50)+2)*85/100)+add+ele1;
            System.out.println("m1 deals damage " + damage);
            hp2 -= damage;
        }
        if(card.getType() == 4)
        {
            damage = card.getPwr();
            System.out.println("m1 deals damage " + damage);
            hp2 -= damage;
        }
    }

    public void m2Attack()
    {
        //multi = rand.nextInt(3)+m2.getLvl();
        //damage = (m2.getStr() * multi) - (m1.getDef() * m1.getLvl()) + m2.getLvl();
        checkElements(m1ele, m2ele);
        multi = rand.nextInt(15)+85;
        add = rand.nextInt(3)+m2.getLvl();
        damage = (((((2*m2.getLvl()/5+2)*m2.getStr()*multi/m1.getDef())/50)+2)*multi/100)+add+ele2;
        System.out.println("m2 deals damage " + damage);
        hp1 -= damage;
    }

    public void m2Card(int c)
    {
        Card card;
        card = inv.useSlot(c);

        System.out.println("m2 used " + card.getName() + " power " + card.getPwr());
        if(card.getType() == 0)
        {
            hp2 += card.getPwr();
            if(hp2 > m2.getHp())
            {
                hp2 = m2.getHp();
            }
        }
        if(card.getType()>=1 && card.getType() <=3)
        {
            checkElements(m1.getEle(),card.getEle());
            add = rand.nextInt(3)+m2.getLvl();
            damage = (((((2*m2.getLvl()/5+2)*m2.getStr()*card.getPwr()/m1.getDef())/50)+2)*85/100)+add+ele1;
            System.out.println("m2 deals damage " + damage);
            hp1 -= damage;
        }
        if(card.getType() == 4)
        {
            damage = card.getPwr();
            System.out.println("m2 deals damage " + damage);
            hp1 -= damage;
        }
    }

    public int winner()
    {
        double factor;
        int xp;
        if(hp1==0)
        {
            if(m2.getLvl() != 5)
            {
                factor = (double)m1.getLvl()/m2.getLvl();
                xp = (int)((factor)*m1.getHp());
                m2.gainExp(xp);
                System.out.println("m2 gained " + xp + " experience");
                m2.checkExp();
            }
            m2.save();
            System.out.println("m2 exp " + m2.getExp() + " m2 level " + m2.getLvl());
            return 2;
        }
        else if(hp2==0)
        {
            if(m1.getLvl() != 5)
            {
                factor = (double)m2.getLvl()/m1.getLvl();
                xp = (int)((factor)*m2.getHp());
                m1.gainExp(xp);
                System.out.println("m1 gained " + xp + " experience");
                m1.checkExp();
            }
            m1.save();
            System.out.println("m1 exp " + m1.getExp() + " m1 level " + m1.getLvl());
            return 1;
        }
        else
            return 0;
    }

    public void status()
    {
        System.out.println("hp1 = "+ hp1 + " " + "hp2 = " + hp2);
    }
    
    public int getM1hp()
    {
    	return hp1;
    }
    
    public int getM2hp()
    {
    	return hp2;
    }

    public void checkElements(int e1, int e2)
    {
        //ice>fire
        //elec>ice
        //fire>elec
        if(e1==2 && e2==1)
        {
            ele1 = m1.getLvl()*2;
        }
        if(e1==3 && e2==2)
        {
            ele1 = m1.getLvl()*2;
        }
        if(e1==1 && e2==3)
        {
            ele1 = m1.getLvl()*2;
        }
        if(e2==2 && e1==1)
        {
            ele2 = m2.getLvl()*2;
        }
        if(e2==3 && e1==2)
        {
            ele2 = m2.getLvl()*2;
        }
        if(e2==1 && e1==3)
        {
            ele2 = m2.getLvl()*2;
        }
    }
}
