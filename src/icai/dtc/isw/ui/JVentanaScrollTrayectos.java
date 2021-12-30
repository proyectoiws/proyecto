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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class JVentanaScrollTrayectos extends JFrame {

    private JPanelScroll panelScroll;
    private String name;
    private ArrayList<Customer> salidas;
    private JVentanaChoose ventanaChoose;
    private JButton btnMasInfo, btnVolver;
    private JVentanaMisTrayectos ventanaMisTrayectos;

    public JVentanaScrollTrayectos(ArrayList<Customer> salidas, JVentanaChoose ventanaChoose, String name) {

        this.salidas = salidas;
        this.ventanaChoose = ventanaChoose;
        this.name = name;

        this.setTitle("Mis trayectos");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        initTitulo();
        initPanel();
        initBotones();
        initActionBotones(name);

        this.getContentPane().setBackground(new Color(207, 185, 151,255)); //color de fondo (lo pongo al final porque sino no se ven las boxes)
    }

    public void initTitulo() {
        JLabel titulo = new JLabel( "Trayectos: " );
        titulo.setBounds(30, 30, 500, 50);
        titulo.setHorizontalAlignment(SwingConstants.LEFT);
        titulo.setForeground(new Color(234, 223, 223,255));
        titulo.setForeground(new Color(0, 47, 152,255));
        titulo.setOpaque(false); //false para quitar el fondo
        titulo.setFont(new Font("Harlow Solid Italic"   , Font.BOLD, 25));
        this.add(titulo);
    }

    public void initPanel() {
        panelScroll = new JPanelScroll(salidas, name);
        panelScroll.setBounds(40,90,920,340);
        this.add(panelScroll);
    }

    public void initBotones() {
        btnMasInfo = new JButton("Ver m\u00E1s informaci\u00F3n");
        btnMasInfo.setBounds(200,450,250,50);
        btnMasInfo.setForeground(Color.BLACK);
        btnMasInfo.setBackground(new Color(215,207,204,255));
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15); //distancia de separacion de dentro
        Border compound = new CompoundBorder(line, margin); //para que tenga el borde de negro
        btnMasInfo.setBorder(compound); // añadimos el borde de negro
        btnMasInfo.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(btnMasInfo);

        btnVolver = new JButton("Volver al men\u00FA");
        btnVolver.setBounds(500,450,250,50);
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setBackground(new Color(215,207,204,255));
        btnVolver.setBorder(compound); // añadimos el borde de negro
        btnVolver.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(btnVolver);
    }

    public void initActionBotones(String name) {
        String n= name;

        btnMasInfo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ventanaMisTrayectos = new JVentanaMisTrayectos(salidas,ventanaChoose,name);
                ventanaMisTrayectos.setVisible(true);
                JVentanaScrollTrayectos.this.setVisible(false);
            }
        });

        btnVolver.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ventanaChoose= new JVentanaChoose(n);
                ventanaChoose.setVisible(true);
                JVentanaScrollTrayectos.this.setVisible(false);
            }
        });
    }
}
