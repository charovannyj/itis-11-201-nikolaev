package ru.kpfu.itis.nikolaev.net.dto;

public class WeatherDto {
    private String temperature;
    private String description;
    private String humadity;

    public WeatherDto(String temperature, String description, String humadity) {
        this.temperature = temperature;
        this.description = description;
        this.humadity = humadity;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

    public String getHumadity() {
        return humadity;
    }
}
