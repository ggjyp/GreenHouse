package com.jyp.greenhouse.pojo;

/**
 * Author   : jyp
 * Date     : 2017/3/16 15:14
 * Describe : 设备测量数据实体类
 */
public class Measurement {
    private double temperature;
    private double humidity;
    private String eventDate;

    public Measurement() {
    }

    public Measurement(double temperature, double humidity, String eventDate) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.eventDate = eventDate;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", eventDate='" + eventDate + '\'' +
                '}';
    }
}
