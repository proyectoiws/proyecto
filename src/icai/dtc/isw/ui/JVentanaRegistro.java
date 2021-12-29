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

public class JVentanaRegistro extends JFrame {

    private JVInicio ventanaInicio;
    private JLabel titulo, lblname, lblcontra, lblcontra2;
    private JTextField txtuser;
    private JPasswordField txtcontra, txtcontra2;
    private JCheckBox checkContrasena, checkContrasena2;
    private JButton btnVolverInicioSesion, btnRegis;

    public static void main(String args[]) {
        new JVentanaRegistro();
    }

    public JVentanaRegistro() {
        this.setTitle("Registro de usuario");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false); //para que no se pueda mover la jventana
        this.setSize(1000,600);
        this.setLocationRelativeTo(null); //para que aparezca en medio de la pantalla
        this.setVisible(true);

        initTitulo();
        initJLabels();
        initTxt();
        initBotones();
        initActionBotones();

        this.getContentPane().setBackground(new Color(207, 185, 151,255)); //color de fondo (lo pongo al final porque sino no se ven las boxes)
    }

    public void initTitulo() {
        JLabel titulo = new JLabel("Registro de usuario");
        titulo.setBounds(325, 50, 350, 50);
        titulo.setFont(new Font("Harlow Solid Italic"   , Font.BOLD, 30));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setOpaque(false); //false para quitar el fondo
        this.add(titulo);
    }

    public void initJLabels() {
        lblname = new JLabel("Usuario:");
        lblname.setBounds(275,125,125,50);
        lblname.setHorizontalAlignment(SwingConstants.LEFT);
        lblname.setForeground(Color.black);
        lblname.setOpaque(false); //false para quitar el fondo
        lblname.setFont(new Font( "Harlow Solid Italic" , Font.BOLD, 20));
        this.add(lblname);

        lblcontra = new JLabel("Contrase\u00F1a:");
        lblcontra.setBounds(250,225,150,50);
        lblcontra.setHorizontalAlignment(SwingConstants.LEFT);
        lblcontra.setForeground(Color.black);
        lblcontra.setOpaque(false); //false para quitar el fondo
        lblcontra.setFont(new Font( "Harlow Solid Italic" , Font.BOLD, 20));
        this.add(lblcontra);

        lblcontra2 = new JLabel("Repita su contrase\u00F1a:");
        lblcontra2.setBounds(150,325,250,50);
        lblcontra2.setHorizontalAlignment(SwingConstants.LEFT);
        lblcontra2.setForeground(Color.black);
        lblcontra2.setOpaque(false); //false para quitar el fondo
        lblcontra2.setFont(new Font( "Harlow Solid Italic" , Font.BOLD, 20));
        this.add(lblcontra2);
    }

    public void initTxt() {
        txtuser = new JTextField(20  );
        txtuser.setToolTipText("Ingrese usuario");
        txtuser.setBounds(425,135,250,30);
        txtuser.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(txtuser);

        txtcontra = new JPasswordField(20);
        txtcontra.setEchoChar('*');
        txtcontra.setBounds(425,235,250,30);
        txtcontra.setToolTipText("Ingrese contraseña");
        txtcontra.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(txtcontra);

        checkContrasena = new JCheckBox("Ver contraseña");
        checkContrasena.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        checkContrasena.setBounds(700,235,200,30);
        checkContrasena.setOpaque(false); //false para quitar el fondo
        this.add(checkContrasena);

        txtcontra2 = new JPasswordField(15);
        txtcontra2.setEchoChar('*');
        txtcontra2.setBounds(425,335,250,30);
        txtcontra2.setToolTipText("Ingrese contraseña");
        txtcontra2.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(txtcontra2);

        checkContrasena2 = new JCheckBox("Ver contraseña");
        checkContrasena2.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        checkContrasena2.setBounds(700,335,200,30);
        checkContrasena2.setOpaque(false); //false para quitar el fondo
        this.add(checkContrasena2);
    }

    public void initBotones() {
        btnRegis = new JButton("Registrarse");
        btnRegis.setBounds(200,450,250,50);
        btnRegis.setForeground(Color.BLACK);
        btnRegis.setBackground(new Color(215,207,204,255));
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15); //distancia de separacion de dentro
        Border compound = new CompoundBorder(line, margin); //para que tenga el borde de negro
        btnRegis.setBorder(compound); // añadimos el borde de negro
        btnRegis.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(btnRegis);

        btnVolverInicioSesion = new JButton("Volver a inicio de sesi\u00F3n");
        btnVolverInicioSesion.setForeground(Color.BLACK);
        btnVolverInicioSesion.setBounds(500,450,250,50);
        btnVolverInicioSesion.setBackground(new Color(215,207,204,255));
        btnVolverInicioSesion.setBorder(compound); // añadimos el borde de negro
        btnVolverInicioSesion.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(btnVolverInicioSesion);
    }

    public void initActionBotones() {
        btnRegis.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                char [] arrayC = txtcontra.getPassword();
                String contra = new String(arrayC);
                char [] arrayC2 = txtcontra2.getPassword();
                String contra2 = new String(arrayC2);

                if (contra.equals(contra2)) {
                    String name = txtuser.getText();
                    Usuario u = new Usuario (name, contra);
                    System.out.println(u.getId()+" "+u.getPassword());
                    Client c = new Client();
                    HashMap<String, Object> peticion = new HashMap<String,Object>();
                    peticion.put("Peticion",u);
                    c.envioPeticion("/setUsuario",peticion);
                    if (c.getComprobarU()==1) {
                        JOptionPane.showMessageDialog(null, "Este usuario ya existe, por favor,cambie el id del usuario o inicie sesi\u00F3n");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "El usuario se ha registrado, inicie sesión");
                        ventanaInicio = new JVInicio();
                        ventanaInicio.setVisible(true);
                        JVentanaRegistro.this.setVisible(false);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                }
            }
        });

        btnVolverInicioSesion.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int confirmado = JOptionPane.showConfirmDialog(null, "\u00BFDesea volver al menú de inicio de sesón?", "Confirmación para volver a iniciar sesión",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                if (JOptionPane.OK_OPTION == confirmado) {
                    ventanaInicio = new JVInicio();
                    ventanaInicio.setVisible(true);
                    JVentanaRegistro.this.setVisible(false);
                }
                else; //nada
            }
        });

        checkContrasena.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkContrasena.isSelected()) txtcontra.setEchoChar((char)0);
                else txtcontra.setEchoChar('*');
            }
        });

        checkContrasena2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkContrasena2.isSelected()) txtcontra2.setEchoChar((char)0);
                else txtcontra2.setEchoChar('*');
            }
        });
    }
}
