# Task Tracker CLI

A simple **command-line task tracking application** built using **Java**.  
It allows users to manage tasks directly from the terminal and stores data in a local JSON file.



## Features

- Persistent storage using a JSON file
- No external libraries or frameworks


## Installation

1. **Clone the repository:**

   ```
   git clone https://github.com/Utkarsh-git-init/task-cli
   cd task-cli
   cd src
2. **Compile the source code:**
    ```
   javac *.java
3. **Run the application:**
    ```
   java TaskCLI <command> [arguments]
   ```
- json file will be created in src folder 
## Usage
````
# Adding a new task
java TaskCLI add "Buy groceries"
# Output: Task added successfully (ID: 1)

# Updating a task
java TaskCLI update 1 "Buy groceries and cook dinner"
# Output: Task updated successfully (ID: 1)

# Deleting a task
java TaskCLI delete 1
# Output: Task deleted successfully (ID: 1)

# Marking a task as in progress
java TaskCLI mark-in-progress 1
# Output: Task marked as in progress (ID: 1)

# Marking a task as done
java TaskCLI mark-done 1
# Output: Task marked as done (ID: 1)

# Listing all tasks
java TaskCLI list

# Listing tasks by status
java TaskCLI list todo
java TaskCLI list in-progress
java TaskCLI list done
````