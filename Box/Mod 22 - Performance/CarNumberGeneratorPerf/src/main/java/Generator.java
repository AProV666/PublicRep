import java.io.PrintWriter;

public class Generator implements Runnable {
    private String path;
    private int regionStart;
    private long regionEnd;
    private long timeStart;


    public Generator(String path, int regionStart, int regionEnd, long timeStart) {
        this.path = path;
        this.regionStart = regionStart;
        this.regionEnd = regionEnd;
        this.timeStart = timeStart;
    }

    @Override
    public void run() {
        try {
            PrintWriter writer = new PrintWriter(path);
            char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
            for (int regionCode = regionStart; regionCode < regionEnd; regionCode++) {
                StringBuilder builder = new StringBuilder();
                for (int number = 1; number < 1000; number++) {
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                builder.append(firstLetter);
                                builder.append(padNumber(number, 3));
                                builder.append(secondLetter);
                                builder.append(thirdLetter);
                                builder.append(padNumber(regionCode, 2));
                                builder.append("\n");
                            }
                        }
                    }
                }
                writer.write(builder.toString());
            }
            writer.flush();
            writer.close();
            System.out.println((System.currentTimeMillis() - timeStart) + " ms");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }
        return numberStr;
    }
}