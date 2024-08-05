package FMIP.RC.articles.repository;


import FMIP.RC.articles.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}
