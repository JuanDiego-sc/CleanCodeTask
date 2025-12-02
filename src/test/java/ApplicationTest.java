import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    @DisplayName("Should execute main without exceptions")
    void shouldExecuteMainWithoutExceptions() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        assertDoesNotThrow(() -> Application.main(new String[]{}));

        String output = outputStream.toString();
        assertTrue(output.contains("Added customer: John Doe"));
        assertTrue(output.contains("Added customer: Jane Smith"));
        assertTrue(output.contains("Order added: Order1"));
        assertTrue(output.contains("Order added: Order2"));
        assertTrue(output.contains("Processing orders for customer: John Doe"));
        assertTrue(output.contains("Customer Report"));
        assertTrue(output.contains("Order Report"));

        System.setOut(originalOut);
    }
}
