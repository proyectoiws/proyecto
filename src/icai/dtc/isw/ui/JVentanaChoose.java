package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Usuario;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class JVentanaChoose extends JFrame{

    private JVentanaInsertarCoche opcion1;
    private JVInicio ventanaInicio;
    private JVentanaBuscar opcion2;
    private JLabel titulo;
    private JButton btnBuscar, btnInsertar, btnVolver;

    public static void main(String args[]) {
        new JVentanaChoose();
    }

    public JVentanaChoose() {

        this.setTitle("Menu");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false); //para que no se pueda mover la jventana
        this.setSize(1000,600);
        this.setLocationRelativeTo(null); //para que aparezca en medio de la pantalla
        this.setVisible(true);

        initTitulo();
        initBotones();
        initActionBotones();

        this.getContentPane().setBackground(new Color(207, 185, 151,255)); //color de fondo (lo pongo al final porque sino no se ven las boxes)
    }

    public void initTitulo() {
        titulo = new JLabel( "\u00BFQu\u00E9 desea hacer?");
        titulo.setBounds(325, 50, 350, 50);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setOpaque(false); //false para quitar el fondo
        titulo.setFont(new Font("Harlow Solid Italic"   , Font.BOLD, 30));
        this.add(titulo);
    }

    public void initBotones() {
        btnBuscar = new JButton("Busca un trayecto");
        btnBuscar.setForeground(Color.BLACK);
        btnBuscar.setBackground(new Color(215, 207, 204, 255));
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15); //distancia de separacion de dentro
        Border compound = new CompoundBorder(line, margin); //para que tenga el borde de negro
        btnBuscar.setBorder(compound); // añadimos el borde de negro
        btnBuscar.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        btnBuscar.setBounds(525,150, 250,50);
        this.add(btnBuscar);

        btnInsertar = new JButton("Añade tu trayecto");
        btnInsertar.setForeground(Color.BLACK);
        btnInsertar.setBackground(new Color(215, 207, 204, 255));
        btnInsertar.setBorder(compound); // añadimos el borde de negro
        btnInsertar.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        btnInsertar.setBounds(225,150, 250,50);
        this.add(btnInsertar);

        btnVolver = new JButton("Cerrar sesi\u00F3n");
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setBackground(new Color(215, 207, 204, 255));
        btnVolver.setBorder(compound); // añadimos el borde de negro
        btnVolver.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        btnVolver.setBounds(375,250, 250,50);
        this.add(btnVolver);
    }

    public void initActionBotones() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcion2 = new JVentanaBuscar();
                opcion2.setVisible(true);
                JVentanaChoose.this.setVisible(false);
            }


        });

        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcion1 = new JVentanaInsertarCoche();
                opcion1.setVisible(true);
                JVentanaChoose.this.setVisible(false);
            }
        });

        btnVolver.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int confirmado = JOptionPane.showConfirmDialog(null, "\u00BFDesea volver al menú de inicio de sesón?", "Confirmación para volver a iniciar sesión",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                if (JOptionPane.OK_OPTION == confirmado) {
                    ventanaInicio = new JVInicio();
                    ventanaInicio.setVisible(true);
                    JVentanaChoose.this.setVisible(false);
                }
                else; //nada
            }
        });

    }

}
