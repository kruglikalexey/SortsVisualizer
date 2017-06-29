package vis.sortvisualizer.sorts;

import java.util.Vector;

/**
 * Created by root on 23.06.17.
 */
public class InsertionSort implements Sortable {
    protected int numb;
    protected int[] array;

    public InsertionSort(int n, int[] arr){
        numb = n;
        array = arr;
    }

    @Override
    public void swap(int[] array, int left, int right) {
        int k = 0;
        k = array[left];
        array[left] = array[right];
        array[right] = k;

    }

    @Override
    public Vector<Integer> sort(int step) {
        Vector<Integer> result =new Vector<Integer>();
        int nowStep = 0;
        if (step!=0){
    int j;
    for (int i = 1;i<numb;++i){
         j = i;
        while (j > 0 && array[j-1] > array[j]){

            result.add(j-1);
            result.add(j);
            swap(array,j - 1,j);
            ++nowStep;
            if (nowStep==step) return result;
            --j;

        }

    }}
        return result;
    }
}