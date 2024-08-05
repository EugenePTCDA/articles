package FMIP.RC.articles.controller;

import FMIP.RC.articles.model.Journal;
import FMIP.RC.articles.service.JournalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(JournalController.class)
class JournalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JournalService journalService;

    private Journal journal1;
    private Journal journal2;

    @BeforeEach
    void setUp() {
        journal1 = new Journal(1L, "Journal 1", "Topic 1", "Index 1");
        journal2 = new Journal(2L, "Journal 2", "Topic 2", "Index 2");
    }

    @Test
    void getAllJournals() throws Exception {
        List<Journal> journals = Arrays.asList(journal1, journal2);
        when(journalService.findAll()).thenReturn(journals);

        mockMvc.perform(get("/journals"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].journalName", is("Journal 1")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].journalName", is("Journal 2")));

        verify(journalService, times(1)).findAll();
    }

    @Test
    void addJournal() throws Exception {
        when(journalService.save(any(Journal.class))).thenReturn(journal1);

        mockMvc.perform(post("/journals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"journalName\":\"Journal 1\"," +
                                "\"researchTopic\":\"Topic 1\"," +
                                "\"citationIndex\":\"Index 1\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.journalName", is("Journal 1")));

        verify(journalService, times(1)).save(any(Journal.class));
    }

    @Test
    void deleteJournal() throws Exception {
        doNothing().when(journalService).deleteById(1L);

        mockMvc.perform(delete("/journals/1"))
                .andExpect(status().isOk());

        verify(journalService, times(1)).deleteById(1L);
    }
}