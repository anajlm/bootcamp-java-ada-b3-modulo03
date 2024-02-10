package tech.ada.java.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.java.todolist.domain.TodoItem;
import tech.ada.java.todolist.dto.TodoItemDTO;
import tech.ada.java.todolist.repository.TodoItemRepository;

import java.util.List;
import java.util.Optional;

//@RequiredArgsConstructor
@RestController("/todo")
public class TodoController {

    private final TodoItemRepository todoItemRepository;
    private final ModelMapper modelMapper;

    public TodoController(TodoItemRepository todoItemRepository, ModelMapper modelMapper) {
        this.todoItemRepository = todoItemRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/cadastrar-item")
    public ResponseEntity<TodoItem> cadastrarItem(@RequestBody TodoItemDTO todoItemDTO) {
        //TodoItem todoItem = todoItemDTO.toEntity();
        TodoItem todoItem = modelMapper.map(todoItemDTO, TodoItem.class);
        /*todoItem.setTitulo(todoItemDTO.titulo());
        todoItem.setDescricao(todoItemDTO.descricao());
        todoItem.setPrazoFinal(todoItemDTO.prazoFinal());*/
        return ResponseEntity.status(HttpStatus.CREATED).body(todoItemRepository.save(todoItem));
    }

    @GetMapping("/listar-itens")
    public List<TodoItem> buscarTodos() {
        return todoItemRepository.findAll();
    }

    @PatchMapping("todo-item/{id}")
    public ResponseEntity<TodoItem> alterarStatus(@PathVariable Long id, @RequestBody String status){
        Optional<TodoItem> optionalTodoItem = todoItemRepository.findById(id);
        if(optionalTodoItem.isPresent()){
            TodoItem todoItem = optionalTodoItem.get();
            todoItem.setConcluida(Boolean.valueOf(status));
            return ResponseEntity.ok(todoItemRepository.save(todoItem));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
