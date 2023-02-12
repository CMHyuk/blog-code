import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MemberTest {
    public static void main(String[] args) {

        Member member1 = new Member("이름", 1);
        Member member2 = new Member("이름", 1);

        System.out.println(member1.hashCode());
        System.out.println(member2.hashCode());

        System.out.println(member1.equals(member2));

        Set<Member> set = new HashSet<>();

        set.add(member1);
        set.add(member2);

        System.out.println(set.size());

        Map<Member, Integer> map = new HashMap<>();
        map.put(member1, 1);

        Integer value = map.get(new Member("이름", 1));
        System.out.println(value);
    }
}
