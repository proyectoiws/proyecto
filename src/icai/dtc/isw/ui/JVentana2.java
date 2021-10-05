package icai.dtc.isw.ui;

import icai.dtc.isw.domain.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

import java.util.*;
import java.awt.BorderLayout;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JVentana2 extends JFrame
{
    private JVentana1 ventana;
    private ArrayList<Customer> salidas;


    public JVentana2(ArrayList<Customer> salidas,JVentana1 ventana)
    {
        super("Personalizar fichero");
        this.ventana = ventana;
        this.salidas = salidas;

        this.setLayout(new BorderLayout());

        JButton btnVolver = new JButton("Otra consulta");
        for (Customer customer : salidas) {
            JTextField area=new JTextField("He leído la matricula: "+customer.getMatricula()+" origen:"+customer.getOrigen()+" destino:"+customer.getDestino()+"numero de plazas"+customer.getPlazas());
            this.add(area, BorderLayout.CENTER);
        }


        this.add(btnVolver,BorderLayout.NORTH);


        btnVolver.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                ventana.setVisible(true);
                JVentana2.this.setVisible(false);


            }
        });


        this.setResizable(false);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
