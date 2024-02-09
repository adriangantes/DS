package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonalTest {

    @Test
    public void testConstructorPersonal() {
        Personal personal = new Personal("Juanito", true);
        assertEquals("Juanito", personal.getNombre());
        assertTrue(personal.getSupervisor());

        Personal persona1 = new Personal(null, true);
        Personal persona2 = new Personal("", true);
    }

    @Test
    public void testSetSupervisor() {
        Personal personal = new Personal("Juanito", false);

        assertFalse(personal.getSupervisor());

        personal.setSupervisor(true);
        assertTrue(personal.getSupervisor());

        personal.setSupervisor(false);
        assertFalse(personal.getSupervisor());
    }

}
