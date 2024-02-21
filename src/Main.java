import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание справочника сотрудников
        EmployeeDirectory directory = new EmployeeDirectory();

        // Добавление нескольких сотрудников
        directory.addEmployee(new Employee(1, "123456789", "Иванов", 5));
        directory.addEmployee(new Employee(2, "987654321", "Петров", 3));
        directory.addEmployee(new Employee(3, "555555555", "Иванов", 7));

        // Поиск сотрудников по стажу
        int experienceToSearch = 5;
        List<Employee> employeesByExperience = directory.findEmployeesByExperience(experienceToSearch);
        System.out.println("Сотрудники со стажем " + experienceToSearch + ":");
        for (Employee employee : employeesByExperience) {
            System.out.println(employee);
        }

        // Поиск номера телефона по имени сотрудника
        String nameToSearch = "Иванов";
        List<String> phoneNumbers = directory.findPhoneNumbersByName(nameToSearch);
        System.out.println("\nНомера телефонов для сотрудника " + nameToSearch + ":");
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }

        // Поиск сотрудника по табельному номеру
        int employeeIdToSearch = 2;
        Employee foundEmployee = directory.findEmployeeById(employeeIdToSearch);
        if (foundEmployee != null) {
            System.out.println("\nСотрудник с табельным номером " + employeeIdToSearch + " найден:");
            System.out.println(foundEmployee);
        } else {
            System.out.println("\nСотрудник с табельным номером " + employeeIdToSearch + " не найден.");
        }
    }
}