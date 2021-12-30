package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Entrada;
import icai.dtc.isw.domain.IteratorCustomer;
import icai.dtc.isw.domain.Usuario;

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


public class JVentanaChoose extends JFrame{


    private JVentanaInsertarCoche ventanaInsertarCoche;
    private JVInicio ventanaInicio;
    private JVentanaMisTrayectos ventanaMisTrayectos;
    private JVentanaScrollTrayectos ventanaScrollTrayectos;
    private JVentanaBuscar ventanaBuscar;
    private JLabel titulo;
    private JButton btnBuscar, btnInsertar, btnVolver, btnMisViajes;
    private String name;

    /*public static void main(String args[]) {
        new JVentanaChoose();
    }*/

    public JVentanaChoose(String name) {
        this.name=name;
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
        btnBuscar.setBounds(375,130, 250,50);
        this.add(btnBuscar);

        btnInsertar = new JButton("Añade tu trayecto");
        btnInsertar.setForeground(Color.BLACK);
        btnInsertar.setBackground(new Color(215, 207, 204, 255));
        btnInsertar.setBorder(compound); // añadimos el borde de negro
        btnInsertar.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        btnInsertar.setBounds(375,200, 250,50);
        this.add(btnInsertar);

        btnVolver = new JButton("Cerrar sesi\u00F3n");
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setBackground(new Color(215, 207, 204, 255));
        btnVolver.setBorder(compound); // añadimos el borde de negro
        btnVolver.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        btnVolver.setBounds(375,340, 250,50);
        this.add(btnVolver);

        btnMisViajes = new JButton("Mis Trayectos");
        btnMisViajes.setForeground(Color.BLACK);
        btnMisViajes.setBackground(new Color(215, 207, 204, 255));
        btnMisViajes.setBorder(compound); // añadimos el borde de negro
        btnMisViajes.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        btnMisViajes.setBounds(375,270, 250,50);
        this.add(btnMisViajes);
    }

    public void initActionBotones() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaBuscar = new JVentanaBuscar(name);
                ventanaBuscar.setVisible(true);
                JVentanaChoose.this.setVisible(false);
            }


        });

        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaInsertarCoche = new JVentanaInsertarCoche(name);
                ventanaInsertarCoche.setVisible(true);
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
        btnMisViajes.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {

                Entrada entrada = new Entrada(name);
                Client c = new Client();
                HashMap<String, Object> peticion = new HashMap<String, Object>();
                peticion.put("Peticion", entrada);
                c.envioPeticion("/getCustomerC", peticion);
                //System.out.println("ok final");
                ArrayList<Customer> salidas = c.getSalidaC();
                if (salidas.size() == 0) {
                    JOptionPane.showMessageDialog(null, "No ha creado ningún viaje todavía");
                } else {
//                    IteratorCustomer it = new IteratorCustomer(salidas,name);
//                    while(it.hasNext()){
//                        System.out.println(it.getText());
//                    }

                    //En salidas esta la info ¿como la ponemos?
                    //JVentanaChoose.this.setVisible(false);
//                    ventanaScrollTrayectos = new JVentanaScrollTrayectos(salidas, name);

                    ventanaScrollTrayectos = new JVentanaScrollTrayectos(salidas,JVentanaChoose.this,name);
                    ventanaScrollTrayectos.setVisible(true);
                    JVentanaChoose.this.setVisible(false);
                }
            }
        });

    }

}
