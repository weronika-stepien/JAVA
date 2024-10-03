<div align="center">

# Flappy Bat
#### A fun and challenging take on the classic Flappy Bird mechanics


![Preview](/Images/Flappy-Game.gif)

![Version](https://img.shields.io/badge/version-1.0-blue?style=for-the-badge&labelColor=black) ![Static Badge](https://img.shields.io/badge/11-blue?style=for-the-badge&label=JAVA&labelColor=black) ![Static Badge](https://img.shields.io/badge/JAVAFX-black?style=for-the-badge)  ![Static Badge](https://img.shields.io/badge/windows%20%7C%20macOs%20%7C%20linux-blue?style=for-the-badge&label=platform&labelColor=black)










------------


![Static Badge](https://img.shields.io/badge/Table%20%20%20%20%20%20%20%20%20%20%20of%20%20%20%20%20%20%20%20%20%20Contents-blue?style=for-the-badge&logoColor=darkviolet)

**| [Overview](#overview) | [Key Features](#key-features) | [User Manual](#user-manual) | [Ongoing Improvements and Known Bugs](#ongoing-improvements-and-known-bugs) | [Found a Bug?](#found-a-bug) |**





------------



## Overview
Flappy Bat is a 2D game where players navigate a bat through a series of vertical pipes. The player must time their taps on the Spacebar to avoid crashing into the pipes or falling to the ground. The game includes score tracking and a restart feature after  game over.


------------



## Key Features
##### Single-Key Gameplay
###### Players use only the Spacebar to control the bat’s flight, making the game intuitive and easy to play.
##### Gravity Simulation
###### The bat is affected by gravity, pulling it downward unless the player presses the Spacebar to counteract it.
##### Dynamic Pipe Placement
###### Each pair of pipes appears at randomized vertical positions, ensuring that no two games are identical.
##### Collision Detection
######  The game features precise collision detection between the bat and pipes, ensuring accurate game-over events.
##### Smooth Game Loop
###### The game runs at a steady 40 frames per second, providing fluid movement for the bat and background.
##### Score Tracking System
###### The player’s score is calculated based on the number of pipes successfully passed, which is displayed on-screen.


------------



## User Manual
</div>

####  Requirements
###### Java Version
The game requires `Java 11` or higher to run. You can check your `Java` version by running below command:
```bash
$ java -version
```

#### Getting Started
###### To run a program, you need to:
- Clone this repository
 ```bash
$ git clone <repository_url>
```
###### If you're using the executable file:
- Navigate to the repository's `releases` folder where the executable file is located.
- Double-click the executable file (`FlappyBatGame.jar`) to launch the game.
- If the executable does not open via double-click, run the following command from the terminal/command prompt:
```bash
$  java -jar FlappyBatGameGame.jar
```
###### If you're running from Source Code
- Open the project in your preferred `Java IDE` (e.g., IntelliJ IDEA, Eclipse).
- Run the `Main.java` class located in the `src/Main.java` to launch the game.

#### Customization
###### Changing the Background Image
The background image is stored in the `IMG/` folder as `background.png`.

**To change the background:**
- Replace the `background.png` file with your desired image.
- Ensure the new image has the same file name or update the image path in the `GameUI.java` file:
```java
$ backgroundImg = new ImageIcon(getClass().getResource("IMG/background.png")).getImage();
```

- You may need to adjust the size of the background to fit the screen:
```java
$ graphicsDraw.drawImage(GameUI.backgroundImg, 0, 0, GameUI.boardWidth, GameUI.boardHeight, null);
```

###### Modifying the Bat Image
The bat image is stored in the `IMG/` folder as `bat.png`.

**To change the bat’s appearance:**
- Replace `bat.png` with your new image file.
- Ensure the new image has the same dimensions or adjust the size in `GameUI.java`:
```java
$ batImg = new ImageIcon(getClass().getResource("IMG/bat.png")).getImage();
$ batWidth = 50;  // Change width as needed
$ batHeight = 50; // Change height as needed
```
- Optionally, modify the bat’s starting position:
```java
$ batX = GameUI.boardWidth / 8;
$ batY = GameUI.boardHeight / 2;
```
###### Customizing the Pipe Images
The pipes are defined by two images: `top.png` and `bottom.png`, stored in the `IMG/` folder.

**To change the appearance of the pipes:**
- Replace the `top.png` and `bottom.png` files with your custom pipe images.
- Ensure the image dimensions are appropriate, or adjust the pipe width and height in `GameUI.java`:
```java
// Adjusting the width of the pipes
$  pipeWidth = 64;  

// Adjusting the height of the pipes
$ pipeHeight = 512; 
```

###### Adjusting Game Difficulty
You can modify the difficulty of the game by changing the gap between the pipes, the bat’s velocity, or gravity:
- Pipe Gap: To make the game harder or easier, adjust the gap between the top and bottom pipes in GameUX.java:
```java
// Reduce for more difficulty, increase for easier gameplay
$ int gap = GameUI.boardHeight / 4; 
```
- Bat Velocity: Modify the speed at which the bat moves in GameUX.java:
```java
// Increase for a stronger jump
$  velocityY = -12;  
// Adjust gravity to change the bat’s downward speed
$ gravity = 1;  
```
###### Speeding Up or Slowing Down the Game
If you want to change the overall game speed, modify the timers in GameUX.java:

- Game Loop Timer: Controls the frame rate, which is set to 40 fps by default
```java
// Lower the value for a faster game, increase for slower gameplay
$ gameLoopTimer = new Timer(1000 / 40, this);  
```
- Pipe Spawning Timer: Controls how often new pipes appear
```java
// Decrease for faster pipe spawning
$ placePipesTimer = new Timer(1500, actionEvent -> placePipes());  
```
------------
<div align="center">

## Ongoing Improvements and Known Bugs

| # | Name                    | Type             | Description                                                                                                                                         |
|---|-------------------------|------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| 1 | Difficulty Levels       | Work in progress | Introducing selectable difficulty levels (Easy, Medium, Hard) where the gravity, pipe gap, and pipe speed will vary based on the chosen difficulty. |
| 2 | Leaderboard             | Work in progress | Implementing a local leaderboard that records high scores across multiple sessions, allowing players to track their best performances.              |
| 3 | Customizable Characters | Work in progress | Adding different bat skins or characters that players can select before starting the game.                                                          |
| 4 | Frame Rate Drops        | Bug              | On certain systems, the game may experience slight frame rate drops, especially when multiple pipes are on the screen at once.                      |





------------

## Found a bug?

If you encounter any issues or bugs while using this project, please feel free to open an issue in the Issues section of the repository. Make sure to describe the bug in detail, providing steps to reproduce, expected behavior, and any relevant logs or screenshots.

If you'd like to contribute a fix for the issue, you're welcome to submit a pull request (PR). When submitting a PR, please reference the issue number and provide a description of the changes made.


------------

</div>




