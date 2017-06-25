import java.util.Vector;

/**
 * Created by root on 22.06.17.
 */
public class SelectionSort implements Sortable {
    protected int numb;
    protected int[] array;

    SelectionSort(int n,int[] arr){
        numb = n;
        array = arr;
    }

    @Override
    public Vector<Integer> sort(int step) {
        int nowStep = 0;
        Vector<Integer> result = new Vector<Integer>();
if (step!=0) {
    for (int i = 0; i < numb - 1; ++i) {
        int least = i;
        for (int j = i + 1; j < numb; j++) {
            if (array[j] < array[least]) {
                least = j;
            }
        }
        result.add(i);
        result.add(least);
        swap(array, i, least);
        ++nowStep;
        if (nowStep == step) return result;
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
