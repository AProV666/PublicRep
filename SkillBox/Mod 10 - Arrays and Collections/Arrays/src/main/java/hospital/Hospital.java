package hospital;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] patientsTemp = new float[patientsCount];
        for (int i = 0; i < patientsTemp.length; i++) {
            float scale = (float) Math.pow(10, 1);
            float result = (float) Math.round((32 + 8 * Math.random()) * scale) / scale;
            patientsTemp[i] = result;
        }
        return patientsTemp;
    }

    public static String getReport(float[] temperatureData) {

        String tempList = "";
        float averageTemp = 0.0f;
        int healthyPatientsCount = 0;
        float minTemp = 36.2f;
        float maxTemp = 36.9f;

        for (int i = 0; i < temperatureData.length; i++) {
            if (i < temperatureData.length - 1) {
                tempList = tempList + temperatureData[i] + " ";
            } else {
                tempList = tempList + temperatureData[i];
            }
            averageTemp += temperatureData[i];
            if ((temperatureData[i] > minTemp || temperatureData[i] == minTemp)
                    && (temperatureData[i] < maxTemp || temperatureData[i] == maxTemp)) {
                healthyPatientsCount++;
            }
        }

        averageTemp = averageTemp / temperatureData.length;
        float scale = (float) Math.pow(10, 2);
        float result = (float) Math.round(averageTemp * scale) / scale;
        averageTemp = result;

        String report =
                "Температуры пациентов: " + tempList +
                        "\nСредняя температура: " + averageTemp +
                        "\nКоличество здоровых: " + healthyPatientsCount;

        return report;
    }
}
