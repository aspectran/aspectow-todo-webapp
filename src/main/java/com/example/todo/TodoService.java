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

import com.aspectran.core.component.bean.annotation.Bean;
import com.aspectran.core.component.bean.annotation.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Service class for managing To-Do items.
 *
 * <p>Created: 2025. 09. 25.</p>
 */
@Component
@Bean("todoService")
public class TodoService {

    private final List<Todo> todos = Collections.synchronizedList(new ArrayList<>());
    private final AtomicLong counter = new AtomicLong();

    public TodoService() {
        // Add some initial data
        addTodo("Learn Aspectran");
        addTodo("Build a To-Do App");
        addTodo("Profit!");
    }

    public List<Todo> getTodos() {
        return new ArrayList<>(todos);
    }

    public Todo getTodo(long id) {
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Todo addTodo(String task) {
        Todo newTodo = new Todo(counter.incrementAndGet(), task);
        todos.add(newTodo);
        return newTodo;
    }

    public Todo updateTodo(long id, boolean completed) {
        Todo todo = getTodo(id);
        if (todo != null) {
            todo.setCompleted(completed);
        }
        return todo;
    }

    public boolean deleteTodo(long id) {
        return todos.removeIf(todo -> todo.getId() == id);
    }
}
