package icai.dtc.isw.domain;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest2 {
    private static Customer trayecto;
    @BeforeClass
    public static void testInitialization() {

        trayecto = new Customer("1A", "Pozuelo", "ICAI", "4", null, null,null);

    }
    @Test
    public void getMatricula() {
        assertEquals("1A", trayecto.getMatricula());
    }
}