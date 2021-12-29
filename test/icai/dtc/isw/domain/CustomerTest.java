package icai.dtc.isw.domain;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private static Customer trayecto;
    @BeforeClass
    public static void testInitialization(){

        trayecto = new Customer("1A","Pozuelo","ICAI","4", null, null);

    }
    @Test
    public void getOrigen() {
        assertEquals("ICAI", trayecto.getDestino());
    }
}