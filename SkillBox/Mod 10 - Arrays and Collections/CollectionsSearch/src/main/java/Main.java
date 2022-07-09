import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {

        List<String> list = CoolNumbers.generateCoolNumbers();

        long start1 = System.currentTimeMillis(); //до кода (в милисекундах)
        boolean b1 = CoolNumbers.bruteForceSearchInList(list, "Р558ХО101");
        if(b1) {
            System.out.print("Номер найден, ");
        } else {
            System.out.print("Номер не найден, ");
        }
        long end1 = System.currentTimeMillis() - start1; //после кода (в милисекундах)
        System.out.println("поиск занял " + end1 + " мс");


        long start2 = System.currentTimeMillis(); //до кода (в милисекундах)
        boolean b2 = CoolNumbers.binarySearchInList(list, "Р358ХО19");
        if(b2) {
            System.out.print("Номер найден, ");
        } else {
            System.out.print("Номер не найден, ");
        }
        long end2 = System.currentTimeMillis() - start2; //после кода (в милисекундах)
        System.out.println("поиск занял " + end2 + " мс");


        HashSet<String> hS = new HashSet<>(list);
        long start3 = System.currentTimeMillis(); //до кода (в милисекундах)
        boolean b3 = CoolNumbers.searchInHashSet(hS, "Р258ХО10");
        if(b3) {
            System.out.print("Номер найден, ");
        } else {
            System.out.print("Номер не найден, ");
        }
        long end3 = System.currentTimeMillis() - start3; //после кода (в милисекундах)
        System.out.println("поиск занял " + end3 + " мс");


        TreeSet<String> tS = new TreeSet<>(list);
        long start4 = System.currentTimeMillis(); //до кода (в милисекундах)
        boolean b4 = CoolNumbers.searchInTreeSet(tS, "Р188ХО190");
        if(b4) {
            System.out.print("Номер найден, ");
        } else {
            System.out.print("Номер не найден, ");
        }
        long end4 = System.currentTimeMillis() - start4; //после кода (в милисекундах)
        System.out.println("поиск занял " + end4 + " мс");
    }
}
