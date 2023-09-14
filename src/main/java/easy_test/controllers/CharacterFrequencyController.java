package easy_test.controllers;

import easy_test.service.CharacterFrequencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class CharacterFrequencyController {

    private final CharacterFrequencyService characterFrequencyService;

    @GetMapping("/calculate-frequency")
    public ResponseEntity<?> getFrequency(@RequestParam String input) {
        try {
            return ResponseEntity.ok(characterFrequencyService.calculateFrequency(input));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        }
    }
}

