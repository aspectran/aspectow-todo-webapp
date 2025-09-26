/*
 * Copyright (c) 2008-2024 The Aspectran Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.todo;

import com.aspectran.core.component.bean.annotation.Action;
import com.aspectran.core.component.bean.annotation.Autowired;
import com.aspectran.core.component.bean.annotation.Component;
import com.aspectran.core.component.bean.annotation.Dispatch;
import com.aspectran.core.component.bean.annotation.Redirect;
import com.aspectran.core.component.bean.annotation.RequestToGet;
import com.aspectran.core.component.bean.annotation.RequestToPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Activity for handling To-Do list operations.
 *
 * <p>Created: 2025. 09. 25.</p>
 */
@Component
public class TodoActivity {

    private static final Logger logger = LoggerFactory.getLogger(TodoActivity.class);

    private final TodoService todoService;

    @Autowired
    public TodoActivity(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * Shows the main to-do list page.
     * @return the list of todos to be displayed
     */
    @RequestToGet("/todos")
    @Dispatch("todo/list")
    @Action("todos") // Make this method also an action named "todos"
    public List<Todo> showTodoListPage() {
        logger.info("Request to show the to-do list page.");
        return todoService.getTodos(); // Return the list of todos
    }



    /**
     * Adds a new To-Do item.
     * @param task the task description from the request parameter
     */
    @RequestToPost("/todos")
    @Redirect("/todos")
    public void addTodo(String task) {
        if (task != null && !task.isBlank()) {
            todoService.addTodo(task);
            logger.info("Added new to-do: {}", task);
        }
    }

    /**
     * Deletes a To-Do item.
     * @param id the ID of the item to delete
     */
    @RequestToPost("/todos/${id}/delete")
    @Redirect("/todos")
    public void deleteTodo(long id) {
        todoService.deleteTodo(id);
        logger.info("Deleted to-do item with id: {}", id);
    }

    /**
     * Updates the completion status of a To-Do item.
     * @param id the ID of the item to update
     * @param completed the completion status from the request parameter
     */
    @RequestToPost("/todos/${id}/update")
    @Redirect("/todos")
    public void updateTodo(long id, boolean completed) {
        todoService.updateTodo(id, completed);
        logger.info("Updated completion status for to-do item with id: {}", id);
    }

}