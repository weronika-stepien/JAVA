import javax.swing.*;
import java.sql.*;

public class Main {


      public static void main(String[] args)
      {
            SwingUtilities.invokeLater
                    (
                            new Runnable()
                            {
                                  @Override
                                  public void run()
                                  {
                                        Calculator calculator = new Calculator();
                                  }
                            }
                    );

          ///  Container container = new Container();
      }

}