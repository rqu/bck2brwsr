package ${package};

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/** Demonstrating POJO testing of HTML page model.
 *
 * @author Jaroslav Tulach <jtulach@netbeans.org>
 */
public class AppTest {
    private Index model;
    

    @BeforeMethod
    public void initModel() {
        model = new Index().applyBindings();
    }

    @Test public void testHelloMessage() {
        model.setName("Joe");
        assertEquals(model.getHelloMessage(), "Hello Joe!", "Cleared after pressing +");
    }
}
