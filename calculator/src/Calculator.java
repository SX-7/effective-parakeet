import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {

    public static void createAndShowGUI() {
        JFrame jf = new JFrame("Calculator");
        
        JPanel viewbox = new JPanel(new BorderLayout());
        JPanel buttons = new JPanel(new GridLayout(4,4)); 
        jf.getContentPane().add(viewbox,BorderLayout.NORTH);
        jf.getContentPane().add(buttons,BorderLayout.SOUTH);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);

        JTextField tf = new JTextField();
        tf.setEditable(false);
        tf.setText("0");
        tf.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        tf.setHorizontalAlignment(JTextField.TRAILING);
        viewbox.add(tf,BorderLayout.CENTER);


        JButton b1 = new JButton("1");
        buttons.add(b1);
        JButton b2 = new JButton("2");
        buttons.add(b2);
        JButton b3 = new JButton("3");
        buttons.add(b3);
        JButton bplus = new JButton("+");
        buttons.add(bplus);

        JButton b4 = new JButton("4");
        buttons.add(b4);
        JButton b5 = new JButton("5");
        buttons.add(b5);
        JButton b6 = new JButton("6");
        buttons.add(b6);
        JButton bminus = new JButton("-");
        buttons.add(bminus);

        JButton b7 = new JButton("7");
        buttons.add(b7);
        JButton b8 = new JButton("8");
        buttons.add(b8);
        JButton b9 = new JButton("9");
        buttons.add(b9);
        JButton bmult = new JButton("*");
        buttons.add(bmult);

        JButton b0 = new JButton("0");
        buttons.add(b0);
        JButton beq = new JButton("=");
        buttons.add(beq);
        JButton bc = new JButton("C");
        buttons.add(bc);
        JButton bdiv = new JButton("/");
        buttons.add(bdiv);

        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });        
    }

}