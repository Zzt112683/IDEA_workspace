package com.neuedu.entity;

public class LogBean {

    private int id;
    private int user_id;
    private Long create_time;
    private String operation;

    public LogBean() {
    }

    public LogBean(int user_id, String operation) {
        this.user_id = user_id;
        this.operation = operation;
    }

    public LogBean(int id, int user_id, Long create_time, String operation) {
        this.id = id;
        this.user_id = user_id;
        this.create_time = create_time;
        this.operation = operation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "LogBean{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", create_time=" + create_time +
                ", operation='" + operation + '\'' +
                '}';
    }
}
