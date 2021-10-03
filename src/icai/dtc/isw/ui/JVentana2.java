package icai.dtc.isw.ui;

import icai.dtc.isw.domain.Entrada;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

import java.awt.Font;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JVentana2 extends JFrame
{
    private JVentana1 ventana;
    private Entrada entrada;


    public JVentana2(Entrada entrada,JVentana1 ventana)
    {
        super("Personalizar fichero");
        this.ventana = ventana;
        this.entrada = entrada;

        this.setLayout(new BorderLayout());

        JButton btnVolver = new JButton("Otra consulta");
        JTextField area=new JTextField("Coche con matricula x y origen "+entrada.getOrigen()+ " con destino "+ entrada.getDestino()+" y "+entrada.getPlazas()+" plazas");


        this.add(btnVolver,BorderLayout.NORTH);
        this.add(area, BorderLayout.CENTER);

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
