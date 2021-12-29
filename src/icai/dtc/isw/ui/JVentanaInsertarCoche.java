package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Entrada;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;

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


public class JVentanaInsertarCoche extends JFrame{

    private JButton btnBuscar, btnVolver;
    private JComboBox<String> cbOrigen, cbDestino, cbPlazas;
    private JLabel labelOrigen, labelDestino, labelPlazas, matricula,lblFecha;
    private JTextField txtmatricula;
    private JVentanaChoose ventanaChoose;
    private Calendar c;
    private JDatePickerImpl datePickerFecha;

    public static void main(String args[])
    {
        new JVentanaInsertarCoche();
    }

    public JVentanaInsertarCoche()
    {
        this.setTitle("Añade tu coche");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false); //para que no se pueda mover la jventana
        this.setSize(1000,600);
        this.setLocationRelativeTo(null); //para que aparezca en medio de la pantalla
        this.setVisible(true);

        initTitulo();
        initJLabels();
        initBotonBuscar();
        initBoxes();
        initActionBotones();
        initCalendar();

        this.getContentPane().setBackground(new Color(207, 185, 151,255)); //color de fondo (lo pongo al final porque sino no se ven las boxes)
    }

    private void initCalendar() {
        UtilCalendarModel modelFecha = new UtilCalendarModel();
        c= Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        int currentMonth = c.get(Calendar.MONTH);
        int currentDay = c.get(Calendar.DAY_OF_MONTH);

        modelFecha.setDate(currentYear, currentMonth, currentDay);

        JDatePanelImpl datePanelFecha = new JDatePanelImpl(modelFecha);
        datePanelFecha.setBackground(new Color(207, 185, 151,255));
        datePickerFecha = new JDatePickerImpl(datePanelFecha);
        datePickerFecha.setBounds(500,390,250,25);
        this.add(datePickerFecha);
    }


    public void initTitulo() {
        JLabel titulo = new JLabel( "Par\u00E1metros de coche:" );
        titulo.setBounds(125, 20, 500, 50);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(new Color(234, 223, 223,255));
        titulo.setForeground(new Color(0, 47, 152,255));
        titulo.setOpaque(false); //false para quitar el fondo
        titulo.setFont(new Font("Harlow Solid Italic"   , Font.BOLD, 25));
        this.add(titulo);
    }

    public void initBotonBuscar() {
        btnBuscar = new JButton("Insertar");
        btnBuscar.setBounds(200,450,250,50);
        btnBuscar.setForeground(Color.BLACK);
        btnBuscar.setBackground(new Color(215,207,204,255));
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15); //distancia de separacion de dentro
        Border compound = new CompoundBorder(line, margin); //para que tenga el borde de negro
        btnBuscar.setBorder(compound); // añadimos el borde de negro
        btnBuscar.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(btnBuscar);

        btnVolver = new JButton("Volver a trayectos");
        btnVolver.setBounds(500,450,250,50);
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setBackground(new Color(215,207,204,255));
        btnVolver.setBorder(compound); // añadimos el borde de negro
        btnVolver.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(btnVolver);


    }

    public void initBoxes() {

        txtmatricula = new JTextField(15  );
        txtmatricula.setBounds(500,80,250,30);
        this.add(txtmatricula);

        String origen[]={"Pozuelo","Majadahonda","Boadilla","Somosaguas","ICAI","ICADE","CIHS","Madrid"};
        cbOrigen = new JComboBox<>(origen);
        cbOrigen.setBounds(500,160,250,30);
//        cbOrigen.setFont(new Font("Bauhaus 93", 0, 20));
        this.add(cbOrigen);

        String destinos[]={"Pozuelo","Majadahonda","Boadilla","Somosaguas","ICAI","ICADE","CIHS","Madrid"};
        cbDestino = new JComboBox<>(destinos);
        cbDestino.setBounds(500,240,250,30);
//        cbDestino.setFont(new Font("Bauhaus 93", 0, 20));
        this.add(cbDestino);

        String plazas[]={"1","2","3","4","5","6","7"};
        cbPlazas = new JComboBox<String>(plazas);
        cbPlazas.setBounds(500,310,250,30);
//        cbPlazas.setFont(new Font("Bauhaus 93", 0, 20));
        this.add(cbPlazas);
    }

    public void initJLabels(){
        matricula = new JLabel( "Matricula:" );
        matricula.setBounds(345, 70, 120, 50);
        matricula.setHorizontalAlignment(SwingConstants.LEFT);
        matricula.setForeground(Color.black);
        matricula.setOpaque(false); //false para quitar el fondo
        matricula.setFont(new Font( Font.DIALOG, Font.BOLD, 20));
        this.add(matricula);

        labelOrigen = new JLabel("Origen:");
        labelOrigen.setBounds(375,150,120,50);
        labelOrigen.setHorizontalAlignment(SwingConstants.LEFT);
        labelOrigen.setForeground(Color.black);
        labelOrigen.setOpaque(false); //false para quitar el fondo
        labelOrigen.setFont(new Font( Font.DIALOG, Font.BOLD, 20));
        this.add(labelOrigen);

        labelDestino = new JLabel("Destino:");
        labelDestino.setBounds(365,230,120,50);
        labelDestino.setHorizontalAlignment(SwingConstants.LEFT);
        labelDestino.setForeground(Color.black);
        labelDestino.setOpaque(false); //false para quitar el fondo
        labelDestino.setFont(new Font( Font.DIALOG, Font.BOLD, 20));
        this.add(labelDestino);

        labelPlazas = new JLabel("Numero de plazas:");
        labelPlazas.setBounds(250,300,250,50);
        labelPlazas.setHorizontalAlignment(SwingConstants.LEFT);
        labelPlazas.setForeground(Color.black);
        labelPlazas.setOpaque(false); //false para quitar el fondo
        labelPlazas.setFont(new Font( Font.DIALOG, Font.BOLD, 20));
        this.add(labelPlazas);

        lblFecha = new JLabel("Numero de plazas:");
        lblFecha.setBounds(250,380,250,50);
        lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
        lblFecha.setForeground(Color.black);
        lblFecha.setOpaque(false); //false para quitar el fondo
        lblFecha.setFont(new Font( Font.DIALOG, Font.BOLD, 20));
        this.add(lblFecha);
    }

    public void initActionBotones() {
        btnBuscar.addActionListener(e -> {
            Calendar f = (Calendar) datePickerFecha.getModel().getValue();
            SimpleDateFormat sdfFecha= new SimpleDateFormat("yyyy-MM-dd");
            String fechaStr = sdfFecha.format(new Date(f.getTimeInMillis()));
            System.out.println(fechaStr);
            String origen = cbOrigen.getItemAt(cbOrigen.getSelectedIndex());
            String plazas=  cbPlazas.getItemAt(cbPlazas.getSelectedIndex());
            String destino = cbDestino.getItemAt(cbDestino.getSelectedIndex());
            String matricula = txtmatricula.getText();
            Customer entrada = new Customer (matricula,origen, destino,plazas);
            Client c = new Client();
            HashMap<String, Object> peticion = new HashMap<>();
            peticion.put("Peticion",entrada);
            c.envioPeticion("/setCoche",peticion);
            System.out.println("ok final");
            if (c.getCocheOk()==1) {
                JOptionPane.showMessageDialog(null, "Este trayecto ya existe");
            }
            else{
                JOptionPane.showMessageDialog(null, "El trayecto se ha registrado");

            }



        });

        btnVolver.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                ventanaChoose = new JVentanaChoose();
                ventanaChoose.setVisible(true);
                JVentanaInsertarCoche.this.setVisible(false);




            }
        });

    }

}
