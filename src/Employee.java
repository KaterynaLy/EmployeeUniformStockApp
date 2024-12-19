import java.util.ArrayList;
import java.util.List;


public class Employee {
    private static int idCounter = 1; // Generador de IDs únicos
    private int id;                  // ID único del empleado
    private String name;             // Nombre del empleado
    private List<Uniform> uniforms;  // Lista de uniformes asignados

    // Constructor
    public Employee(String name) {
        this.id = idCounter++;       // Asignar ID único
        this.name = name;
        this.uniforms = new ArrayList<>();

        // Crear uniformes predeterminados
        addUniform(new Uniform("jackets", 1));
        addUniform(new Uniform("pants", 2));
    }

    public void addUniform(Uniform uniform) {
        uniforms.add(uniform);
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
        Employee.idCounter = idCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Uniform> getUniforms() {
        return uniforms;
    }

    public void setUniforms(List<Uniform> uniforms) {
        this.uniforms = uniforms;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uniforms=" + uniforms +
                '}';
    }


}


