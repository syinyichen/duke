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

### Greets Duke: `hello` or `hi`
Duke will greet back. 


### Adds a _todo_ task: `todo (task descriptions)`
A _todo_ task will be added to the tasks list.


### Adds a _deadline_: `deadline (task descriptions) /by (date and time)`
A _deadline_ will be added to the tasks list.

Kindly take note that the date and time should be in the format of _yyyy-MM-dd HHmm_.


### Adds an _event_: `event (task descriptions) /at (date and time)`
An _event_ will be added to the tasks list.

Kindly take note that the date and time should be in the format of _yyyy-MM-dd HHmm_.


### Lists out the tasks: `list`
Duke will list out the existing tasks.


### Marks a task as _done_: `done (task's index)`
The status of the task will be marked as _done_.


### Marks a task as _undone_: `undone (task's index)`
The status of the task will be marked as _undone_.


### Deletes a task: `delete (task's index)`
The task will be removed from the tasks list.


### Finds tasks: `find (keyword)`
A list of tasks consisting of the keyword will be returned.


### Sorts the tasks list: `sort /by (description)`
* To sort the tasks list by _time_ (in ascending order):
  * Kindly input: `sort /by time`
* To sort the tasks list by _task type_ (categorise the tasks by their types):
  * Kindly input: `sort /by task type`
* To sort the tasks list by _task name_ (in alphabetical order):
  * Kindly input: `sort /by task name`


### Exits the window: `bye`