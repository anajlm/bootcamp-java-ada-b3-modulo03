package tech.ada.java.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.java.todolist.domain.TodoItem;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
