package com.company;
import javax.swing.*;
import com.company.Sprite.*;
import com.company.GameView.*;
import com.company.Sprite.DisasterViewSprite.Bug;
import com.company.Sprite.DisasterViewSprite.Frog;
import com.company.Sprite.DisasterViewSprite.Ice;
import com.company.Sprite.DisasterViewSprite.Tombstone;
import com.company.Sprite.RedSeaGameViewSprite.Anubis;
import com.company.Sprite.RedSeaGameViewSprite.Cat;
import com.company.Sprite.RedSeaGameViewSprite.Pharoagh;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Main extends JPanel implements KeyListener
{
    public static final int CELL=50; // 每格50px
    public static final int WIDTH=500; //設定寬500px
    public static final int HEIGHT=500; // /設定高500px
    public static final int ROW= HEIGHT/CELL; //設定"行"
    public static final int COLUMN = WIDTH/CELL; //設定"列"


    Moses moses;
    public static GameView gameView;
    private int level;


    public Main()
    {
        level =1;
        resetGame(new DisasterView());
        addKeyListener(this);
    }

    public void resetGame(GameView game)
    {
        moses = new Moses(1,1);
        gameView = game;
        repaint();
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(WIDTH,HEIGHT);
    }
    public void paintComponent(Graphics g)
    {
            gameView.drawView(g);
            moses.draw(g);
            requestFocusInWindow();
    }
    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //設定按X即關閉
        window.setContentPane(new Main()); // 設定Pane的內容為 Main物件
        window.pack(); // 依照視窗自動調整按鈕
        window.setLocationRelativeTo(null); // 設置窗口在螢幕上的位置，null為正中間
        window.setVisible(true); // 設定視窗可見
        window.setResizable(false); //玩家不能改變視窗大小

    }

    private boolean changeLevel( String result)
    {
        if(result.equals("Next level"))
        {
            level++;
            if(level ==2)
            {
                resetGame(new RedSeaGameView());
            }
            else if(level ==3)
            {
                resetGame(new TenComandmentsView());
            }
            return true;
        }
        return false;
    }


    public void keyTyped(KeyEvent e)
    {

    }
    public void keyPressed(KeyEvent e)
    {
        Point mosePoint = moses.getRalativePosition();

        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if(mosePoint.y>1)
                {
                    String result = moses.overlap(mosePoint.x , mosePoint.y-1);
                    if(result.equals("Die"))
                    {
                        level=1;
                        JOptionPane.showMessageDialog(this,"you die. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if(!result.equals("Cannot move"))
                    {
                        mosePoint.y -=1;
                    }
                    if(result.equals("Game Over"))
                    {
                        JOptionPane.showMessageDialog(this, "You win");
                    }
                    if(changeLevel(result))return;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(mosePoint.y< ROW)
                {
                    String result = moses.overlap(mosePoint.x, mosePoint.y+1);
                    if(result.equals("Die"))
                    {
                        level=1;
                        JOptionPane.showMessageDialog(this,"you die. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if(!result.equals("Cannot move"))
                    {
                        mosePoint.y +=1;
                    }
                    if(result.equals("Game Over"))
                    {
                        JOptionPane.showMessageDialog(this,"you win");
                    }
                    if(changeLevel(result))return;
                }
                break;
            case  KeyEvent.VK_RIGHT:
                if(mosePoint.x<COLUMN)
                {
                    String result = moses.overlap(mosePoint.x+1, mosePoint.y);

                    if(result.equals("Die"))
                    {
                        level=1;
                        JOptionPane.showMessageDialog(this,"you die. Please try agian");
                        resetGame(new DisasterView());
                        return;
                    }
                    if(!result.equals("Cannot move")) {
                        mosePoint.x += 1;
                    }
                    if(result.equals("Game Over"))
                    {
                        JOptionPane.showMessageDialog(this, "you win");
                    }
                    if(changeLevel(result))return;
                }
                break;
            case KeyEvent.VK_LEFT:
                if(mosePoint.x>1)
                {
                    String result = moses.overlap(mosePoint.x-1, mosePoint.y);
                    if(result.equals("Die"))
                    {
                        level=1;
                        JOptionPane.showMessageDialog(this,"you die. Please try again");
                        resetGame(new DisasterView());
                        return;
                    }
                    if(!result.equals("Cannot move")) {
                        mosePoint.x -= 1;
                    }
                    if(result.equals("Game Over"))
                    {
                        JOptionPane.showMessageDialog(this, "you win");
                    }
                    if(changeLevel(result))return;
                }
                break;

            case KeyEvent.VK_W:
                for(int i = mosePoint.x;i>0;i--)
                {
                    for(Sprite s : gameView.getElements())
                    {
                        if(s.getRalativePosition()!=null && s.getRalativePosition().x == mosePoint.x && s.getRalativePosition().y == i)
                        {
                            if(s instanceof Cat || s instanceof Ice || s instanceof Tombstone)
                            {
                                return;
                            }
                            if(s instanceof Anubis || s instanceof Pharoagh || s instanceof Bug || s instanceof Frog)
                            {
                                s.setNullPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;
            case KeyEvent.VK_S:
                for(int i = mosePoint.y; i<=ROW; i++)
                {
                    for(Sprite s : gameView.getElements())
                    {
                        if(s.getRalativePosition()!=null && s.getRalativePosition().x == mosePoint.x && s.getRalativePosition().y ==i )
                        {
                            if(s instanceof Cat || s instanceof Ice || s instanceof Tombstone)
                            {
                                return;
                            }
                            if(s instanceof Anubis || s instanceof Pharoagh || s instanceof Bug || s instanceof Frog)
                            {
                                s.setNullPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;
            case KeyEvent.VK_A:
                for(int i = mosePoint.x ; i>0 ;i--)
                {
                    for(Sprite s : gameView.getElements())
                    {
                        if(s.getRalativePosition()!=null && s.getRalativePosition().x == i && s.getRalativePosition().y==mosePoint.y)
                        {
                            if(s instanceof Cat || s instanceof Ice || s instanceof Tombstone)
                            {
                                return;
                            }
                            if(s instanceof Anubis || s instanceof Pharoagh || s instanceof Bug || s instanceof Frog)
                            {
                                s.setNullPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;
            case KeyEvent.VK_D:
                for(int i = mosePoint.x ; i<=COLUMN ; i++)
                {
                    for (Sprite s : gameView.getElements())
                    {
                        if(s.getRalativePosition()!=null && s.getRalativePosition().x == i && s.getRalativePosition().y == mosePoint.y)
                        {
                            if(s instanceof Cat || s instanceof Ice || s instanceof Tombstone)
                            {
                                return;
                            }
                            if(s instanceof Anubis || s instanceof Pharoagh || s instanceof Bug || s instanceof Frog)
                            {
                                s.setNullPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;

        }
        moses.setPosition(mosePoint);
        repaint();
    }
    public void keyReleased(KeyEvent e)
    {

    }
}