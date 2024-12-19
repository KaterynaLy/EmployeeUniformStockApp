
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Lista de empleados
        List<Employee> employees = new ArrayList<>();

        // Stock inicial de uniformes
        Map<String, Integer> initialStock = new HashMap<>();
        initialStock.put("jackets", 50);
        initialStock.put("pants", 50);
        initialStock.put("shoes", 50);
        initialStock.put("masks", 50);
        initialStock.put("gloves", 50);

        // Crear empleados
        Employee employee = new Employee("Josep Garcia");
        employee.addUniform(new Uniform("gloves", 1));

        Employee employee1 = new Employee("Nastya");
        Employee employee2 = new Employee("Anfisa");
        Employee employee3 = new Employee("Geka");
        Employee employee4 = new Employee("Carlos");
        Employee employee5 = new Employee("Inna");

        // Agregar empleados a la lista
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        // Mostrar la lista de empleados
        System.out.println("La lista de empleados: ");
        for (Employee e : employees) {
            System.out.println(e);
        }

        // Calcular el stock restante
        calculateRemainingStock(initialStock, employees);

        // Menú interactivo
        Scanner entrada = new Scanner(System.in);
        int option = 0;
        while (option != 1) {
            System.out.println(
                    "Choose what you would like to do: \n" +
                            "1. Exit the application\n" +
                            "2. Register worker\n" +
                            "3. Edit worker\n" +
                            "4. Delete worker\n" +
                            "5. Withdraw uniform\n" +
                            "6. Return uniform"
            );
            option = entrada.nextInt();
            entrada.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Exit App");
                    break;
                case 2:
                    System.out.println("Register new Employee...");
                    System.out.println("Enter the name:");
                    String name = entrada.nextLine();
                    registerNewEmployee(name, employees);  // Método para registrar nuevos empleados
                    break;
                case 3:
                    // Implement Edit Worker
                    break;
                case 4:
                    // Implement Delete Worker
                    break;
                case 5:
                    // Implement Withdraw Uniform
                    break;
                case 6:
                    // Implement Return Uniform
                    break;
                default:
                    System.out.println("Choose from 1 to 6");
            }
        }
    }

    public static void calculateRemainingStock(Map<String, Integer> initialStock, List<Employee> employees) {
        Map<String, Integer> remainingStock = new HashMap<>(initialStock);

        for (Employee employee : employees) {
            for (Uniform uniform : employee.getUniforms()) {
                String uniformName = uniform.getName();
                int quantityAssigned = uniform.getQuantity();

                // Restar la cantidad asignada al uniforme
                if (remainingStock.containsKey(uniformName)) {
                    remainingStock.put(uniformName, remainingStock.get(uniformName) - quantityAssigned);
                }
            }
        }

        System.out.println("\nRemaining stock:");
        for (Map.Entry<String, Integer> entry : remainingStock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " units remaining");
        }
    }

    public static void registerNewEmployee(String name, List<Employee> employees) {
        for (Employee e : employees) {
            if (e.getName().equalsIgnoreCase(name)) {
                System.out.println("Employee already registered.");
                return;
            }
        }

        // Si no está registrado, agregarlo
        Employee newEmployee = new Employee(name);
        employees.add(newEmployee);
        System.out.println("New employee registered: " + name);
    }
}
