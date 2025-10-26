package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class MainView extends JFrame {

    public void Inicialize() {
        setTitle("");
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Gestor de procesos", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        root.add(Box.createRigidArea(new Dimension(0, 40)));
        root.add(label);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nombre del catalogo:"));
        panel.add(new JTextField(10));
        panel.setBackground(Color.WHITE);
        panel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        container.add(panel);

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Numero de procesos a capturar:"));
        panel1.add(new JTextField(5));
        panel1.setBackground(Color.WHITE);
        panel1.setAlignmentX(Component.RIGHT_ALIGNMENT);

        container.add(panel1);

        JButton button = new JButton("Enviar");

        panel.setMaximumSize(panel.getPreferredSize());
        panel1.setMaximumSize(panel1.getPreferredSize());
        container.setMaximumSize(container.getPreferredSize());

        container.setAlignmentX(Component.CENTER_ALIGNMENT);
        root.add(Box.createRigidArea(new Dimension(0, 40)));
        root.add(container);
        root.add(Box.createRigidArea(new Dimension(0, 20)));
        root.add(button);

        JPanel panel2 = new JPanel();

        panel2.add(new JLabel("Nombre:"));
        panel2.setMaximumSize(container.getPreferredSize());
        panel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.setBackground(Color.red);
        panel2.setLayout(new BorderLayout());
        panel2.setMaximumSize(container.getMaximumSize());
        
        root.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel tablelabel = new JLabel("__________________________Tabla de procesos_______________________");
        tablelabel.setFont(new Font("Arial", Font.BOLD, 15));
        tablelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        root.add(tablelabel);

        String[] columnas = {"PID", "Nombre", "Usuario", "Descripción", "prioridad"};
        Object[][] datos = {
            {"", "", "", "", ""},
        };

        JTable tabla = new JTable(datos, columnas);
        tabla.setDefaultEditor(Object.class, null);

        JScrollPane scroll = new JScrollPane(tabla);

        root.add(Box.createRigidArea(new Dimension(0, 20)));
        root.add(scroll);
        root.add(Box.createRigidArea(new Dimension(0, 10)));
       

        root.setBackground(Color.WHITE);
        add(root, BorderLayout.CENTER);

        setVisible(true);

    }
}
