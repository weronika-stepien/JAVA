<div align="center">

# To-Do list
#### Organize and prioritize the tasks effectively


![Preview](/Images/todo.gif)

![Version](https://img.shields.io/badge/version-1.0-blue?style=for-the-badge&labelColor=black) ![Static Badge](https://img.shields.io/badge/3-blue?style=for-the-badge&logo=python&logoColor=blue&label=python&labelColor=black) ![Static Badge](https://img.shields.io/badge/django-black?style=for-the-badge&logo=Django&logoColor=blue)  ![Static Badge](https://img.shields.io/badge/windows%20%7C%20macOs%20%7C%20linux-blue?style=for-the-badge&label=platform&labelColor=black)










------------


![Static Badge](https://img.shields.io/badge/Table%20%20%20%20%20%20%20%20%20%20%20of%20%20%20%20%20%20%20%20%20%20Contents-blue?style=for-the-badge&logoColor=darkviolet)

**| [Overview](#overview) | [Key Features](#key-features) | [User Manual](#user-manual) | [Ongoing Improvements and Known Bugs](#ongoing-improvements-and-known-bugs) | [Found a Bug?](#found-a-bug) |**





------------



## Overview
This To-Do App is a web-based task organizer designed to help users keep track of daily activities. It provides users with the ability to log in, create tasks, edit task details, and mark tasks as completed. With an intuitive design and Django framework, the app is both secure and scalable.


------------



## Key Features
##### User Authentication
###### Secure login system allowing each user to manage their tasks privately.
##### Task Creation
######  Users can create new tasks by entering a title and description.
##### Edit Tasks
######  Modify task details such as title, description, or status.
##### Mark Tasks as Complete
###### Users can mark tasks as complete once they are finished.
##### Delete Tasks
###### Remove tasks from the list when no longer needed.
##### Task Filtering
###### Filter tasks by completion status or by search input.
##### Task Status Count
###### Display the number of tasks remaining or completed.


------------



## User Manual
</div>

####  Requirements
###### Python Version
The game requires `Python 3` or higher to run. You can check your  version by running below command:
```bash
$ python -version
```
###### SQLite
The To-Do List app comes with `SQLite` configured by default. It is a lightweight, serverless database, perfect for small-scale applications and development environments. No additional setup is required.

The default configuration for `SQLite` can be found in `settings.py`:
```python
DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.sqlite3',
        'NAME': BASE_DIR / 'db.sqlite3',
    }
}
```
Run migrations to create the necessary database tables.
```bash
python manage.py migrate
```
###### Dependencies
Install the required `Python` packages:
```bash
$ pip install -r requirements.txt
```

#### Getting Started
###### To run a program, you need to:
- Clone this repository
 ```bash
$ git clone <repository_url>
```

###### If you're using the executable file:
- Navigate to the repository's `releases` folder where the executable file is located.
- Double-click the executable file (`todo.jar`) to launch the game.
- If the executable does not open via double-click, run the following command from the terminal/command prompt:
```bash
$  python todo.jar
```

###### If you're running from Source Code
- Run the application:
```bash
$ python manage.py runserver
```
- Access the application via your web browser at:
```bash
http://localhost:8000
```

#### Customization
###### The task model
The task model can be extended to include additional fields or functionality:

**Steps to make the change:**
1. Open the `models.py` file in the `todo` directory.
2. Add new fields like priority, due date, or category:
```python
class Task(models.Model):
    title = models.CharField(max_length=200)
    description = models.TextField(null=True, blank=True)
    complete = models.BooleanField(default=False)
    priority = models.CharField(max_length=50, default='Medium')  # New field
    due_date = models.DateField(null=True, blank=True)  # New field
```
3. Run the following commands to apply the changes:
```bash
$ python manage.py makemigrations
$ python manage.py migrate
```

###### Database
The app uses `SQLite` by default, but you can change the database backend (e.g., `PostgreSQL` or `MySQL`):

**Steps to make the change:**
1. In `settings.py`, modify the `DATABASES` section:
```python
DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.postgresql',
        'NAME': 'todo_db',
        'USER': 'yourusername',
        'PASSWORD': 'yourpassword',
        'HOST': 'localhost',
        'PORT': '5432',
    }
}
```
2. Ensure you install the necessary database driver, e.g., `psycopg2` for `PostgreSQL`:
```bash
$ pip install psycopg2
```

------------
<div align="center">

## Ongoing Improvements and Known Bugs

##### So Far So Good






------------

## Found a bug?

If you encounter any issues or bugs while using this project, please feel free to open an issue in the Issues section of the repository. Make sure to describe the bug in detail, providing steps to reproduce, expected behavior, and any relevant logs or screenshots.

If you'd like to contribute a fix for the issue, you're welcome to submit a pull request (PR). When submitting a PR, please reference the issue number and provide a description of the changes made.


------------

</div>




