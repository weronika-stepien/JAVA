<div align="center">

# Earth Simulation
#### 3D sphere with high-resolution textures

![Preview](/Images/earth.gif)

![Version](https://img.shields.io/badge/version-1.0-blue?style=for-the-badge&labelColor=black) ![Static Badge](https://img.shields.io/badge/8-blue?style=for-the-badge&label=JAVA&labelColor=black) ![Static Badge](https://img.shields.io/badge/JAVAFX-black?style=for-the-badge)  ![Static Badge](https://img.shields.io/badge/windows%20%7C%20macOs%20%7C%20linux-blue?style=for-the-badge&label=platform&labelColor=black) 










------------


![Static Badge](https://img.shields.io/badge/Table%20%20%20%20%20%20%20%20%20%20%20of%20%20%20%20%20%20%20%20%20%20Contents-blue?style=for-the-badge&logoColor=darkviolet)

**| [Overview](#overview) | [Key Features](#key-features) | [User Manual](#user-manual) | [Ongoing Improvements and Known Bugs](#ongoing-improvements-and-known-bugs) | [Found a Bug?](#found-a-bug) |**





------------



## Overview
A 3D Earth simulation project built in JavaFX. It features a detailed model of Earth with geographic textures, dynamic lighting, and terrain elevation. The simulation allows for full user interaction, including mouse-controlled rotation and zooming.


------------



## Key Features
##### Mouse-Controlled Rotation
###### Users can rotate the Earth in any direction by clicking and dragging the mouse, allowing for a full 360-degree exploration of the globe.
##### Zoom Functionality
###### A vertical slider lets users zoom in and out, giving them control over how closely they want to view the 3D Earth model.
##### Terrain Elevation Mapping
###### Bump mapping is used to depict mountains, valleys, and other terrain features, providing a realistic three-dimensional effect on the Earth's surface.
##### Dynamic Lighting Effect
###### The simulation includes real-time lighting effects that simulate sunlight and shadow on the Earth's surface.
##### Illumination Map
###### The application uses an illumination map that simulates artificial lighting from cities, making the night side of the Earth glow with lights from urban areas.
##### Perspective Camera
###### The simulation uses a perspective camera to give users a realistic view of the Earth, with a sense of depth and scale as they rotate and zoom in.


------------



## User Manual
</div>

####  Requirements
###### Java Version
The game requires `Java 8` or higher to run. You can check your `Java` version by running below command:
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
- Double-click the executable file (`Earth3D.jar`) to launch the game.
- If the executable does not open via double-click, run the following command from the terminal/command prompt:
```bash
$  java -jar Earth3D.jar
```
###### If you're running from Source Code
- Open the project in your preferred `Java IDE` (e.g., IntelliJ IDEA, Eclipse).
- Run the `Application.java` class located in the `application.earth3d` package to launch the game.


------------
<div align="center">


## Ongoing Improvements and Known Bugs

| # | Name               | Type             | Description                                                                                                                       |
|---|--------------------|------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| 1 | Cloud Layer        | Work in progress | Adding a cloud layer that moves independently of the Earth’s surface, providing a more realistic view of the planet's atmosphere. |
| 2 | Zoom Slider Glitch | Bug              | The zoom slider may occasionally become unresponsive or "jump" to extremes when dragged quickly.                                  |





------------

## Found a bug?

If you encounter any issues or bugs while using this project, please feel free to open an issue in the Issues section of the repository. Make sure to describe the bug in detail, providing steps to reproduce, expected behavior, and any relevant logs or screenshots.

If you'd like to contribute a fix for the issue, you're welcome to submit a pull request (PR). When submitting a PR, please reference the issue number and provide a description of the changes made.


------------

</div>



