import java.util.Random;

public class Generator {
    String generate(int length) {
        Random random = new Random();
        int left_length = length - 2;
        String generatedLine = "St";
        while (generatedLine.matches(".*[A-Z].*")) {
            generatedLine = generatedLine.replaceAll("St", "S\\$");
            if (generatedLine.contains("S")) {
                if (left_length > 2) {
                    generatedLine = generatedLine.replaceAll("S", "BA");
                    left_length -= 1;
                } else {
                    if (random.nextInt(2) == 1) {
                        generatedLine = generatedLine.replaceAll("S", "BA");
                        left_length -= 1;
                    } else {
                        generatedLine = generatedLine.replaceAll("S", "AAd");
                        left_length -= 2;
                    }
                }
            }
            if (generatedLine.contains("A")) {
                if (left_length < 0) {
                    generatedLine = generatedLine.replaceFirst("A", "");
                    left_length += 1;
                } else {
                    if (generatedLine.contains("B")) {
                        if (random.nextInt(2) == 1) {
                            generatedLine = generatedLine.replaceFirst("A", "");
                            left_length += 1;
                        } else {
                            generatedLine = generatedLine.replaceFirst("A", "a");
                        }
                    } else {
                        generatedLine = generatedLine.replaceFirst("A", "a");
                    }
                }
            }
            if (generatedLine.contains("B")) {
                if (left_length < 1) {
                    generatedLine = generatedLine.replaceAll("B", "bA");
                    left_length -= 1;
                } else {
                    if (left_length == 1) {
                        if (random.nextInt(2) == 1) {
                            generatedLine = generatedLine.replaceAll("B", "bA");
                            left_length -= 1;
                        } else {
                            generatedLine = generatedLine.replaceAll("B", "cB");
                            left_length -= 1;
                        }
                    } else {
                        generatedLine = generatedLine.replaceAll("B", "cB");
                        left_length -= 1;
                    }
                }
            }
        }
        return generatedLine;
    }
}