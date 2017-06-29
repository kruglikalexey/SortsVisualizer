package vis.sortvisualizer.handlers;

import vis.sortvisualizer.graphic.Graphic;
import vis.sortvisualizer.handlers.visualize.Move;
import vis.sortvisualizer.handlers.visualize.SortTree;

import java.awt.*;
import java.util.Vector;

/**
 * Created by root on 26.06.17.
 */
public class HandlerAnotherSortButt extends SortTree {
    private Vector<Integer> result = new Vector<>();
    private int[] safeArr = new int[Graphic.maxElem];

    public void standartHandle(){
        for (int i = 0; i< Graphic.maxElem; ++i)
            safeArr[i] = Graphic.sortedArray[i];

        switch ((String) Graphic.typeOfSort.getSelectedItem()){
            case "Automatic":
                for (int i = 0; i< Graphic.maxElem; ++i)
                    Graphic.sortedEl[i].setForeground(Color.LIGHT_GRAY);

                SortTree.automaticSort(safeArr,result);
                break;
            case "Step-by-Step":
                Move.lock();
                Graphic.anotherSortButt.setEnabled(true);
                Graphic.step = 1;
                for (int i = 0; i< Graphic.maxElem; ++i){
                    Graphic.firstSafedArray[i] = safeArr[i];
                }
                SortTree.stepByStepSort(Graphic.step,result,safeArr);
                break;
            case "Result":

                Move.unlock();
                for (int i = 0; i < Graphic.maxElem; ++i)
                    Graphic.sortedEl[i].setForeground(Color.lightGray);

                Graphic.step = -1;
                for (int i = 0; i< Graphic.maxElem; ++i){
                    Graphic.firstSafedArray[i] = safeArr[i];
                }
                SortTree.stepByStepSort(Graphic.step,result,safeArr);
                Graphic.nextStepSortButt.setEnabled(false);
                Graphic.prevStepSortButt.setEnabled(false);
                for (int i = 0; i< Graphic.maxElem; ++i){
                    Graphic.sortedEl[i].setForeground(Color.LIGHT_GRAY);
                }

                Graphic.uppSecVisPanel.setData(-5,-5);
                Graphic.uppSecVisPanel.repaint();
                Move.unlock();
                Graphic.nextStepSortButt.setEnabled(false);
                Graphic.prevStepSortButt.setEnabled(false);
                break;
        }

    }
}