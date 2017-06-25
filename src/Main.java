import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

/**
 * Created by root on 21.06.17.
 */
public class Main {

    static int numberOfSortedEl;
    static final int speed = 5;
    static final int speedB = 5;
    static final int maxElem = 30;
    static final int minRange = 0;
    static final int maxRange = 1000;
    static final int height = 600;
    static final int width = 400;
    static final int lengthElem = 20;
    static int step = 1;
    static JFrame mainWindow = new JFrame();
    static JPanel visualizePanel = new JPanel();
    static JPanel secVisPanel = new JPanel();
    static GraphicPanel uppSecVisPanel = new GraphicPanel();

    static JPanel centerSecVisPanel = new JPanel();

    static JPanel firstVisPanel = new JPanel();
    static JPanel secondWorkPanel = new JPanel();
    static JPanel thirdWorkPanel = new JPanel();
    static JPanel fourWorkPanel = new JPanel();
    static JPanel fiveWorkPanel = new JPanel();
    static JPanel sixWorkPanel = new JPanel();
    static JPanel workPanel = new JPanel();
    static JPanel upperPanel = new JPanel();
    static JTextField numbOfElement = new JTextField(2);
    static JTextField[] ourArray = new JTextField[maxElem];
    static JProgressBar[] sortedEl = new JProgressBar[maxElem];
    static int[] sortedArray = new int[maxElem];
    static JButton anotherSortButt = new JButton("Sort");
    static JButton nextStepSortButt = new JButton(">");
    static JButton prevStepSortButt = new JButton("<");
    static JComboBox<String> typeOfSort = new JComboBox<String>();
    static JComboBox<String> sortBox = new JComboBox<String>();
    static int[] firstSafedArray = new int[maxElem];
    static JButton randomButt = new JButton("random");
    static JButton getButt = new JButton("get");


