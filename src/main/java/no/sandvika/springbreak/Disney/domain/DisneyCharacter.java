package no.sandvika.springbreak.Disney.domain;

import java.util.List;
import java.util.Objects;

public class DisneyCharacter {
    private final String name;
    private final boolean human;
    private final Gender gender;
    private final Franchise franchise;
    private final List<Strength> strengths;

    public DisneyCharacter(
            final String name,
            final boolean human,
            final Gender gender,
            final Franchise francise,
            final List<Strength> strengths) {
        this.name = name;
        this.human = human;
        this.gender = gender;
        this.franchise = francise;
        this.strengths = strengths;
    }

    public String getName() {
        return name;
    }

    public boolean isHuman() {
        return human;
    }

    public Gender getGender() {
        return gender;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public List<Strength> getStrengths() {
        return strengths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DisneyCharacter that = (DisneyCharacter) o;

        if (human != that.human) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (gender != that.gender) return false;
        if (franchise != that.franchise) return false;
        return strengths != null ? strengths.equals(that.strengths) : that.strengths == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, human, gender, franchise, strengths);
    }
}
