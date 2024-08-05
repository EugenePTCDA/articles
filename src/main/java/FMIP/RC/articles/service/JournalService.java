package FMIP.RC.articles.service;


import FMIP.RC.articles.model.Journal;
import FMIP.RC.articles.repository.JournalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {

    private final JournalRepository journalRepository;

    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public List<Journal> findAll() {
        return journalRepository.findAll();
    }

    public Journal save(Journal journal) {
        return journalRepository.save(journal);
    }

    public void deleteById(Long id) {
        journalRepository.deleteById(id);
    }
}