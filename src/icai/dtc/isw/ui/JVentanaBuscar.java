package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Entrada;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class JVentanaBuscar extends JFrame
{

    private JVentanaResultadosBuscar ventana2;
    private JButton btnBuscar;
    private JComboBox cbOrigen, cbDestino, cbPlazas;


    public static void main(String args[])
    {
        new JVentanaBuscar();
    }


    public JVentanaBuscar()
    {
        this.setTitle("B\u00FAsqueda de coches");
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(207, 185, 151,255)); //color de fondo
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true); //para que no se pueda mover la jventana
        this.setSize(1000,600);
        this.setLocationRelativeTo(null); //para que aparezca en medio de la pantalla
        this.setVisible(true);

//        initTitulo();
        initBotonBuscar();
        initActionBotones();
        initBoxes();
    }

    public void initTitulo() {
        JLabel titulo = new JLabel( "Busca tu coche" );
        titulo.setBounds(0, 0, 800, 100);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(new Color(215,207,204,255));
        titulo.setOpaque(false); //false para quitar el fondo
        titulo.setFont(new Font("Harlow Solid Italic"   , Font.BOLD, 25));
        this.add(titulo);
    }

    public void initBotonBuscar() {
        btnBuscar = new JButton("Buscar");
        this.add(btnBuscar);
        btnBuscar.setBounds(375,450,250,50);
        btnBuscar.setForeground(Color.BLACK);
        btnBuscar.setBackground(new Color(215,207,204,255));
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15); //distancia de separacion de dentro
        Border compound = new CompoundBorder(line, margin); //para que tenga el borde de negro
        btnBuscar.setBorder(compound); // añadimos el borde de negro
        btnBuscar.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
    }

    public void initBoxes() {

        String origen[]={"Pozuelo","Majadahonda","Boadilla","Somosaguas","ICAI","ICADE","CIHS","Madrid"};
        String destinos[]={"Pozuelo","Majadahonda","Boadilla","Somosaguas","ICAI","ICADE","CIHS","Madrid"};
        String plazas[]={"1","2","3","4","5","6","7"};

        cbOrigen = new JComboBox<String>(origen);
        cbOrigen.setBounds(10,10,100,50);
        cbDestino = new JComboBox<String>(destinos);
        cbPlazas = new JComboBox<String>(plazas);

        this.add(cbOrigen);
        this.add(cbDestino);
        this.add(cbPlazas);
    }

    public void initActionBotones() {
        btnBuscar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String origen = (String) cbOrigen.getItemAt(cbOrigen.getSelectedIndex());
                String plazas=  (String) cbPlazas.getItemAt(cbPlazas.getSelectedIndex());
                String destino = (String) cbDestino.getItemAt(cbDestino.getSelectedIndex());
                Entrada entrada = new Entrada (origen, destino,plazas);
                Client c = new Client();
                HashMap<String, Object> peticion = new HashMap<String,Object>();
                peticion.put("Peticion",entrada);
                c.envioPeticion("/getCustomer",peticion);
                System.out.println("ok final");
                ArrayList<Customer> salidas = c.getSalida();

                ventana2 = new JVentanaResultadosBuscar(salidas,JVentanaBuscar.this);
                ventana2.setVisible(true);
                JVentanaBuscar.this.setVisible(false);

            }
        });
    }


}

