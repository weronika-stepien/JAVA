import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
      public static final Color VERY_DARK_BLUE = new Color(0 , 0 ,153);
      JFrame frame;
      JTextField textField;
      JButton[] buttonNumber = new JButton[10];
      JButton[] buttonFunctional = new JButton[9];
      JButton addButton, subButton, mulButton, divButton;
      JButton decButton, equButton, delButton, clrButton, negButton;
      JPanel panel;
      Font font = new Font("Helvetica", Font.BOLD, 15);
      double num1 = 0, num2 = 0, result = 0;
      char operator;

      Calculator() {

            frame = new JFrame("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 600);
            frame.setLayout(null);

            textField = new JTextField();
            textField.setBounds(50, 25, 300, 50);
            textField.setFont(font);
            textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            textField.setEditable(false);

            addButton = new JButton("+");
            subButton = new JButton("-");
            mulButton = new JButton("*");
            divButton = new JButton("/");
            decButton = new JButton(".");
            equButton = new JButton("=");
            delButton = new JButton("Delete");
            clrButton = new JButton("Clear");
            negButton = new JButton("(-)");

            buttonFunctional[0] = addButton;
            buttonFunctional[1] = subButton;
            buttonFunctional[2] = mulButton;
            buttonFunctional[3] = divButton;
            buttonFunctional[4] = decButton;
            buttonFunctional[5] = equButton;
            buttonFunctional[6] = delButton;
            buttonFunctional[7] = clrButton;
            buttonFunctional[8] = negButton;

            // Adding styling to buttons using a loop for convenience:
            for (int i = 0; i < 9; i++) {
                  buttonFunctional[i].addActionListener(this);
                  buttonFunctional[i].setFont(font);
                  buttonFunctional[i].setBackground(Color.GRAY);
                  buttonFunctional[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
                  buttonFunctional[i].setForeground(Color.WHITE);
                  buttonFunctional[i].setFocusable(false);
            }
            negButton.setBounds(50, 430, 100, 50);
            delButton.setBounds(155, 430, 100, 50);
            clrButton.setBounds(260, 430, 100, 50);

            // Adding numeric buttons:
            for (int i = 0; i < 10; i++) {
                  buttonNumber[i] = new JButton(String.valueOf(i));
                  buttonNumber[i].addActionListener(this);
                  buttonNumber[i].setFont(font);
                  buttonNumber[i].setFocusable(false);
                  buttonNumber[i].setBorder(BorderFactory.createLineBorder(VERY_DARK_BLUE, 2));
                  buttonNumber[i].setBackground(Color.BLUE);
                  buttonNumber[i].setForeground(Color.WHITE);
            }

            panel = new JPanel();
            panel.setBounds(50, 100, 300, 300);
            panel.setLayout(new GridLayout(4, 4, 10, 10));
            // panel.setBackground(Color.BLUE);
            panel.add(buttonNumber[1]);
            panel.add(buttonNumber[2]);
            panel.add(buttonNumber[3]);
            panel.add(addButton);
            panel.add(buttonNumber[4]);
            panel.add(buttonNumber[5]);
            panel.add(buttonNumber[6]);
            panel.add(subButton);
            panel.add(buttonNumber[7]);
            panel.add(buttonNumber[8]);
            panel.add(buttonNumber[9]);
            panel.add(mulButton);
            panel.add(decButton);
            panel.add(buttonNumber[0]);
            panel.add(equButton);
            panel.add(divButton);

            frame.add(panel);
            frame.add(negButton);
            frame.add(delButton);
            frame.add(clrButton);
            frame.add(textField);
            frame.setVisible(true);
      }

      @Override
      public void actionPerformed(ActionEvent actionEvent) {
            for (int i = 0; i < 10; i++) {
                  if (actionEvent.getSource() == buttonNumber[i]) {
                        textField.setText(textField.getText().concat(String.valueOf(i)));
                  }
            }

            if (actionEvent.getSource() == decButton) {
                  textField.setText(textField.getText().concat("."));
            }

            if (actionEvent.getSource() == addButton) {
                  num1 = Double.parseDouble(textField.getText());
                  operator = '+';
                  textField.setText("");
            }

            if (actionEvent.getSource() == subButton) {
                  num1 = Double.parseDouble(textField.getText());
                  operator = '-';
                  textField.setText("");
            }

            if (actionEvent.getSource() == mulButton) {
                  num1 = Double.parseDouble(textField.getText());
                  operator = '*';
                  textField.setText("");
            }

            if (actionEvent.getSource() == divButton) {
                  num1 = Double.parseDouble(textField.getText());
                  operator = '/';
                  textField.setText("");
            }

            if (actionEvent.getSource() == equButton) {
                  num2 = Double.parseDouble(textField.getText());

                  switch (operator) {
                        case '+':
                              result = num1 + num2;
                              break;

                        case '-':
                              result = num1 - num2;
                              break;

                        case '*':
                              result = num1 * num2;
                              break;

                        case '/':
                              result = num1 / num2;
                              break;
                  }

                  textField.setText(String.valueOf(result));
                  num1 = result;
            }

            if (actionEvent.getSource() == clrButton) {
                  textField.setText("");
            }

            if (actionEvent.getSource() == delButton) {
                  String string = textField.getText();
                  textField.setText("");

                  for (int i = 0; i < string.length() - 1; i++) {
                        textField.setText(textField.getText() + string.charAt(i));
                  }
            }
            if (actionEvent.getSource() == negButton) {
                  double temp = Double.parseDouble(textField.getText());
                  temp *= -1;
                  textField.setText(String.valueOf(temp));
            }
      }
}
