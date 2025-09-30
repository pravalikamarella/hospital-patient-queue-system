import java.util.*;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalQueueSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p2.severity, p1.severity)
        );

        while (true) {
            System.out.println("\n--- Hospital Patient Queue System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Treat Patient");
            System.out.println("3. Show Waiting Patients");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter severity level (1-10): ");
                    int severity = sc.nextInt();
                    sc.nextLine();
                    patientQueue.add(new Patient(name, severity));
                    System.out.println("Patient added successfully!");
                    break;

                case 2:
                    if (patientQueue.isEmpty()) {
                        System.out.println("No patients in the queue.");
                    } else {
                        Patient treated = patientQueue.poll();
                        System.out.println("Treating patient: " + treated);
                    }
                    break;

                case 3:
                    if (patientQueue.isEmpty()) {
                        System.out.println("No patients waiting.");
                    } else {
                        System.out.println("Waiting Patients:");
                        for (Patient p : patientQueue) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}