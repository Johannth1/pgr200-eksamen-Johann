package no.kristiania.prg200.database;


import no.kristiania.prg200.database.core.*;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class TracksDaoTest {
//
//
//    private TracksDao tracksDao = new TracksDao (TestDataSource.createDataSource() );
//
//    @Test
//    public void shouldCreateTracks() throws SQLException{
//        Tracks tracks = sampleTracks();
//        tracksDao.save(tracks);
////        assertThat(tracks).hasNoNullFieldsOrProperties();
////        assertThat (tracksDao.retrieve (tracks.getId()))
////                .isEqualToComparingFieldByField(tracks);
//    }
//
//    @Test
//    public void shouldRetrieveTracksById() throws IOException, SQLException {
//        Tracks tracks = sampleTracks();
//        tracksDao.save(tracks);
//
//        assertThat(tracks.getId()).isNotNull();
////        assertThat(tracksDao.retrieve(tracks.getId()))
////                .isEqualToComparingFieldByField(tracks);
//    }
//
//    @Test
//    public void shouldFindSavedTracks() throws SQLException, IOException{
//        Tracks tracks = sampleTracks();
//        tracksDao.save(tracks);
//
//        assertThat(tracksDao.listAll().contains(tracks));
//    }
//
//    private Tracks sampleTracks() {
//        Tracks tracks = new Tracks ();
//
//        tracks.setTracks(randomTracks());
//        tracks.setTalks_id(randomIDs());
//        tracks.setDays_id(randomIDs ());
//        tracks.setTimeslots_id(randomIDs());
//        tracks.setRooms_id(randomIDs());
//
//        return tracks;
//    }
//
//    private String randomTracks() {
//        return pickOne ( new String[] {"1", "2", "3", "", "4"});
//    }
//
//    private Long randomIDs() {
//        return pickOneLong ( new Long[] {1L, 2L, 3L, 4L, 5L});
//    }
//
//
//
//    private String pickOne(String[] strings) {
//        return strings[random.nextInt(strings.length)];
//    }
//
//    private Long pickOneLong(Long[] longs) {
//        return longs[random.nextInt(longs.length)];
//    }
//
//    private static Random random = new Random ();

}