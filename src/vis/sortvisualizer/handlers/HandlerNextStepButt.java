package vis.sortvisualizer.handlers;

import java.awt.*;
import vis.sortvisualizer.graphic.Graphic;
import vis.sortvisualizer.handlers.visualize.Move;
import vis.sortvisualizer.handlers.visualize.SortTree;
import java.util.Vector;

/**
 * Created by root on 26.06.17.
 */
public class HandlerNextStepButt extends SortTree {

    public void standartHandle(){
        Vector<Integer> result = new Vector<>();
        int[] safeArr = new int[Graphic.maxElem];
    boolean flag = true;
            for (int i = 1; i< Graphic.numberOfSortedEl; ++i){
        if (Integer.valueOf(Graphic.ourArray[i-1].getText())>Integer.valueOf(Graphic.ourArray[i].getText())){
            flag = false;
            break;}
    }
            if (flag==false) {
        if (Graphic.step == -1) Graphic.step = 0;
        ++Graphic.step;
        for (int i = 0; i < Graphic.maxElem; ++i) {
            safeArr[i] = Graphic.firstSafedArray[i];
        }
        SortTree.stepByStepSort(Graphic.step, result, safeArr);
    } else {
        for (int i = 0; i< Graphic.maxElem; ++i){
            Graphic.sortedEl[i].setForeground(Color.LIGHT_GRAY);
        }

                Graphic.uppSecVisPanel.setData(-5,-5);
                Graphic.uppSecVisPanel.repaint();
                Move.unlock();
                Graphic.nextStepSortButt.setEnabled(false);
                Graphic.prevStepSortButt.setEnabled(false);
    }
    }
}