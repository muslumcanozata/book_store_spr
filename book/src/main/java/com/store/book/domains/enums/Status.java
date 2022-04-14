package com.store.book.domains.enums;

public enum Status {
    ACTIVE(0), DELETED(1), DISABLED(2);

    private final Integer value;

    Status(Integer i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static Status getStatus(Integer value) throws Exception {
        if (value == 0) {
            return Status.ACTIVE;
        }
        else if(value == 1) {
            return Status.DELETED;
        }
        else if(value == 2) {
            return Status.DISABLED;
        }
        else {
            throw new Exception();
        }
    }
}