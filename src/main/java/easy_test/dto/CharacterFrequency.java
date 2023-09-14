package easy_test.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CharacterFrequency {
    private final char character;
    private final int frequency;
}

