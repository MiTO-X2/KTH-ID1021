public class TestTrainMapWithHash {
    public static void main(String[] args) {
        TrainMapWithHash trainMap = new TrainMapWithHash(70);  // Initial size of 100

        try {
            // Load the train map from the CSV file
            trainMap.loadMap("trains.csv");

            // Print the hash table to check if cities are hashed correctly
            trainMap.printMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
