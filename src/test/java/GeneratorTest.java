import org.junit.Assert;
import org.junit.Test;

public class GeneratorTest {
    @Test
    public void GenTest() {
        int start=5;
        int finish=6;
        int iterations=100;
        for(int j=0;j<iterations;j++) {
            for (int i = start; i < finish; i++) {
                Generator generator = new Generator();
                String sequence = generator.generate(i);
                Assert.assertEquals("Created sequence has wrong length, got sequence: " + sequence, sequence.length(), i);
                System.out.println(sequence);
            }
        }
    }
    @Test
    public void UncontrolledGenTest() {
        int iterations=100;
        for(int j=0;j<iterations;j++) {
            for (int i = 2; i < 100; i++) {
                Generator generator = new Generator();
                String sequence = generator.generate(i);
                Assert.assertEquals("Created sequence has wrong length, got sequence: " + sequence, sequence.length(), i);
            }
        }
    }
}
