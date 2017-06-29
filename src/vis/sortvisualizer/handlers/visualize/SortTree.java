package vis.sortvisualizer.handlers.visualize;

import vis.sortvisualizer.sorts.*;
import vis.sortvisualizer.graphic.Graphic;
import vis.sortvisualizer.sorts.*;
import java.util.Vector;

/**
 * Created by root on 26.06.17.
 */
public class SortTree extends Move {

    public static void automaticSort(int[] safeArr, Vector<Integer> result){
        Graphic.nextStepSortButt.setEnabled(false);
        Graphic.prevStepSortButt.setEnabled(false);

        String choiceSort = (String) Graphic.sortBox.getSelectedItem();

        switch (choiceSort) {
            case "MergeSort":
                MergeSort merge = new MergeSort(Graphic.numberOfSortedEl, safeArr);
                result = merge.sort(-1);
                moveNotChoiceSort(result);
                break;
            case "ShellSort":
                ShellSort shell = new ShellSort(Graphic.numberOfSortedEl,safeArr);
                result = shell.sort(-1);
                moveNotChoiceSort(result);
                break;
            case  "SelectionSort":
                SelectionSort sel = new SelectionSort(Graphic.numberOfSortedEl,safeArr);
                result = sel.sort(-1);
                move(result);
                break;
            case "InsertionSort":
                InsertionSort ins = new InsertionSort(Graphic.numberOfSortedEl,safeArr);
                result = ins.sort(-1);
                move(result);
                break;
            case "BubbleSort":
                BubbleSort bubSort = new BubbleSort(Graphic.numberOfSortedEl, safeArr);
                result = bubSort.sort(-1);
                move(result);
                break;
            case "QuickSort":
                QuickSort quickSortt = new QuickSort(Graphic.numberOfSortedEl,safeArr);
                result = quickSortt.sort(-1);
                move(result);
                break;
            case "ShakerSort":
                ShakerSort shakeSort = new ShakerSort(Graphic.numberOfSortedEl,safeArr);
                result = shakeSort.sort(-1);
                move(result);
                break;
            case "StupidSort":
                StupidSort stupSort = new StupidSort(Graphic.numberOfSortedEl,safeArr);
                result = stupSort.sort(-1);
                move(result);
                break;
        }

    }

    protected static void stepByStepSort(int step, Vector<Integer> result, int[] safeArr){
        Graphic.nextStepSortButt.setEnabled(true);
        Graphic.prevStepSortButt.setEnabled(true);


        String choiceSort = (String) Graphic.sortBox.getSelectedItem();
        for (int i = 0; i< Graphic.maxElem; ++i){
            safeArr[i] = Graphic.firstSafedArray[i];
        }

        switch (choiceSort) {
            case "MergeSort":
                MergeSort merge = new MergeSort(Graphic.numberOfSortedEl, safeArr);
                result = merge.sort(step);
                moveNotChoiceSortStepByStep(result, Graphic.firstSafedArray);
                break;
            case "ShellSort":
                ShellSort shell = new ShellSort(Graphic.numberOfSortedEl,safeArr);
                result = shell.sort(step);
                moveNotChoiceSortStepByStep(result, Graphic.firstSafedArray);
                break;
            case  "SelectionSort":
                SelectionSort sel = new SelectionSort(Graphic.numberOfSortedEl,safeArr);
                result = sel.sort(step);
                moveNextStep(result, Graphic.firstSafedArray);
                break;
            case "InsertionSort":
                InsertionSort ins = new InsertionSort(Graphic.numberOfSortedEl,safeArr);
                result = ins.sort(step);
                moveNextStep(result, Graphic.firstSafedArray);
                break;
            case "BubbleSort":
                BubbleSort bubSort = new BubbleSort(Graphic.numberOfSortedEl, safeArr);
                result = bubSort.sort(step);
                moveNextStep(result, Graphic.firstSafedArray);
                break;
            case "QuickSort":
                QuickSort quickSortt = new QuickSort(Graphic.numberOfSortedEl,safeArr);
                result = quickSortt.sort(step);
                moveNextStep(result, Graphic.firstSafedArray);
                break;
            case "ShakerSort":
                ShakerSort shakeSort = new ShakerSort(Graphic.numberOfSortedEl,safeArr);
                result = shakeSort.sort(step);
                moveNextStep(result, Graphic.firstSafedArray);
                break;
            case "StupidSort":
                StupidSort stupSort = new StupidSort(Graphic.numberOfSortedEl,safeArr);
                result = stupSort.sort(step);
                moveNextStep(result, Graphic.firstSafedArray);
                break;
        }

    }
}
