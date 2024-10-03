import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener {

      JFrame frame = new JFrame("Timer");
      JButton buttonStart = new JButton("START");
      JButton buttonReset = new JButton("RESET");
      JLabel label = new JLabel();
      int elapsedTime = 0, seconds = 0, minutes = 0, hours = 0;
      boolean isStarted = false;
      String seconds_string = String.format("%02d", seconds);
      String minutes_string = String.format("%02d", minutes);
      String hours_string = String.format("%02d", hours);
      Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  // Everything the timer will do every second:
                  elapsedTime += 1000;
                  hours = (elapsedTime / 3600000);
                  minutes = (elapsedTime / 60000) % 60;
                  seconds = (elapsedTime / 1000) % 60;
                  seconds_string = String.format("%02d", seconds);
                  minutes_string = String.format("%02d", minutes);
                  hours_string = String.format("%02d", hours);
                  label.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
            }
      });

      Stopwatch() {
            label.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
            label.setBounds(100, 100, 200, 100);
            label.setFont(new Font("Verdana", Font.BOLD, 35));
            label.setBorder(BorderFactory.createBevelBorder(1, Color.blue, Color.black));
            label.setHorizontalAlignment(JTextField.CENTER);
            label.setOpaque(true);

            buttonStart.setBounds(100, 200, 100, 50);
            buttonStart.setFont(new Font("Arial", Font.BOLD, 20));
            buttonStart.setFocusable(false);
            buttonStart.addActionListener(this);

            buttonReset.setBounds(200, 200, 100, 50);
            buttonReset.setFont(new Font("Arial", Font.BOLD, 20));
            buttonReset.setFocusable(false);
            buttonReset.addActionListener(this);

            frame.add(label);
            frame.add(buttonStart);
            frame.add(buttonReset);

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLayout(null);
            frame.setSize(420, 420);
            frame.setVisible(true);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonStart) {
                  if (!isStarted) {
                        isStarted = true;
                        buttonStart.setText("STOP");
                        start();
                  } else {
                        isStarted = false;
                        buttonStart.setText("START");
                        stop();
                  }
            }
            if (e.getSource() == buttonReset) {
                  isStarted = false;
                  buttonStart.setText("START");
                  restart();
            }
      }

      void start() {
            timer.start();
      }

      void stop() {
            timer.stop();
      }

      void restart() {
            timer.stop();
            elapsedTime = 0;
            seconds = 0;
            minutes = 0;
            hours = 0;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            label.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
      }
}
