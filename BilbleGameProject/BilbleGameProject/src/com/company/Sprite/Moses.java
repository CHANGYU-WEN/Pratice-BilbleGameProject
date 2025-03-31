package com.company.Sprite;

import com.company.GameView.DisasterView;
import com.company.GameView.RedSeaGameView;
import com.company.GameView.TenComandmentsView;
import com.company.Main;
import com.company.Sprite.DisasterViewSprite.*;
import com.company.Sprite.RedSeaGameViewSprite.*;
import com.company.Sprite.TenComandmentSprite.TenComandment;

import javax.swing.*;
import java.awt.image.ReplicateScaleFilter;
import java.util.ArrayList;


public class Moses extends Sprite  {

    public Moses(int x, int y )
    {
        setPosition(x,y);
        img = new ImageIcon("Moses.png");
    }

    public String overlap(int x, int y)
    {
        if (Main.gameView instanceof DisasterView)
        {
            //確認Bug和Frogs
            //先轉型成DisasterView 才能用getBugs方法
            ArrayList<Bug> bugs= ((DisasterView)Main.gameView).getBugs();
            ArrayList<Frog> forgs =( (DisasterView)Main.gameView).getFrogs();
            for (Frog f : forgs)
            {
                if(f.getRalativePosition()!=null && x ==f.getRalativePosition().x && y==f.getRalativePosition().y)
                {
                    return "Die";
                }
            }
            for(Bug b : bugs)
            {
                if(b.getRalativePosition()!=null && x== b.getRalativePosition().x && y== b.getRalativePosition().y )
                {
                    return "Die";
                }
            }

            ArrayList<Ice> ices = ((DisasterView)Main.gameView).getIces();
            ArrayList<Tombstone> tombstones = ((DisasterView)Main.gameView).getTombstones();

            for(Ice i : ices)
            {
                if(i.getRalativePosition()!=null && i.getRalativePosition().x ==x && i.getRalativePosition().y ==y)
                {
                    return "Cannot move";
                }
            }

            for(Tombstone t : tombstones)
            {
                if(t.getRalativePosition()!=null && t.getRalativePosition().x==x && t.getRalativePosition().y ==y)
                {
                    return "Cannot move";
                }
            }
            Door door = Main.gameView.getDoor();
            if(x==door.getRalativePosition().x && y==door.getRalativePosition().y)
            {
                return "Next level";
            }
        }
        else if(Main.gameView instanceof RedSeaGameView)
        {
            ArrayList<Cat> cats = ((RedSeaGameView)Main.gameView).getCats();
            ArrayList<Anubis> anubis = ((RedSeaGameView)Main.gameView).getAnubis();
            ArrayList<Pharoagh> pharoaghs = ((RedSeaGameView)Main.gameView).getPharoagh();

            for(Cat c: cats)
            {
                if(c.getRalativePosition()!=null && x == c.getRalativePosition().x && y == c.getRalativePosition().y)
                {
                    return "Cannot move";
                }

            }
            Door door = Main.gameView.getDoor();
            if(x==door.getRalativePosition().x && y==door.getRalativePosition().y)
            {
                return "Next level";
            }

            for(Anubis a : anubis)
            {
                if(a.getRalativePosition()!=null && x== a.getRalativePosition().x && y == a.getRalativePosition().y)
                {
                    return "Die";
                }
            }

            for(Pharoagh p : pharoaghs)
            {
                if(p.getRalativePosition()!=null && x == p.getRalativePosition().x && y == p.getRalativePosition().y)
                {
                    return "Die";
                }
            }
        }
        else if(Main.gameView instanceof TenComandmentsView)
        {
          ArrayList<TenComandment> stones = ((TenComandmentsView)Main.gameView).getStones();
          for(TenComandment t : stones )
          {
              if(t.getRalativePosition()!=null && t.getRalativePosition().x ==x && t.getRalativePosition().y ==y)
              {
                  t.setNullPosition();
                  ((TenComandmentsView)Main.gameView).setCount(1);
                  if(((TenComandmentsView)Main.gameView).getCount() ==10)
                  {
                      return "Game Over";
                  }
                  else
                  {
                      return "none";
                  }

              }
          }


        }
        return "none";
    }

}
