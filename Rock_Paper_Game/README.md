# Rock-Paper-Scissors
#### JavaFX-based implementation of the classic game


![Preview](/Images/RPS-GAME.gif)

![Version](https://img.shields.io/badge/version-1.0-blue?style=for-the-badge&labelColor=black) ![Static Badge](https://img.shields.io/badge/11-blue?style=for-the-badge&label=JAVA&labelColor=black) ![Static Badge](https://img.shields.io/badge/JAVAFX-black?style=for-the-badge)  ![Static Badge](https://img.shields.io/badge/windows%20%7C%20macOs%20%7C%20linux-blue?style=for-the-badge&label=platform&labelColor=black)










------------


![Static Badge](https://img.shields.io/badge/Table%20%20%20%20%20%20%20%20%20%20%20of%20%20%20%20%20%20%20%20%20%20Contents-blue?style=for-the-badge&logoColor=darkviolet)

**| [Overview](#overview) | [Key Features](#key-features) | [User Manual](#user-manual) | [Ongoing Improvements and Known Bugs](#ongoing-improvements-and-known-bugs) | [Found a Bug?](#found-a-bug) |**





------------



## Overview
The Rock-Paper-Scissors game allows players to interact with a JavaFX interface, selecting their move while the computer responds with a randomly chosen move. Results are displayed immediately, with scores automatically updated after each round.


------------



## Key Features
##### Clear Gameplay
###### The game enforces the standard rules of Rock-Paper-Scissors, determining the winner based on the classic game logic.
##### Visual Feedback for Choices
###### Both player and computer choices are represented by corresponding images, making the game more engaging.
##### Randomized Opponent Move
###### The computer randomly selects its move, adding an element of surprise and ensuring fair play.
##### Game Status Display
###### The results of each round—win, lose, or draw—are clearly shown to the player using a label on the interface.
##### Real-Time Score Update
###### Player and computer scores are updated immediately after each round, displayed clearly on the screen.


------------



## User Manual
</div>

####  Requirements
###### Java Version
The game requires `Java 11` or higher to run. You can check your `Java` version by running below command:
```bash
$ java -version
```
###### JavaFX
If you are running the game from source code, make sure `JavaFX` is installed and configured.You can do that by running below command:
- for DPKG-based systems::
```bash
# You can check if JavaFX is installed by searching for its package:
dpkg -l | grep openjfx
```
-  for RPM-based systems:
```bash
rpm -qa | grep openjfx
```
- For Windows and macOS:
  There is no specific package manager, but you can check if you have the `javafx` libraries downloaded under your project or JDK installation directories.

#### Getting Started
###### To run a program, you need to:
- Clone this repository
 ```bash
$ git clone <repository_url>
```
###### If you're using the executable file:
- Navigate to the repository's `releases` folder where the executable file is located.
- Double-click the executable file (`RPSdemo.jar`) to launch the game.
- If the executable does not open via double-click, run the following command from the terminal/command prompt:
```bash
$  java -jar RPSdemo.jar
```
###### If you're running from Source Code
- Open the project in your preferred `Java IDE` (e.g., IntelliJ IDEA, Eclipse).
- Run the `Main.java` class located in the `application.rpsdemo` package to launch the game.

#### Customization
###### Changing the Background Image
The background image used in the game is stored in the resources folder.

**To change the background image:**
- Replace the existing image at `src/main/resources/application/rpsdemo/pictures/background.jpg` with your desired image file.
- Ensure the new image is named `background.jpg` or update the file path in the `Main.java` file:
```java
$ Image image = new Image(new FileInputStream("/path/to/your/background.jpg"));
```
- Ensure the image dimensions match or adjust the size in the code by updating these lines:
```java
$ backgroundImg.setFitWidth(790); 
$ backgroundImg.setFitHeight(544);
```

###### Game Appearance
- You can modify the appearance of buttons, labels, and other UI elements in the `style.fxml` file.
- To change button styles or text appearance, edit the relevant properties in the FXML file or add CSS styles.
- For example to change the button font or color, you can update the `style.fxml` file as follows:
```xml
<Button id="rockButton" text="Rock" style="-fx-font-size: 16px; -fx-background-color: #ff0000;" />
```

------------
<div align="center">

## Ongoing Improvements and Known Bugs

| # | Name                    | Type             | Description                                                                                                              |
|---|-------------------------|------------------|--------------------------------------------------------------------------------------------------------------------------|
| 1 | Sound Effects           | Work in progress | Adding sound effects for player actions (e.g., button clicks, game results) to make the game more engaging.              |
| 2 | Statistics Tracking     | Work in progress | Implementing a feature to record and display player statistics (win/loss/draw history) over multiple sessions.           |
| 3 | Theming Options         | Work in progress | Adding the ability to switch between different visual themes, allowing users to customize the look and feel of the game. |
| 4 | Delayed Image Rendering | Bug              | Occasionally, there is a slight delay in rendering the images representing the player's or computer's choice.            |




------------

## Found a bug?

If you encounter any issues or bugs while using this project, please feel free to open an issue in the Issues section of the repository. Make sure to describe the bug in detail, providing steps to reproduce, expected behavior, and any relevant logs or screenshots.

If you'd like to contribute a fix for the issue, you're welcome to submit a pull request (PR). When submitting a PR, please reference the issue number and provide a description of the changes made.


------------

</div>




