package de.paulfillafer.kibeispiel;

import de.paulfillafer.kibeispiel.controller.HelloController;
import de.paulfillafer.kibeispiel.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerTest {

    @Test
    public void testHello() {
        HelloService service = new HelloService();
        HelloController controller = new HelloController(service);

        ResponseEntity<String> response = controller.hello();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Hello from PaulFillafer!", response.getBody());
    }
}