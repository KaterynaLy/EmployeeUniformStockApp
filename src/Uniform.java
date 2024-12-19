
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Uniform {
    private static int idCounter = 1;
    private int id;
    private String name;
    private int quantity;

    // Constructor
    public Uniform(String name, int quantity) {
        this.id = idCounter++;       // Asignar ID único
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Uniform.idCounter = idCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Uniform{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
