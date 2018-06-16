package logik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Window extends JFrame {

    private ArrayList<JButton> jButtonsList = new ArrayList<JButton>();
    private JLabel jLabelY, jLabelX;
    private JTextField jTextFieldK, jTextFieldB;


    public Window() {
        setTitle("Графики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 250, 100);

        addPanels();

        setVisible(true);
        this.setResizable(false);
    }


    private void addPanels(){
        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        setLayout(new BorderLayout());

        this.add(bottomPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);

        addComponentInPanel(centerPanel);
        addBottonButton(bottomPanel, "Go");
        goButtonPress(jButtonsList.get(0));

    }

    private void addComponentInPanel(JPanel panel) {
        jLabelY = new JLabel("y = ");
        jTextFieldK = new JTextField("k");

        jLabelX = new JLabel("x + ");
        jTextFieldB = new JTextField("b");

        panel.setLayout(new FlowLayout());
        panel.add(jLabelY);
        panel.add(jTextFieldK);
        panel.add(jLabelX);
        panel.add(jTextFieldB);

    }

    private void addBottonButton(JPanel panel, String str) {
        JButton jbtn = new JButton(str);

        panel.setLayout(new FlowLayout());
        panel.add(jbtn);

        jButtonsList.add(jbtn);
    }

    private void addLabelText() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JLabel jlblText = new JLabel("Введите коэффициенты");
        jlblText.setAlignmentY(TOP_ALIGNMENT);

        add(jlblText);
    }

    private void goButtonPress(JButton jButton){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int b, k;

                k = Integer.parseInt(jTextFieldK.getText());
                b = Integer.parseInt(jTextFieldB.getText());

                PaintFrame paintFrame = new PaintFrame(k, b);
            }
        });
    }
}
