# Task Tracker CLI

A simple **command-line task tracking application** built using **Java**.  
It allows users to manage tasks directly from the terminal and stores data in a local JSON file.



## Features

- Persistent storage using a JSON file
- No external libraries or frameworks

## Usage
````
# Adding a new task
task-cli add "Buy groceries"
# Output: Task added successfully (ID: 1)

# Updating a task
task-cli update 1 "Buy groceries and cook dinner"
# Output: Task updated successfully (ID: 1)

# Deleting a task
task-cli delete 1
# Output: Task deleted successfully (ID: 1)

# Marking a task as in progress
task-cli mark-in-progress 1
# Output: Task marked as in progress (ID: 1)

# Marking a task as done
task-cli mark-done 1
# Output: Task marked as done (ID: 1)

# Listing all tasks
task-cli list

# Listing tasks by status
task-cli list todo
task-cli list in-progress
task-cli list done
````