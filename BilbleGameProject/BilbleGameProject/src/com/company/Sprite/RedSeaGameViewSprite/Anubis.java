package com.company.Sprite.RedSeaGameViewSprite;

import com.company.Sprite.Sprite;

import javax.swing.*;

public class Anubis extends Sprite
{
    public Anubis(int x, int y)
    {
        setPosition(x,y);
        img = new ImageIcon("anubis.png");
    }
    public String overlap(int x , int y)
    {
        return null;
    }
}
