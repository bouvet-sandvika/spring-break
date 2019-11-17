package no.sandvika.springbreak.Disney.franchiseRepository;

import no.sandvika.springbreak.Disney.domain.DisneyCharacter;
import no.sandvika.springbreak.Disney.domain.Franchise;
import no.sandvika.springbreak.Disney.domain.Gender;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;
import static no.sandvika.springbreak.Disney.domain.Franchise.MARVEL;
import static no.sandvika.springbreak.Disney.domain.Gender.*;
import static no.sandvika.springbreak.Disney.domain.Gender.FEMALE;
import static no.sandvika.springbreak.Disney.domain.Strength.*;

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
