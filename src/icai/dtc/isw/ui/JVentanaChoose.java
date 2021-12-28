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
    private JVentanaBuscar opcion2;
    public static void main(String args[]) {
        new JVentanaChoose();
    }

    public JVentanaChoose() {

        this.setTitle("Menu");
        this.setLayout(new BorderLayout());

        JPanel pnlCentral = new JPanel(new FlowLayout());
        JPanel pnlNorte = new JPanel(new FlowLayout());


        JLabel titulo = new JLabel("Trayecto");
        titulo.setFont(new Font("Harlow Solid Italic", Font.BOLD, 30));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        pnlNorte.add(titulo);

        JButton btnBuscar = new JButton("Busca un trayecto");
        btnBuscar.setForeground(Color.BLACK);
        btnBuscar.setBackground(new Color(215, 207, 204, 255));
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15); //distancia de separacion de dentro
        Border compound = new CompoundBorder(line, margin); //para que tenga el borde de negro
        btnBuscar.setBorder(compound); // añadimos el borde de negro
        btnBuscar.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        btnBuscar.setBounds(200,200, 50,40);
        pnlCentral.add(btnBuscar);

        JButton btnInsertar = new JButton("Añade tu trayecto");
        btnInsertar.setForeground(Color.BLACK);
        btnInsertar.setBackground(new Color(215, 207, 204, 255));
        btnInsertar.setBorder(compound); // añadimos el borde de negro
        btnInsertar.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        btnInsertar.setBounds(200,200, 50,40);
        pnlCentral.add(btnInsertar);

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

        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlNorte, BorderLayout.NORTH);


        this.setResizable(false); //para que no se pueda mover la jventana
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null); //para que aparezca en medio de la pantalla
        this.setVisible(true);
        pnlCentral.setBackground(new Color(207, 185, 151, 255));
        pnlNorte.setBackground(new Color(207, 185, 151, 255));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    }
