package com.company.Sprite.TenComandmentSprite;

import com.company.Sprite.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TenComandment extends Sprite
{


    public TenComandment(int x , int y)
    {
        setPosition(x,y);
        img = new ImageIcon("stone.png");
    }

    public String overlap(int x , int y)
    {
        return null;
    }
}
