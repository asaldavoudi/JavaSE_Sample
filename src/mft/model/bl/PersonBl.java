package mft.model.bl;

import lombok.Getter;
import mft.controller.exceptions.FailedRequiermentException;
import mft.controller.exceptions.NoPersonFoundException;
import mft.model.da.PersonDa;
import mft.model.entity.Person;

import java.util.List;

public class PersonBl {
    @Getter
    private static PersonBl personBl = new PersonBl();

    private PersonBl() {
    }

    public Person save(Person person) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            personDa.save(person);
            return person;
        }
    }

    public Person edit(Person person) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            if (personDa.findById(person.getId()) != null) {
                personDa.edit(person);
                return person;
            } else {
                throw new NoPersonFoundException();
            }
        }
    }

    public Person remove(int id) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            Person person = personDa.findById(id);
            if (person != null) {
                personDa.remove(id);
                return person;
            } else {
                throw new NoPersonFoundException();
            }
        }
    }

    public List<Person> findAll() throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            List<Person> perosnList = personDa.findAll();
            if (!perosnList.isEmpty()) {
                return perosnList;
            } else {
                throw new NoPersonFoundException();
            }
        }
    }

    public Person findById(int id) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            Person person = personDa.findById(id);
            if (person != null) {
                return person;
            } else {
                throw new NoPersonFoundException();
            }
        }
    }

    public List<Person> findByFamily(String family) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            List<Person> perosnList = personDa.findByFamily(family);
            if (!perosnList.isEmpty()) {
                return perosnList;
            } else {
                throw new NoPersonFoundException();
            }
        }
    }
}
