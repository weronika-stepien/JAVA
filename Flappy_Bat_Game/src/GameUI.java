import javax.swing.*;
import java.awt.*;

public class GameUI extends JFrame {
      //    Dimensions
      static final int boardWidth = 480;
      static final int boardHeight = 640;

      //    Images
      static Image backgroundImg;
      static Image batImg;
      static Image topPipeImg;
      static Image bottomPipeImg;

      //    Bat icon settings
      static int batX = GameUI.boardWidth / 8;
      static int batY = GameUI.boardHeight / 2;
      static final int batWidth = 50;
      static final int batHeight = 50;

      //    Pipes settings
      static int pipeX = boardWidth;
      static int pipeY = 0;
      static int pipeWidth = 64;
      static int pipeHeight = 512;


      GameUI() {
            setTitle("Flappy Bat");
            setSize(boardWidth, boardHeight);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setResizable(false);

            //    Setting the environment
            backgroundImg = new ImageIcon(getClass().getResource("IMG/background.png")).getImage();
            batImg = new ImageIcon(getClass().getResource("IMG/bat.png")).getImage();
            topPipeImg = new ImageIcon(getClass().getResource("IMG/top.png")).getImage();
            bottomPipeImg = new ImageIcon(getClass().getResource("IMG/bottom.png")).getImage();


//    Adding JPanel to the frame
            GameUX panel = new GameUX();

            add(panel);
            pack();

            panel.requestFocus();

            setVisible(true);
      }


}
