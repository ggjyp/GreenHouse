package com.jyp.greenhouse.pojo;

/**
 * Author   : jyp
 * Date     : 2017/4/5 16:46
 * Describe : 操作日志实体类
 */
public class Log {
    private long id;
    private String from;
    private String to;
    private String date;
    private String behavior;
    private int state;//0：失败，1：成功

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Log() {
    }

    public Log(long id, String from, String to, String date, String behavior, int state) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.behavior = behavior;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date='" + date + '\'' +
                ", behavior='" + behavior + '\'' +
                ", state=" + state +
                '}';
    }
}
