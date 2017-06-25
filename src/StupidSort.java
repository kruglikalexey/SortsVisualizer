import org.apache.tools.ant.types.resources.Sort;

import java.util.Vector;

/**
 * Created by root on 22.06.17.
 */
public class StupidSort implements Sortable{
    protected int numb;
    protected int[] array;

    StupidSort(int numberOfEl,int[] arr){
        numb = numberOfEl;
        array = arr;
    }

    @Override
    public Vector<Integer> sort(int step) {
        int nowStep = 0;
        Vector<Integer> result = new Vector<Integer>();

        int flag = 0;
        int k = 0;
        if (step!=0){

        while (flag!=(numb-1)){
            if (array[flag]>array[flag+1]){
                result.add(flag);
                result.add(flag+1);
                swap(array,flag,flag+1);
                ++nowStep;
                if (nowStep==step) return result;
                flag = 0;
            } else ++flag;
        }}
        return result;
    }

    @Override
    public void swap(int[] array, int left, int right) {
        int k = 0;
        k  = array[left];
        array[left] = array[right];
        array[right] = k;
    }
}
