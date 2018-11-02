package no.kristiania.prg200.database;

import no.kristiania.prg200.database.core.Days;
import no.kristiania.prg200.database.core.DaysDao;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;



public class DaysDaoTest {

    private DaysDao daysDao = new DaysDao ( TestDataSource.createDataSource() );

    @Test
    public void shouldCreateDays() throws SQLException{
        Days days = sampleDays();
        daysDao.save ( days );
        assertThat(days).hasNoNullFieldsOrProperties();
        assertThat (daysDao.retrieve (days.getId()))
            .isEqualToComparingFieldByField(days);
    }

    @Test
    public void shouldRetrieveDaysById() throws IOException, SQLException {
        Days days = sampleDays ();
        daysDao.save (days);

        assertThat(days.getId()).isNotNull();
        assertThat(daysDao.retrieve(days.getId()))
            .isEqualToComparingFieldByField(days);
    }

    @Test
    public void shouldFindSavedDays() throws SQLException, IOException{
        Days days = sampleDays ();
        daysDao.save(days);

        assertThat(daysDao.listAll().contains(days));
    }

    private Days sampleDays() {
        Days days = new Days(randomLong (), randomDays (), randomDates ());
        days.setDays ( randomDays() );
        days.setDate ( randomDates () );
        return days;
    }

    private Long randomLong(){
        return pickOneLong(new Long[] {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L});
    }

    private String randomDates() {
        return pickOne ( new String[] {"01.10", "07.10", "22.10", "01.11", "03.11"});
    }

    private String randomDays() {
        return pickOne(new String[] {"Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag"});
    }

    private String pickOne(String[] strings) {
        return strings[random.nextInt(strings.length)];
    }

    private Long pickOneLong(Long[] longs) {
        return longs[random.nextInt(longs.length)];
    }

    private static Random random = new Random ();

}
