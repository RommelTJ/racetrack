package racetrack
import grails.test.mixin.*
import org.junit.*

@TestFor(Race)
class RaceTests {
    void testInMiles() {
        def race = new Race(distance:5.0)
        assertEquals 3.107, race.inMiles(), 1e-15
    }
}
