package LibraryManagementSystem.daftarbuku;

import LibraryManagementSystem.daftarbuku.core.DaftarBukuResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class DaftarBukuResourceFactory{
    private static final Logger LOGGER = Logger.getLogger(DaftarBukuFactory.class.getName());

    public DaftarBukuResourceFactory()
    {

    }

    public static DaftarBukuResource createDaftarBukuResource(String fullyQualifiedName, Object ... base)
    {
        DaftarBukuResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (DaftarBukuResource) constructor.newInstance(base);
        } 
        catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of DaftarBuku.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e)
        {   LOGGER.severe("Failed to create instance of DaftarBuku.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.severe("Failed to create instance of DaftarBuku.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e)
        {
            LOGGER.severe("Failed to create instance of DaftarBuku.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}
