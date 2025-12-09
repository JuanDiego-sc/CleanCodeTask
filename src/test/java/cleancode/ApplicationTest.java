package cleancode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

  @Test
  @DisplayName("Should execute main without exceptions")
  void shouldExecuteMainWithoutExceptions() {
    assertDoesNotThrow(() -> Application.main(new String[] {}));
  }
}