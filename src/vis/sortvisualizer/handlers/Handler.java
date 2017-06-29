package vis.sortvisualizer.handlers;

import vis.sortvisualizer.handlers.visualize.SortTree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by root on 26.06.17.
 */
public class Handler extends SortTree {


    public static class AnotherSortButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
           HandlerAnotherSortButt handler = new HandlerAnotherSortButt();
           handler.standartHandle();
        }
    }

    public static class GetElButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            HandlerGetElButt handler = new HandlerGetElButt();
            handler.standartHandle();
        }
    }


    public static class RandomButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            HandlerRandomButt handler = new HandlerRandomButt();
            handler.standartHandle();
        }
    }

    public static class nextStepActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            HandlerNextStepButt handler = new HandlerNextStepButt();
            handler.standartHandle();
        }

    }

    public static class prevStepActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            HandlerPrevStepButt handler = new HandlerPrevStepButt();
            handler.standartHandle();
        }

    }
}