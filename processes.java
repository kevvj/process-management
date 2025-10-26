
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class processes {

    public processes() {
    }

    public process[] getProcesses(int L) {
        process[] pl = new process[L];
        int j = 0;
        try {

            String[] cmd = {"tasklist", "/V", "/FO", "CSV"};

            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            reader.readLine();

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

                    int pid = Integer.parseInt(processId);

                    pl[j] = new process(description, name, pid, user);
                    j = j + 1;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        return Arrays.copyOf(pl, j);
    }

}
