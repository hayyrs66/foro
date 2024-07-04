package com.forohub.forohub.domain.topic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Table(name = "topic")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;

    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
    private Long idAuthor;
    private Long idCourse;

    public Topic(DataTopic data) {
        this.title = data.title();
        this.message = data.message();
        this.idAuthor = data.idAuthor();
        this.idCourse = data.idCourse();
    }

    public void updateData(UpdateDataTopic data) {
        if(data.title() != null){
            this.title = data.title();
        }
        if(data.message() != null){
            this.message = data.message();
        }
    }
}
