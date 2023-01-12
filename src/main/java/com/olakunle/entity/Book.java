package com.olakunle.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Book")
@Data
public class Book implements Serializable {


//    private static final long serialVersionUID = 6529685098267757690L;
//    private static final long serialVersionUID = 955123080133623029L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private Double price;
}

