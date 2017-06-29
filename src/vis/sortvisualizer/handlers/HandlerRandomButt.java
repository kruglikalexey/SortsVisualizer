package vis.sortvisualizer.handlers;

import vis.sortvisualizer.graphic.Graphic;

import java.util.Random;

/**
 * Created by root on 26.06.17.
 */
public class HandlerRandomButt {
    public void standartHandle(){
        Random random = new Random();
        Integer numb = Graphic.maxElem;

        for (int i = 0; i< Graphic.maxElem; ++i){
            Graphic.ourArray[i].setText("");
            Graphic.sortedEl[i].setValue(Graphic.minRange);
            Graphic.sortedEl[i].setVisible(true);
            Graphic.sortedEl[i].setString("");
        }

        try {
            numb = Integer.valueOf(Graphic.numbOfElement.getText());
        }catch (NumberFormatException e) {
            Graphic.numbOfElement.setText("Неверный формат строки");
            numb=0;
        }
        if (numb> Graphic.maxElem) {
            numb = Graphic.maxElem;
            Graphic.numbOfElement.setText(Integer.toString(Graphic.maxElem));
        } else if (numb<0){ Graphic.numbOfElement.setText(Integer.toString(0));
            numb = 0;}
        Graphic.numberOfSortedEl = numb;
        Integer sch = 0;

        for (Integer i = 0;i<numb;++i){
            sch = random.nextInt(Graphic.maxRange);
            Graphic.sortedEl[i].setValue(sch);
            Graphic.sortedArray[i] = sch;
            Graphic.sortedEl[i].setString(sch.toString());
            Graphic.ourArray[i].setText(sch.toString());
        }
        //расскомментировать, при необходимости
        //for (int i = numb;i<maxElem;++i)
        //    sortedEl[i].setVisible(false);
    }
}