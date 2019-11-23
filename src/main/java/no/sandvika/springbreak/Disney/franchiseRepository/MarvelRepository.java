package no.sandvika.springbreak.disney.franchiseRepository;


import no.sandvika.springbreak.disney.domain.DisneyCharacter;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;
import static no.sandvika.springbreak.disney.domain.Franchise.MARVEL;
import static no.sandvika.springbreak.disney.domain.Gender.FEMALE;
import static no.sandvika.springbreak.disney.domain.Gender.MALE;
import static no.sandvika.springbreak.disney.domain.Strength.*;


public class MarvelRepository {
    public List<DisneyCharacter> getMarvelCharacaters() {
        return of(
                new DisneyCharacter(
                      "Hulk",
                      true,
                        MALE,
                        MARVEL,
                        of(
                                GREEN,
                                SUPER_STRENGTH
                        ).collect(toList())
                ),
                new DisneyCharacter(
                        "Thor",
                        false,
                        MALE,
                        MARVEL,
                        of(
                                SUPER_STRENGTH,
                                CAN_FLY,
                                COOL_HAMMER,
                                CONTROL_WEATHER
                        ).collect(toList())

                ),
                new DisneyCharacter(
                        "Iron Man",
                        true,
                        MALE,
                        MARVEL,
                        of(
                                WiSE,
                                CAN_FLY,
                                COOL_SUIT
                        ).collect(toList())
                ),
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
                )
        ).collect(toList());
    }
}
