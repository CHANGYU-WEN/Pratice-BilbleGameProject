package com.company.GameView;

import com.company.Sprite.TenComandmentSprite.TenComandment;

import javax.swing.*;
import java.util.ArrayList;

public class TenComandmentsView extends GameView
{
    private ArrayList<TenComandment> stones =  new ArrayList<>();
    private int count =0;

    public ArrayList<TenComandment> getStones()
    {
        return stones;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count += count;
    }

    public TenComandmentsView()
    {
        img = new ImageIcon("mountain.jpg");
        elements = new ArrayList<>();
        count=0;

        stones.add(new TenComandment(5,5));
        stones.add(new TenComandment(1,5));
        stones.add(new TenComandment(2,4));
        stones.add(new TenComandment(4,4));
        stones.add(new TenComandment(2,6));
        stones.add(new TenComandment(4,2));
        stones.add(new TenComandment(5,4));
        stones.add(new TenComandment(3,4));
        stones.add(new TenComandment(1,4));
        stones.add(new TenComandment(2,3));
        elements.addAll(stones);
    }


}
