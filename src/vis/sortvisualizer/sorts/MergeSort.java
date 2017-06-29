package vis.sortvisualizer.sorts;

import java.util.Vector;

/**
 * Created by root on 22.06.17.
 */
public class MergeSort implements Sortable {
    protected int numb;
    protected int[] array;
    protected int[] buffer;

    public MergeSort(int n, int[] arr){
        numb = n;
        array = arr;
        buffer = new int[n];
    }

    private void  merge(int left,int right,Vector<Integer> result,int step,int nowStep){
        if (nowStep==step) return;
        if (left==right) return;

        if ((right - left)==1) {
            if (array[left]>array[right]){
            result.add(array[right]);
            result.add(left);
                ++nowStep;
                if (nowStep==step) return;
            result.add(array[left]);
            result.add(right);
                ++nowStep;
                if (nowStep==step) return;

            swap(array,left,right);
            return;}
        }

        int middle = (left+right)/2;

        merge(left,middle,result,step,nowStep);
        merge(middle+1,right,result,step,nowStep);

        int xLeft = left;
        int xRight = middle+1;
        int current = 0;


        while ((right-left+1)!=current){
            if (xLeft>middle){
                buffer[current++] = array[xRight++];
            } else if (xRight>right){
                buffer[current++] = array[xLeft++];
            } else if (array[xLeft]>array[xRight]){
                buffer[current++] = array[xRight++];
            } else {
                buffer[current++] = array[xLeft++];
            }
        }

        for (int i = 0; i<current;++i){
            result.add(buffer[i]);
            result.add(left+i);
            array[left+i] = buffer[i];
            ++nowStep;
            if (nowStep==step) return;
        }

        return;

    }

    @Override
    public Vector<Integer> sort(int step) {
        Vector<Integer> result = new Vector<Integer>();
        if (step!=0){
        merge(0,numb-1,result,step,0);}

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