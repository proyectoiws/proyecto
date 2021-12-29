package icai.dtc.isw.domain;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntradaTest extends TestCase {
    private static Entrada trayecto;
    @BeforeClass
    public static void testInitialization(){

        trayecto = new Entrada("Pozuelo","ICAI",null, null);

    }

    @Test

    public void getDestino(){

    }
}