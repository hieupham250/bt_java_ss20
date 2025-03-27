import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Bai5 {
    public static void main(String[] args) {
        List<Integer> normalList = List.of(10, 5, 8, 20, 7);
        List<Integer> singleElementList = List.of(10);
        List<Integer> allSameList = List.of(10, 10, 10);

        System.out.println("Danh sách bình thường: " + findSecondLargest(normalList));
        System.out.println("Danh sách phần tử đơn: " + findSecondLargest(singleElementList));
        System.out.println("Tất cả cùng một danh sách: " + findSecondLargest(allSameList));
    }

    public static String findSecondLargest(List<Integer> numbers) {
        Optional<Integer> secondLargest = numbers.stream().distinct().sorted((a, b) -> Integer.compare(b, a)).skip(1).findFirst();
        return secondLargest.map(String::valueOf).orElse("Không tìm thấy số lớn thứ hai");
    }
}
