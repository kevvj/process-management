
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class processes {

    public processes() {
    }

    public process[] getProcesses(int L) {
        process[] pl = new process[L];
        int j = 0;
        try {
            Process p = Runtime.getRuntime().exec("tasklist /V /FO CSV");

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while (j < L) {
                String line = reader.readLine();

                if (line == null) {
                    break;
                }

                String[] info = line.replace("\"", "").split(",");

                if (info.length >= 5) {
                    String name = info[0];
                    String processId = info[1];
                    String user = info[6];
                    String description = info[0];

                    pl[j] = new process(description, name, processId, user);
                    System.out.println(info[6]);
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
