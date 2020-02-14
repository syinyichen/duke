# User Guide

## Features 

### Add tasks
You can add and classify your tasks into three types: _todo_, _deadline_, and _event_.

### List out the tasks
Duke lists out the tasks you have added previously.

### Add status to a task
You can mark your task as _done_ or _undone_.

### Delete a task
You can delete an unwanted task from the existing tasks.

### Find tasks
You can search for tasks based on their descriptions.

### Sort the tasks
You can sort your tasks in the list by _time_ (time which the task has to be done), 
_task type_ (type of the tasks) and _task name_ (name of the task, in alphabetical order).

## Usage

### `hello` or `hi` - Greets Duke.
Duke will greet back. 

### `todo (task descriptions)` - Adds a _todo_ task.
A _todo_ task will be added to the tasks list.

### `deadline (task descriptions) /by (date and time)` - Adds a _deadline_.
A _deadline_ will be added to the tasks list.

Kindly take note that the date and time should be in the format of _yyyy-MM-dd HHmm_.

### `event (task descriptions) /at (date and time)` - Adds an _event_.
An _event_ will be added to the tasks list.

Kindly take note that the date and time should be in the format of _yyyy-MM-dd HHmm_.

### `list` - Lists out the tasks.
Duke will list out the existing tasks.

### `done (task's index)` - Marks a task as done.
The status of the task will be marked as done.

### `undone (task's index)` - Marks a task as undone.
The status of the task will be marked as undone.

### `delete (task's index)` - Deletes a tasks.
The task will be removed from the tasks list.

### `find (keyword)` - Finds tasks.
A list of tasks consisting of the keyword will be returned.

### `sort /by (description)` - Sorts the tasks list.
* To sort the tasks list by _time_ (in ascending order):
  * Kindly input: `sort /by time`
* To sort the tasks list by _task type_ (categorise the tasks by their types):
  * Kindly input: `sort /by task type`
* To sort the tasks list by _task name_ (in alphabetical order):
  * Kindly input: `sort /by task name`

### `bye` - Exits the window.