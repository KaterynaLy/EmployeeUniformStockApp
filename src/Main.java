
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
                            "6. Return uniform\n" +
                            "7. Check all Employees and their uniforms assigned\n"
            );
            option = entrada.nextInt();
            entrada.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Exit App");
                    break;
                case 2:
                    System.out.println("Enter the name:");
                    String name = entrada.nextLine();
                    registerNewEmployee(name, employees);
                    break;
                case 3:
                    System.out.println("Enter the name to edit:");
                    name = entrada.nextLine();
                    System.out.println("Enter new name: ");
                    String newName = entrada.nextLine();
                    editEmployee(name, newName, employees);
                    break;
                case 4:
                    System.out.println("Enter the name of Employee you would like to delete:");
                    name = entrada.nextLine();
                    deleteEmployee(name, employees);
                    break;
                case 5:
                    // Implement Withdraw Uniform
                    break;
                case 6:
                    // Implement Return Uniform
                    break;
                case 7:
                    System.out.println("Check all Employees and their uniforms assigned");
                    mostrarLista(employees);
                    calculateRemainingStock(initialStock, employees);
                    break;
                default:
                    System.out.println("Choose from 1 to 7");
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

    public static Employee searchEmployee(String name, List<Employee> employees) {
        for (Employee e : employees) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null;
    }

    public static void editEmployee(String name, String newName, List<Employee> employees) {
        Employee employeeToEdit = searchEmployee(name, employees);

        if (employeeToEdit != null) {
            employeeToEdit.setName(newName);
            System.out.println("Employee is edited: " + newName);
        } else {
            System.out.println("There is no such an employee");
        }
    }

    public static void deleteEmployee(String name, List<Employee> employees) {
        Employee employeeToDelete = searchEmployee(name, employees);
        if (employeeToDelete != null) {
            employees.remove(employeeToDelete);
            System.out.println("Employee"  + name + " deleted successfully.");
        } else {
            System.out.println("There is no such an employee");
        }
    }

    public static void mostrarLista(List<Employee> employees){
        System.out.println("La lista de empleados: ");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}