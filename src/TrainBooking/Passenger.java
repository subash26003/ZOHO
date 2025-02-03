package TrainBooking;

public class Passenger {
    static int Id;
    String name;
    int age;
    String berthPreferance;
    String alloted;
    int passengerId;
    int seatNo;

    public Passenger(String name, int age, String berthPreferance) {
        this.name = name;
        this.age = age;
        this.berthPreferance = berthPreferance;
        this.passengerId = Id++;
        this.alloted = "";
        this.seatNo = 0;

    }
}
