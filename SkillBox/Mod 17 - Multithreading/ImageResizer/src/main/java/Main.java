import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int newWidth = 300;
    public static void main(String[] args) {
        String srcFolder = "/Users/a_pro/Desktop/src";
        String dstFolder = "/Users/a_pro/Desktop/dst";

        File srcDir = new File(srcFolder);
        int nrOfProcessors = nrOfProcessors();
        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();

        int newSizeArray = files.length / nrOfProcessors;

        List<ImageResizer> imageResizersList = new ArrayList<>();

        for(int i = 0; i < nrOfProcessors; i++) {
            if(i != nrOfProcessors - 1) {
                File[] fileCopy = new File[newSizeArray];
                System.arraycopy(files, fileCopy.length * i, fileCopy, 0, fileCopy.length);

                ImageResizer resizer = new ImageResizer(fileCopy, newWidth, dstFolder, start);
                imageResizersList.add(resizer);
            } else {
                File[] fileCopy = new File[files.length - (newSizeArray * (nrOfProcessors - 1))];
                System.arraycopy(files, fileCopy.length * i, fileCopy, 0, fileCopy.length);

                ImageResizer resizer = new ImageResizer(fileCopy, newWidth, dstFolder, start);
                imageResizersList.add(resizer);
            }
        }

        for(ImageResizer res : imageResizersList) {
            res.start();
        }
    }

    public static int nrOfProcessors() {
        Runtime runtime = Runtime.getRuntime();
        int nrOfProcessors = runtime.availableProcessors();
        return nrOfProcessors;
    }
}



//public class Main {
//
//    private static int newWidth = 300;
//
//    public static void main(String[] args) {
//        String srcFolder = "/Users/a_pro/Desktop/src";
//        String dstFolder = "/Users/a_pro/Desktop/dst";
//
//        File srcDir = new File(srcFolder);

//        long start = System.currentTimeMillis();
//
//        File[] files = srcDir.listFiles();
//
//        try {
//            for (File file : files) {
//                BufferedImage image = ImageIO.read(file);
//                if (image == null) {
//                    continue;
//                }
//                int newHeight = (int) Math.round(
//                        image.getHeight() / (image.getWidth() / (double) newWidth)
//                );
//                BufferedImage newImage = new BufferedImage(
//                        newWidth, newHeight, BufferedImage.TYPE_INT_RGB
//                );
//
//                int widthStep = image.getWidth() / newWidth;
//                int heightStep = image.getHeight() / newHeight;
//
//                for (int x = 0; x < newWidth; x++) {
//                    for (int y = 0; y < newHeight; y++) {
//                        int rgb = image.getRGB(x * widthStep, y * heightStep);
//                        newImage.setRGB(x, y, rgb);
//                    }
//                }
//
//                File newFile = new File(dstFolder + "/" + file.getName());
//                ImageIO.write(newImage, "jpg", newFile);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println("Duration: " + (System.currentTimeMillis() - start));
//
//    }
//}
