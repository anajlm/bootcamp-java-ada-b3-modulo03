package tech.ada.java.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import tech.ada.java.todolist.domain.TodoItem;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class TodoItemDTO{

    private String titulo;
    private String descricao;
    private LocalDate prazoFinal;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getPrazoFinal() {
        return prazoFinal;
    }

    public void setPrazoFinal(LocalDate prazoFinal) {
        this.prazoFinal = prazoFinal;
    }

    public TodoItem toEntity(){
        return new TodoItem(titulo, descricao, prazoFinal);
    }
}
