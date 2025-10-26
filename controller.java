import java.util.Scanner;
public class Controller {

    processes p;

    public Controller() {
        p = new processes();
    }
    
    @SuppressWarnings("resource")

    public void iniciar() {
        Scanner sc = new Scanner(System.in);

        System.err.println("Escribe el titulo de tu cagada");
        String texto = sc.nextLine(); 

        System.out.println("Escribe el numero de procesos que quieres imprimir: ");
        int num = sc.nextInt();

        System.err.println("Titulo: " + texto);

        process[] cap = p.getProcesses(num);

        for (process cap_ : cap) {
            System.out.println(cap_.getProcess());
        }

        DBConnection db = new DBConnection();
        db.createProcess("ejemplo", "userejemplo", 123, "aaaa", 0);

    }
}
