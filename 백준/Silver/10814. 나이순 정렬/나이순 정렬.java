
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Student {
        int age;
        String name;
        int index;

        public Student(int age, String name, int index) {
            this.index = index;
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Student(age, name, i));
        }
      /*  list.sort((a, b) -> {
            if (a.getAge() != b.getAge()) {
                return a.getAge() - b.getAge();
            } else {
                return a.getIndex() - b.getIndex();
            }
        });*/

        list.sort(Comparator.comparing(Student::getAge)
                .thenComparing(Student::getIndex));

        for (Student s : list) {
            System.out.println(s);
        }
    }
}
