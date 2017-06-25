import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Vector;

/**
 * Created by root on 22.06.17.
 */
public class QuickSort implements Sortable {
    protected int numb;
    protected int[] array;

    QuickSort(int n,int[] arr){
        numb = n;
        array = arr;
    }

    public void QuickSort(int left, int right,Vector<Integer> result,int step,int nowStep){

        if (nowStep==step) return;

        int middle = array[(left+right)/2];
        int k = 0;
        int i = left;
        int j = right;

        while (i<=j){

            while (array[i]<middle) ++i;
            while (array[j]>middle) --j;

            if (i<=j){
                result.add(i);
                result.add(j);
               swap(array,i,j);
               ++nowStep;
               if (nowStep==step) return;
                ++i;
                --j;
            }

        }

        if (i<right) QuickSort(i,right,result,step,nowStep);
        if (left<j) QuickSort(left,j,result,step,nowStep);
        return;

    }

    @Override
    public Vector<Integer> sort(int step) {
        Vector<Integer> result = new Vector<Integer>();
        if (step!=0){
        QuickSort(0,numb-1,result,step,0);}
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
