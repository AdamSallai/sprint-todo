package com.codecool.springtodo.service;

public enum Status {
    ACTIVE(false),
    COMPLETE(true);

    private final boolean value;

    Status(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    public static Status enumConverter(String name) {
        if(name == null) {
            return null;
        } else if (name.equals("active")) {
            return Status.ACTIVE;
        } else {
            return Status.COMPLETE;
        }
    }
}
