import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

        ActionListener myActionListener = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			System.out.println("[ActionListener] Button = "+e.getActionCommand());
    		}    		
    	};

        JButton b1 = new JButton("1");
        b1.addActionListener(myActionListener);
        buttons.add(b1);
        JButton b2 = new JButton("2");
        b2.addActionListener(myActionListener);
        buttons.add(b2);
        JButton b3 = new JButton("3");
        b3.addActionListener(myActionListener);
        buttons.add(b3);
        JButton bplus = new JButton("+");
        bplus.addActionListener(myActionListener);
        buttons.add(bplus);

        JButton b4 = new JButton("4");
        b4.addActionListener(myActionListener);
        buttons.add(b4);
        JButton b5 = new JButton("5");
        b5.addActionListener(myActionListener);
        buttons.add(b5);
        JButton b6 = new JButton("6");
        b6.addActionListener(myActionListener);
        buttons.add(b6);
        JButton bminus = new JButton("-");
        bminus.addActionListener(myActionListener);
        buttons.add(bminus);

        JButton b7 = new JButton("7");
        b7.addActionListener(myActionListener);
        buttons.add(b7);
        JButton b8 = new JButton("8");
        b8.addActionListener(myActionListener);
        buttons.add(b8);
        JButton b9 = new JButton("9");
        b9.addActionListener(myActionListener);
        buttons.add(b9);
        JButton bmult = new JButton("*");
        bmult.addActionListener(myActionListener);
        buttons.add(bmult);

        JButton b0 = new JButton("0");
        b0.addActionListener(myActionListener);
        buttons.add(b0);
        JButton beq = new JButton("=");
        beq.addActionListener(myActionListener);
        buttons.add(beq);
        JButton bc = new JButton("C");
        bc.addActionListener(myActionListener);
        buttons.add(bc);
        JButton bdiv = new JButton("/");
        bdiv.addActionListener(myActionListener);
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