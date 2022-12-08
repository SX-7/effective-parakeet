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
        // make a new window
        JFrame jf = new JFrame("Calculator");

        // create two parts of it as panels
        JPanel viewbox = new JPanel(new BorderLayout());
        JPanel buttons = new JPanel(new GridLayout(4, 4));
        // lay them out
        jf.getContentPane().add(viewbox, BorderLayout.NORTH);
        jf.getContentPane().add(buttons, BorderLayout.SOUTH);
        // set properties
        
        jf.setResizable(false);

        // create a read only text field, set properties, put it in container
        JTextField tf = new JTextField();
        tf.setEditable(false);
        tf.setText("0");
        tf.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        tf.setHorizontalAlignment(JTextField.TRAILING);
        viewbox.add(tf, BorderLayout.CENTER);

        // common action listener for buttons - to be adjusted later
        // we don't need to make a new object, since this one is all we'll need and use
        ActionListener myActionListener = new ActionListener() {
            private JTextField textField = tf;
            // left side is "memory", and is used for operations
            private Integer leftSide = null;
            // right side is what'll be usually displayed, and is the working side of things
            private Integer rightSide = null;
            private String operator = null;
            private String lastArg = "C";

            public void actionPerformed(ActionEvent event) {
                // we get the symbol
                // identify it, and dispatch to function that deals with it
                // first try to parse it as int
                try {
                    // if it fails it's not an int
                    textField.setText(this.parseNumber(Integer.parseInt(event.getActionCommand())));
                    this.lastArg = "Number";
                    return; // that's it, let's continue
                } catch (Exception exception) {
                    // do nothing, just continue the checks
                }
                // it is not an int, so now just run a simple switch
                switch (event.getActionCommand()) {
                    case "C":
                        textField.setText(this.clear());
                        this.lastArg = "C";
                        break;
                    case "=":
                        textField.setText(this.equals());
                        this.lastArg = "=";
                        break;
                    case "+":
                        textField.setText(this.operation("+"));
                        this.lastArg = "Operator";
                        break;
                    case "-":
                        textField.setText(this.operation("-"));
                        this.lastArg = "Operator";
                        break;
                    case "/":
                        textField.setText(this.operation("/"));
                        this.lastArg = "Operator";
                        break;
                    case "*":
                        textField.setText(this.operation("*"));
                        this.lastArg = "Operator";
                        break;
                    default:
                        System.err.println("some error happened while parsing symbols!");
                        break;
                }
            }

            private String parseNumber(Integer number) {
                switch (this.lastArg) {
                    case "C":
                        // everything is nice and clean, just put right side in there
                        this.rightSide = number;
                        break;
                    case "=":
                        // whatever was before, we ignore
                        this.clear();
                        this.rightSide = number;
                        break;
                    case "Number":
                        // number after number, nothing unusual
                        this.rightSide = this.rightSide * 10 + number;
                        break;
                    case "Operator":
                        // last one was an operator, if it was something like 2+ then we move to left
                        // and write to right, but if it was something like 2+2+, then what?
                        // technically speaking, we should see something like 4+2 (order important cuz /
                        // and -), so do we just make operators move thing to the left? y not
                        // we assume we don't care for the right side, in first case it's been moved
                        // in second case, we're overwriting the value that was there purely for =
                        this.rightSide = number;
                        break;
                    default:
                        // if we get there, just print an error, we should never see this line
                        System.err.println("number parsing previous command switch case error");
                        break;
                }
                // we return the right side, cuz that is the only thing we're modyfying, and
                // we're doing it always
                return Integer.toString(this.rightSide);
            }

            private String clear() {
                // basically: return everything to starting values. if null is problematic, fix
                // it later
                this.leftSide = null;
                this.rightSide = null;
                this.operator = null;
                return "0";
            }

            private String equals() {
                // we can just output the left side? it is helpful to do so
                // if the last one was a number, we got 2 options
                // there's no operator ( we do nothing), or there was (we do maths)
                switch (this.lastArg) {
                    case "Number":
                        // check for operator, if there's one, calculate (but check for null in case of
                        // -2=!!)
                        if (this.operator == null) {
                            // there's no operator, so we can just do nothing - yes
                            // as a matter of fact, just move the number to left, for output
                            // writing numbers after that will overwrite it
                            this.leftSide = this.rightSide;
                        } else {
                            // that means we gotta do the calculation, simple as
                            // the most basic of basic, just run a switch for operator
                            // after applying it, move the result, but change nothing
                            // *also* we assume that there are two non null args, which makes sense
                            // possibly in case of -1, as operator doesn't set left to 0
                            switch (this.operator) {
                                case "+":
                                    this.leftSide = this.leftSide + this.rightSide;
                                    break;
                                case "-":
                                    this.leftSide = this.leftSide - this.rightSide;
                                    break;
                                case "*":
                                    this.leftSide = this.leftSide * this.rightSide;
                                    break;
                                case "/":
                                    try {
                                        this.leftSide = this.leftSide / this.rightSide;
                                    } catch (Exception e) {
                                        this.clear();
                                        return "ERROR: div by zero";
                                    }
                                    break;
                                default:
                                    System.err.println("error switch case equal after number");
                                    break;
                            }
                        }

                        break;
                    case "Operator":
                        // since operator is handling moving stuff, the left side is the thing we wanna
                        // do
                        // and the right side, well, there are two options
                        // it can be null, if it was something like 2+, in which case we're duplicating
                        // the arg
                        // and outputting the result to left, without removing the duplicate arg (so it
                        // looks like 4+2 now, if we wanted to do multiple "=")
                        // it can be not null, which'd imply something like 2+2+ happened, but in this
                        // case the operator would do the calculations and change it to 4+, since we are
                        // overriding the right side with the second operator
                        // so we have an operator, time to slap it with self operation
                        // but we also have to save it to the right, just in case we gonna retry =
                        switch (this.operator) {
                            case "+":
                                this.rightSide = this.leftSide;
                                this.leftSide = this.leftSide + this.leftSide;
                                break;
                            case "-":
                                this.rightSide = this.leftSide;
                                this.leftSide = this.leftSide - this.leftSide;
                                break;
                            case "*":
                                this.rightSide = this.leftSide;
                                this.leftSide = this.leftSide * this.leftSide;
                                break;
                            case "/":
                                this.rightSide = this.leftSide;
                                this.leftSide = this.leftSide / this.leftSide;
                                break;
                            default:
                                System.err.println("error switch case equal after operator");
                                break;
                        }
                        break;
                    case "=":
                        // do the same thing as in the case of number, really
                        // we have to check for operator null-ness, in case of 3== for example
                        if (this.operator != null) {
                            switch (this.operator) {
                                case "+":
                                    this.leftSide = this.leftSide + this.rightSide;
                                    break;
                                case "-":
                                    this.leftSide = this.leftSide - this.rightSide;
                                    break;
                                case "*":
                                    this.leftSide = this.leftSide * this.rightSide;
                                    break;
                                case "/":
                                    this.leftSide = this.leftSide / this.rightSide;
                                    break;
                                default:
                                    System.err.println("error switch case equal after equal");
                                    break;
                            }
                        }
                        break;
                    case "C":
                        // nothing man
                        break;
                    default:
                        System.err.println("equals previous command switch case error");
                        break;
                }
                // a safeguard
                if (this.leftSide == null) {
                    this.leftSide = 0;
                }
                return Integer.toString(this.leftSide);
            }

            // we just slap them all in one
            private String operation(String operator) {
                switch (this.lastArg) {
                    case "Number":
                        // if the last one was a number, two options. we either are without the right
                        // number nor have an operator, or we have a number and an operator
                        // in first case we just write operator and move right to left, in second we
                        // calculate with equals
                        if (this.operator == null) {
                            // no operator, so the number was on the right
                            this.leftSide = this.rightSide;
                            this.rightSide = null;
                            this.operator = operator;
                        } else {
                            // there was an operator, so we have to calc it
                            String returnMessage = this.equals(); // this can return "error" message, in which case we
                                                                  // have to stop this function and just return the
                                                                  // message instead, sadly no try catch here as it's
                                                                  // done one level below
                            // this shouldn't be done but is quick and easy
                            try {
                                Integer.parseInt(returnMessage);
                            } catch (Exception e) {
                                // this means we have done the goofed and it's a string containing an error
                                // message, return
                                return(returnMessage);
                            }
                            // the output is on left now, so just change operator and apply null
                            this.operator = operator;
                            this.rightSide = null;
                        }
                        break;
                    case "Operator":
                        // just override the last one, always
                        this.operator = operator;
                        break;
                    case "=":
                        // = outputs to the left side, so what we do is purge right and change operator
                        // spoiler: there's none there anyways
                        this.rightSide = null;
                        this.operator = operator;
                        break;
                    case "C":
                        // just write it, like nothing's gonna happen anyways, the slate is clean and
                        // known
                        this.operator = operator;
                        break;
                    default:
                        break;
                }
                // a safeguard
                if (this.leftSide == null) {
                    this.leftSide = 0;
                }
                return Integer.toString(this.leftSide);
            }
        };

        // gigantic slog of creating buttons
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
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // invoking the gui
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}