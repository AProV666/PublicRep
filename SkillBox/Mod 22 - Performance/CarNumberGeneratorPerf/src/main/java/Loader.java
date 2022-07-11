public class Loader {

    private static final String path_1_49 = "res/numbers_1_50.txt";
    private static final int REGIONS_1_49_START = 1;
    private static final int REGIONS_1_49 = 50;

    private static final int REGIONS_50_100_START = 50;
    private static final String path_50_100 = "res/numbers_50_100.txt";
    private static final int REGIONS_50_100 = 100;

    public static void main(String[] args){
        long start = System.currentTimeMillis();

        Generator generator1 = new Generator(path_1_49, REGIONS_1_49_START, REGIONS_1_49, start);
        Generator generator2 = new Generator(path_50_100, REGIONS_50_100_START, REGIONS_50_100, start);

        new Thread(generator1).start();
        new Thread(generator2).start();

    }
}