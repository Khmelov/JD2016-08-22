package by.it.voronovich.JD03_02.test;

import by.it.voronovich.JD03_02.bean.CatalogGood;
import by.it.voronovich.JD03_02.crud.CatalogGoodCRUD;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CatalogGoodCRUDTest {

    @Test
    public void create() throws Exception {
        double random = Math.round(Math.random());
        String line = "" + random;
        CatalogGood cg = new CatalogGood(0, line, line, random, line, line);
        CatalogGoodCRUD cgCRUD = new CatalogGoodCRUD();
        String cg1 = cgCRUD.create(cg).toString();
        String cg2 = cgCRUD.read(cg.getIdCatalog()).toString();
        assertEquals(cg1, cg2);
        cgCRUD.delete(cg);
    }

    @Test
    public void update() throws Exception {
        double random = Math.round(Math.random());
        String line = "" + random;
        CatalogGood cg = new CatalogGood(0, line, line, random, line, line);
        CatalogGoodCRUD cgCRUD = new CatalogGoodCRUD();
        cgCRUD.create(cg);
        double random1 = Math.round(Math.random());
        String line1 = "" + random1;
        cg.setBrand(line1);
        String cg1 = cgCRUD.update(cg).toString();
        String cg2 = cgCRUD.read(cg.getIdCatalog()).toString();
        assertEquals(cg1, cg2);
        cgCRUD.delete(cg);
    }

    @Test
    public void delete() throws Exception {
        double random = Math.random();
        String line = "" + random;
        CatalogGood cg = new CatalogGood(0, line, line, random, line, line);
        CatalogGoodCRUD cgCRUD = new CatalogGoodCRUD();
        cgCRUD.create(cg);
        boolean cg1 = cgCRUD.delete(cg);
        boolean cg2 = true;
        assertEquals(cg1, cg2);
    }
}