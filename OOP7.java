public class Train {
    private String destination;
    private String number;
    private String timeOfDeparture;
 
    private EnumMap<CarType, Integer> seatCountHolder;
 
    public enum CarType {
        COMMON, COMPARTMENT, RESERVED_SEAT, LUXURY;
    }
 
    public Train(String destination, String number, String timeOfDeparture,
                 final int commonSeatsCount, final int compartmentSeatsCount,
                 final int reservedSeatCount, final int luxurySeatCount ) {
        this.destination = destination;
        this.number = number;
        this.timeOfDeparture = timeOfDeparture;
 
        this.seatCountHolder = new EnumMap<CarType, Integer>(CarType.class);
 
        seatCountHolder.put(CarType.COMMON, commonSeatsCount);
        seatCountHolder.put(CarType.COMPARTMENT, compartmentSeatsCount);
        seatCountHolder.put(CarType.RESERVED_SEAT, reservedSeatCount);
        seatCountHolder.put(CarType.LUXURY, luxurySeatCount);
    }
 
    public String getDestination() {
        return destination;
    }
 
    public void setDestination(String destination) {
        this.destination = destination;
    }
 
    public String getNumber() {
        return number;
    }
 
    public void setNumber(String number) {
        this.number = number;
    }
 
    public String getTimeOfDeparture() {
        return timeOfDeparture;
    }
 
    public void setTimeOfDeparture(String timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }
 
    public int getSeatCountByCarType(final CarType type) {
        return seatCountHolder.get(type);
    }
 
    public void setSeatCountByCarType(final CarType type, final int newCount) {
        seatCountHolder.put(type, newCount);
    }
 
    public int getTotalSeatCount() {
        int count = 0;
 
        for (CarType type : CarType.values())
            count = count + seatCountHolder.get(type);
 
        return count;
    }
 
    @Override
    public String toString() {
        return "Train :\n" +
                " destination         : '" + destination + "\'\n" +
                " number              : '" + number + "\'\n" +
                " time of departure   : '" + timeOfDeparture + "\'\n" +
                " seats               : " + getTotalSeatCount() + "\n" +
                "   common seats      : " + seatCountHolder.get(CarType.COMMON) + "\n" +
                "   compartment seats : " + seatCountHolder.get(CarType.COMPARTMENT) + "\n" +
                "   reserved seats    : " + seatCountHolder.get(CarType.RESERVED_SEAT) + "\n" +
                "   luxury seats      : " + seatCountHolder.get(CarType.LUXURY);
    }
}
public class Trains {
    private static final String[] CITIES = {"Moscow", "St.Petersburg", "Ekaterinburg", "Paris", "London"};
 
    private static final ThreadLocalRandom RNG = ThreadLocalRandom.current();
 
 
    public static List<Train> findTrainsWithSameDestination(final Collection<Train> trains, final String destination) {
        List<Train> result = new ArrayList<>(trains);
        return result.stream()
                .filter(train -> Objects.equals(train.getDestination(), destination))
                .collect(Collectors.toList());
    }
 
    public static List<Train> findTrainsWithSameDestinationAndAfterTime(final Collection<Train> trains,
                                                                        final String destination,
                                                                        final String givenTime) {
        List<Train> result = new ArrayList<>(trains);
        return result.stream()
                .filter(train -> Objects.equals(train.getDestination(), destination))
                .filter(train -> DatatypeConverter.parseTime(train.getTimeOfDeparture()).after(
                        DatatypeConverter.parseTime(givenTime)))
                .collect(Collectors.toList());
    }
 
    public static List<Train> findTrainsWithSameDestinationAndHaveCommonSeats(final Collection<Train> trains,
                                                                              final String destination) {
        List<Train> result = new ArrayList<>(trains);
        return result.stream()
                .filter(train -> Objects.equals(train.getDestination(), destination))
                .filter(train -> train.getSeatCountByCarType(Train.CarType.COMMON) > 0)
                .collect(Collectors.toList());
    }
 
    public static List<Train> newRandomTrainList(final int trainCount) {
        List<Train> trains = new ArrayList<>(trainCount);
 
        for (int i = 0; i < trainCount; i++)
            trains.add(newRandomTrain());
 
        return trains;
    }
 
    public static Train newRandomTrain() {
        final String city = randomCity();
        final String number = randomNumber();
        final String time = randomTime();
 
        Train train = new Train(city, number, time, 0, 0, 0, 0);
        for (Train.CarType type : Train.CarType.values())
            train.setSeatCountByCarType(type, RNG.nextInt(21));
        return train;
    }
 
    private static String randomCity() {
        return CITIES[RNG.nextInt(CITIES.length)];
    }
 
    private static String randomTime() {
        return String.format("%02d:%02d:%02d", RNG.nextInt(13), RNG.nextInt(60), RNG.nextInt(60));
    }
 
    private static String randomNumber() {
        return String.format("%03d", RNG.nextInt(1000));
    }
}
public class Main {
    public static void main(String[] args) {
        List<Train> trainsList = Trains.newRandomTrainList(10);
 
        System.out.println("Original list:");
        trainsList.forEach(System.out::println);
 
        List<Train> trainsWithGivenDestination = Trains.findTrainsWithSameDestination(trainsList, "Moscow");
        System.out.println("Trains for Moscow:");
        trainsWithGivenDestination.forEach(System.out::println);
 
        List<Train> trainsWithGivenDestinationAndTime = Trains
                .findTrainsWithSameDestinationAndAfterTime(trainsList, "Paris", "09:00:00");
        System.out.println("Trains for Paris and 09:00:");
        trainsWithGivenDestinationAndTime.forEach(System.out::println);
 
        List<Train> trainsWithGivenDestinationAndSeats = Trains
                .findTrainsWithSameDestinationAndHaveCommonSeats(trainsList, "Ekaterinburg");
        System.out.println("Trains for Ekaterinburg and seats:");
        trainsWithGivenDestinationAndSeats.forEach(System.out::println);
    }
}