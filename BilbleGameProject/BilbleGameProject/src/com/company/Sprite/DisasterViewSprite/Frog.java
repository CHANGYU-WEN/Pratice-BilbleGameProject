package com.company.Sprite.DisasterViewSprite;

import com.company.Sprite.Sprite;
import javax.swing.*;

public class Frog extends Sprite {

    public String overlap(int x , int y)
    {
        return null;
    }

    public Frog(int x, int y)
    {
        setPosition(x,y);
        img= new ImageIcon("Frog.png");
    }
}
