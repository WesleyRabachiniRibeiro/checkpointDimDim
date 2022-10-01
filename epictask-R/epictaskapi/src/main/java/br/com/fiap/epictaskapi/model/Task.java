package br.com.fiap.epictaskapi.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_TASK")
@SequenceGenerator(name = "SQ_TASK", sequenceName = "SQ_TASK", allocationSize = 1)
public class Task {
 
    @Id
    @Column(name = "CD_TASK", nullable = false, length = 3)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TASK")
    private Long id;
    @Column(name = "NM_TASK", nullable = false, length = 50)
    private String title;
    @Column(name = "DS_TASK", nullable = false, length = 150)
    private String description;
    @Column(name = "NR_PONTUACAO", length = 3)
    private int score;
    @Column(name = "ST_TASK", nullable = false, length = 1)
    private int status;


    public Task() {
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Task(String title, String description, int score) {
        this.title = title;
        this.description = description;
        this.score = score;
    }

    public Task(String title, String description, int score, int status) {
        this.title = title;
        this.description = description;
        this.score = score;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task [description=" + description + ", id=" + id + ", score=" + score + ", status=" + status
                + ", title=" + title + "]";
    }


}
