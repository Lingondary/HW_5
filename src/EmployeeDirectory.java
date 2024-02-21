import java.util.ArrayList;
import java.util.List;

class EmployeeDirectory {
    private List<Employee> employees;

    public EmployeeDirectory() {
        employees = new ArrayList<>();
    }

    // Добавление сотрудника в справочник
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Удаление сотрудника из справочника
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    // Получение списка всех сотрудников
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Поиск сотрудников по стажу
    public List<Employee> findEmployeesByExperience(int experience) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == experience) {
                foundEmployees.add(employee);
            }
        }
        return foundEmployees;
    }

    // Поиск номера телефона сотрудника по имени
    public List<String> findPhoneNumbersByName(String name) {
        List<String> phoneNumbers = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                phoneNumbers.add(employee.getPhoneNumber());
            }
        }
        return phoneNumbers;
    }

    // Поиск сотрудника по табельному номеру
    public Employee findEmployeeById(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null; // Если сотрудник не найден
    }
}