import java.util.Vector;

/**
 * Created by root on 22.06.17.
 */
public class BubbleSort implements Sortable {
    protected int numb;
    protected int[] array;

    BubbleSort(int n,int[] arr){
        numb = n;
        array = arr;
    }

    @Override
    public Vector<Integer> sort(int step){
        int nowStep=0;
        Vector<Integer> result = new Vector<Integer>();
        if (step!=0) {
            for (Integer i = numb - 1; i >= 0; i--)
                for (Integer j = 0; j < i; ++j)
                    if (array[j] > array[j + 1]) {
                        swap(array, j, j + 1);
                        result.add(j);
                        result.add(j + 1);
                        ++nowStep;
                        if (nowStep == step) return result;

                    }
        }
        return result;
    }

    @Override
    public void swap(int[] array,int left,int right) {
        int k = 0;
        k = array[left];
        array[left] = array[right];
        array[right] = k;

    }
}
