package no.kristiania.prg200.database;

import no.kristiania.prg200.database.core.*;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class TimeslotsDaoTest {

    private TimeslotsDao timeslotsDao = new TimeslotsDao (TestDataSource.createDataSource() );

    @Test
    public void shouldCreateTimeslots() throws SQLException{
        Timeslots timeslots = sampleTimeslots();
        timeslotsDao.save(timeslots);
        assertThat(timeslots).hasNoNullFieldsOrProperties();
        assertThat (timeslotsDao.retrieve (timeslots.getId()))
                .isEqualToComparingFieldByField(timeslots);
    }

    @Test
    public void shouldRetrieveTimeslotsById() throws IOException, SQLException {
        Timeslots timeslots = sampleTimeslots();
        timeslotsDao.save(timeslots);

        assertThat(timeslots.getId()).isNotNull();
        assertThat(timeslotsDao.retrieve(timeslots.getId()))
                .isEqualToComparingFieldByField(timeslots);
    }

    @Test
    public void shouldFindSavedTimeslots() throws SQLException, IOException{
        Timeslots timeslots = sampleTimeslots();
        timeslotsDao.save(timeslots);

        assertThat(timeslotsDao.listAll().contains(timeslots));
    }

    private Timeslots sampleTimeslots() {
        Timeslots timeslots = new Timeslots(randomLong (), randomTime ());

        timeslots.setTime(randomTime());
        return timeslots;
    }

    private Long randomLong(){
        return pickOneLong(new Long[] {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L});
    }

    private String randomTime() {
        return pickOne ( new String[] {"08.00-09.00", "11.00-14.15", "10.00-13.00", "", "16.30-18.00"});
    }


    private String pickOne(String[] strings) {
        return strings[random.nextInt(strings.length)];
    }

    private Long pickOneLong(Long[] longs) {
        return longs[random.nextInt(longs.length)];
    }

    private static Random random = new Random ();

}