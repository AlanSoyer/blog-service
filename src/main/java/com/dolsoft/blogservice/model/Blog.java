package com.dolsoft.blogservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Blog extends RepresentationModel<Blog> implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    private String title;
    private String content;
    private String creationDate;
    private int authorId;
}