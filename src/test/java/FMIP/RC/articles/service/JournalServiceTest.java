package FMIP.RC.articles.service;

import FMIP.RC.articles.model.Journal;
import FMIP.RC.articles.repository.JournalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JournalServiceTest {

    @Mock
    private JournalRepository journalRepository;

    @InjectMocks
    private JournalService journalService;

    private Journal journal1;
    private Journal journal2;

    @BeforeEach
    void setUp() {
        journal1 = new Journal(1L, "Journal 1", "Topic 1", "Index 1");
        journal2 = new Journal(2L, "Journal 2", "Topic 2", "Index 2");
    }

    @Test
    void findAll() {
        List<Journal> journals = Arrays.asList(journal1, journal2);
        when(journalRepository.findAll()).thenReturn(journals);

        List<Journal> result = journalService.findAll();

        assertThat(result).hasSize(2).contains(journal1, journal2);
        verify(journalRepository, times(1)).findAll();
    }

    @Test
    void save() {
        when(journalRepository.save(any(Journal.class))).thenReturn(journal1);

        Journal result = journalService.save(journal1);

        assertThat(result).isEqualTo(journal1);
        verify(journalRepository, times(1)).save(journal1);
    }

    @Test
    void deleteById() {
        doNothing().when(journalRepository).deleteById(1L);

        journalService.deleteById(1L);

        verify(journalRepository, times(1)).deleteById(1L);
    }
}
