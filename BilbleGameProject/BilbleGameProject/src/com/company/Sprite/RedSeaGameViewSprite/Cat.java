package com.company.Sprite.RedSeaGameViewSprite;

import com.company.Sprite.Sprite;

import javax.swing.*;

public class Cat extends Sprite
{
        public Cat(int x , int y)
        {
            setPosition(x,y);
            img = new ImageIcon("cat.png");
        }
        public String overlap(int x , int y)
        {
            return null;
        }
}
