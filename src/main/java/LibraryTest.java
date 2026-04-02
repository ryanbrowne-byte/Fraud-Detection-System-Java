
import com.opencsv.CSVReader;
import weka.core.Instances;
import java.io.StringReader;
import java.util.Arrays;

public class LibraryTest {
    public static void main(String[] args) {
        System.out.println("--- Starting Library Connection Test ---");

        // 1. Testing OpenCSV
        try {
            String simulatedCsv = "TransactionID,Amount,Status\nTX101,500.0,Normal";
            CSVReader reader = new CSVReader(new StringReader(simulatedCsv));
            String[] nextLine = reader.readNext(); // Read Header
            nextLine = reader.readNext(); // Read first data row
            System.out.println("✅ OpenCSV Success: Read transaction " + nextLine[0]);
        } catch (Exception e) {
            System.err.println("❌ OpenCSV Failed: " + e.getMessage());
        }

        // 2. Testing Weka
        try {
            // Creating a dummy Weka 'Instances' object to see if the library is linked
            Instances dummyData = new Instances("TestDataset", new java.util.ArrayList<>(), 0);
            System.out.println("✅ Weka Success: Created " + dummyData.relationName() + " object.");
        } catch (Exception e) {
            System.err.println("❌ Weka Failed: " + e.getMessage());
        }

        System.out.println("--- Test Complete ---");
    }
}