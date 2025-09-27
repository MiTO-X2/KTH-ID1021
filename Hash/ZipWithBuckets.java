import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ZipWithBuckets {
    // private ArrayList<Area>[] buckets;
    private List<Area>[] buckets;

    private int max = 10000; // Size of the buckets array
    private int size = 0; // Number of actual zip codes inserted

    public class Area {
        Integer code; // Zip code
        String name; // Name of the area
        int population; // Population

        public Area(Integer code, String name, int population) {
            this.code = code;
            this.name = name;
            this.population = population;
        }
    }

    @SuppressWarnings("unchecked") // Suppress warning for unchecked conversion
    public ZipWithBuckets(String file) {
        buckets = new ArrayList[max];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                String name = row[1];
                int population = Integer.valueOf(row[2]);
                addArea(new Area(code, name, population));
            }
            System.out.println("Loaded " + size + " entries.");
        } catch (Exception e) {
            System.out.println("File " + file + " not found");
        }
    }

    private void addArea(Area area) {
        int index = area.code % max;

        if (buckets[index] == null) {
            buckets[index] = new ArrayList<>();
        }
        buckets[index].add(area);
        size++;
    }

    public String lookup(Integer zip) {
        int index = zip % max;

        if (buckets[index] != null) {
            for (Area area : buckets[index]) {
                if (area.code.equals(zip)) {
                    return area.name + ", Population: " + area.population;
                }
            }
        }
        return "Zip code not found.";
    }

    public static void main(String[] args) {
        ZipWithBuckets zipLookup = new ZipWithBuckets("postnummer.csv");

        // Sample lookups
        System.out.println("Lookup for 11115: " + zipLookup.lookup(11115));
        System.out.println("Lookup for 98499: " + zipLookup.lookup(98499));
        System.out.println("Lookup for 99999: " + zipLookup.lookup(99999)); // Non-existent
    }
}
