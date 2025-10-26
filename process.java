
public class process {

    String description;
    String name;
    int priority;
    int processId;
    String user;

    public process(String description, String name, int processId, String user) {
        this.description = description;
        this.name = name;
        this.processId = processId;
        this.user = user;

        priority = setPriority();
    }

    final int setPriority(){
        int pr = 0;
        if(user.toLowerCase().contains("system")){
            pr = 1;
        }
        return pr;
    }

    public String getProcess() {
        return "Descripción: " + description + ", Nombre: " + name + ", Prioridad: " + priority + ", ID Proceso: " + processId + ", Usuario" + user;
    }

    public void insertProcess(){
        DBConnection db = new DBConnection();
        db.createProcess(name, user, processId, description, priority);
    }

}
