
import java.io.*;
import java.util.Arrays;

public class processes {

    public processes() {
    }

    public process[] getProcesses(int L) {
        process[] pl = new process[L];
        int j = 0;
        try {
            Process p = Runtime.getRuntime().exec("wmic process get ProcessId,Name,Description,Priority,UserModeTime"); // ejecutar el comando tasklist(devuelve la lista de procesos activos)

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())); // leemos el texto que genera el comando tasklist

            while (j < L) {
                String line = reader.readLine();

                if (line == null) {
                    break;
                }

                String[] info = line.trim().replaceAll(" +", " ").split(" ");

                if (info.length >= 5) {
                    String description = info[0];
                    String name = info[1];
                    String priority = info[2];
                    String processId = info[3];

                    pl[j] = new process(description, name, priority, processId);

                    j = j + 1;
                }

            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return Arrays.copyOf(pl, j);
    }
}
