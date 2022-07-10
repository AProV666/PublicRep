import java.io.File;

public class FileUtils {
    public static long calculateFolderSize(String path) {
        long sum = 0;
        try {
            File file = new File(path);

            if (file.isFile()) {
                return file.length();
            }
            File[] files = file.listFiles();
            for (File f : files) {
                sum += calculateFolderSize(f.getPath());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sum;
    }
}
