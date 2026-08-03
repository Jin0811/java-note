package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectDemo {
    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>();
        scores.add(60);
        scores.add(85);
        scores.add(90);
        scores.add(45);

        List<Integer> passedScores = scores.stream()
                .filter(score -> score >= 60)
                .collect(Collectors.toList());

        System.out.println("passedScores = " + passedScores);
    }
}

