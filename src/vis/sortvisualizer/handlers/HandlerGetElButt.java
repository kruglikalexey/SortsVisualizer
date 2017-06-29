package vis.sortvisualizer.handlers;

import vis.sortvisualizer.graphic.Graphic;

/**
 * Created by root on 26.06.17.
 */
public class HandlerGetElButt {
    private Integer numb = Graphic.maxElem, el = 0;

    public void standartHandle(){
        for (int i = 0; i < Graphic.maxElem; ++i) {
            Graphic.sortedEl[i].setValue(Graphic.minRange);
            Graphic.sortedEl[i].setVisible(true);
            Graphic.sortedEl[i].setString("");
        }

        try {
            numb = Integer.valueOf(Graphic.numbOfElement.getText());
        } catch (NumberFormatException e) {
            Graphic.numbOfElement.setText("Неверный формат строки");
            numb = 0;
        }
        if (numb > Graphic.maxElem) {
            numb = Graphic.maxElem;
            Graphic.numbOfElement.setText(Integer.toString(Graphic.maxElem));
        }
        Graphic.numberOfSortedEl = numb;

        for (Integer i = 0; i < numb; ++i) {
            Graphic.sortedArray[i] = 0;
            try {
                el = Integer.valueOf(Graphic.ourArray[i].getText());
            } catch (NumberFormatException e) {
                Graphic.numbOfElement.setText("Неверный формат элементов");
                return;
            }
            if (el > Graphic.maxRange) {
                el = Graphic.maxRange;
                Graphic.ourArray[i].setText(Integer.toString(Graphic.maxRange));
            } else if (el< Graphic.minRange){
                el = Graphic.minRange;
                Graphic.ourArray[i].setText(Integer.toString(Graphic.minRange));
            }
            Graphic.sortedArray[i] = el;
        }

        for (int i = numb; i < Graphic.maxElem; ++i)
            Graphic.ourArray[i].setText("");

        for (Integer i = 0; i < numb; ++i) {
            Graphic.sortedEl[i].setString(Integer.toString(Graphic.sortedArray[i]));
            Graphic.sortedEl[i].setValue(Graphic.sortedArray[i]);
        }
        //расскоментировать при необходимости
        //for (int i = numb;i<=maxElem;++i)
        //    sortedEl[i].setVisible(false);
    }
}