import java.util.Vector;

/**
 * Created by root on 22.06.17.
 */
public interface Sortable {
    Vector<Integer> sort(int step);
    void swap(int[] array, int left, int right);
}
