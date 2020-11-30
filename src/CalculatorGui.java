import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

/**
 * GUI and logic for calculator
 */

public class CalculatorGui implements KeyListener  {
    JFrame calFrame;
    JPanel keyboardPanel;
    JPanel keyboardPanel2;
    JPanel keyboardPanel3;
    JTextArea display;
    JScrollPane scrollPane;
    JTabbedPane tp ;
    JMenuBar menuBar;
    JMenu myMenu;
    private JButton jbtNum1;
    private JButton jbtNum2;
    private JButton jbtNum3;
    private JButton jbtNum4;
    private JButton jbtNum5;
    private JButton jbtNum6;
    private JButton jbtNum7;
    private JButton jbtNum8;
    private JButton jbtNum9;
    private JButton jbtNum0;
    JButton sumBtn = new JButton();
    JButton minusBtn = new JButton();
    JButton doBtn = new JButton();
    JButton multiBtn = new JButton();
    JButton divBtn = new JButton();
    JButton tBtn = new JButton();
    private  String dis;
    private double TEMP;
    private double SolveTEMP;
    private boolean addBool;
    private  boolean subBool;
    private boolean mulBool;
    private boolean divBool;
    private String copy ;
    private  int key ;

    public CalculatorGui(){
        calFrame = new JFrame();
        keyboardPanel = new JPanel();
        keyboardPanel2 = new JPanel();
        keyboardPanel3 = new JPanel();
        display = new JTextArea(3,10);
        tp = new JTabbedPane();
        menuBar = new JMenuBar();
        myMenu = new JMenu("menu");
    }

    /**
     * creating frame in this method
     */
    public void  frame() {

        calFrame.setTitle("AUT Calculator");
        calFrame.setSize(300, 300);
        calFrame.setLocation(100, 200);
        calFrame.setLayout(new BorderLayout());
        calFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calFrame.setVisible(true);
    }

    /**
     * creating panels in this method
     */
    public void panel(){

        keyboardPanel.setSize(100,100);
        keyboardPanel.setLocation(10, 150);
        keyboardPanel.setLayout(new GridLayout(4,4));
        keyboardPanel.setFocusable(true);
        keyboardPanel.requestFocusInWindow();
        keyboardPanel2.setSize(20,20);
        keyboardPanel2.setLocation(10, 15);
        keyboardPanel2.setLayout(new BorderLayout());
        keyboardPanel3.setSize(100,100);
        keyboardPanel3.setLocation(10, 150);
        keyboardPanel3.setLayout(new GridLayout(5,5));

    }

