package pl.gatomek.enumset;

import java.util.EnumSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

enum WeekDays {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

/**
 * Links:
 * @see <a href="https://www.baeldung.com/java-enumset">Guide to EnumSet</a>
 * @see <a href="https://www.geeksforgeeks.org/java/enumset-class-java/">EnumSet in Java</a>
 */

class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        EnumSet<WeekDays> set = EnumSet.noneOf(WeekDays.class);
        set.add( WeekDays.MONDAY);

        // calculation length of enum
        LOGGER.info( "Len: {}", WeekDays.values().length);

        // calculation size of set
        LOGGER.info( "Set size: {}", set.size());

        // position of entry in enum
        WeekDays friday = WeekDays.FRIDAY;
        LOGGER.info( "Position of entry {} in enum: {}", friday, friday.ordinal());

        // creating sub-enumset
        EnumSet<WeekDays> range = EnumSet.range(WeekDays.TUESDAY, WeekDays.THURSDAY);
        LOGGER.info( "Range: {}", range);
    }
}