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

    private JButton btnInsertar, btnVolver;
    private JComboBox<String> cbOrigen, cbDestino, cbPlazas, cbHora, cbMinuto;
    private JLabel labelOrigen, labelDestino, labelPlazas, matricula,lblFecha, lblHora;
    private JTextField txtmatricula;
    private JVentanaChoose ventanaChoose;
    private Calendar c;
    private JDatePickerImpl datePickerFecha;
    private String name;

    //public static void main(String args[])*{new JVentanaInsertarCoche();}

    public JVentanaInsertarCoche(String name)
    {
        this.name=name;
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
        datePickerFecha.setBounds(500,320,250,25);
        this.add(datePickerFecha);
    }


    public void initTitulo() {
        JLabel titulo = new JLabel( "Par\u00E1metros del coche:" );
        titulo.setBounds(125, 0, 500, 50);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(new Color(234, 223, 223,255));
        titulo.setForeground(new Color(0, 47, 152,255));
        titulo.setOpaque(false); //false para quitar el fondo
        titulo.setFont(new Font("Harlow Solid Italic"   , Font.BOLD, 25));
        this.add(titulo);
    }

    public void initBotonBuscar() {
        btnInsertar = new JButton("Insertar");
        btnInsertar.setBounds(200,450,250,50);
        btnInsertar.setForeground(Color.BLACK);
        btnInsertar.setBackground(new Color(215,207,204,255));
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15); //distancia de separacion de dentro
        Border compound = new CompoundBorder(line, margin); //para que tenga el borde de negro
        btnInsertar.setBorder(compound); // añadimos el borde de negro
        btnInsertar.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(btnInsertar);

        btnVolver = new JButton("Volver al men\u00FA");
        btnVolver.setBounds(500,450,250,50);
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setBackground(new Color(215,207,204,255));
        btnVolver.setBorder(compound); // añadimos el borde de negro
        btnVolver.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
        this.add(btnVolver);
    }

    public void initBoxes() {

        txtmatricula = new JTextField(15  );
        txtmatricula.setBounds(500,60,250,30);
        this.add(txtmatricula);

        String origen[]={"Pozuelo","Majadahonda","Boadilla","Somosaguas","ICAI","ICADE","CIHS","Madrid"};
        cbOrigen = new JComboBox<>(origen);
        cbOrigen.setBounds(500,130,250,30);
//        cbOrigen.setFont(new Font("Bauhaus 93", 0, 20));
        this.add(cbOrigen);

        String destinos[]={"Pozuelo","Majadahonda","Boadilla","Somosaguas","ICAI","ICADE","CIHS","Madrid"};
        cbDestino = new JComboBox<>(destinos);
        cbDestino.setBounds(500,200,250,30);
//        cbDestino.setFont(new Font("Bauhaus 93", 0, 20));
        this.add(cbDestino);

        String plazas[]={"1","2","3","4","5","6","7"};
        cbPlazas = new JComboBox<String>(plazas);
        cbPlazas.setBounds(500,260,250,30);
//        cbPlazas.setFont(new Font("Bauhaus 93", 0, 20));
        this.add(cbPlazas);

        String horas[]={"08","09","10","11","12","13","14","15","16","17","18","19","20","21"};
        cbHora = new JComboBox<String>(horas);
        cbHora.setToolTipText("Hora");
        cbHora.setBounds(500,380,100,30);
        this.add(cbHora);

        String minutos[]={"00","05","10","15","20","25","30","35","40","45","50","55"};
        cbMinuto = new JComboBox<String>(minutos);
        cbMinuto.setBounds(650,380,100,30);
        cbMinuto.setToolTipText("Minutos");
        this.add(cbMinuto);
    }

    public void initJLabels(){
        matricula = new JLabel( "Matr\u00EDcula:" );
        matricula.setBounds(345, 50, 120, 50);
        matricula.setHorizontalAlignment(SwingConstants.RIGHT);
        matricula.setForeground(Color.black);
        matricula.setOpaque(false); //false para quitar el fondo
        matricula.setFont(new Font( Font.DIALOG, Font.BOLD, 20));
        this.add(matricula);

        labelOrigen = new JLabel("Origen:");
        labelOrigen.setBounds(345,120,120,50);
        labelOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
        labelOrigen.setForeground(Color.black);
        labelOrigen.setOpaque(false); //false para quitar el fondo
        labelOrigen.setFont(new Font( Font.DIALOG, Font.BOLD, 20));
        this.add(labelOrigen);

        labelDestino = new JLabel("Destino:");
        labelDestino.setBounds(345,190,120,50);
        labelDestino.setHorizontalAlignment(SwingConstants.RIGHT);
        labelDestino.setForeground(Color.black);
        labelDestino.setOpaque(false); //false para quitar el fondo
        labelDestino.setFont(new Font( Font.DIALOG, Font.BOLD, 20));
        this.add(labelDestino);

        labelPlazas = new JLabel("Numero de plazas:");
        labelPlazas.setBounds(215,250,250,50);
        labelPlazas.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPlazas.setForeground(Color.black);
        labelPlazas.setOpaque(false); //false para quitar el fondo
        labelPlazas.setFont(new Font( Font.DIALOG, Font.BOLD, 20));
        this.add(labelPlazas);

        lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(345,310,120,50);
        lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
        lblFecha.setForeground(Color.black);
        lblFecha.setOpaque(false); //false para quitar el fondo
        lblFecha.setFont(new Font( Font.DIALOG, Font.BOLD, 20));
        this.add(lblFecha);

        lblHora = new JLabel("Hora:");
        lblHora.setBounds(345,370,120,50);
        lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
        lblHora.setForeground(Color.black);
        lblHora.setOpaque(false); //false para quitar el fondo
        lblHora.setFont(new Font( Font.DIALOG, Font.BOLD, 20));
        this.add(lblHora);
    }

    public void initActionBotones() {
        btnInsertar.addActionListener(e -> {
            Calendar f = (Calendar) datePickerFecha.getModel().getValue();
            SimpleDateFormat sdfFecha= new SimpleDateFormat("yyyy-MM-dd");
            String fechaStr = sdfFecha.format(new Date(f.getTimeInMillis()));
            //System.out.println(fechaStr);
            String origen = cbOrigen.getItemAt(cbOrigen.getSelectedIndex());
            String plazas=  cbPlazas.getItemAt(cbPlazas.getSelectedIndex());
            String destino = cbDestino.getItemAt(cbDestino.getSelectedIndex());
            String matricula = txtmatricula.getText();
            String hora = cbHora.getItemAt(cbHora.getSelectedIndex());
            String horaPuntos = hora.concat(":");
            String minutos = cbMinuto.getItemAt(cbMinuto.getSelectedIndex());
            String horaFinal = horaPuntos.concat(minutos);

            System.out.println(horaFinal);

            Customer entrada = new Customer (matricula,origen, destino,plazas,fechaStr, horaFinal, name,"0");
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
                ventanaChoose = new JVentanaChoose(name);
                ventanaChoose.setVisible(true);
                JVentanaInsertarCoche.this.setVisible(false);
            }
        });

    }

}
