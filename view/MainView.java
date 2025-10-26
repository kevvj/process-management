package view;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.plaf.DimensionUIResource;


public class MainView extends JFrame {

    public void Inicialize() {
        setTitle("");
        setSize(500, 600);
        setMinimumSize(new DimensionUIResource(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        JLabel label = new JLabel("Hola mundo");
        add(label);
        setVisible(true);

    }
}
