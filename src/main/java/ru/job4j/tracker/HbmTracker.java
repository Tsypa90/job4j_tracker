package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        int result = session.createQuery("update Item s set s.name = :fName, s.created = :fCreated where s.id = :fId")
                .setParameter("fName", item.getName())
                .setParameter("fCreated", item.getCreated())
                .setParameter("fId", id).executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result == 1;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        int result = session.createQuery("delete Item s where s.id = :fId")
                .setParameter("fId", id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result == 1;
    }

    @Override
    public void deleteAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        session.createQuery("delete Item ").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        var rsl = session.createQuery("from Item ").list();
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    @Override
    public void findAllByReact(Observe<Item> observe) {
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        var rsl = session.createQuery("from Item s where s.name = :fName")
                .setParameter("fName", key).list();
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item rsl = (Item) session.createQuery("from Item s where s.id = :fId")
                .setParameter("fId", id).uniqueResult();
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
