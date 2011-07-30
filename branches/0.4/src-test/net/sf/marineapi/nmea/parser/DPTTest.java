package net.sf.marineapi.nmea.parser;

import static org.junit.Assert.assertEquals;
import net.sf.marineapi.nmea.sentence.DPTSentence;
import net.sf.marineapi.nmea.sentence.TalkerId;

import org.junit.Before;
import org.junit.Test;

public class DPTTest {

    public static final String EXAMPLE = "$IIDPT,012.6,-1.0,*45";
    DPTSentence empty;
    DPTSentence dpt;

    @Before
    public void setUp() throws Exception {
        empty = new DPTParser();
        dpt = new DPTParser(EXAMPLE);
    }

    @Test
    public void testDPTParser() {
        assertEquals(TalkerId.II, empty.getTalkerId());
        assertEquals("DPT", empty.getSentenceId());
        assertEquals(2, empty.getFieldCount());

    }

    @Test
    public void testDPTParserString() {
        assertEquals(TalkerId.II, dpt.getTalkerId());
        assertEquals("DPT", dpt.getSentenceId());
        assertEquals(3, dpt.getFieldCount());
    }

    @Test
    public void testGetDepth() {
        assertEquals(12.6, dpt.getDepth(), 0.01);
    }

    @Test
    public void testGetOffset() {
        assertEquals(-1.0, dpt.getOffset(), 0.01);
    }

    @Test
    public void testSetDepth() {
        final double depth = 1.2333333;
        empty.setDepth(depth);
        assertEquals(depth, empty.getDepth(), 0.1);
    }

    @Test
    public void testSetOffset() {
        final double offset = 1.555555;
        empty.setOffset(offset);
        assertEquals(offset, empty.getOffset(), 0.1);
    }

}
