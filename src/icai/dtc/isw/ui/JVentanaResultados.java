package icai.dtc.isw.ui;

import icai.dtc.isw.domain.Customer;

import javax.swing.*;
import java.util.ArrayList;

public class JVentanaResultados extends JFrame
{
    private ArrayList<JPanelResultados> listaPaneles = new ArrayList<JPanelResultados>(1);
    private JTabbedPane pestanas = new JTabbedPane();

    private JVentanaBuscar ventanaBuscar;
    private ArrayList<Customer> salidas;
    private JButton btnVolver;
    private JLabel labelMatricula, labelOrigen, labelDestino, labelPlazas;

    public JVentanaResultados(ArrayList<Customer> salidas,JVentanaBuscar ventanaBuscar)
    {
        this.ventanaBuscar = ventanaBuscar;
        this.salidas = salidas;

        this.setTitle("Resultados de la b\u00FAsqueda");
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
            listaPaneles.add(new JPanelResultados(customer, ventanaBuscar, this));
            pestanas.addTab("Respuesta "+(i+1), listaPaneles.get(i));
            this.getContentPane().add(pestanas);
        }
    }
}

