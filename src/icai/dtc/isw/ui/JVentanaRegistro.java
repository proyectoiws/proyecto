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

    public static void main(String args[]) {
        new JVentanaRegistro();
    }

    public JVentanaRegistro() {
        this.setTitle("Registro de usuario");
        this.setLayout(new BorderLayout());

        JPanel pnlCentral = new JPanel(new FlowLayout());
        JPanel pnlNorte = new JPanel(new FlowLayout());
        JPanel pnlSur = new JPanel(new FlowLayout());

        JLabel titulo = new JLabel("Registro de usuario");
        titulo.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font("Harlow Solid Italic"   , Font.BOLD, 30));;
        pnlNorte.add(titulo);

        JLabel lblname = new JLabel("Usuario:");
        lblname.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        //lblname.setBounds(10,100,80,25);

        JLabel lblcontra = new JLabel("Contraseña:");
        lblcontra.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        //lblcontra.setBounds(10,300,80,25);

        JLabel lblcontra2 = new JLabel("Repita su contraseña:");
        lblcontra2.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));

        JTextField txtuser = new JTextField(15  );
        txtuser.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        txtuser.setToolTipText("Ingrese usuario");
        //txtuser.setBounds(100,100,160,25);

        JPasswordField txtcontra = new JPasswordField(15);
        txtcontra.setToolTipText("Ingrese contraseña");
        txtcontra.setEchoChar('*');
        txtcontra.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        //txtcontra.setBounds(100,300,160,25);

        JCheckBox checkContrasena = new JCheckBox("Ver contraseña");
        checkContrasena.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        checkContrasena.setOpaque(false); //false para quitar el fondo


        JPasswordField txtcontra2 = new JPasswordField(15);
        txtcontra2.setToolTipText("Ingrese contraseña");
        txtcontra2.setEchoChar('*');
        txtcontra2.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));

        JCheckBox checkContrasena2 = new JCheckBox("Ver contraseña");
        checkContrasena2.setOpaque(false); //false para quitar el fondo



        pnlCentral.add(lblname);
        pnlCentral.add(txtuser);
        pnlCentral.add(lblcontra);
        pnlCentral.add(txtcontra);
        pnlCentral.add(checkContrasena);
        pnlCentral.add(lblcontra2);
        pnlCentral.add(txtcontra2);
        pnlCentral.add(checkContrasena2);

        JButton btnRegis = new JButton("Registrarse");
        btnRegis.setForeground(Color.BLACK);
        btnRegis.setBackground(new Color(215,207,204,255));
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15); //distancia de separacion de dentro
        Border compound = new CompoundBorder(line, margin); //para que tenga el borde de negro
        btnRegis.setBorder(compound); // añadimos el borde de negro
        btnRegis.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        pnlSur.add(btnRegis);

        JButton btnVolverInicioSesion = new JButton("Volver a iniciar sesión");
        btnVolverInicioSesion.setForeground(Color.BLACK);
        btnVolverInicioSesion.setBackground(new Color(215,207,204,255));
        btnVolverInicioSesion.setBorder(compound); // añadimos el borde de negro
        btnVolverInicioSesion.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        pnlSur.add(btnVolverInicioSesion);

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

        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlNorte, BorderLayout.NORTH);
        this.add(pnlSur, BorderLayout.SOUTH);


        this.setResizable(false); //para que no se pueda mover la jventana
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null); //para que aparezca en medio de la pantalla
        this.setVisible(true);
        pnlCentral.setBackground(new Color(207, 185, 151,255));
        pnlNorte.setBackground(new Color(207, 185, 151,255));
        pnlSur.setBackground(new Color(207, 185, 151,255));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
