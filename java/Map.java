import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Map {

	public static void main(String[] args) {
		
	Map<Integer, String> mapA = new ConcurrentHashMap<>();
	Map<Integer, String> mapB = new HashMap<>();
	
	System.out.println("======추가======");
    System.out.println("ConcurrentHashMap = " + add(mapA));
    System.out.println("HashMap = " + add(mapB));
	 
	System.out.println("\n======수정======");
    System.out.println("ConcurrentHashMap = " + edit(mapA));
    System.out.println("HashMap = " + edit(mapB));
     
    System.out.println("\n======조회======");
    System.out.println("ConcurrentHashMap = " + find(mapA));
    System.out.println("HashMap = " + find(mapB));
     
    System.out.println("\n======삭제======");
    System.out.println("ConcurrentHashMap = " + delete(mapA));
    System.out.println("HashMap = " + delete(mapB));
	 
 }
	
	public static long add(Map<Integer, String> map) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            map.put(i, "100");
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
	
	public static long edit(Map<Integer, String> map) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            map.replace(200, "100");
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
     
    public static long find(Map<Integer, String> map) {
    	long start = System.currentTimeMillis();
    	for(int i = 0; i < 1000000; i++) {
            map.get(i);
        }
    	long end = System.currentTimeMillis();
        return end - start;
    }
    
    public static long delete(Map<Integer, String> map) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            map.remove(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

}
