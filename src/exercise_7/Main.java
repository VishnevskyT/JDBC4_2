package exercise_7;

import exercise_7.entity.Animal;

import java.util.List;

/**
 * Задание 7
 * Создать новую базу данных с помощью MySQLWorkbench.
 * Создать обычный java-проект и подключить к нему библиотеки JPA и Hibernate.
 * Создать файл с настройками persistence.xml в папке META-INF.
 * И создать класс Animal(int age, String name, boolean tail) с методами get и set, как сущность к нашей таблице.
 * И с помощью jpa сделать crud в классе AnimalHelper.
 */
public class Main {
    public static void main(String[] args) {
        AnimalHelper animalHelper = new AnimalHelper();

//        Animal animal  = new Animal();
//        animal.setName("Mailo");
//        animal.setAge(9);
//        animal.setTail(true);
//
//        animalHelper.addAnimal(animal);

        List<Animal> animals = animalHelper.getAllAnimals();

        for (Animal a : animals) {
            System.out.println(a.getId() + " " + a.getName() + " "
                    + a.getAge() + " " + a.isTail());
        }

    }
}