package application.rpsdemo;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controller {
      //    Creating variables
      private static final String ROCK = "Rock";
      private static final String PAPER = "Paper";
      private static final String SCISSORS = "Scissors";
      private Image image;

      //    Getting components from Scene Builder
      @FXML
      private Button paperButton;
      @FXML
      private ImageView playerChoice1;
      @FXML
      private ImageView playerChoice2;
      @FXML
      private Label playerScore1;
      @FXML
      private Label playerScore2;
      @FXML
      private Label results;
      @FXML
      private Button rockButton;
      @FXML
      private Button scissorsButton;

      //    Creating method to set user options
      @FXML
      private void player1Turn(ActionEvent actionEvent) throws FileNotFoundException {
            String choice1 = null;

            switch (((Button) actionEvent.getSource()).getId()) {
                  case "rockButton":
                        image = new Image(new FileInputStream("/home/W/IT/JAVA/PORTFOLIO/RPSdemo/src/main/resources/application/rpsdemo/pictures/stone-big.png"));
                        choice1 = ROCK;
                        break;
                  case "paperButton":
                        image = new Image(new FileInputStream("/home/W/IT/JAVA/PORTFOLIO/RPSdemo/src/main/resources/application/rpsdemo/pictures/toilet-paper-big.png"));
                        choice1 = PAPER;
                        break;
                  case "scissorsButton":
                        image = new Image(new FileInputStream("/home/W/IT/JAVA/PORTFOLIO/RPSdemo/src/main/resources/application/rpsdemo/pictures/scissors2-big.png"));
                        choice1 = SCISSORS;
                        break;
            }
            //    Changing the picture to chosen game option from SWITCH
            playerChoice1.setImage(image);

            //    Calling computer to play its move
            game(choice1, player2Turn());
      }

      private String player2Turn() throws FileNotFoundException {
            String choice2 = null;
            int index = (int) (Math.random() * 3);

            switch (index) {
                  case 0:
                        image = new Image(new FileInputStream("/home/W/IT/JAVA/PORTFOLIO/RPSdemo/src/main/resources/application/rpsdemo/pictures/stone-big.png"));
                        choice2 = ROCK;
                        break;
                  case 1:
                        image = new Image(new FileInputStream("/home/W/IT/JAVA/PORTFOLIO/RPSdemo/src/main/resources/application/rpsdemo/pictures/toilet-paper-big.png"));
                        choice2 = PAPER;
                        break;
                  case 2:
                        image = new Image(new FileInputStream("/home/W/IT/JAVA/PORTFOLIO/RPSdemo/src/main/resources/application/rpsdemo/pictures/scissors2-big.png"));
                        choice2 = SCISSORS;
                        break;
            }

            //    Changing the picture to chosen game option from SWITCH
            playerChoice2.setImage(image);

            //    Returning second player choice
            return choice2;
      }

      //    Creating method to display each user score
      public void firstPlayerWins() {
            results.setText("You won!");
            playerScore1.setText(String.valueOf(Integer.parseInt(playerScore1.getText()) + 1));
      }

      public void secondPlayerWins() {
            results.setText("You lose");
            playerScore2.setText(String.valueOf(Integer.parseInt(playerScore2.getText()) + 1));
      }

      // Creating method to display draw
      public void draw() {
            results.setText("DRAW!");
      }

      //    Creating method to set gameplay rules
      private void game(String firstPlayerChoice, String secondPlayerChoice) {
            if (firstPlayerChoice.equals(secondPlayerChoice)) {
                  draw();
                  return;
            }
            if (firstPlayerChoice.equals(ROCK)) {
                  if (secondPlayerChoice.equals(PAPER)) {
                        secondPlayerWins();
                  }
                  else if (secondPlayerChoice.equals(SCISSORS)) {
                        firstPlayerWins();
                  }
            }
            else if (firstPlayerChoice.equals(PAPER)) {
                  if (secondPlayerChoice.equals(ROCK)) {
                        firstPlayerWins();
                  }
                  else if (secondPlayerChoice.equals(SCISSORS)) {
                        secondPlayerWins();
                  }
            }
            else {
                  if (secondPlayerChoice.equals(ROCK)) {
                        secondPlayerWins();
                  }
                  else if (secondPlayerChoice.equals(PAPER)) {
                        firstPlayerWins();
                  }
            }


      }


}






