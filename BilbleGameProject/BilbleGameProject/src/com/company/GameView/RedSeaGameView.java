package com.company.GameView;

import com.company.Sprite.*;
import com.company.Sprite.RedSeaGameViewSprite.*;

import javax.swing.*;
import java.util.ArrayList;

public class RedSeaGameView extends GameView
{
    private ArrayList<Cat> cats = new ArrayList<>();
    private ArrayList<Anubis> anubis = new ArrayList<>();
    private ArrayList<Pharoagh> pharoagh = new ArrayList<>();

    public ArrayList<Cat> getCats()
    {
        return cats;
    }
    public ArrayList<Anubis> getAnubis()
    {
        return anubis;
    }
    public ArrayList<Pharoagh> getPharoagh()
    {
        return pharoagh;
    }

    public RedSeaGameView()
    {
        img= new ImageIcon("sea.jpg");
        elements = new ArrayList<>();
        door = new Door(10,10);

        cats.add(new Cat(6,3));
        cats.add(new Cat(6,4));
        cats.add(new Cat(6,5));
        cats.add(new Cat(8,3));
        cats.add(new Cat(1,3));
        cats.add(new Cat(6,9));
        cats.add(new Cat(2,7));
        cats.add(new Cat(2,5));

        pharoagh.add(new Pharoagh(5,4));
        pharoagh.add(new Pharoagh(6,1));
        pharoagh.add(new Pharoagh(5,1));
        pharoagh.add(new Pharoagh(4,1));
        pharoagh.add(new Pharoagh(3,1));
        pharoagh.add(new Pharoagh(1,4));

        anubis.add(new Anubis(2,6));;
        anubis.add(new Anubis(7,6));
        anubis.add(new Anubis(7,7));
        anubis.add(new Anubis(7,8));
        anubis.add(new Anubis(10,1));


        elements.addAll(cats);
        elements.addAll(anubis);
        elements.addAll(pharoagh);
        elements.add(door);
    }
}