    public static void main(String[] args) {
        mainWindow.setSize(height, width);
        mainWindow.setTitle("Shaker Sort Visualizer");

        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setMaximumSize(new Dimension(height, width));
        mainWindow.setMinimumSize(new Dimension(height, width));
        mainWindow.setResizable(false);

        mainWindow.setLayout(new BorderLayout());
        workPanel.setLayout(new GridLayout());
        workPanel.setBackground(Color.LIGHT_GRAY);
        visualizePanel.setBackground(Color.black);


        sortBox.addItem("ShakerSort");
        sortBox.addItem("MergeSort");
        sortBox.addItem("ShellSort");
        sortBox.addItem("SelectionSort");
        sortBox.addItem("InsertionSort");
        sortBox.addItem("BubbleSort");
        sortBox.addItem("QuickSort");
        sortBox.addItem("StupidSort");

        typeOfSort.addItem("Automatic");
        typeOfSort.addItem("Step-by-Step");
        typeOfSort.addItem("Result");
        nextStepSortButt.setEnabled(false);
        prevStepSortButt.setEnabled(false);

        anotherSortButt.addActionListener(new AnotherSortButtonActionListener());
        nextStepSortButt.addActionListener(new nextStepActionListener());
        prevStepSortButt.addActionListener(new prevStepActionListener());
        centerSecVisPanel.setLayout(new BorderLayout());
        centerSecVisPanel.add(secVisPanel, BorderLayout.CENTER);
        centerSecVisPanel.add(uppSecVisPanel, BorderLayout.PAGE_START);
        secVisPanel.setLayout(new GridLayout());

        getButt.addActionListener(new GetElButtonActionListener());
        randomButt.addActionListener(new RandomButtonActionListener());
        JLabel enterNumbOfEl = new JLabel(" Please enter number of elements: ");


        workPanel.add(getButt);
        workPanel.add(randomButt);
        secVisPanel.add(prevStepSortButt);

        for (int i = 0; i < maxElem; ++i) {
            ourArray[i] = new JTextField(3);
            sortedEl[i] = new JProgressBar();
            sortedEl[i].setMinimum(minRange);
            sortedEl[i].setMaximum(maxRange);
            sortedEl[i].setValue(minRange);
            sortedEl[i].setOrientation(JProgressBar.VERTICAL);
            secVisPanel.add(sortedEl[i]);
        }
        secVisPanel.add(nextStepSortButt);
        visualizePanel.setLayout(new BoxLayout(visualizePanel, BoxLayout.PAGE_AXIS));
        visualizePanel.add(centerSecVisPanel);

        JLabel enterArrEl = new JLabel(" If you dont want random data, please enter elements: ");
        firstVisPanel.setLayout(new BorderLayout());
        secondWorkPanel.setLayout(new BorderLayout());
        thirdWorkPanel.setLayout(new BorderLayout());
        fourWorkPanel.setLayout(new BorderLayout());
        fiveWorkPanel.setLayout(new FlowLayout());
        sixWorkPanel.setLayout(new BorderLayout());
        sixWorkPanel.add(fiveWorkPanel);
        fourWorkPanel.add(sixWorkPanel, BorderLayout.CENTER);
        thirdWorkPanel.add(fourWorkPanel, BorderLayout.CENTER);
        secondWorkPanel.add(thirdWorkPanel, BorderLayout.CENTER);
        firstVisPanel.add(secondWorkPanel, BorderLayout.CENTER);

        for (int i = 0; i < maxElem; ++i)
            fiveWorkPanel.add(ourArray[i]);

        thirdWorkPanel.add(enterNumbOfEl, BorderLayout.NORTH);
        fourWorkPanel.add(numbOfElement, BorderLayout.NORTH);
        sixWorkPanel.add(enterArrEl, BorderLayout.NORTH);
        visualizePanel.add(firstVisPanel, BorderLayout.CENTER);


        JLabel upper = new JLabel("          visualization: ");
        upperPanel.setLayout(new GridLayout());
        upperPanel.setBackground(Color.LIGHT_GRAY);
        upperPanel.add(sortBox);
        upperPanel.add(prevStepSortButt);
        upperPanel.add(typeOfSort);
        upperPanel.add(nextStepSortButt);
        upperPanel.add(anotherSortButt);
        mainWindow.add(visualizePanel, BorderLayout.CENTER);
        mainWindow.add(workPanel, BorderLayout.SOUTH);
        mainWindow.add(upperPanel, BorderLayout.NORTH);
        mainWindow.setVisible(true);

    }


