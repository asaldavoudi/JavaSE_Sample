package mft.model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import mft.model.entity.enums.City;
import mft.model.entity.enums.Gender;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder(toBuilder = true)

public class Person {
    private int id;
    private String name;
    private String family;
    private Gender gender;
    private LocalDate birthDate;
    private City city;
    private boolean algorithmSkill;
    private boolean JavaSESkill;
    private boolean JavaEESkill;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
