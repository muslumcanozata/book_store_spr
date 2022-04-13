package com.store.book.mongo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Document("logs")
public class LogEntity {
    @Id
    private String id;
    private String operationName;
    private String tableName;
    private Date dateTime;
}
