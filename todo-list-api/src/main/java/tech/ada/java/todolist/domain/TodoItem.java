package tech.ada.java.todolist.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table
@Entity
@Setter
@Getter
//@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private boolean concluida;
    private LocalDateTime dataHoraCriacao;
    private LocalDate prazoFinal;

    // Default constructor needed by ModelMapper to convert TodoItemDTO do TodoItem
    public TodoItem(){
        this.concluida = false;
        this.dataHoraCriacao = LocalDateTime.now();
    }

    // Constructor needed by toEntity() function in TodoItemDTO
    public TodoItem(String titulo, String descricao, LocalDate prazoFinal){
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false;
        this.dataHoraCriacao = LocalDateTime.now();
        this.prazoFinal = prazoFinal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHora) {
        this.dataHoraCriacao = dataHora;
    }

    public LocalDate getPrazoFinal() {
        return prazoFinal;
    }

    public void setPrazoFinal(LocalDate prazoFinal) {
        this.prazoFinal = prazoFinal;
    }
}
