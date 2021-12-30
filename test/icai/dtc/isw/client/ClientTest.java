package icai.dtc.isw.client;

import icai.dtc.isw.domain.Customer;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ClientTest {
    private static Client cliente;
    private static ArrayList<Customer> salidas;
    @BeforeClass
    public static void testInitialization(){

        cliente= new Client();
        salidas = new ArrayList<>();
        Customer trayecto1 = new Customer("1A","Pozuelo","ICAI","4", null, null,null, null);
        Customer trayecto2 = new Customer("1B","Somosaguas","ICAI","4", null, null,null,null);
        Customer trayecto3 = new Customer("1C","Pozuelo","ICADE","4", null, null,null,null);
        Customer trayecto4 = new Customer("1E","Castellana","ICAI","4", null, null,null,null);
        salidas.add(trayecto1);
        salidas.add(trayecto2);
        salidas.add(trayecto3);
        salidas.add(trayecto4);
        cliente.setSalidas(salidas);


    }


    @Test
    public void getSalidaC() {
        assertEquals(salidas, cliente.getSalidaC());
    }
}