    /**
     * creating buttons in this method logic and gui pressby mous and keypad
     */
    public  void button(){

        keyboardPanel.add(jbtNum1 = new JButton("1"));
        keyboardPanel.add(jbtNum2 = new JButton("2"));
        keyboardPanel.add(jbtNum3 = new JButton("3"));
        keyboardPanel.add(jbtNum4 = new JButton("4"));
        keyboardPanel.add(jbtNum5 = new JButton("5"));
        keyboardPanel.add(jbtNum6 = new JButton("6"));
        keyboardPanel.add(jbtNum7 = new JButton("7"));
        keyboardPanel.add(jbtNum8 = new JButton("8"));
        keyboardPanel.add(jbtNum9 = new JButton("9"));
        keyboardPanel.add(jbtNum0 = new JButton("0"));
        jbtNum1.addActionListener(new ListenToOne());
        jbtNum1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button 1 pressed by mouse!");
            }
        });

        jbtNum2.addActionListener(new ListenToTwo());
        jbtNum2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button 2 pressed by mouse!");
            }
        });

        jbtNum3.addActionListener(new ListenToThree());
        jbtNum3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button 3 pressed by mouse!");
            }
        });

        jbtNum4.addActionListener(new ListenToFour());
        jbtNum4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button 4 pressed by mouse!");
            }
        });

        jbtNum5.addActionListener(new ListenToFive());
        jbtNum5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button 5 pressed by mouse!");
            }
        });

        jbtNum6.addActionListener(new ListenToSix());
        jbtNum6.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button 6 pressed by mouse!");
            }
        });

        jbtNum7.addActionListener(new ListenToSeven());
        jbtNum7.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button 7 pressed by mouse!");
            }
        });

        jbtNum8.addActionListener(new ListenToEight());
        jbtNum8.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button 8 pressed by mouse!");
            }
        });

        jbtNum9.addActionListener(new ListenToNine());
        jbtNum9.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button 9 pressed by mouse!");
            }
        });

        jbtNum0.addActionListener(new ListenToZero());
        jbtNum0.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button 0 pressed by mouse!");
            }
        });

        sumBtn.setText("+");
        keyboardPanel.add(sumBtn);

        minusBtn.setText("-");
        keyboardPanel.add(minusBtn);

        doBtn.setText("=");
        keyboardPanel.add(doBtn);

        multiBtn.setText("*");
        keyboardPanel.add(multiBtn);

        divBtn.setText("/");
        keyboardPanel.add(divBtn);

        tBtn.setText("AC");
        keyboardPanel.add(tBtn);

        JButton scBtn = new JButton();
        scBtn.setText("sin/cos");
        keyboardPanel3.add(scBtn);

        JButton tcBtn = new JButton();
        tcBtn.setText("tan/cot");
        keyboardPanel3.add(tcBtn);

        JButton shiftBtn = new JButton();
        shiftBtn.setText("shift");
        keyboardPanel3.add(shiftBtn);

        JButton LBtn = new JButton();
        LBtn.setText("log/exp");
        keyboardPanel3.add(LBtn);

        JButton eBtn = new JButton();
        eBtn.setText("e");
        keyboardPanel3.add(eBtn);

        JButton pBtn = new JButton();
        pBtn.setText("PI");
        keyboardPanel3.add(pBtn);

        JButton powwBtn = new JButton();
        powwBtn.setText("x**2");
        keyboardPanel3.add(powwBtn);

        JButton makusBtn = new JButton();
        makusBtn.setText("1/x");
        keyboardPanel3.add(makusBtn);

        JButton ghadrBtn = new JButton();
        ghadrBtn.setText("|x|");
        keyboardPanel3.add(ghadrBtn);

        JButton pow3Btn = new JButton();
        pow3Btn.setText("x**3");
        keyboardPanel3.add(pow3Btn);

        sumBtn.addActionListener(new ListenToAdd());
        sumBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button + pressed by mouse!");
            }
        });
        sumBtn.setToolTipText("this is adding to numbers");


        minusBtn.addActionListener(new ListenToSubtract());
        minusBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button - pressed by mouse!");
            }
        });


        multiBtn.addActionListener(new ListenToMultiply());
        multiBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button * pressed by mouse!");
            }
        });


        divBtn.addActionListener(new ListenToDivide());
        divBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button / pressed by mouse!");
            }
        });
        divBtn.setToolTipText("this is dividing to numbers");


        tBtn.addActionListener(new ListenToClear());
        tBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button clear pressed by mouse!");
            }
        });
        tBtn.setToolTipText("this is clearing all numbers");


        doBtn.addActionListener(new ListenToSolve());
        doBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button = pressed by mouse!");
            }
        });
    }
    @Override
    public void keyTyped(KeyEvent e) { }

    /**
     * press keypad for all the buttons .
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();

        if(key== KeyEvent.VK_0){
            jbtNum0.doClick();
        }
        if(key== KeyEvent.VK_1) {
            jbtNum1.doClick();
        }
        if(key== KeyEvent.VK_2) {
            jbtNum2.doClick();
        }
        if(key== KeyEvent.VK_3) {
            jbtNum3.doClick();
        }
        if(key== KeyEvent.VK_4) {
            jbtNum4.doClick();
        }
        if(key== KeyEvent.VK_5) {
            jbtNum5.doClick();
        }
        if(key== KeyEvent.VK_6) {
            jbtNum6.doClick();
        }
        if(key== KeyEvent.VK_7) {
            jbtNum7.doClick();
        }
        if(key== KeyEvent.VK_8) {
            jbtNum8.doClick();
        }
        if(key== KeyEvent.VK_9) {
            jbtNum9.doClick();
        }
        if(key== 107) {
            sumBtn.doClick();
        }
        if(key== 109) {
            minusBtn.doClick();
        }
        if(key== 106) {
            multiBtn.doClick();
        }
        if(key== 111) {
            divBtn.doClick();
        }
        if(key== 61 ) {
            doBtn.doClick();
        }
        if(key== 8) {
            tBtn.doClick();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) { }

    /**
     * all the inner class used by buttons about action listener and logic for cal
     */

    private class ListenToOne implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dis = display.getText();
            display.setText(dis + "1");
        }
    }

    private class ListenToTwo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dis = display.getText();
            display.setText(dis + "2");
        }
    }

    private class ListenToThree implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dis = display.getText();
            display.setText(dis + "3");
        }
    }

    private class ListenToFour implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dis = display.getText();
            display.setText(dis + "4");
        }
    }

    private class ListenToFive implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dis = display.getText();
            display.setText(dis + "5");
        }
    }

    private class ListenToSix implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dis = display.getText();
            display.setText(dis + "6");
        }
    }

    private class ListenToSeven implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dis = display.getText();
            display.setText(dis + "7");
        }
    }

    private class ListenToEight implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dis = display.getText();
            display.setText(dis + "8");
        }
    }

    private class ListenToNine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dis = display.getText();
            display.setText(dis + "9");
        }
    }

    private class ListenToZero implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dis = display.getText();
            display.setText(dis + "0");
        }
    }

    class ListenToAdd implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(display.getText());
            display.setText("");
            addBool = true;
        }
    }

    class ListenToSubtract implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(display.getText());
            display.setText("");
            subBool = true;
        }
    }

    class ListenToMultiply implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(display.getText());
            display.setText("");
            mulBool = true;
        }
    }

    class ListenToDivide implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(display.getText());
            display.setText("");
            divBool = true;
        }
    }

    class ListenToSolve implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            SolveTEMP = Double.parseDouble(display.getText());
            if (addBool == true)
                SolveTEMP = SolveTEMP + TEMP;
            else if ( subBool == true)
                SolveTEMP = SolveTEMP - TEMP;
            else if ( mulBool == true)
                SolveTEMP = SolveTEMP * TEMP;
            else if ( divBool == true)
                SolveTEMP = SolveTEMP / TEMP;
            display.setText(  Double.toString(SolveTEMP));

            addBool = false;
            subBool = false;
            mulBool = false;
            divBool = false;
        }
    }

    class ListenToClear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //display = jtfResult.getText();
            display.setText("");
            addBool = false;
            subBool = false;
            mulBool = false;
            divBool = false;

            TEMP = 0;
            SolveTEMP = 0;
        }
    }

    /**
     * creating textFiled in this method
     */
    public void text(){
        display.setEditable(false);
        display.setFont(new Font("Arial", 14,14));
    }

    public void scroll() {

        scrollPane = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        keyboardPanel2.add(scrollPane);
    }

    /**
     * seperate sade from mohanesi in this method
     */
    public void tabBedPane(){

        tp.setBounds(50,50,200,200);
        tp.add("sade",keyboardPanel);
        tp.add("mohandesi",keyboardPanel3);
    }

    /**
     * set menu for calculator that has two items copy and exit.
     */
    public void menuBarr(){
        menuBar.add(myMenu);
        JMenuItem exit = new JMenuItem("exit",KeyEvent.VK_E);
        JMenuItem copyItem = new JMenuItem("copy",KeyEvent.VK_C);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exit.requestFocusInWindow();
        exit.setAccelerator((KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK)));
        myMenu.add(exit);

        copyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copy = display.getText();
                System.out.println("copycal : "+copy);
            }
        });
        copyItem.setMnemonic(KeyEvent.VK_C);
        copyItem.requestFocusInWindow();
        myMenu.add(copyItem);
    }

    /**
     * adding all method together
     */
    public void add(){
        frame();
        panel();
        button();
        text();
        scroll();
        tabBedPane();
        menuBarr();
        calFrame.setJMenuBar(menuBar);
        calFrame.add(keyboardPanel2,BorderLayout.NORTH);
        calFrame.add(tp);
        calFrame.addKeyListener(this);
        keyboardPanel.addKeyListener(this);
    }
}
