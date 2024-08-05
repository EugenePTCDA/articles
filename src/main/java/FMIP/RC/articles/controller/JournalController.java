package FMIP.RC.articles.controller;


import FMIP.RC.articles.model.Journal;
import FMIP.RC.articles.service.JournalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journals")
public class JournalController {

    private final JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping
    public List<Journal> getAllJournals() {
        return journalService.findAll();
    }

    @PostMapping
    public Journal addJournal(@RequestBody Journal journal) {
        return journalService.save(journal);
    }

    @DeleteMapping("/{id}")
    public void deleteJournal(@PathVariable Long id) {
        journalService.deleteById(id);
    }
}
