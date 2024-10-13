<div align="center">

# Gym Management System
#### Manage members with JavaFX UI


![Preview](/Images/gym.gif)

![Version](https://img.shields.io/badge/version-1.0-blue?style=for-the-badge&labelColor=black) ![Static Badge](https://img.shields.io/badge/8-blue?style=for-the-badge&label=java&labelColor=black) ![Static Badge](https://img.shields.io/badge/javafx-black?style=for-the-badge) ![Static Badge](https://img.shields.io/badge/CSS3-black?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Connected-blue?style=for-the-badge&labelColor=black)









------------


![Static Badge](https://img.shields.io/badge/Table%20%20%20%20%20%20%20%20%20%20%20of%20%20%20%20%20%20%20%20%20%20Contents-blue?style=for-the-badge&logoColor=darkviolet)

**| [Overview](#overview) | [Key Features](#key-features) | [User Manual](#user-manual) | [Ongoing Improvements and Known Bugs](#ongoing-improvements-and-known-bugs) | [Found a Bug?](#found-a-bug) |**




------------



## Overview
A Java-based Gym Management System designed to automate routine gym tasks like member registration, coach assignment, and payment processing. It integrates with MySQL for data storage and retrieval, offering a smooth and efficient user experience.


------------



## Key Features
##### User Authentication
###### The system includes a secure login mechanism that verifies users before granting access to the dashboard and other features.
##### Interactive Dashboard
###### Users are presented with a dashboard that provides key metrics such as the number of active members, total coaches, and daily income.
##### Database Integration
###### The system connects to a MySQL database for persistent data storage, ensuring that all records are securely saved and easily retrievable.
##### Role-Based Access Control
###### Different levels of access are provided based on user roles, with administrators having full access and regular users limited to their own data.
##### Member / Coach Management
###### Administrators can add, update, delete members and coaches records, including personal details like name, age, contact information, and membership status.
##### Coach Assignment
###### The system allows administrators to assign members to specific coaches, ensuring that each coach has an updated roster of members to train.


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
- Double-click the executable file (`GymManagementSystem.jar`) to launch the game.
- If the executable does not open via double-click, run the following command from the terminal/command prompt:
```bash
$  java -jar GymManagementSystem.jar
```
###### If you're running from Source Code
- Open the project in your preferred  `IDE` (e.g. IntelliJ IDEA, Eclipse).
- Make sure you have `MySQL` set up and the database schema loaded (details on how to set up the database can be found in the `Database Setup` section).
- Run the `Main.java` class located in the `application.gymmanagementsystem` package to launch the game.

#### Database Setup
###### MySQL
- Install `MySQL` on your local machine.
- Create a new database and import the provided SQL schema file (`gym_management.sql`) from the repository to set up the required tables.
- Update the `Database.java` file with your MySQL credentials (username, password, database name) to ensure proper connectivity:
```java
$ String url = "jdbc:mysql://localhost:3306/your_database_name";
$ String user = "your_username";
$ String password = "your_password";
```
> If your getting error while trying to start `mysql.service` try `sudo systemctl restart httpd.service`

##### Customization
###### Changing the Application Theme
The application's look and feel can be customized by modifying the `CSS` stylesheets used in the `JavaFX` user interface.

**Steps to make the change:**
1. Navigate to the resources folder in the project structure.
2. Locate the `style.css` file.
3. Modify the `CSS` properties to change colors, fonts, button styles, etc. For example, to change the background color of the dashboard, update:
```css
.dashboard 
{
    -fx-background-color: #f0f0f0; /* Change this value to your desired color */
}
```
You can also replace the `CSS` file with a new one to implement a completely different theme.

###### Changing the Logo or Branding
You can change the logo displayed in the application to fit your gym’s branding.

**Steps to make the change:**
1. Navigate to the resources folder and locate the `logo.png` file.
2. Replace the `logo.png` file with your own image.
3. Ensure the new image file has the same dimensions as the original, or modify the layout constraints in the `FXML` file that handles the logo:
```xml
<ImageView fx:id="logoImage" fitWidth="150" fitHeight="150" />
```

###### Customizing Member or Coach Data Fields
The system currently stores predefined data for members and coaches. You can add or remove fields depending on your needs.

**Steps to make the change:**
1. Update the database schema to include the new field. For example, to add a `membership_level` field to members, alter the members table:
```sql
$ ALTER TABLE members ADD membership_level VARCHAR(50);
```
2. Modify the `MemberData.java` or `CoachData.java` classes to reflect the new field:
```java
$ private String membershipLevel;
```
3. Update the user interface in the corresponding `FXML` files to include input forms for the new field.
4. Modify the `SQL` queries in `Database.java` to handle the new field when adding, updating, or deleting records.
------------
<div align="center">


## Ongoing Improvements and Known Bugs

| # | Name                   | Type             | Description                                                                                                                             |
|---|------------------------|------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| 1 | Data Import and Export | Work in progress |  Providing options to import and export data, such as member lists or financial records, in various formats (CSV, Excel, PDF).          |
| 2 | Special Characters     | Bug              | Input fields (especially in member and coach profiles) do not currently handle special characters correctly, causing validation errors. |






------------



## Found a bug?

If you encounter any issues or bugs while using this project, please feel free to open an issue in the Issues section of the repository. Make sure to describe the bug in detail, providing steps to reproduce, expected behavior, and any relevant logs or screenshots.

If you'd like to contribute a fix for the issue, you're welcome to submit a pull request (PR). When submitting a PR, please reference the issue number and provide a description of the changes made.


------------

</div>



