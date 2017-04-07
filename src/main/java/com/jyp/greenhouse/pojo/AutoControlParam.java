package com.jyp.greenhouse.pojo;

/**
 * Author   : jyp
 * Date     : 2017/4/6 14:13
 * Describe : 自控参数实体类
 */
public class AutoControlParam {
    private int id;
    private String paramName;
    private float temperatureMin;
    private float temperatureMax;
    private float humidityMin;
    private float humidityMax;
    private float lightIntensityMin;
    private float lightIntensityMax;
    private float soilMoistureMin;
    private float soilMoistureMax;
    private String createDate;
    private String deleteDate;
    private String modifyDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public float getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(float temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public float getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(float temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public float getHumidityMin() {
        return humidityMin;
    }

    public void setHumidityMin(float humidityMin) {
        this.humidityMin = humidityMin;
    }

    public float getHumidityMax() {
        return humidityMax;
    }

    public void setHumidityMax(float humidityMax) {
        this.humidityMax = humidityMax;
    }

    public float getLightIntensityMin() {
        return lightIntensityMin;
    }

    public void setLightIntensityMin(float lightIntensityMin) {
        this.lightIntensityMin = lightIntensityMin;
    }

    public float getLightIntensityMax() {
        return lightIntensityMax;
    }

    public void setLightIntensityMax(float lightIntensityMax) {
        this.lightIntensityMax = lightIntensityMax;
    }

    public float getSoilMoistureMin() {
        return soilMoistureMin;
    }

    public void setSoilMoistureMin(float soilMoistureMin) {
        this.soilMoistureMin = soilMoistureMin;
    }

    public float getSoilMoistureMax() {
        return soilMoistureMax;
    }

    public void setSoilMoistureMax(float soilMoistureMax) {
        this.soilMoistureMax = soilMoistureMax;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public AutoControlParam() {
    }

    public AutoControlParam(
            int id,
            String paramName,
            float temperatureMin,
            float temperatureMax,
            float humidityMin,
            float humidityMax,
            float lightIntensityMin,
            float lightIntensityMax,
            float soilMoistureMin,
            float soilMoistureMax,
            String createDate,
            String deleteDate,
            String modifyDate) {
        this.id = id;
        this.paramName = paramName;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.humidityMin = humidityMin;
        this.humidityMax = humidityMax;
        this.lightIntensityMin = lightIntensityMin;
        this.lightIntensityMax = lightIntensityMax;
        this.soilMoistureMin = soilMoistureMin;
        this.soilMoistureMax = soilMoistureMax;
        this.createDate = createDate;
        this.deleteDate = deleteDate;
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "AutoControlParam{" +
                "id=" + id +
                ", paramName='" + paramName + '\'' +
                ", temperatureMin=" + temperatureMin +
                ", temperatureMax=" + temperatureMax +
                ", humidityMin=" + humidityMin +
                ", humidityMax=" + humidityMax +
                ", lightIntensityMin=" + lightIntensityMin +
                ", lightIntensityMax=" + lightIntensityMax +
                ", soilMoistureMin=" + soilMoistureMin +
                ", soilMoistureMax=" + soilMoistureMax +
                ", createDate='" + createDate + '\'' +
                ", deleteDate='" + deleteDate + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                '}';
    }
}

