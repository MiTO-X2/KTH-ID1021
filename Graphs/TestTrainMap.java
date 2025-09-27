public class TestTrainMap {
    public static void main(String[] args) {
        TrainMap trainMap = new TrainMap();

        try {
            // Load the train map from the CSV file
            trainMap.loadMap("trains.csv");

            // Print the map to verify the connections
            trainMap.printMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
