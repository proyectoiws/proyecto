package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Usuario;

import javax.swing.*;
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
        pnlNorte.add(titulo);

        JLabel lblname = new JLabel("Usuario:");
        //lblname.setBounds(10,100,80,25);

        JLabel lblcontra = new JLabel("Contraseña:");
        //lblcontra.setBounds(10,300,80,25);

        JLabel lblcontra2 = new JLabel("Repita su contraseña:");

        JTextField txtuser = new JTextField(10  );
        txtuser.setToolTipText("Ingrese usuario");
        //txtuser.setBounds(100,100,160,25);

        JPasswordField txtcontra = new JPasswordField(10);
        txtcontra.setToolTipText("Ingrese contraseña");
        txtcontra.setEchoChar('*');
        //txtcontra.setBounds(100,300,160,25);

        JCheckBox checkContrasena = new JCheckBox("Ver contraseña");


        JPasswordField txtcontra2 = new JPasswordField(10);
        txtcontra2.setToolTipText("Ingrese contraseña");
        txtcontra2.setEchoChar('*');

        JCheckBox checkContrasena2 = new JCheckBox("Ver contraseña");


        pnlCentral.add(lblname);
        pnlCentral.add(txtuser);
        pnlCentral.add(lblcontra);
        pnlCentral.add(txtcontra);
        pnlCentral.add(checkContrasena);
        pnlCentral.add(lblcontra2);
        pnlCentral.add(txtcontra2);
        pnlCentral.add(checkContrasena2);

        JButton btnRegis = new JButton("Registrarse");
        pnlSur.add(btnRegis);

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
                        JOptionPane.showMessageDialog(null, "Ese nombre de usuario ya existe");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "El usuario se ha registrado, inicie sesión");
                         }
                    ventanaInicio = new JVInicio();
                    ventanaInicio.setVisible(true);
                    JVentanaRegistro.this.setVisible(false);
                }

                else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                }
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
        this.setBackground(new Color(207, 185, 151,255));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
