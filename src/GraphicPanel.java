import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;



/**
 * Created by root on 23.06.17.
 */
public class GraphicPanel extends JPanel{//это рисует
        Graphics2D g2;
        int xStart = -5;
        int xEnd = -5;

public void setData(int startX,int endX){
        xStart = startX;
        xEnd = endX;
        }

    @Override
protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        g2.setColor(Color.ORANGE);
        xStart += 5;
        xEnd += 5;
        g2.drawLine(xStart,5,xEnd,5);
        g2.drawLine(xStart,5,xStart,10);
        g2.drawLine(xEnd,5,xEnd,10);
        }
};