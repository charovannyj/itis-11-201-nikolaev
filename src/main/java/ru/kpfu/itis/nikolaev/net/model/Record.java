package ru.kpfu.itis.nikolaev.net.model;

import java.sql.Timestamp;

public class Record {
    private Integer id;
    private Integer idMaster;
    private Integer idService;
    private Timestamp time;
    private String phone;

    public Record(Integer id, Integer idMaster, Integer idService, Timestamp time, String phone) {
        this.id = id;
        this.idMaster = idMaster;
        this.idService = idService;
        this.time = time;
        this.phone = phone;
    }
    public Record(Integer masterId, Integer serviceId, Timestamp time, String phone) {
        this.idMaster = idMaster;
        this.idService = idService;
        this.time = time;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMaster() {
        return idMaster;
    }

    public void setIdMaster(Integer idMaster) {
        this.idMaster = idMaster;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

