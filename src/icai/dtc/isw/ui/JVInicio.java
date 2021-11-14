package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Entrada;
import icai.dtc.isw.domain.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class JVInicio extends JFrame

{
    private JVentanaBuscar ventanaBuscar;
    private JVentanaRegistro ventanaResistro;

    public static void main(String args[]){
        new JVInicio();
    }

    public JVInicio()
    {
        this.setTitle("Bienvenido al programa");
        this.setLayout(new BorderLayout());

        JPanel pnlCentral = new JPanel(new FlowLayout());
        JPanel pnlNorte = new JPanel( new FlowLayout());
        JPanel pnlSur = new JPanel(new FlowLayout());

        JLabel titulo = new JLabel("Conectate Comillas");
        titulo.setFont(new Font("Harlow Solid Italic"   , Font.BOLD, 30));;
        titulo.setHorizontalAlignment(JLabel.CENTER);
        pnlNorte.add(titulo);

        JLabel lblname = new JLabel("Usuario:");
        lblname.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        //lblname.setBounds(10,100,80,25);


        JLabel lblcontra = new JLabel("Contraseña:");
        lblcontra.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        //lblcontra.setBounds(10,300,80,25);


        JTextField txtuser = new JTextField(20);
        txtuser.setToolTipText("Ingrese usuario");
        txtuser.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        //txtuser.setBounds(100,100,160,25);


        JPasswordField txtcontra = new JPasswordField(20);
        txtcontra.setEchoChar('*');
        txtcontra.setToolTipText("Ingrese contraseña");
        txtcontra.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        //txtcontra.setBounds(100,300,160,25);

        JCheckBox checkContrasena = new JCheckBox("Ver contraseña");
        checkContrasena.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        checkContrasena.setOpaque(false); //false para quitar el fondo

        pnlCentral.add(lblname);
        pnlCentral.add(txtuser);
        pnlCentral.add(lblcontra);
        pnlCentral.add(txtcontra);
        pnlCentral.add(checkContrasena);

        JButton btnRegis = new JButton("Registrarse");
        JButton btnIn= new JButton("Iniciar sesion");
        pnlSur.add(btnIn);
        pnlSur.add(btnRegis);

        btnIn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                char [] arrayC = txtcontra.getPassword();
                String contra= new String(arrayC);
                String name = txtuser.getText();
                Usuario u = new Usuario (name, contra);
                System.out.println(u.getId()+" "+u.getPassword());
                Client c = new Client();
                HashMap<String, Object> peticion = new HashMap<String,Object>();
                peticion.put("Peticion",u);
                c.envioPeticion("/getUsuario",peticion);
                //System.out.println("ok final");
                int entrar = c.getSalidaU();
                if(entrar==0){
                    JOptionPane.showMessageDialog(null, "No se encuentra su usuario, regístrese para crear una cuenta");
                }
                else {
                    ventanaBuscar = new JVentanaBuscar();
                    ventanaBuscar.setVisible(true);
                    JVInicio.this.setVisible(false);
                }
            }
        });

        btnRegis.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaResistro = new JVentanaRegistro();
                ventanaResistro.setVisible(true);
                JVInicio.this.setVisible(false);
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

//        btnRegis.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                char [] arrayC = txtcontra.getPassword();
//                String contra= new String(arrayC);
//                String name = txtuser.getText();
//                Usuario u = new Usuario (name, contra);
//                System.out.println(u.getId()+" "+u.getPassword());
//                Client c = new Client();
//                HashMap<String, Object> peticion = new HashMap<String,Object>();
//                peticion.put("Peticion",u);
//                c.envioPeticion("/getRegistrar",peticion);
//                //System.out.println("ok final");
//                int entrar = c.getSalidaU();
//                if(entrar==0){
//                    JOptionPane.showMessageDialog(null, "Su usuario se ha añadido, por favor inicie sesion con la ");
//                }
//                else {
//                    JOptionPane.showMessageDialog(null, "Este usuario ya ha sido registrado, por favor, inicie sesión con este");
//                }
//            }
//        });

        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlNorte, BorderLayout.NORTH);
        this.add(pnlSur, BorderLayout.SOUTH);


        this.setResizable(false); //para que no se pueda mover la jventana
        this.setSize(1000,600);
        this.setLocationRelativeTo(null); //para que aparezca en medio de la pantalla
        this.setVisible(true);
        pnlCentral.setBackground(new Color(207, 185, 151,255));
        pnlNorte.setBackground(new Color(207, 185, 151,255));
        pnlSur.setBackground(new Color(207, 185, 151,255));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
