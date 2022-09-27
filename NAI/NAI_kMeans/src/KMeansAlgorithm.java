import java.io.IOException;
import java.util.*;

public class KMeansAlgorithm {

    public static class Distance {

        public Distance() {
            // TODO Auto-generated constructor stub
        }

        public static double euclideanDistance(double[] point1, double[] point2) {
            double sum = 0.0;
            for(int i = 0; i < point1.length; i++) {
                //formula of euclidean distance
                sum += ((point2[i] - point1[i]) * (point2[i] - point1[i]));
            }
            return Math.sqrt(sum);
        }

    }

    public KMeansAlgorithm() {
        // TODO Auto-generated constructor stub
    }
    //main method
    public static void main(String args[]) throws IOException {
        Dataset r1 = new Dataset();
        Map<double[],String> data;
        Scanner sc = new Scanner(System.in);
        String file="C:\\Users\\Abuset\\IdeaProjects\\NAI_kMeans\\iris.data.txt";
        r1.read(file); //load data
        int ex;
        data = r1.irises;
        do{
            System.out.println("Enter the no. of clusters");
            int k = sc.nextInt();
//            System.out.println("Enter maximum iterations");
//            int max_iterations = sc.nextInt();
            //Hashmap to store centroids with index
            Map<Integer, double[]> centroids = new HashMap<>();
            // calculating initial centroids
            double[] x1;
            int r;
            for (int i = 0; i < k; i++) {  //initial centroids and putting them to map

                r = (int)(Math.random()*(r1.features.size()-1)+1);
                x1=r1.features.get(r);
                centroids.put(i, x1);

            }
            //Map for finding cluster indexes and calculating k means
            Map<double[], Integer> clusters;
            clusters = kmeans(r1.features, centroids, k);

            double db[];

            //reassigning to new clusters, according to the number of iterations

            Double sumCheck = Double.MAX_VALUE;
            int it = 0;
            while(true){
                for (int j = 0; j < k; j++) {
                    List<double[]> list = new ArrayList<>();
                    for (double[] key : clusters.keySet()) {
                        if (clusters.get(key)==j) {
                            list.add(key);
                        }
                    }
                    //calculating the new centroids
                    db = centroidCalculator(list);
                    centroids.put(j, db);
                }

                //new clustering
                clusters.clear();
                clusters = kmeans(r1.features, centroids, k);

                double sum = 0;
                System.out.println("Iteration " + it + ": ");
                for(int c = 0; c < k; c++){
                    System.out.print("Cluster " + c + ": ");
                    for (double[] key : clusters.keySet()){
                        if (clusters.get(key)==c){
                            for (int s = 0; s<key.length; s++){
                                System.out.print(key[s] + "\t");
                            }
                            System.out.print(", ");
                        }
                    }
                    System.out.println();

                    //sum of distances
                    for (double[] key : clusters.keySet()){
                        if (clusters.get(key)==c){
                            sum += Distance.euclideanDistance(key,centroids.get(c));
                        }
                    }
                }
                it++;
                System.out.println();
                System.out.println("Sum of distances: " + sum + "\n");
                if(sumCheck-sum <= 0.0){
                    break;
                }
                sumCheck = sum;

            }

            //final cluster print
            System.out.println("\nFinal Clustering of Data\n");
//
            System.out.println("Cluster Homogeneity:");
            //finding percentage of each iris class
            //the big for loop iterating on each cluster
            for (int i = 0; i < k; i++){
                int set=0,versi=0,vir=0;
                System.out.print("Cluster " + i + " = ");
                //checking all the observations and their clusters
                for (double[] key : clusters.keySet()){
                    if (clusters.get(key)==i){
                        //getting the label of each observation
                        for (double[] x : data.keySet()){
                            if (x == key){
//                                System.out.println(data.get(x));
                                switch (data.get(x)){
                                    case "Iris-setosa" : set++;
                                        break;
                                    case "Iris-versicolor" : versi++;
                                        break;
                                    case "Iris-virginica" : vir++;
                                        break;
                                }
                            }
                        }
                    }
                }
                // printing percentage of each label for clusters
                double total = set+versi+vir;
                System.out.println("{Setosa: " + Math.round(set*100/total * 100.0)/100.0 + "%, Versicolor: " +
                        Math.round(versi*100/total * 100.0)/100.0 + "%, Virginica: "
                        + Math.round(vir*100/total * 100.0)/100.0 + "% ");
            }

            System.out.println("\n*********Results************\n");
            System.out.println("Iterations: "+it);
            System.out.println("Number of Clusters: "+k);
            System.out.println("Press 1 if you want to continue else press 0 to exit..");
            ex=sc.nextInt();
        }while(ex==1);
    }

    //method to calculate centroids
    public static double[] centroidCalculator(List<double[]> a) {

        int count = 0;
        double sum=0.0;
        double[] centroids = new double[Dataset.numberOfFeatures];
        for (int i = 0; i < Dataset.numberOfFeatures; i++) {
            sum=0.0;
            count = 0;
            //finding means
            for(double[] x:a){
                count++;
                sum = sum + x[i];
            }
            centroids[i] = sum / count;
        }
        return centroids;
    }

    //method for putting features to clusters.
    public static Map<double[], Integer> kmeans(List<double[]> features, Map<Integer, double[]> centroids, int k) {
        Map<double[], Integer> clusters = new HashMap<>();
        int k1 = 0;
        double dist=0.0;
        //for each double array
        for(double[] x:features) {
            double minimum = 999999.0;
            for (int j = 0; j < k; j++) {
                //finding distance between the observation and the centroids
                    dist = Distance.euclideanDistance(centroids.get(j), x);

                if (dist < minimum) {  //checking if the distance is the minimum
                    minimum = dist;
                    k1 = j;
                }
            }
            //store the observation to map with its cluster
            clusters.put(x, k1);
        }

        return clusters;

    }

}
