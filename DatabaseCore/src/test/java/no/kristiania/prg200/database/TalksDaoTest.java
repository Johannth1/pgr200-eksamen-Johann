package no.kristiania.prg200.database;


import no.kristiania.prg200.database.core.Talks;
import no.kristiania.prg200.database.core.TalksDao;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class TalksDaoTest {

    private TalksDao talksDao = new TalksDao (TestDataSource.createDataSource() );

    @Test
    public void shouldCreateTalks() throws SQLException{
        Talks talks = sampleTalks();
        talksDao.save(talks);
        assertThat(talks).hasNoNullFieldsOrProperties();
        assertThat (talksDao.retrieve (talks.getId()))
                .isEqualToComparingFieldByField(talks);
    }

    @Test
    public void shouldRetrieveTalksById() throws IOException, SQLException {
        Talks talks = sampleTalks();
        talksDao.save(talks);

        assertThat(talks.getId()).isNotNull();
        assertThat(talksDao.retrieve(talks.getId()))
                .isEqualToComparingFieldByField(talks);
    }

    @Test
    public void shouldFindSavedTalks() throws SQLException, IOException{
        Talks talks = sampleTalks();
        talksDao.save(talks);

        assertThat(talksDao.listAll().contains(talks));
    }

    private Talks sampleTalks() {
        Talks talks = new Talks();
        talks.setTitle(randomTitle());
        talks.setTopic(randomTopic());
        talks.setDescription(randomDescription());
        return talks;
    }

    private String randomTitle() {
        return pickOne ( new String[] {"Dinosaurer i ", "Datamaskiner i ", "Matematikk for ", "", "Velkommen til "});
    }

    private String randomTopic() {
        return pickOne(new String[] {"nåtiden", "gårsdagen", "fremtiden", "barnehagen", "verden"});
    }

    private String randomDescription() {
        return pickOne(new String[] {"En samtale om data.", "Informasjon om tid og rom.", "Mange steder på en gang."});
    }

    private String pickOne(String[] strings) {
        return strings[random.nextInt(strings.length)];
    }

    private static Random random = new Random ();

}