package com.company.Sprite.RedSeaGameViewSprite;

import com.company.Sprite.Sprite;

import javax.swing.*;

public class Pharoagh extends Sprite
{
    public Pharoagh(int x , int y)
    {
        setPosition(x,y);
        img = new ImageIcon("pharaoh.png");
    }
    public String overlap(int x , int y)
    {
        return null;
    }
}
