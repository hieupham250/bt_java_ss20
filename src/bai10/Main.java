package bai10;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User u1 = new User(1, "Quý", "quy@example.com");
        User u2 = new User(2, "Lan", null);
        User u3 = new User(3, "Huyền", "huyen@example.com");

        List<Task> tasks = List.of(
                new Task(1, "Viết báo cáo", u1, LocalDate.of(2025, 3, 20), false),
                new Task(2, "Thiết kế slide", u1, LocalDate.of(2025, 3, 25), true),
                new Task(3, "Họp nhóm", u2, LocalDate.of(2025, 3, 18), false),
                new Task(4, "Nộp tài liệu", u3, LocalDate.of(2025, 3, 22), true),
                new Task(5, "Chuẩn bị thuyết trình", u2, LocalDate.of(2025, 3, 19), true)
        );

        System.out.println("== Công việc quá hạn và chưa hoàn thành ==");
        tasks.stream()
                .filter(Task::isOverdue)
                .forEach(task -> System.out.println(task.toDisplayString()));

        long completedTasks = tasks.stream().filter(Task::isCompleted).count();
        System.out.println("== Số công việc đã hoàn thành ==");
        System.out.println("Tổng: " + completedTasks);

        System.out.println("== Thống kê người dùng ==");
        List<User> users = List.of(u1, u2, u3);
        users.forEach(user -> {
            long totalTasks = tasks.stream().filter(task -> task.getAssignedTo().equals(user)).count();
            long overdueTasks = tasks.stream().filter(task -> task.getAssignedTo().equals(user) && task.isOverdue()).count();
            System.out.printf("%s | Tổng task: %d | Quá hạn: %d\n", user.toDisplayString(), totalTasks, overdueTasks);
        });
    }
}
