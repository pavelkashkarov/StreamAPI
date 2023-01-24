package task2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        System.out.println("Список людей:");
        System.out.println(persons);
        System.out.println("Количество несовершенннолетних:");
        Stream<Person> stream = persons.stream();
        System.out.println((stream.filter(x -> x.getAge() < 18)
                                    .count()));
        System.out.println("Список призывников:");
        Stream<Person> stream2 = persons.stream();
        List<String> list = stream2.filter(x -> x.getAge() >= 18)
                                    .filter(x -> x.getAge() <= 27)
                                    .filter(x -> x.getSex() == Sex.MAN)
                                    .map(x -> x.getFamily())
                                    .collect(Collectors.toList());
        System.out.println(list);
        System.out.println("Список трудоспособных:");
        Stream<Person> stream3 = persons.stream();
        List<String> workListMan = stream3.filter(x -> x.getAge() >= 18 && ((x.getAge() <= 65 && x.getSex() == Sex.MAN) ||(x.getAge() <= 60 && x.getSex() == Sex.WOMAN)))
                                            .filter(x -> x.getEducation() == Education.HIGHER)
                                            .sorted(Comparator.comparing(Person::getFamily))
                                            .map(x -> x.getFamily())
                                            .collect(Collectors.toList());
        System.out.println(workListMan);
    }
}
