package no.sandvika.springbreak.disney.service;


import no.sandvika.springbreak.disney.domain.DisneyCharacter;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;

import static no.sandvika.springbreak.disney.domain.Franchise.MARVEL;
import static no.sandvika.springbreak.disney.domain.Franchise.STAR_WARS;
import static no.sandvika.springbreak.disney.domain.Gender.FEMALE;
import static no.sandvika.springbreak.disney.domain.Strength.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class DisneyCharacterServiceTest {

    DisneyCharacterService disneyCharacterService =  new DisneyCharacterService();

    @Test
    @Ignore
    public void shouldReturnAllFemaleCharacters() {
        List<DisneyCharacter> actual = disneyCharacterService.allFemaleCharacters();

        List<DisneyCharacter> expected = Arrays.asList(
                new DisneyCharacter(
                        "Storm",
                        false,
                        FEMALE,
                        MARVEL,
                        of(
                                CAN_FLY,
                                CONTROL_WEATHER
                        ).collect(toList())
                ),
                new DisneyCharacter(
                        "Phoenix",
                        false,
                        FEMALE,
                        MARVEL,
                        of(
                                CAN_FLY,
                                TELEPATICH
                        ).collect(toList())
                ),
                new DisneyCharacter(
                        "Lana Rey",
                        true,
                        FEMALE,
                        STAR_WARS,
                        Stream.of(
                                JEDI_KNIGHT,
                                COOL_LIGHT_SABER,
                                LIGHT_SABER_FENCING,
                                TELEPATICH
                        ).collect(toList())
                )
        );

        assertThat(
                "All characters are female",
                actual,
                is(
                     expected
                )
        );
    }
}