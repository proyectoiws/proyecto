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
    private JVentanaBuscar ventana1;
    public static void main(String args[]){
        new JVInicio();
    }

    public JVInicio()
    {
        super("Bienvenido al programa");
        this.setLayout(new BorderLayout());

        JPanel pnlCentral = new JPanel(new FlowLayout());
        JPanel pnlNorte = new JPanel( new FlowLayout());
        JPanel pnlSur = new JPanel(new FlowLayout());

        JLabel titulo = new JLabel("Conectate Comillas");
        titulo.setFont(new Font(Font.SERIF , Font. BOLD , 50));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        pnlNorte.add(titulo);

        JLabel lblname = new JLabel("Usuario:");
        //lblname.setBounds(10,100,80,25);


        JLabel lblcontra = new JLabel("Contraseña:");
        //lblcontra.setBounds(10,300,80,25);


        JTextField txtuser = new JTextField(20);
        //txtuser.setBounds(100,100,160,25);


        JPasswordField txtcontra = new JPasswordField(20);
        //txtcontra.setBounds(100,300,160,25);


        pnlCentral.add(lblname);
        pnlCentral.add(txtuser);
        pnlCentral.add(lblcontra);
        pnlCentral.add(txtcontra);

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
                    JOptionPane.showMessageDialog(null, "No se encuentra su usuario, vuelva a intentarlo");
                }
                else {
                    ventana1 = new JVentanaBuscar();
                    ventana1.setVisible(true);
                    JVInicio.this.setVisible(false);
                }

            }
        });

        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlNorte, BorderLayout.NORTH);
        this.add(pnlSur, BorderLayout.SOUTH);


        this.setResizable(false); //para que no se pueda mover la jventana
        this.setSize(1000,600);
        this.setLocationRelativeTo(null); //para que aparezca en medio de la pantalla
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
