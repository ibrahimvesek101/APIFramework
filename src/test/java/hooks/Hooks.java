package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup(){

        // Raporlama ile ilgili birtakim konf gerekiyorsa bu konf yapilir.
        // Eger her scenario da kullanilacak bir obje var ise yine burada olusturulur.

    }

    @After
    public void teardown(){

    }

}