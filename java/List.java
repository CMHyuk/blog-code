import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
       
    	ArrayList<Integer> listA = new ArrayList<>();
        LinkedList<Integer> listB = new LinkedList<>();
            
        for(int i = 0; i < 1000000; i++) {
        	listA.add(i);
        	listB.add(i);
        }
        
        System.out.println("======수정======");
        System.out.println("ArrayList = " + edit(listA));
        System.out.println("LinkedList = " + edit(listB));
        
        System.out.println("\n======조회======");
        System.out.println("ArrayList = " + find(listA));
        System.out.println("LinkedList = " + find(listB));
        
        System.out.println("\n======삭제======");
        System.out.println("ArrayList = " + delete(listA));
        System.out.println("LinkedList = " + delete(listB));

                
    }

    public static long edit(List<Integer> list) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
            list.add(200, 100);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
     
    public static long find(List<Integer> list) {
    	long start = System.currentTimeMillis();
    	for(int i = 0; i < 10000; i++) {
            list.get(i);
        }
    	long end = System.currentTimeMillis();
        return end - start;
    }
    
    public static long delete(List<Integer> list) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    } 
}