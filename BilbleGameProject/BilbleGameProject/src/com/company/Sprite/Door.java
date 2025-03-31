package com.company.Sprite;
import javax.swing.*;

public class Door extends Sprite {

    public Door(int x , int y)
    {
        setPosition(x,y);
        img= new ImageIcon("door.png");
    }
    public String overlap(int x, int y)
    {
        return null;
    }
}
