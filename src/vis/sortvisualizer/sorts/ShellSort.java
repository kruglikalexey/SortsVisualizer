package vis.sortvisualizer.sorts;

import java.util.Vector;

/**
 * Created by root on 22.06.17.
 */
public class ShellSort implements Sortable {
    protected int numb;
    protected int[] array;

    public ShellSort(int n, int[] arr){
        numb = n;
        array = arr;
    }

    @Override
    public Vector<Integer> sort(int step) {
        int nowStep = 0;
        Vector<Integer> result = new Vector<Integer>();

        int flag = 0,i=0,t=0,j = 0;
        if (step!=0){

        for (flag = numb;flag>0;flag/=2) {
            for (i = flag;i<numb;++i){
                t = array[i];
                for (j = i; j >= flag && t < array[j - flag]; j -= flag){
                    result.add(array[j-flag]);
                    result.add(j);
                    array[j] = array[j-flag];
                }
                result.add(t);
                result.add(j);
                array[j]=t;
                ++nowStep;
                if (nowStep==step) return result;
            }

        }}

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
