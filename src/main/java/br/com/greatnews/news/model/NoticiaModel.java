package br.com.greatnews.news.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name="noticia")
@AllArgsConstructor
public class NoticiaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

  @CreationTimestamp 
    @Column(name = "data_hora_criacao", updatable = false)
    private LocalDateTime dataHoraCriacao;

    @UpdateTimestamp
    @Column(name = "data_hora_alteracao")
    private LocalDateTime dataHoraAlteracao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorModel autorModel;

    public NoticiaModel() {}

}
