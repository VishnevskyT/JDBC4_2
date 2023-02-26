package exercise_7;

import exercise_7.entity.Animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AnimalHelper {

    EntityManagerFactory managerFactory;

    EntityManager manager;

    public AnimalHelper() {
        managerFactory = Persistence.createEntityManagerFactory("animals");
        manager = managerFactory.createEntityManager();
    }

    public Animal getById (int id) {
        manager.getTransaction().begin();
        Animal animal = manager.find(Animal.class, id);
        manager.getTransaction().commit();
        managerFactory.close();
        return animal;
    }

    public void addAnimal (Animal animal) {
        manager.getTransaction().begin();
        manager.merge(animal);
        manager.getTransaction().commit();
        managerFactory.close();
    }

    public void removeAnimal (Animal animal) {
        manager.getTransaction().begin();
        manager.remove(animal);
        manager.getTransaction().commit();
        managerFactory.close();
    }

    public List<Animal> getAllAnimals() {
        manager.getTransaction().begin();
        Query query = manager.createQuery("SELECT animals FROM Animal animals");
        List<Animal> animals = query.getResultList();
        manager.getTransaction().commit();
        managerFactory.close();
        return animals;
    }

}
