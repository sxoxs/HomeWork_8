package logik;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PaintFrame extends JFrame {
        int x1, x2, y1, y2;
        int k, b;
        final int STEP_LINE = 20;
        ArrayList<JLabel> jLabelsList = new ArrayList<JLabel>();

    public PaintFrame(int k, int b) {
        this.k = k;
        this.b = b;
        setBounds(100,100, 500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateLabels();

        setVisible(true);
    }

    private void conversionCoordinate(){
        int y1, y2, x1, x2;

        x1 = 0 - this.getWidth()/STEP_LINE/2;
        y1 = (k*x1 + b);
        x2 = this.getWidth()/STEP_LINE/2;
        y2 = (k*x2 + b);

        this.x1 = x1*(STEP_LINE) + this.getWidth()/2;
        this.y1 = this.getHeight() - (y1*(STEP_LINE) + this.getHeight()/2);
        this.x2 = x2*(STEP_LINE) + this.getWidth()/2;
        this.y2 = this.getHeight() - (y2*(STEP_LINE) + this.getHeight()/2);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        paintAxis(g);
        paintGrap(g);
    }

    private void paintGrap(Graphics g) {
        conversionCoordinate();
        g.setColor(Color.RED);
        g.drawLine(x1, y1, x2, y2);
    }

    private void paintAxis(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine((this.getWidth()/2), 0, (this.getWidth()/2), this.getHeight());
        g.drawLine(0, (this.getHeight()/2), getWidth(), (this.getHeight()/2));

        for (int i = (this.getHeight()/2 + STEP_LINE); i <= this.getHeight(); i+=STEP_LINE) {
            g.drawLine(((this.getWidth()/2)-5), i, ((this.getWidth()/2)+5), i);
            g.drawLine(((this.getWidth()/2)-5), this.getHeight() - i, ((this.getWidth()/2)+5), this.getHeight() - i);
        }
        for (int i = (this.getWidth()/2+STEP_LINE); i <= this.getWidth(); i+=STEP_LINE) {
            g.drawLine(i, ((this.getHeight()/2)-5), i, ((this.getHeight()/2)+5));
            g.drawLine(this.getWidth() - i, ((this.getHeight()/2)-5), this.getWidth() - i, ((this.getHeight()/2)+5));
        }
        updateLabels();
    }

    private void updateLabels(){
        for (JLabel jLabel:
             jLabelsList) {
            this.remove(jLabel);
        }
        jLabelsList.clear();

        for (int i = this.getWidth()/2 + STEP_LINE, j = 1; i < this.getWidth() ; i+=STEP_LINE, j++) {
            addJLabel(Integer.toString(j), i, this.getHeight()/2 - 20);
            addJLabel(Integer.toString(j*(-1)), this.getWidth() - i, this.getHeight()/2 - 20);
        }
        addJLabel("X", this.getWidth()-20, this.getHeight()/2 - 44);
        for (int i = this.getHeight()/2 + STEP_LINE, j = 1; i < this.getHeight() ; i+=STEP_LINE, j++) {
            if (j!=1) {
                addJLabel(Integer.toString(j * (-1)), this.getWidth() / 2 - 20, i - 2 * STEP_LINE);
            }
            addJLabel(Integer.toString(j), this.getWidth()/2-20, this.getHeight() - i - 2*STEP_LINE);
        }
        addJLabel("Y", this.getWidth()/2 + 10, 0);
    }

    private void addJLabel(String text, int x, int y){
        JLabel jLabel = new JLabel(text);
        jLabel.setFont(new Font("Arial",Font.PLAIN, 8));

        setLayout(null);
        jLabel.setBounds(x-5, y, 15, 10);
        this.add(jLabel);
        jLabelsList.add(jLabel);
    }

}
