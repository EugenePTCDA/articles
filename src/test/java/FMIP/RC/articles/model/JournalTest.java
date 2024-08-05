package FMIP.RC.articles.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class JournalTest {

    @Test
    void testJournalCreation() {
        Journal journal = new Journal(1L,
                "Journal Name",
                "Research Topic",
                "Citation Index");

        assertThat(journal.getId()).isEqualTo(1L);
        assertThat(journal.getJournalName()).isEqualTo("Journal Name");
        assertThat(journal.getResearchTopic()).isEqualTo("Research Topic");
        assertThat(journal.getCitationIndex()).isEqualTo("Citation Index");
    }

    @Test
    void testJournalSetters() {
        Journal journal = new Journal();

        journal.setId(2L);
        journal.setJournalName("New Journal Name");
        journal.setResearchTopic("New Research Topic");
        journal.setCitationIndex("New Citation Index");

        assertThat(journal.getId()).isEqualTo(2L);
        assertThat(journal.getJournalName()).isEqualTo("New Journal Name");
        assertThat(journal.getResearchTopic()).isEqualTo("New Research Topic");
        assertThat(journal.getCitationIndex()).isEqualTo("New Citation Index");
    }

    @Test
    void testJournalToString() {
        Journal journal = new Journal(3L,
                "Journal Name",
                "Research Topic",
                "Citation Index");
        String expectedToString = "Journal(id=3, " +
                "journalName=Journal Name, " +
                "researchTopic=Research Topic, " +
                "citationIndex=Citation Index)";

        assertThat(journal.toString()).isEqualTo(expectedToString);
    }

    @Test
    void testJournalEqualsAndHashCode() {
        Journal journal1 = new Journal(4L,
                "Journal Name",
                "Research Topic",
                "Citation Index");
        Journal journal2 = new Journal(4L,
                "Journal Name",
                "Research Topic",
                "Citation Index");
        Journal journal3 = new Journal(5L,
                "Different Journal Name",
                "Different Research Topic",
                "Different Citation Index");

        assertThat(journal1).isEqualTo(journal2);
        assertThat(journal1).isNotEqualTo(journal3);
        assertThat(journal1.hashCode()).isEqualTo(journal2.hashCode());
        assertThat(journal1.hashCode()).isNotEqualTo(journal3.hashCode());
    }
}