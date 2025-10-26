import java.util.Scanner;

import view.MainView;
public class Controller {

    processes p;
    DBConnection db;

    public Controller() {
        p = new processes();
        db = new DBConnection();
    }

    public void vista(){
        MainView view = new MainView();
        view.Inicialize();
    }
    
    @SuppressWarnings("resource")

    public void iniciar() {
        Scanner sc = new Scanner(System.in);

        System.err.println("Escribe el titulo de tu cagada");
        String text = sc.nextLine(); 

        System.out.println("Escribe el numero de procesos que quieres imprimir: ");
        int num = sc.nextInt();



        process[] cap = p.getProcesses(num);

        int catalog = db.createCatalog(num, text);

        for (process cap_ : cap) {
            System.out.println(cap_.getProcess());
            
            cap_.insertProcess(catalog);
        }

    }
}
