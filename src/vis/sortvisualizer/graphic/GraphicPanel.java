package vis.sortvisualizer.graphic;

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
        int dis = 5;

public void setData(int startX,int endX){
        xStart = startX;
        xEnd = endX;
        }

    @Override
protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        g2.setColor(Color.ORANGE);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(xStart+dis,5,xEnd+dis,5);
        g2.drawLine(xStart+dis,5,xStart+dis,10);
        g2.drawLine(xEnd+dis,5,xEnd+dis,10);
        }
};