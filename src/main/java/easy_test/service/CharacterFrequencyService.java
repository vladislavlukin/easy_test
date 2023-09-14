package easy_test.service;

import easy_test.dto.CharacterFrequency;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class CharacterFrequencyService {
    public List<CharacterFrequency> calculateFrequency(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Входная строка не должна быть пустой.");
        }
        if (!input.matches("^[\\p{L}]+$")) {
            throw new IllegalArgumentException("Входная строка должна содержать только буквы.");
        }


        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return frequencyMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .map(entry -> new CharacterFrequency(entry.getKey(), entry.getValue().intValue()))
                .collect(Collectors.toList());
    }
}
