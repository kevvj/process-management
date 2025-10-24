
public class process {

    String description;
    String name;
    String priority;
    String processId;

    public process(String description, String name, String priority, String processId) {
        this.description = description;
        this.name = name;
        this.priority = priority;
        this.processId = processId;
    }

    public String getProcess() {
        return "Descripción: " + description + ", Nombre: " + name + ", Prioridad: " + priority + ", ID Proceso: " + processId;
    }

}
