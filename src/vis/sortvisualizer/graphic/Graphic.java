package vis.sortvisualizer.graphic;

import javax.swing.*;
import java.awt.*;
import vis.sortvisualizer.handlers.Handler;

/**
 * Created by root on 26.06.17.
 */
public class Graphic {
    public static int numberOfSortedEl;
    public static final int speed = 5;
    public static final int speedB = 5;
    public static final int maxElem = 40;
    public static final int minRange = 0;
    public static final int maxRange = 1000;
    static final int height = maxElem*20;
    static final int width = 400;
    public static final int lengthElem = 20;
    public static int step = 1;
    static JFrame mainWindow = new JFrame();
    static JPanel visualizePanel = new JPanel();
    static JPanel secVisPanel = new JPanel();
    public static GraphicPanel uppSecVisPanel = new GraphicPanel();

    static JPanel centerSecVisPanel = new JPanel();

    static JPanel firstVisPanel = new JPanel();
    static JPanel secondWorkPanel = new JPanel();
    static JPanel thirdWorkPanel = new JPanel();
    static JPanel fourWorkPanel = new JPanel();
    static JPanel fiveWorkPanel = new JPanel();
    static JPanel sixWorkPanel = new JPanel();
    static JPanel workPanel = new JPanel();
    static JPanel upperPanel = new JPanel();
    public static JTextField numbOfElement = new JTextField(2);
    public static JTextField[] ourArray = new JTextField[maxElem];
    public static JProgressBar[] sortedEl = new JProgressBar[maxElem];
    public static int[] sortedArray = new int[maxElem];
    public static JButton anotherSortButt = new JButton("Sort");
    public static JButton nextStepSortButt = new JButton(">");
    public static JButton prevStepSortButt = new JButton("<");
    public static JComboBox<String> typeOfSort = new JComboBox<String>();
    public static JComboBox<String> sortBox = new JComboBox<String>();
    public static int[] firstSafedArray = new int[maxElem];
    public static JButton randomButt = new JButton("random");
    public static JButton getButt = new JButton("get");

    public void visualize(){
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

        anotherSortButt.addActionListener(new Handler.AnotherSortButtonActionListener());
        nextStepSortButt.addActionListener(new Handler.nextStepActionListener());
        prevStepSortButt.addActionListener(new Handler.prevStepActionListener());
        centerSecVisPanel.setLayout(new BorderLayout());
        centerSecVisPanel.add(secVisPanel, BorderLayout.CENTER);
        centerSecVisPanel.add(uppSecVisPanel, BorderLayout.PAGE_START);
        secVisPanel.setLayout(new GridLayout());

        getButt.addActionListener(new Handler.GetElButtonActionListener());
        randomButt.addActionListener(new Handler.RandomButtonActionListener());
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
            sortedEl[i].setStringPainted(true);
            sortedEl[i].setString("");
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
}