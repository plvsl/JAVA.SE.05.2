package test;

import main.KeyNotFoundException;
import main.PropertyFileNotFoundException;
import main.UniversalClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class UniversalClassTest {

    @BeforeClass
    public static void setUp() throws IOException, PropertyFileNotFoundException {
        UniversalClass.importProperties("C:\\Users\\Polina\\Desktop\\JAVA.SE\\JAVA.SE.05\\JAVA.SE.05.2\\src\\main\\" +
                "resources\\prop.properties");
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getKeyMethodShouldReturnCorrectValueByExistingKey() throws KeyNotFoundException {
        assertEquals(UniversalClass.getValueByKey("3"), "Java is very difficult");
    }

    @Test (expected = KeyNotFoundException.class)
    public void getKeyMethodShouldReturnExceptionUsingNotExistingKey() throws KeyNotFoundException {
        UniversalClass.getValueByKey("10");
    }

    @Test
    public void importPropertiesMethodShouldReturnFalseUsingNotExistingFile() throws IOException, PropertyFileNotFoundException {
        assertFalse(UniversalClass.importProperties("C:\\Users\\Polina\\Desktop\\JAVA.SE\\JAVA.SE.05\\JAVA.SE.05.2\\src\\main\\" +
                "resources\\Prop2.properties"));
    }

    @Test
    public void importPropertiesMethodShouldReturnFalseUsingSamePathTwice() throws IOException, PropertyFileNotFoundException {
        assertFalse(UniversalClass.importProperties("C:\\Users\\Polina\\Desktop\\JAVA.SE\\JAVA.SE.05\\JAVA.SE.05.2\\src" +
                "\\main\\resources\\prop.properties"));
    }

    @Test
    public void importPropertiesMethodShouldAcceptDifferentFilePathsFormats() throws IOException, PropertyFileNotFoundException {
        assertTrue(UniversalClass.importProperties("C:/Users/Polina/Desktop/JAVA.SE/JAVA.SE.05/JAVA.SE.05.2/src/main/" +
                "resources/prop3.properties"));
        assertTrue(UniversalClass.importProperties("src/main/resources/prop4.properties"));
    }

    @Test
    public void importPropertiesMethodShouldNotImportSameFileByDifferentPathsFormats() throws IOException, PropertyFileNotFoundException {
        assertFalse(UniversalClass.importProperties("C:/Users/Polina/Desktop/JAVA.SE/JAVA.SE.05/JAVA.SE.05.2/src/main/" +
                "resources/prop.properties"));
        assertFalse(UniversalClass.importProperties("src/main/resources/prop.properties"));
    }

}
