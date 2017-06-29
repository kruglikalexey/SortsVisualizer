package vis.sortvisualizer.sorts;

import java.util.Vector;

/**
 * Created by root on 22.06.17.
 */
public class ShakerSort implements Sortable {
    protected int numb;
    protected int[] array;

    public ShakerSort(int n, int[] arr){
        numb = n;
        array = arr;
    }

    @Override
    public Vector<Integer> sort(int step){
        int nowStep = 0;
        Vector<Integer> result = new Vector<Integer>();
        int left = 0;
        int right = numb - 1;
        if (step!=0) {
            while (left <= right) {
                for (int i = left; i < right; ++i) {
                    if (array[i] > array[i + 1]) {
                        result.add(i);
                        result.add(i + 1);
                        swap(array, i, i + 1);
                        ++nowStep;
                        if (nowStep == step) return result;
                    }
                }
                --right;

                for (int i = right; i > left; --i) {
                    if (array[i - 1] > array[i]) {
                        result.add(i - 1);
                        result.add(i);
                        swap(array, i - 1, i);
                        ++nowStep;
                        if (nowStep == step) return result;
                    }
                }
                left++;
            }
        }

        return result;
    }

    @Override
    public void swap(int[] array, int left, int right) {
        int k = 0;
        k = array[left];
        array[left] = array[right];
        array[right] = k;

    }
}
