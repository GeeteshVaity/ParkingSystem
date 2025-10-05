package Data;

public class ParkingLot {
    public int lotId;
    public String lotName;
    public String address;
    public int totalSpot;
    public float hourly_rate_car;
    public float hourly_rate_bike;
    public float hourly_rate_truck;

    public ParkingLot(int lotId, String lotName,String address,  int totalSpot, float hourly_rate_car, float hourly_rate_bike, float hourly_rate_truck) {
        this.lotId = lotId;
        this.lotName = lotName;
        this.address = address;
        this.totalSpot = totalSpot;
        this.hourly_rate_car = hourly_rate_car;
        this.hourly_rate_bike = hourly_rate_bike;
        this.hourly_rate_truck = hourly_rate_truck;
    }

    public ParkingLot(int lotId, String lotName, String address, int totalSpot) {
        this.lotId = lotId;
        this.lotName = lotName;
        this.address = address;
        this.totalSpot = totalSpot;
    }

}
