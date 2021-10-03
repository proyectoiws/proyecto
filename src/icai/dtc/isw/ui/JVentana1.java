package icai.dtc.isw.ui;

import icai.dtc.isw.domain.Entrada;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.*;

import java.awt.Font;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class JVentana1 extends JFrame
{

    private JVentana2 ventana2;

    public static void main(String args[])
    {
        new JVentana1();
    }


    public JVentana1()
    {
        super("Busqueda de coches");
        this.setLayout(new BorderLayout());

        //JPanel pnlNorte = new JPanel(new FlowLayout());
        //JPanel pnlSur= new JPanel(new FlowLayout());
        JPanel pnlCentral= new JPanel(new FlowLayout());

        JLabel titulo = new JLabel( "Busca tu coche" );
        //titulo.setFont( new Font( Font.SERIF, Font.BOLD, 50 ) );
        titulo.setHorizontalAlignment( JLabel.CENTER );




        JButton btnBuscar = new JButton("Buscar");

        String origen[]={"Origen","Pozuelo","Majadahonda","Boadilla","Somosaguas","ICAI","ICADE","CIHS","Madrid"};
        String destinos[]={"Destino","Pozuelo","Majadahonda","Boadilla","Somosaguas","ICAI","ICADE","CIHS","Madrid"};
        String plazas[]={"Plazas","1","2","3","4","5","6","7"};


        final JComboBox cbOrigen= new JComboBox(origen);
        final JComboBox cbDestino= new JComboBox(destinos);
        final JComboBox cbPlazas= new JComboBox(plazas);


        pnlCentral.add(titulo);
        pnlCentral.add(btnBuscar);
        pnlCentral.add(cbOrigen);
        pnlCentral.add(cbDestino);
        pnlCentral.add(cbPlazas);




        //btnJugar.setEnabled(false);



        btnBuscar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String origen = (String) cbOrigen.getItemAt(cbOrigen.getSelectedIndex());
                String plazas=  (String) cbPlazas.getItemAt(cbPlazas.getSelectedIndex());
                String destino = (String) cbDestino.getItemAt(cbDestino.getSelectedIndex());
                Entrada entrada = new Entrada (origen, destino,plazas);
                // llamar a socket y a client
                // lo q devuleve client (array) es el argumento de JVentana2

                ventana2 = new JVentana2(entrada,JVentana1.this);
                ventana2.setVisible(true);
                JVentana1.this.setVisible(false);

            }
        });


        // this.add(pnlSur, BorderLayout.SOUTH);
        //this.add(pnlNorte, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }



}

