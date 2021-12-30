package icai.dtc.isw.ui;

import icai.dtc.isw.domain.Customer;

import javax.swing.*;
import java.util.ArrayList;

public class JVentanaMisTrayectos extends JFrame {

    private ArrayList<JPanelResultadosMisTrayectos> listaPaneles = new ArrayList<JPanelResultadosMisTrayectos>(1);
    private JTabbedPane pestanas = new JTabbedPane();

    private JVentanaChoose ventanaChoose;
    private ArrayList<Customer> salidas;
    private String name;

    public JVentanaMisTrayectos(ArrayList<Customer> salidas, JVentanaChoose ventanaChoose, String name) {
        this.ventanaChoose = ventanaChoose;
        this.salidas = salidas;
        this.name = name;

        this.setTitle("Mis trayectos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        initPestañas();
    }

    public void initPestañas() {
        for (int i = 0 ; i < salidas.size(); i++) { //salidas.size() es el número de resultados que se tienen en la búsqueda
            Customer customer = (Customer) salidas.get(i);
            listaPaneles.add(new JPanelResultadosMisTrayectos(customer, ventanaChoose, this,name));
            pestanas.addTab("Respuesta "+(i+1), listaPaneles.get(i));
            this.getContentPane().add(pestanas);
        }
    }
}
