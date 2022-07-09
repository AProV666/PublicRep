public class Main {
    public static void main(String[] args) {
        int vasyaAge = 69;
        int katyaAge = 60;
        int mishaAge = 65;

        int min = -1;
        int middle = -1;
        int max = -1;

        if (vasyaAge < katyaAge && vasyaAge < mishaAge) {
            min = vasyaAge;
        } else if (katyaAge < vasyaAge && katyaAge < mishaAge) {
            min = katyaAge;
        } else {
            min = mishaAge;
        }

        if ((vasyaAge > katyaAge && vasyaAge < mishaAge) || (vasyaAge < katyaAge && vasyaAge > mishaAge)) {
            middle = vasyaAge;
        } else if ((katyaAge > vasyaAge && katyaAge < mishaAge) || (katyaAge < vasyaAge && katyaAge > mishaAge)) {
            middle = katyaAge;
        } else {
            middle = mishaAge;
        }

        if (vasyaAge > katyaAge && vasyaAge > mishaAge) {
            max = vasyaAge;
        } else if (katyaAge > vasyaAge && katyaAge > mishaAge) {
            max = katyaAge;
        } else {
            max = mishaAge;
        }

        System.out.println("Minimal age: " + min);
        System.out.println("Middle age: " + middle);
        System.out.println("Maximum age: " + max);
    }
}
