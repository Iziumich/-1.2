import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        //1)
        List<Person> minors = persons.stream()
                .filter(person -> person.getAge() < 18)
                .collect(Collectors.toList());
        for (Person minor : minors) {
            //      System.out.println(minor);
        }

        //2)
        List<Person> conscripts = persons.stream()
                .filter(person -> person.getSex() == Sex.MAN & person.getAge() > 17 & person.getAge() < 27)
                .collect(Collectors.toList());
        for (Person conscript : conscripts) {
            //      System.out.println(conscript);
        }


        //3
        List<Person> potentials = persons.stream()
                .sorted(Comparator.comparing(Person::getFamily))
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> person.getSex() == Sex.MAN & person.getAge() > 17 & person.getAge() < 65 || person.getSex() == Sex.WOMAN & person.getAge() > 17 & person.getAge() < 60)
                .collect(Collectors.toList());
        for (Person potential : potentials) {
            //      System.out.println(potential);
        }
    }
}