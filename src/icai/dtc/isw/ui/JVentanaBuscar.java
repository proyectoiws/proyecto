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

    private JVentanaResultados ventanaResultados;
    private JButton btnBuscar, btnVolver;
    private JComboBox<String> cbOrigen, cbDestino, cbPlazas;
    private JLabel labelOrigen, labelDestino, labelPlazas;
    private JVentanaChoose volver;


    public static void main(String args[])
    {
        new JVentanaBuscar();
    }


    public JVentanaBuscar()
    {
        this.setTitle("B\u00FAsqueda de coches");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false); //para que no se pueda mover la jventana
        this.setSize(1000,600);
        this.setLocationRelativeTo(null); //para que aparezca en medio de la pantalla
        this.setVisible(true);

        initTitulo();
        initJLabels();
        initBotones();
        initBoxes();
        initActionBotones();

        this.getContentPane().setBackground(new Color(207, 185, 151,255)); //color de fondo (lo pongo al final porque sino no se ven las boxes)
    }

    public void initTitulo() {
        JLabel titulo = new JLabel( "Elige los par\u00E1metros de b\u00FAsqueda:" );
        titulo.setBounds(125, 50, 500, 50);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(new Color(234, 223, 223,255));
        titulo.setForeground(new Color(0, 47, 152,255));
        titulo.setOpaque(false); //false para quitar el fondo
        titulo.setFont(new Font("Harlow Solid Italic"   , Font.BOLD, 25));
        this.add(titulo);
    }

    public void initBotones() {
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(200,450,250,50);
        btnBuscar.setForeground(Color.BLACK);
        btnBuscar.setBackground(new Color(215,207,204,255));
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15); //distancia de separacion de dentro
        Border compound = new CompoundBorder(line, margin); //para que tenga el borde de negro
        btnBuscar.setBorder(compound); // añadimos el borde de negro
        btnBuscar.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(btnBuscar);

        btnVolver = new JButton("Volver a trayectos");
        btnVolver.setBounds(500,450,250,50);
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setBackground(new Color(215,207,204,255));
        btnVolver.setBorder(compound); // añadimos el borde de negro
        btnVolver.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(btnVolver);
    }

    public void initBoxes() {
        String origen[]={"Pozuelo","Majadahonda","Boadilla","Somosaguas","ICAI","ICADE","CIHS","Madrid"};
        cbOrigen = new JComboBox<String>(origen);
        cbOrigen.setBounds(500,160,250,30);
//        cbOrigen.setFont(new Font("Bauhaus 93", 0, 20));
        this.add(cbOrigen);

        String destinos[]={"Pozuelo","Majadahonda","Boadilla","Somosaguas","ICAI","ICADE","CIHS","Madrid"};
        cbDestino = new JComboBox<String>(destinos);
        cbDestino.setBounds(500,240,250,30);
//        cbDestino.setFont(new Font("Bauhaus 93", 0, 20));
        this.add(cbDestino);

        String plazas[]={"1","2","3","4","5","6","7"};
        cbPlazas = new JComboBox<String>(plazas);
        cbPlazas.setBounds(500,320,250,30);
//        cbPlazas.setFont(new Font("Bauhaus 93", 0, 20));
        this.add(cbPlazas);
    }

    public void initJLabels(){
        labelOrigen = new JLabel("Origen:");
        labelOrigen.setBounds(375,150,120,50);
        labelOrigen.setHorizontalAlignment(SwingConstants.LEFT);
        labelOrigen.setForeground(Color.black);
        labelOrigen.setOpaque(false); //false para quitar el fondo
        labelOrigen.setFont(new Font( Font.DIALOG, Font.BOLD, 20));
        this.add(labelOrigen);

        labelDestino = new JLabel("Destino:");
        labelDestino.setBounds(370,230,120,50);
        labelDestino.setHorizontalAlignment(SwingConstants.LEFT);
        labelDestino.setForeground(Color.black);
        labelDestino.setOpaque(false); //false para quitar el fondo
        labelDestino.setFont(new Font( Font.DIALOG, Font.BOLD, 20));
        this.add(labelDestino);

        labelPlazas = new JLabel("Numero de plazas:");
        labelPlazas.setBounds(250,310,250,50);
        labelPlazas.setHorizontalAlignment(SwingConstants.LEFT);
        labelPlazas.setForeground(Color.black);
        labelPlazas.setOpaque(false); //false para quitar el fondo
        labelPlazas.setFont(new Font( Font.DIALOG, Font.BOLD, 20));
        this.add(labelPlazas);
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
                //System.out.println("ok final");
                ArrayList<Customer> salidas = c.getSalidaC();
                if(salidas.size()==0){
                    JOptionPane.showMessageDialog(null, "No se encuentra resultado para sus requisitos, vuelva a intentarlo");
                }
                else {
                    ventanaResultados = new JVentanaResultados(salidas,JVentanaBuscar.this);
                    ventanaResultados.setVisible(true);
                    JVentanaBuscar.this.setVisible(false);
                }
            }
        });

        btnVolver.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                    volver= new JVentanaChoose();
                    volver.setVisible(true);
                    JVentanaBuscar.this.setVisible(false);
            }
        });


    }


}

