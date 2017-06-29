package vis.sortvisualizer.handlers.visualize;

import vis.sortvisualizer.graphic.Graphic;

import java.awt.*;
import java.util.Vector;

/**
 * Created by root on 26.06.17.
 */
public class Move {
    protected static void lock(){
        Graphic.anotherSortButt.setEnabled(false);
        Graphic.getButt.setEnabled(false);
        Graphic.randomButt.setEnabled(false);
        Graphic.sortBox.setEnabled(false);
        for (int i = 0; i< Graphic.maxElem; ++i)
            Graphic.ourArray[i].setEnabled(false);

    }

    protected static void unlock(){
        Graphic.anotherSortButt.setEnabled(true);
        Graphic.getButt.setEnabled(true);
        Graphic.randomButt.setEnabled(true);
        Graphic.sortBox.setEnabled(true);
        for (int i = 0; i< Graphic.maxElem; ++i)
            Graphic.ourArray[i].setEnabled(true);

    }

    protected static void move(Vector<Integer> result) {
        Thread myThready = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    lock();
                    int k = 0;
                    int flag = 1;
                    Integer j = 0;

                    for (Integer i : result) {
                        if (flag % 2 == 0) {
                            Graphic.uppSecVisPanel.setData(i * Graphic.lengthElem, j * Graphic.lengthElem);
                            Graphic.uppSecVisPanel.repaint();
                            ++flag;
                            try {
                                Thread.sleep(Graphic.speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                            Graphic.sortedEl[j].setForeground(Color.green);
                            try {
                                Thread.sleep(Graphic.speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            Graphic.sortedEl[i].setForeground(Color.green);
                            try {
                                Thread.sleep(Graphic.speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            k = Graphic.sortedArray[j];

                            Graphic.sortedArray[j] = Graphic.sortedArray[i];
                            try {
                                Thread.sleep(Graphic.speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            Graphic.sortedArray[i] = k;
                            Graphic.sortedEl[j].setValue(Graphic.sortedArray[j]);
                            Graphic.sortedEl[j].setString(Integer.toString(Graphic.sortedArray[j]));
                            Graphic.sortedEl[i].setValue(Graphic.sortedArray[i]);
                            Graphic.sortedEl[i].setString(Integer.toString(Graphic.sortedArray[i]));

                            Graphic.ourArray[j].setText(Integer.toString(Graphic.sortedArray[j]));
                            Graphic.ourArray[i].setText(Integer.toString(Graphic.sortedArray[i]));
                            Graphic.sortedEl[j].setForeground(Color.blue);
                            try {
                                Thread.sleep(Graphic.speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            Graphic.sortedEl[i].setForeground(Color.blue);
                        } else {
                            j = i;
                            ++flag;
                        }
                    }
                }
                for (int i = 0; i < Graphic.maxElem; ++i) {
                    Graphic.sortedEl[i].setForeground(Color.RED);
                    try {
                        Thread.sleep(Graphic.speedB);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < Graphic.maxElem; ++i) {
                    Graphic.sortedEl[i].setForeground(Color.cyan);
                    try {
                        Thread.sleep(Graphic.speedB);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < Graphic.maxElem; ++i) {
                    Graphic.sortedEl[i].setForeground(Color.lightGray);
                    try {
                        Thread.sleep(Graphic.speedB);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                unlock();
                Graphic.uppSecVisPanel.setData(-5, -5);
                Graphic.uppSecVisPanel.repaint();
            }
        });
        myThready.start();
    }



    public static void moveNextStep(Vector<Integer> result, int[] arr) {

        int k = 0;
        int flag = 1;
        Integer j = 0;

        for (int i = 0; i < Graphic.numberOfSortedEl; ++i) {
            Graphic.sortedArray[i] = arr[i];
            Graphic.sortedEl[i].setValue(arr[i]);
            Graphic.sortedEl[i].setString(Integer.toString(arr[i]));
            Graphic.ourArray[i].setText(Integer.toString(arr[i]));
            Graphic.sortedEl[i].setForeground(Color.BLUE);

        }

        for (Integer i : result) {
            if (flag % 2 == 0) {
                Graphic.uppSecVisPanel.setData(i * Graphic.lengthElem, j * Graphic.lengthElem);
                Graphic.uppSecVisPanel.repaint();
                ++flag;
                Graphic.sortedEl[j].setForeground(Color.green);
                Graphic.sortedEl[i].setForeground(Color.green);

                k = Graphic.sortedArray[j];
                Graphic.sortedArray[j] = Graphic.sortedArray[i];
                Graphic.sortedArray[i] = k;
                Graphic.sortedEl[j].setValue(Graphic.sortedArray[j]);
                Graphic.sortedEl[j].setString(Integer.toString(Graphic.sortedArray[j]));
                Graphic.sortedEl[i].setValue(Graphic.sortedArray[i]);
                Graphic.sortedEl[i].setString(Integer.toString(Graphic.sortedArray[i]));
                Graphic.ourArray[j].setText(Integer.toString(Graphic.sortedArray[j]));
                Graphic.ourArray[i].setText(Integer.toString(Graphic.sortedArray[i]));
                Graphic.sortedEl[j].setForeground(Color.blue);
                Graphic.sortedEl[i].setForeground(Color.blue);
            } else {
                j = i;
                ++flag;
            }
        }


        Graphic.sortedEl[j].setForeground(Color.green);
        if (result.size()>=1){
            Graphic.sortedEl[result.get(result.size() - 1)].setForeground(Color.green);}
    }

    public static void moveNotChoiceSortStepByStep(Vector<Integer> result,int[] arr) {
        int k = 0;
        int flag = 1;
        Integer j = 0;

        for (int i = 0; i < Graphic.numberOfSortedEl; ++i) {
            Graphic.sortedArray[i] = arr[i];
            Graphic.sortedEl[i].setValue(arr[i]);
            Graphic.sortedEl[i].setString(Integer.toString(arr[i]));
            Graphic.ourArray[i].setText(Integer.toString(arr[i]));
            Graphic.sortedEl[i].setForeground(Color.BLUE);

        }

        for (Integer i : result) {
            if (flag % 2 == 0) {
                ++flag;
                Graphic.sortedEl[i].setForeground(Color.green);
                Graphic.sortedArray[i] = j;
                Graphic.sortedEl[i].setValue(j);
                Graphic.sortedEl[i].setString(Integer.toString(j));
                Graphic.ourArray[i].setText(Integer.toString(j));
                Graphic.sortedEl[i].setForeground(Color.blue);

            } else {
                j = i;
                ++flag;
            }
        }
        if (result.size()>1){
            Graphic.sortedEl[result.get(result.size() - 1)].setForeground(Color.green);
            }
    }


    public static void moveNotChoiceSort(Vector<Integer> result){
        Thread mySecondThready = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    lock();
                    int k = 0;
                    int flag = 1;
                    Integer j = 0;

                    for (Integer i : result) {
                        if (flag%2==0){
                            ++flag;
                            try {
                                Thread.sleep(Graphic.speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            Graphic.sortedEl[i].setForeground(Color.green);
                            try {
                                Thread.sleep(Graphic.speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                            Graphic.sortedArray[i] = j;
                            Graphic.sortedEl[i].setValue(j);
                            Graphic.sortedEl[i].setString(Integer.toString(j));
                            Graphic.ourArray[i].setText(Integer.toString(j));

                            try {
                                Thread.sleep(Graphic.speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            Graphic.sortedEl[i].setForeground(Color.blue);
                            try {
                                Thread.sleep(Graphic.speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        } else {j = i;
                            ++flag;}}
                }
                for (int i = 0; i < Graphic.maxElem; ++i){
                    Graphic.sortedEl[i].setForeground(Color.RED);
                    try {
                        Thread.sleep(Graphic.speedB);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }}

                for (int i = 0; i < Graphic.maxElem; ++i){
                    Graphic.sortedEl[i].setForeground(Color.cyan);
                    try {
                        Thread.sleep(Graphic.speedB);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }}
                for (int i = 0; i < Graphic.maxElem; ++i){
                    Graphic.sortedEl[i].setForeground(Color.lightGray);
                    try {

                        Thread.sleep(Graphic.speedB);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }}
                unlock();

            }

        }); mySecondThready.start();
    }
}