package ru.kpfu.itis.nikolaev.net.model;

public class MasterService {
    private int idMaster;
    private int idService;

    public MasterService(int idMaster, int idService) {
        this.idMaster = idMaster;
        this.idService = idService;
    }

    public int getIdMaster() {
        return idMaster;
    }

    public void setIdMaster(int idMaster) {
        this.idMaster = idMaster;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }
}
