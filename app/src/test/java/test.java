import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllPersons() throws Exception {
        mockMvc.perform(get("/api/persons"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAddPerson() throws Exception {
        String newPersonJson = "{\"name\": \"Mario Rossi\", \"age\": 30}";

        mockMvc.perform(post("/api/persons")
                        .contentType("application/json")
                        .content(newPersonJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mario Rossi"))
                .andExpect(jsonPath("$.age").value(30));
    }
}