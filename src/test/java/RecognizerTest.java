import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RecognizerTest {
    @Test
    public void RecognizedTwoChar() {
        ArrayList<String> sequences = new ArrayList<>();
        //recognized by automate and regular expression
        sequences.add("d$");
        sequences.add("b$");
        for (String sequence : sequences) {
            Recognizer recognizer = new Recognizer();
            int got_state = recognizer.nextState(sequence);
            Assert.assertEquals("SMTH WENT WRONG: " + sequence + " got state: " + got_state, 1, got_state);
        }
    }

    @Test
    public void RecognizedThreeChar() {
        ArrayList<String> sequences = new ArrayList<>();
        //recognized by automate and regular expression
        sequences.add("ad$");
        sequences.add("ba$");
        sequences.add("cb$");
        for (String sequence : sequences) {
            Recognizer recognizer = new Recognizer();
            int got_state = recognizer.nextState(sequence);
            Assert.assertEquals("SMTH WENT WRONG: " + sequence + " got state: " + got_state, 1, got_state);
        }
    }

    @Test
    public void RecognizedFourChar() {
        ArrayList<String> sequences = new ArrayList<>();
        //recognized by automate and regular expression
        sequences.add("aad$");
        sequences.add("baa$");
        sequences.add("cba$");
        sequences.add("ccb$");
        for (String sequence : sequences) {
            Recognizer recognizer = new Recognizer();
            int got_state = recognizer.nextState(sequence);
            Assert.assertEquals("SMTH WENT WRONG: " + sequence + " got state: " + got_state, 1, got_state);
        }
    }

    @Test
    public void RecognizedFiveChar() {
        ArrayList<String> sequences = new ArrayList<>();
        //recognized by automate and regular expression
        sequences.add("cbaa$");
        sequences.add("ccba$");
        sequences.add("cccb$");
        for (String sequence : sequences) {
            Recognizer recognizer = new Recognizer();
            int got_state = recognizer.nextState(sequence);
            Assert.assertEquals("SMTH WENT WRONG: " + sequence + " got state: " + got_state, 1, got_state);
        }
    }

    @Test
    public void RecognizedByOnlyAutomate() {
        ArrayList<String> sequences = new ArrayList<>();
        //recognized by automate and NOT regular expression
        sequences.add("aabaccbcb");
        sequences.add("aadd$");
        for (String sequence : sequences) {
            Recognizer recognizer = new Recognizer();
            int got_state = recognizer.nextState(sequence);
            Assert.assertEquals("SMTH WENT WRONG: " + sequence + " got state: " + got_state, 0, got_state);
        }
    }

    @Test
    public void NotRecognizedByBoth() {
        ArrayList<String> sequences = new ArrayList<>();
        //NOT recognized by automate and regular expression
        sequences.add("bbb");
        sequences.add("cca");
        for (String sequence : sequences) {
            Recognizer recognizer = new Recognizer();
            int got_state = recognizer.nextState(sequence);
            Assert.assertEquals("SMTH WENT WRONG: " + sequence + " got state: " + got_state, 0, got_state);
        }
    }

    @Test
    public void RecognizerTestRecognizedNotAlphChar() {
        ArrayList<String> sequences = new ArrayList<>();
        //NOT recognized symbols
        sequences.add("aaccb1");
        sequences.add("223");
        sequences.add("aa2ccb");
        sequences.add("waaccb");
        for (String sequence : sequences) {
            Recognizer recognizer = new Recognizer();
            int got_state = recognizer.nextState(sequence);
            Assert.assertEquals("SMTH WENT WRONG: " + sequence + " got state: " + got_state, -1, got_state);
        }
    }
}
