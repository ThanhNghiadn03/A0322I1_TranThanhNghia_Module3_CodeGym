package models.service;

public class Service {
    private int idService;
    private String nameService;
    private int areaService;
    private long costService;
    private int maxPeople;
    private String roomStandard;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numOfFloors;
    private RentType rentType;
    private ServiceType serviceType;

    public Service() {
    }

    public Service(int idService, String nameService, int areaService, long costService, int maxPeople, String roomStandard, String descriptionOtherConvenience, double poolArea, int numOfFloors, int idRentType, int idServiceType) {
        this.idService = idService;
        this.nameService = nameService;
        this.areaService = areaService;
        this.costService = costService;
        this.maxPeople = maxPeople;
        this.roomStandard = roomStandard;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numOfFloors = numOfFloors;
        this.rentType = new RentType(idRentType,"");
        this.serviceType = new ServiceType(idServiceType,"");
    }

    public Service(String nameService, int areaService, long costService, int maxPeople, String roomStandard, String descriptionOtherConvenience, double poolArea, int numOfFloors, int idRentType, int idServiceType) {
        this.nameService = nameService;
        this.areaService = areaService;
        this.costService = costService;
        this.maxPeople = maxPeople;
        this.roomStandard = roomStandard;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numOfFloors = numOfFloors;
        this.rentType = new RentType(idRentType,"");
        this.serviceType = new ServiceType(idServiceType,"");
    }

    public Service(int idService, String nameService, int areaService, long costService, int maxPeople, String roomStandard, String descriptionOtherConvenience, double poolArea, int numOfFloors, RentType rentType, ServiceType serviceType) {
        this.idService = idService;
        this.nameService = nameService;
        this.areaService = areaService;
        this.costService = costService;
        this.maxPeople = maxPeople;
        this.roomStandard = roomStandard;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numOfFloors = numOfFloors;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public Service(int idService, String nameService, int areaService, long costService, int maxPeople, String roomStandard, String descriptionOtherConvenience, double poolArea, int numOfFloors,int idRentType, String nameRentType, int idServiceType, String nameServiceType) {
        this.idService = idService;
        this.nameService = nameService;
        this.areaService = areaService;
        this.costService = costService;
        this.maxPeople = maxPeople;
        this.roomStandard = roomStandard;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numOfFloors = numOfFloors;
        this.rentType = new RentType(idRentType,nameRentType);
        this.serviceType = new ServiceType(idServiceType,nameServiceType);
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public int getAreaService() {
        return areaService;
    }

    public void setAreaService(int areaService) {
        this.areaService = areaService;
    }

    public long getCostService() {
        return costService;
    }

    public void setCostService(long costService) {
        this.costService = costService;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public void setRentTypeOther(int idRentType, String nameRentType) {
        this.rentType = new RentType(idRentType,nameRentType);
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void setServiceTypeOther(int idServiceType, String nameServiceType) {
        this.serviceType = new ServiceType(idServiceType,nameServiceType);
    }
}
