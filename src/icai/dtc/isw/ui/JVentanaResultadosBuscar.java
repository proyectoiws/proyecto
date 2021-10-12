package icai.dtc.isw.ui;

import icai.dtc.isw.domain.Customer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JVentanaResultadosBuscar extends JFrame
{
    private JVentanaBuscar ventana;
    private ArrayList<Customer> salidas;
    private JButton btnVolver;
    private JLabel labelMatricula, labelOrigen, labelDestino, labelPlazas;


    public JVentanaResultadosBuscar(ArrayList<Customer> salidas,JVentanaBuscar ventana)
    {
        this.ventana = ventana;
        this.salidas = salidas;

        this.setTitle("Resultados de la b\u00FAsqueda");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        initBotonVolver();
        initTitulo();
        initJLabels();
        initActionBoton();

        this.getContentPane().setBackground(new Color(207, 185, 151,255)); //color de fondo (lo pongo al final porque sino no se ven las boxes)

    }

    public void initBotonVolver() {
        btnVolver = new JButton("Volver a buscar");
        btnVolver.setBounds(375,450,250,50);
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setBackground(new Color(215,207,204,255));
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15); //distancia de separacion de dentro
        Border compound = new CompoundBorder(line, margin); //para que tenga el borde de negro
        btnVolver.setBorder(compound); // añadimos el borde de negro
        btnVolver.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(btnVolver);
    }

    public void initTitulo() {
        JLabel titulo = new JLabel( "Resultados de la b\u00FAsqueda:" );
        titulo.setBounds(125, 50, 500, 50);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(new Color(234, 223, 223,255));
        titulo.setForeground(new Color(0, 47, 152,255));
        titulo.setOpaque(false); //false para quitar el fondo
        titulo.setFont(new Font("Harlow Solid Italic"   , Font.BOLD, 25));
        this.add(titulo);
    }

    public void initJLabels() {
        for (Customer customer : salidas) {

            labelMatricula = new JLabel("Matr\u00EDcula: " + customer.getMatricula());
            labelMatricula.setBounds(250, 125, 400, 50);
            labelMatricula.setHorizontalAlignment(SwingConstants.LEFT);
            labelMatricula.setForeground(Color.black);
            labelMatricula.setOpaque(false); //false para quitar el fondo
            labelMatricula.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            this.add(labelMatricula);

            labelOrigen = new JLabel("Origen: " + customer.getOrigen());
            labelOrigen.setBounds(250, 205, 400, 50);
            labelOrigen.setHorizontalAlignment(SwingConstants.LEFT);
            labelOrigen.setForeground(Color.black);
            labelOrigen.setOpaque(false); //false para quitar el fondo
            labelOrigen.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            this.add(labelOrigen);

            labelDestino = new JLabel("Destino: " + customer.getDestino());
            labelDestino.setBounds(250, 285, 400, 50);
            labelDestino.setHorizontalAlignment(SwingConstants.LEFT);
            labelDestino.setForeground(Color.black);
            labelDestino.setOpaque(false); //false para quitar el fondo
            labelDestino.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            this.add(labelDestino);

            labelPlazas = new JLabel("Numero de plazas: " + customer.getDestino());
            labelPlazas.setBounds(250, 365, 400, 50);
            labelPlazas.setHorizontalAlignment(SwingConstants.LEFT);
            labelPlazas.setForeground(Color.black);
            labelPlazas.setOpaque(false); //false para quitar el fondo
            labelPlazas.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            this.add(labelPlazas);
        }
    }

    public void initActionBoton() {
        btnVolver.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ventana.setVisible(true);
                JVentanaResultadosBuscar.this.setVisible(false);
            }
        });
    }
}