    public static void move(Vector<Integer> result) {


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
                            uppSecVisPanel.setData(i * lengthElem, j * lengthElem);
                            uppSecVisPanel.repaint();
                            ++flag;
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                            sortedEl[j].setForeground(Color.green);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            sortedEl[i].setForeground(Color.green);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            k = sortedArray[j];

                            sortedArray[j] = sortedArray[i];
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            sortedArray[i] = k;
                            sortedEl[j].setValue(sortedArray[j]);
                            sortedEl[i].setValue(sortedArray[i]);
                            ourArray[j].setText(Integer.toString(sortedArray[j]));
                            ourArray[i].setText(Integer.toString(sortedArray[i]));
                            sortedEl[j].setForeground(Color.blue);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            sortedEl[i].setForeground(Color.blue);
                        } else {
                            j = i;
                            ++flag;
                        }
                    }
                }
                for (int i = 0; i < maxElem; ++i) {
                    sortedEl[i].setForeground(Color.RED);
                    try {
                        Thread.sleep(speedB);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < maxElem; ++i) {
                    sortedEl[i].setForeground(Color.cyan);
                    try {
                        Thread.sleep(speedB);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < maxElem; ++i) {
                    sortedEl[i].setForeground(Color.lightGray);
                    try {
                        Thread.sleep(speedB);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                unlock();
                uppSecVisPanel.setData(-5, -5);
                uppSecVisPanel.repaint();
            }
        });
        myThready.start();


    }

    public static void moveNextStep(Vector<Integer> result, int[] arr) {

        int k = 0;
        int flag = 1;
        Integer j = 0;

        for (int i = 0; i < numberOfSortedEl; ++i) {
            sortedArray[i] = arr[i];
            sortedEl[i].setValue(arr[i]);
            ourArray[i].setText(Integer.toString(arr[i]));
            sortedEl[i].setForeground(Color.BLUE);

        }

        for (Integer i : result) {
            if (flag % 2 == 0) {
                uppSecVisPanel.setData(i * lengthElem, j * lengthElem);
                uppSecVisPanel.repaint();
                ++flag;
                sortedEl[j].setForeground(Color.green);
                sortedEl[i].setForeground(Color.green);

                k = sortedArray[j];
                sortedArray[j] = sortedArray[i];
                sortedArray[i] = k;
                sortedEl[j].setValue(sortedArray[j]);
                sortedEl[i].setValue(sortedArray[i]);
                ourArray[j].setText(Integer.toString(sortedArray[j]));
                ourArray[i].setText(Integer.toString(sortedArray[i]));
                for (int p = 0; p < numberOfSortedEl; ++p) {
                    System.out.println(sortedArray[p]);
                }

                sortedEl[j].setForeground(Color.blue);
                sortedEl[i].setForeground(Color.blue);
            } else {
                j = i;
                ++flag;
            }
        }


        sortedEl[j].setForeground(Color.green);
        sortedEl[result.get(result.size() - 1)].setForeground(Color.green);
    }

    public static void moveNotChoiceSortStepByStep(Vector<Integer> result,int[] arr) {
            int k = 0;
            int flag = 1;
            Integer j = 0;

        for (int i = 0; i < numberOfSortedEl; ++i) {
            sortedArray[i] = arr[i];
            sortedEl[i].setValue(arr[i]);
            ourArray[i].setText(Integer.toString(arr[i]));
            sortedEl[i].setForeground(Color.BLUE);

        }

            for (Integer i : result) {
                if (flag % 2 == 0) {
                    ++flag;
                    sortedEl[i].setForeground(Color.green);
                    sortedArray[i] = j;
                    sortedEl[i].setValue(j);
                    ourArray[i].setText(Integer.toString(j));
                    sortedEl[i].setForeground(Color.blue);

                } else {
                    j = i;
                    ++flag;
                }
            }
        sortedEl[result.get(result.size() - 1)].setForeground(Color.green);
        sortedEl[result.get(result.size() - 2)].setForeground(Color.green);
    }


    private static void lock(){
        anotherSortButt.setEnabled(false);
        getButt.setEnabled(false);
        randomButt.setEnabled(false);
        for (int i = 0;i<maxElem;++i)
            ourArray[i].setEnabled(false);

    }

    private static void unlock(){
        anotherSortButt.setEnabled(true);
        getButt.setEnabled(true);
        randomButt.setEnabled(true);
        for (int i = 0;i<maxElem;++i)
            ourArray[i].setEnabled(true);

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
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            sortedEl[i].setForeground(Color.green);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                            sortedArray[i] = j;
                            sortedEl[i].setValue(j);
                            ourArray[i].setText(Integer.toString(j));

                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            sortedEl[i].setForeground(Color.blue);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        } else {j = i;
                            ++flag;}}
                }
                for (int i = 0; i < maxElem; ++i){
                    sortedEl[i].setForeground(Color.RED);
                    try {
                        Thread.sleep(speedB);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }}

                for (int i = 0; i < maxElem; ++i){
                    sortedEl[i].setForeground(Color.cyan);
                    try {
                        Thread.sleep(speedB);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }}
                for (int i = 0; i < maxElem; ++i){
                    sortedEl[i].setForeground(Color.lightGray);
                    try {

                        Thread.sleep(speedB);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }}
               unlock();

            }

        }); mySecondThready.start();


    }


    public static void automaticSort(int[] safeArr, Vector<Integer> result){
        nextStepSortButt.setEnabled(false);
        prevStepSortButt.setEnabled(false);

        String choiceSort = (String) sortBox.getSelectedItem();

        switch (choiceSort) {
            case "MergeSort":
                MergeSort merge = new MergeSort(numberOfSortedEl, safeArr);
                result = merge.sort(-1);
                moveNotChoiceSort(result);
                break;
            case "ShellSort":
                ShellSort shell = new ShellSort(numberOfSortedEl,safeArr);
                result = shell.sort(-1);
                moveNotChoiceSort(result);
                break;
            case  "SelectionSort":
                SelectionSort sel = new SelectionSort(numberOfSortedEl,safeArr);
                result = sel.sort(-1);
                move(result);
                break;
            case "InsertionSort":
                InsertionSort ins = new InsertionSort(numberOfSortedEl,safeArr);
                result = ins.sort(-1);
                move(result);
                break;
            case "BubbleSort":
                BubbleSort bubSort = new BubbleSort(numberOfSortedEl, safeArr);
                result = bubSort.sort(-1);
                move(result);
                break;
            case "QuickSort":
                QuickSort quickSortt = new QuickSort(numberOfSortedEl,safeArr);
                result = quickSortt.sort(-1);
                move(result);
                break;
            case "ShakerSort":
                ShakerSort shakeSort = new ShakerSort(numberOfSortedEl,safeArr);
                result = shakeSort.sort(-1);
                move(result);
                break;
            case "StupidSort":
                StupidSort stupSort = new StupidSort(numberOfSortedEl,safeArr);
                result = stupSort.sort(-1);
                move(result);
                break;
        }

    }

    static void stepByStepSort(int step,Vector<Integer> result,int[] safeArr){
        nextStepSortButt.setEnabled(true);
        prevStepSortButt.setEnabled(true);


        String choiceSort = (String) sortBox.getSelectedItem();
        for (int i = 0;i<maxElem;++i){
            safeArr[i] = firstSafedArray[i];
        }

        switch (choiceSort) {
            case "MergeSort":
                MergeSort merge = new MergeSort(numberOfSortedEl, safeArr);
                result = merge.sort(step);
                moveNotChoiceSortStepByStep(result,firstSafedArray);
                break;
            case "ShellSort":
                ShellSort shell = new ShellSort(numberOfSortedEl,safeArr);
                result = shell.sort(step);
                moveNotChoiceSortStepByStep(result,firstSafedArray);
                break;
            case  "SelectionSort":
                SelectionSort sel = new SelectionSort(numberOfSortedEl,safeArr);
                result = sel.sort(step);
                moveNextStep(result,firstSafedArray);
                break;
            case "InsertionSort":
                InsertionSort ins = new InsertionSort(numberOfSortedEl,safeArr);
                result = ins.sort(step);
                moveNextStep(result,firstSafedArray);
                break;
            case "BubbleSort":
                BubbleSort bubSort = new BubbleSort(numberOfSortedEl, safeArr);
                result = bubSort.sort(step);
                moveNextStep(result,firstSafedArray);
                break;
            case "QuickSort":
                QuickSort quickSortt = new QuickSort(numberOfSortedEl,safeArr);
                result = quickSortt.sort(step);
                moveNextStep(result,firstSafedArray);
                break;
            case "ShakerSort":
                ShakerSort shakeSort = new ShakerSort(numberOfSortedEl,safeArr);
                result = shakeSort.sort(step);
                moveNextStep(result,firstSafedArray);
                break;
            case "StupidSort":
                StupidSort stupSort = new StupidSort(numberOfSortedEl,safeArr);
                result = stupSort.sort(step);
                moveNextStep(result,firstSafedArray);
                break;
        }

    }

    public static class AnotherSortButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Vector<Integer> result = new Vector<>();
            int[] safeArr = new int[maxElem];
            for (int i = 0;i<maxElem;++i)
                safeArr[i] = sortedArray[i];

            switch ((String)typeOfSort.getSelectedItem()){
                case "Automatic":

                    automaticSort(safeArr,result);
                    break;
                case "Step-by-Step":
                    //anotherSortButt.setEnabled(false);
                    step = 1;
                    for (int i = 0;i<maxElem;++i){
                        firstSafedArray[i] = safeArr[i];
                    }
                    stepByStepSort(step,result,safeArr);
                    break;
                case "Result":
                    step = -1;
                    for (int i = 0;i<maxElem;++i){
                        firstSafedArray[i] = safeArr[i];
                    }
                    stepByStepSort(step,result,safeArr);
                    for (int i = 0; i < maxElem; ++i)
                        sortedEl[i].setForeground(Color.lightGray);
                    nextStepSortButt.setEnabled(false);
                    prevStepSortButt.setEnabled(false);
                    break;
            }


        }
    }

    public static class GetElButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Integer numb = maxElem, el = 0;
            for (int i = 0; i < maxElem; ++i) {
                sortedEl[i].setValue(minRange);
                // ourArray[i].setText("");
                sortedEl[i].setVisible(true);
            }

            try {
                numb = Integer.valueOf(numbOfElement.getText());
            } catch (NumberFormatException e) {
                numbOfElement.setText("Неверный формат строки");
                numb = 0;
            }
            if (numb > maxElem) {
                numb = maxElem;
                numbOfElement.setText(Integer.toString(maxElem));
            }
            numberOfSortedEl = numb;

            for (Integer i = 0; i < numb; ++i) {
                sortedArray[i] = 0;
                try {
                    el = Integer.valueOf(ourArray[i].getText());
                } catch (NumberFormatException e) {
                    numbOfElement.setText("Неверный формат элементов");
                    return;
                }
                if (el > maxRange) {
                    el = maxRange;
                    ourArray[i].setText(Integer.toString(maxRange));
                }
                sortedArray[i] = el;
            }

            for (int i = numb + 1; i < maxElem; ++i)
                ourArray[i].setText("");

            for (Integer i = 0; i < numb; ++i) {
                sortedEl[i].setValue(sortedArray[i]);
            }
            //расскоментировать при необходимости
            //for (int i = numb;i<=maxElem;++i)
            //    sortedEl[i].setVisible(false);


        }
    }


    public static class RandomButtonActionListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Random random = new Random();
            Integer numb = maxElem;

            for (int i = 0;i<maxElem;++i){
                ourArray[i].setText("");
                sortedEl[i].setValue(minRange);
                sortedEl[i].setVisible(true);
            }

            try {
                numb = Integer.valueOf(numbOfElement.getText());
            }catch (NumberFormatException e) {
                numbOfElement.setText("Неверный формат строки");
                numb=0;
            }
            if (numb>maxElem) {
                numb = maxElem;
                numbOfElement.setText(Integer.toString(maxElem));
            }
            numberOfSortedEl = numb;
            Integer sch = 0;
            for (Integer i = 0;i<numb;++i){
                sch = random.nextInt(maxRange);
                sortedEl[i].setValue(sch);
                sortedArray[i] = sch;
                ourArray[i].setText(sch.toString());
            }
            //расскомментировать, при необходимости
            //for (int i = numb;i<maxElem;++i)
            //    sortedEl[i].setVisible(false);
        }
    }

    public static class nextStepActionListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            boolean flag = true;
            //anotherSortButt.setEnabled(false);
            for (int i = 1;i<numberOfSortedEl;++i){
                if (Integer.valueOf(ourArray[i-1].getText())>Integer.valueOf(ourArray[i].getText())){
                    flag = false;
                    break;}
            }
            if (flag==false) {
                Vector<Integer> result = new Vector<>();
                int[] safeArr = new int[maxElem];
                if (step == -1) step = 0;
                ++step;
                for (int i = 0; i < maxElem; ++i) {
                    safeArr[i] = firstSafedArray[i];
                }
                stepByStepSort(step, result, safeArr);
            } //else {
                //anotherSortButt.setEnabled(true);
            //}

    }

}

    public static class prevStepActionListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent actionEvent) {
           // anotherSortButt.setEnabled(false);
            Vector<Integer> result = new Vector<>();
            int[] safeArr = new int[maxElem];
            if(step>0){
            --step;
            for (int i = 0;i<maxElem;++i){
                safeArr[i] = firstSafedArray[i];
            }
            stepByStepSort(step,result,safeArr);}
            else if(step==0){
                stepByStepSort(0,result,safeArr);
              //  anotherSortButt.setEnabled(true);
            }
        }

    }

}
