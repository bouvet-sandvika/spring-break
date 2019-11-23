package no.sandvika.springbreak.disney.franchiseRepository;

import no.sandvika.springbreak.disney.domain.DisneyCharacter;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;
import static no.sandvika.springbreak.disney.domain.Franchise.STAR_WARS;
import static no.sandvika.springbreak.disney.domain.Gender.FEMALE;
import static no.sandvika.springbreak.disney.domain.Gender.MALE;
import static no.sandvika.springbreak.disney.domain.Strength.*;


public class StarWarsRepository {
    public List<DisneyCharacter> getStarWarsCharacaters() {
        return of(
                new DisneyCharacter(
                        "Yoda",
                        false,
                        MALE,
                        STAR_WARS,
                        Stream.of(
                                GREEN,
                                JEDI_KNIGHT,
                                COOL_LIGHT_SABER,
                                LIGHT_SABER_FENCING,
                                WiSE,
                                COOL_EARS,
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
                ),
                new DisneyCharacter(
                        "Darth Vader",
                        false,
                        MALE,
                        STAR_WARS,
                        Stream.of(
                                JEDI_KNIGHT,
                                COOL_LIGHT_SABER,
                                LIGHT_SABER_FENCING,
                                WiSE,
                                COOL_SUIT,
                                TELEPATICH
                        ).collect(toList())
                )
        ).collect(toList());
    }
}
