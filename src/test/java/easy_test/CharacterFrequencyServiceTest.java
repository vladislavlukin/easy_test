package easy_test;

import easy_test.dto.CharacterFrequency;
import easy_test.service.CharacterFrequencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterFrequencyServiceTest {

    private CharacterFrequencyService characterFrequencyService;

    @BeforeEach
    public void setUp() {
        characterFrequencyService = new CharacterFrequencyService();
    }

    @Test
    public void testCalculateFrequency() {
        String input = "aaaaabcccc";

        List<CharacterFrequency> result = characterFrequencyService.calculateFrequency(input);

        assertNotNull(result);
        assertEquals(3, result.size());

        assertEquals('a', result.get(0).getCharacter());
        assertEquals(5, result.get(0).getFrequency());

        assertEquals('c', result.get(1).getCharacter());
        assertEquals(4, result.get(1).getFrequency());

        assertEquals('b', result.get(2).getCharacter());
        assertEquals(1, result.get(2).getFrequency());
    }

    @Test
    public void testCalculateFrequencyWithEmptyInput() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> characterFrequencyService.calculateFrequency(input));
    }

    @Test
    public void testCalculateFrequencyWithNonLetterCharacters() {
        String input = "123abc";
        assertThrows(IllegalArgumentException.class, () -> characterFrequencyService.calculateFrequency(input));
    }
}

