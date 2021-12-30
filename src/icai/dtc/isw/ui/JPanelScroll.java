package icai.dtc.isw.ui;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.IteratorCustomer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPanelScroll extends JPanel {
    private String name;
    private ArrayList<Customer> salidas;
    private String texto="";
    private JTextArea areaTexto;
    private JScrollPane pScroll;

    public JPanelScroll(ArrayList<Customer> salidas, String name) {
        this.salidas = salidas;
        this.name = name;

        this.setLayout(null);
//        this.setSize(955, 380);
//        this.setBounds(35,60,955,380);
        this.setVisible(true);
        this.setBackground(new Color(207, 185, 151,255));
//        this.setBackground(Color.red);

        initIterator();
        initArea();
    }

    public void initIterator() {
        IteratorCustomer it = new IteratorCustomer(salidas, name);
        while (it.hasNext()) {
//            System.out.println(it.getText());
            texto = texto.concat(it.getText());
            texto = texto.concat("\n\n");
        }
        System.out.println(texto);
    }

    public void initArea() {
        areaTexto = new JTextArea(texto);
        areaTexto.setEditable(false);

        pScroll = new JScrollPane(areaTexto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pScroll.setBounds(0,0,920,340);

        this.add(pScroll);
    }
}
