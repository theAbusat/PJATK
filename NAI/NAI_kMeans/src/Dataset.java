import java.io.*;
import java.util.*;

public class Dataset {
    protected List<double[]> features=new ArrayList<>();
    protected List<String> label=new ArrayList<>();

    //storing features and label into map
    protected static Map<double[],String> irises = new HashMap<>();
    protected static int numberOfFeatures;

    void read(String s) throws NumberFormatException, IOException {

        File file=new File(s);

        try {
            BufferedReader readFile=new BufferedReader(new FileReader(file));
            String line;
            while((line=readFile.readLine()) != null)
            {

                String[] split = line.split(",");
                double[] feature = new double[split.length - 1];
                numberOfFeatures = split.length-1;
                for (int i = 0; i < split.length - 1; i++)
                    feature[i] = Double.parseDouble(split[i]);
                features.add(feature);
                String labels = split[feature.length];
                label.add(labels);
                irises.put(feature,labels);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }




}
