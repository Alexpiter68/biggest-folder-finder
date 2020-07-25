import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {

        String folderPath = "/users/alexfolov/Desktop/Books";

        File file = new File(folderPath);

            System.out.println(file);

        System.out.println(getFolderSize(file));

    }

    public static long getFolderSize(File folder){
        if(folder.isFile()){
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();

        for(File file :files){
            sum += getFolderSize(file);

        }
        return sum;
    }

    public String getHumanReadableSize(long size){

        String size22 = Long.toString(size);
        double sizeOfAnswer = (double) size;

        String letter = "Б";
        long a = 1024;
        long b = 1048576;
        long c = 1073741824;

        if (size22.length() >= 4 && size22.length() <= 6) {
            sizeOfAnswer = (double) size / a;
            letter = "Кб";
        } else if (size22.length() > 6 && size22.length() <= 9) {
            sizeOfAnswer = (double) size / b;
            letter = "Мб";
        } else if (size22.length() > 9) {
            sizeOfAnswer = (double) size / c;
            letter = "Гб";
        }

        String humanReadableSize = Double.toString(getDouble(sizeOfAnswer)) + " " + letter;

        return humanReadableSize;
    }
    private static Double getDouble(Double sizeOfAnswer){

        int x = 0;

        BigDecimal bd = new BigDecimal(Double.toString(sizeOfAnswer));
        bd = bd.setScale(x, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }
    
}
