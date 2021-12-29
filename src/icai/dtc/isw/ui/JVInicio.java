package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Entrada;
import icai.dtc.isw.domain.Usuario;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class JVInicio extends JFrame

{
    private JVentanaChoose ventanaBuscar;
    private JVentanaRegistro ventanaResistro;
    private JLabel lblname, lblcontra;
    private JButton btnRegis, btnIn;
    private JTextField txtuser;
    private JPasswordField txtcontra;
    private JCheckBox checkContrasena;

    public static void main(String args[]){
        new JVInicio();
    }

    public JVInicio()
    {
        this.setTitle("Bienvenido al programa");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false); //para que no se pueda mover la jventana
        this.setSize(1000,600);
        this.setLocationRelativeTo(null); //para que aparezca en medio de la pantalla
        this.setVisible(true);

        initTitulo();
        initJLabels();
        initBotones();
        initActionBotones();
        initTxt();

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
        this.getContentPane().setBackground(new Color(207, 185, 151,255)); //color de fondo (lo pongo al final porque sino no se ven las boxes)
    }

    public void initTitulo() {
        JLabel titulo = new JLabel( "Con\u00E9ctate Comillas");
        titulo.setBounds(325, 50, 350, 50);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setOpaque(false); //false para quitar el fondo
        titulo.setFont(new Font("Harlow Solid Italic"   , Font.BOLD, 30));
        this.add(titulo);
    }

    public void initJLabels(){
        lblname = new JLabel("Usuario:");
        lblname.setBounds(250,180,125,50);
        lblname.setHorizontalAlignment(SwingConstants.LEFT);
        lblname.setForeground(Color.black);
        lblname.setOpaque(false); //false para quitar el fondo
        lblname.setFont(new Font( "Harlow Solid Italic" , Font.BOLD, 20));
        this.add(lblname);

        lblcontra = new JLabel("Contraseña:");
        lblcontra.setBounds(250,280,150,50);
        lblcontra.setHorizontalAlignment(SwingConstants.LEFT);
        lblcontra.setForeground(Color.black);
        lblcontra.setOpaque(false); //false para quitar el fondo
        lblcontra.setFont(new Font( "Harlow Solid Italic" , Font.BOLD, 20));
        this.add(lblcontra);
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

        btnIn = new JButton("Iniciar sesi\u00F3n");
        btnIn.setBounds(500,450,250,50);
        btnIn.setForeground(Color.BLACK);
        btnIn.setBackground(new Color(215,207,204,255));
        btnIn.setBorder(compound); // añadimos el borde de negro
        btnIn.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(btnIn);

        JButton btnRegis = new JButton("Registrarse");
        btnRegis.setForeground(Color.BLACK);
        btnRegis.setBackground(new Color(215,207,204,255));
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15); //distancia de separacion de dentro
        Border compound = new CompoundBorder(line, margin); //para que tenga el borde de negro
        btnRegis.setBorder(compound); // añadimos el borde de negro
        btnRegis.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));

        JButton btnIn;
        btnIn = new JButton("Iniciar sesi\u00F3n");
        btnIn.setBounds(375,450,250,50);
        btnIn.setForeground(Color.BLACK);
        btnIn.setBackground(new Color(215,207,204,255));
        btnIn.setBorder(compound); // añadimos el borde de negro
        btnIn.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
    }

    public void initTxt() {

        String destinos[]={"Pozuelo","Majadahonda","Boadilla","Somosaguas","ICAI","ICADE","CIHS","Madrid"};
        cbDestino = new JComboBox<String>(destinos);
        cbDestino.setBounds(600,240,200,30);
//        cbDestino.setFont(new Font("Bauhaus 93", 0, 20));
        this.add(cbDestino);

        String plazas[]={"1","2","3","4","5","6","7"};
        cbPlazas = new JComboBox<String>(plazas);
        cbPlazas.setBounds(600,320,200,30);
//        cbPlazas.setFont(new Font("Bauhaus 93", 0, 20));
        this.add(cbPlazas);

        txtuser = new JTextField(20);
        txtuser.setToolTipText("Ingrese usuario");
        txtuser.setBounds(600,160,200,30);
        txtuser.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(txtuser);


        JPasswordField txtcontra = new JPasswordField(20);
        txtcontra.setEchoChar('*');
        txtcontra.setToolTipText("Ingrese contraseña");
        txtcontra.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(txtcontra);

        checkContrasena = new JCheckBox("Ver contraseña");
        checkContrasena.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        checkContrasena.setOpaque(false); //false para quitar el fondo
        this.add(checkContrasena);
    }

    public void initActionBotones() {
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
                HashMap<String, Object> peticion = new HashMap<>();
                peticion.put("Peticion",u);
                c.envioPeticion("/getUsuario",peticion);
                //System.out.println("ok final");
                int entrar = c.getSalidaU();
                if(entrar==0){
                    JOptionPane.showMessageDialog(null, "No se encuentra su usuario, regístrese para crear una cuenta");
                }
                else {
                    ventanaBuscar = new JVentanaChoose();
                    ventanaBuscar.setVisible(true);
                    JVInicio.this.setVisible(false);
                }
            }
        });

        btnRegis.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
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
    }
}
