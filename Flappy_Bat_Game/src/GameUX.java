import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class GameUX extends JPanel implements ActionListener, KeyListener {

      //    Game logic
      Timer gameLoopTimer;
      Timer placePipesTimer;

      int velocityX = -5;
      int velocityY = -3;
      int gravity = 1;
      double score = 0;

      ArrayList<Pipe> pipes;

      boolean gameStart = false;
      boolean gameOver = false;

//    Game components classes

      //    BAT
      class Bat {
            int x = GameUI.batX;
            int y = GameUI.batY;
            int width = GameUI.batWidth;
            int height = GameUI.batHeight;
            Image img;

            //    Bat CONSTRUCTOR
            Bat(Image image) {
                  this.img = image;
            }
      }

      //    PIPE
      class Pipe {
            int x = GameUI.pipeX;
            int y = GameUI.pipeY;
            int width = GameUI.pipeWidth;
            int height = GameUI.pipeHeight;
            Image img;
            boolean passed = false;

            //    Pipe CONSTRUCTOR
            Pipe(Image image) {
                  this.img = image;
            }
      }

      //    Instantiating the objects
      Bat bat;

      //    CONSTRUCTOR
      GameUX() {
            setFocusable(true);
            setPreferredSize(new Dimension(GameUI.boardWidth, GameUI.boardHeight));
            addKeyListener(this);

            //    Setting the bat
            bat = new Bat(GameUI.batImg);

            //    Setting the pipe
            pipes = new ArrayList<>();

            //    Setting the pipe timer
            placePipesTimer = new Timer(1500, new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent actionEvent) {
                        placePipes();
                  }
            });

            //    Setting the background timer -> 60 fps  | 1000 / 60 = 16.6
            gameLoopTimer = new Timer(1000 / 40, this);
      }

      //    Method that creates pipes and adds them to the array list
      public void placePipes() {
            //   Making pipes spawn at random height
            int randomPipeY = (int) (GameUI.pipeY - GameUI.pipeHeight / 4 - Math.random() * (GameUI.pipeHeight / 2));

            //   Making sure that the bat will fit through space between pipes
            int gap = GameUI.boardHeight / 4;

            Pipe topPipe = new Pipe(GameUI.topPipeImg);
            topPipe.y = randomPipeY;
            pipes.add(topPipe);

            Pipe bottomPipe = new Pipe(GameUI.bottomPipeImg);
            bottomPipe.y = topPipe.y + GameUI.pipeHeight + gap;
            pipes.add(bottomPipe);
      }

      //    Methods that paint the gameplay
      public void paintComponent(Graphics graphicsPaint) {
            super.paintComponent(graphicsPaint);
            draw(graphicsPaint);
      }

      public void draw(Graphics graphicsDraw) {
            //    Drawing the background
            graphicsDraw.drawImage(GameUI.backgroundImg, 0, 0, GameUI.boardWidth, GameUI.boardHeight, null);

            //    Drawing the bat
            graphicsDraw.drawImage(bat.img, bat.x, bat.y, bat.width, bat.height, null);

            if (!gameStart) {
                  //    Drawing the text
                  graphicsDraw.setFont(new Font("Arial", Font.ITALIC, 30));
                  graphicsDraw.drawString("PRESS 'SPACE' TO START", 80, 320);
            }
            else {

                  //     Drawing the pipe
                  for (int i = 0; i < pipes.size(); i++) {
                        Pipe pipe = pipes.get(i);
                        graphicsDraw.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
                  }
            }

            //    Drawing the text
            graphicsDraw.setFont(new Font("Arial Black", Font.ITALIC, 56));
            graphicsDraw.setColor(Color.WHITE);

            if (gameOver) {
                  graphicsDraw.drawString("GAME OVER", 90, 200);
                  graphicsDraw.drawString("SCORE: " + (int) score, 115, 300);

                  graphicsDraw.setFont(new Font("Arial", Font.ITALIC, 20));
                  graphicsDraw.drawString("PRESS 'SPACE' TO RESTART", 110, 350);
            }
            else {
                  graphicsDraw.drawString(String.valueOf((int) score), 12, 45);
            }
      }

      //    Method that defines the movements
      public void move() {
            //    Updating the velocity with gravity to make the bat fall
            velocityY += gravity;

            //    Pushing the bat upwards with velocity
            bat.y += velocityY;

            //    Not letting the bat go past the screen
            bat.y = Math.max(bat.y, 0);

            //    Moving pipes to the left
            for (int i = 0; i < pipes.size(); i++) {
                  Pipe pipe = pipes.get(i);
                  pipe.x += velocityX;

                  //    Setting score rules -> if bat passes the right side of the pipe
                  if (!pipe.passed && bat.x > pipe.x + pipe.width) {
                        pipe.passed = true;
                        score += 0.5; //  0.5 because there are two pipes, so it's always 0.5 x 2 = 1 -> two sets of pipes
                  }

                  //    Setting game-over rules -> collision case
                  if (collision(bat, pipe)) {
                        gameOver = true;
                  }
            }

            //    Setting game-over rules -> out of the screen case
            if (bat.y > GameUI.boardHeight) {
                  gameOver = true;
            }

      }

      //    Method that detects collision with the pipes
      public boolean collision(Bat batsy, Pipe pipsy) {
            return batsy.x < pipsy.x + pipsy.width &&  //    bat's top left corner doesn't reach pipe's top right corner
                    batsy.x + batsy.width > pipsy.x &&  //    bat's top right corner passes pipe's top left corner
                    batsy.y < pipsy.y + pipsy.height && //    bat's top left doesn't reach pipe's bottom left corner
                    batsy.y + batsy.height > pipsy.y;   //    bat's bottom left corner passes pipe's top left corner

      }

      @Override
      public void actionPerformed(ActionEvent actionEvent) {
            if (gameStart) {
                  //    Updating bat position before repainting the background
                  move();

                  //    Calling the paint component function to repaint the background
                  repaint();
            }
            //    Stopping drawing components in case of game over
            if (gameOver) {
                  placePipesTimer.stop();
                  gameLoopTimer.stop();
            }
      }

      //    Method that assigns keyboard keys
      @Override
      public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
                  gameStart = true;

                  if (gameStart) {
                        velocityY = -12;
                        placePipesTimer.start();
                        gameLoopTimer.start();
                  }

                  //   Restarting the game by resetting the conditions
                  if (gameOver) {
                        bat.y = GameUI.batY;
                        velocityY = -3;
                        pipes.clear();
                        score = 0;
                        gameOver = false;
                        gameLoopTimer.start();
                        placePipesTimer.start();
                  }
            }
      }

      @Override
      public void keyTyped(KeyEvent keyEvent) {
      }

      @Override
      public void keyReleased(KeyEvent keyEvent) {
      }


}

