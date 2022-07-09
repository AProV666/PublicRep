public class Main {
    public static void main(String[] args) {
        int volume = 1200;
        int fillingSpeed = 30; //30 litres per minute
        int devastation = 10; //10 litres per minute

        int volumeNow = 0;
        int time = 0; //min

        while (true) {
            volumeNow += fillingSpeed - devastation;
            time++;
            if (volumeNow >= volume) {
                break;
            }
        }
        System.out.println(time + " min");
    }
}
