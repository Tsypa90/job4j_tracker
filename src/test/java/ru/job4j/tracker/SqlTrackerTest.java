package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenEditItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.replace(item.getId(), new Item("test"));
        assertThat(tracker.findById(item.getId()).getName(), is("test"));
    }

    @Test
    public void whenDeleteItemAndFindByGeneratedIdThenMustBeNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("test");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenShowAllItemsThenMustBeEmpty() {
        SqlTracker tracker = new SqlTracker(connection);
        assertThat(tracker.findAll(), is(empty()));
    }

    @Test
    public void whenShowAllItemsThenMustBeOneItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item test = new Item("test");
        tracker.add(test);
        assertThat(tracker.findAll(), is(List.of(test)));
    }

    @Test
    public void whenDeleteInvalidItemThenMustBeFalse() {
        SqlTracker tracker = new SqlTracker(connection);
        assertFalse(tracker.delete(0));
    }

    @Test
    public void whenFindItemByNameTheMustBeItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("test");
        tracker.add(item);
        assertThat(tracker.findByName(item.getName()), is(List.of(item)));
    }
}