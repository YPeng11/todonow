const taskList = document.getElementById('task-list');
const taskTitle = document.getElementById('task-title');
const taskDueDate = document.getElementById('task-due-date');
const createTaskButton = document.getElementById('create-task');

// Event listener for creating tasks
createTaskButton.addEventListener('click', () => {
    if (taskTitle.value === '' || taskDueDate.value === '') {
        alert('Please provide both task title and due date');
        return;
    }

    const task = {
        title: taskTitle.value,
        dueDate: taskDueDate.value,
        completed: false
    };

    fetch('http://localhost:8080/api/tasks', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(task)
    })
    .then(response => response.json())
    .then(newTask => {
        addTaskToList(newTask);
        taskTitle.value = '';
        taskDueDate.value = '';
    });
});

// Add task to the list in the DOM
function addTaskToList(task) {
    const li = document.createElement('li');
    li.innerHTML = `${task.title} - Due: ${new Date(task.dueDate).toLocaleString()} <button class="complete-task">Complete</button>`;
    taskList.appendChild(li);

    const completeButton = li.querySelector('.complete-task');
    completeButton.addEventListener('click', () => {
        markTaskAsCompleted(li, task);
    });
}

// Mark task as completed
function markTaskAsCompleted(li, task) {
    task.completed = true;
    li.classList.add('completed');
    li.querySelector('.complete-task').remove();
}

// Fetch and display tasks on page load
fetch('http://localhost:8080/api/tasks')
    .then(response => response.json())
    .then(tasks => {
        tasks.forEach(addTaskToList);
    });
