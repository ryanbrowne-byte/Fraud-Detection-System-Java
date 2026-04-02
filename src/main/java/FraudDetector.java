import com.opencsv.CSVReader;
import java.io.FileReader;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.classifiers.trees.J48;   // A classic Decision Tree algorithm
import java.io.File;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;
import javax.swing.JFrame;

public class FraudDetector {
    public static void main(String[] args) throws Exception {

        try {
            // 1. Loading my dataset downloaded from Kaggle using Weka
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File("src/main/resources/creditcard_2023.csv"));
            Instances data = loader.getDataSet();

            // 2. Telling Weka that the LAST column (Class) is what i want to predict
            if (data.classIndex() == -1) {
                data.setClassIndex(data.numAttributes() - 1);
                data.instance(0).dataset().attribute(data.classIndex());

                // THE FIX:
                weka.filters.unsupervised.attribute.NumericToNominal filter = new weka.filters.unsupervised.attribute.NumericToNominal();
                filter.setAttributeIndices("" + (data.classIndex() + 1));
                filter.setInputFormat(data);
                data = weka.filters.Filter.useFilter(data, filter);

            }

            // 3. Building the "Brain" (The Decision Tree)
            J48 tree = new J48();
            tree.buildClassifier(data);
            System.out.println("\n--- DECISION TREE LOGIC ---");
            System.out.println(tree.toString());
            System.out.println("-------------------------------------------\n");

            // 4. Running the Evaluation
            int totalCorrect = 0;
            int totalFraudDetected = 0;

            for (int i = 0; i < 10000; i++) {
                double actual = data.instance(i).classValue();
                double prediction = tree.classifyInstance(data.instance(i));

                if (actual == prediction) totalCorrect++;
                if (actual == 1.0 && prediction == 1.0) totalFraudDetected++;
            }

            System.out.println("\n========================================");
            System.out.println("🤖 WEKA MACHINE LEARNING REPORT");
            System.out.println("========================================");
            System.out.println("Total Samples Analyzed : 10,000");
            System.out.println("Real Fraud Cases Found : " + totalFraudDetected + " / 38");

                        System.out.println("System Accuracy        : " + (totalCorrect / 100.0) + "%");
            System.out.println("========================================");

            System.out.println("Opening Visual Flowchart...");
            displayTree(tree);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void displayTree(weka.classifiers.trees.J48 tree) throws Exception {
        TreeVisualizer tv = new TreeVisualizer(null, tree.graph(), new PlaceNode2());
        JFrame jf = new JFrame("Fraud Detection Decision Tree");
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setSize(1000, 800);
        jf.getContentPane().add(tv);
        jf.setVisible(true);
        tv.fitToScreen();

    }

}