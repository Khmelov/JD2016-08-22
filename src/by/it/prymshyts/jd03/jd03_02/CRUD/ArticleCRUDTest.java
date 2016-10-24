package by.it.prymshyts.jd03.jd03_02.CRUD;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArticleCRUDTest {
    private ArticleCRUD articleCRUD = new ArticleCRUD();
    private Article article = new Article(1, "Test title", 123, "Test info", 1);

    @Test
    public void create() throws Exception {
        assertTrue(articleCRUD.create(article));
    }

    @Test
    public void read() throws Exception {
        assertEquals(articleCRUD.read(1).getFK_User(), 1);
    }

    @Test
    public void update() throws Exception {
        assertTrue(articleCRUD.update(article));
    }

    @Test
    public void delete() throws Exception {
        article.setID(2);
        assertTrue(articleCRUD.delete(article));
    }
}