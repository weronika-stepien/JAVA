import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public class MyFrame extends JFrame {

      SimpleDateFormat timeFormat, dayFormat, monthFormat, zoneFormat;
      JLabel timeLabel, dayLabel, monthLabel, zoneLabel;
      String time, day, month, zone;

      // Constructor:

      MyFrame() {

            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setLayout(new FlowLayout());
            this.setSize(150, 100);
            this.setResizable(false);
            this.setTitle("Clock");

            // https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#text

            timeFormat = new SimpleDateFormat("k:mm:ss a");
            dayFormat = new SimpleDateFormat("EEEE");
            monthFormat = new SimpleDateFormat("MMMMM");
            zoneFormat = new SimpleDateFormat("z");

            // METHOD CHAINING ||| The variable 'time' will hold the current time from the 'timeFormat' variable:

            time = timeFormat.format(Calendar.getInstance().getTime());
            day = dayFormat.format(Calendar.getInstance().getTime());
            month = monthFormat.format(Calendar.getInstance().getTime());
            zone = zoneFormat.format(Calendar.getInstance().getTime());

            // Display the date using JLabel:

            timeLabel = new JLabel();
            timeLabel.setText(time);

            dayLabel = new JLabel();
            dayLabel.setText(day);

            monthLabel = new JLabel();
            monthLabel.setText(month);

            zoneLabel = new JLabel();
            zoneLabel.setText(zone);

            this.add(timeLabel);
            this.add(dayLabel);
            this.add(monthLabel);
            this.add(zoneLabel);
            this.setVisible(true);

            // Call the method that will refresh the time every second, creating the clock effect:

            refreshTime();
      }

      // Create a method that will refresh the time every second, creating the clock effect:

      public void refreshTime() {

            while (true) {
                  time = timeFormat.format(Calendar.getInstance().getTime());
                  timeLabel.setText(time);

                  try {
                        Thread.sleep(1000);
                  } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                  }
            }
      }
}
