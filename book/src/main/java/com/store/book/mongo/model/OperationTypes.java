package com.store.book.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * OperationTypes
 * @author mcozata
 * @since 2022/04/11
 */
@Getter
@AllArgsConstructor
public enum OperationTypes {
    CREATE(1, "create"),
    DELETE(2, "delete"),
    UPDATE(3, "update"),
    READ(4, "read");

    private final Integer key;
    private final String name;
}
