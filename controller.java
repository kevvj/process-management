
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import view.MainView;

public class controller {

    processes p;
    DBConnection db;

    MainView view;
    JButton button;
    JTextField nameField;
    JTextField numField;
    DefaultTableModel model;

    public controller() {
        p = new processes();
        db = new DBConnection();
        view = new MainView();
        button = view.getButton();
        nameField = view.getNameField();
        numField = view.getNumField();
        model = view.getTable();
    }

    public void start() {
        view.Inicialize();
        initController();
    }

    private void initController() {
        button.addActionListener(e -> {
            String name = nameField.getText();
            int num = Integer.parseInt(numField.getText());

            insertData(name, num);
        });
    }

    private void insertData(String name, int num) {
        model.setRowCount(0);
        process[] cap = p.getProcesses(num);
        int catalog = db.createCatalog(num, name);


        for (process cap_ : cap) {
            System.out.println(cap_.getProcess());

            cap_.insertProcess(catalog);

            model.addRow(new Object[]{cap_.processId, cap_.name, cap_.user, cap_.description, cap_.priority});
        }
    }

    @SuppressWarnings("resource")

    public void iniciar() {
        Scanner sc = new Scanner(System.in);

        System.err.println("Escribe el titulo de tu cagada");
        String text = sc.nextLine();

        System.out.println("Escribe el numero de procesos que quieres imprimir: ");
        int num1 = sc.nextInt();

        process[] cap = p.getProcesses(num1);

        int catalog = db.createCatalog(num1, text);

        for (process cap_ : cap) {
            System.out.println(cap_.getProcess());

            cap_.insertProcess(catalog);
        }

    }
}
