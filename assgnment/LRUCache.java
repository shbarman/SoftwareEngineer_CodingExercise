import java.util.LinkedHashMap;
import java.util.*;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.image.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

class LRUCache extends LinkedHashMap<String, helperType> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public void check(String key) {
        if (super.containsKey(key)) {
            System.out.println(key + " IN_CACHE " + super.get(key).length);
        } else {
            super.put(key, helper(key));
            System.out.println(key + " DOWNLOADED " + super.get(key).length);
        }
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<String, helperType> eldest) {
        System.out.println("here");
        return size() > capacity;
    }

    public helperType helper(String key) {
        helperType list = null;
        try {
            BufferedImage img = null;
            URL iconURL = new URL(key);
            img = ImageIO.read(iconURL);
            ImageIcon icon = new ImageIcon(iconURL);
            Image i = icon.getImage();
            int length = iconURL.openConnection().getContentLength();
            list = new helperType(i, length);
            // System.out.println();

        } catch (Exception e) {
            System.out.println(e + " Not Found");
        }
        return list;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int capacity = 0;
        System.out.println("Enter the cache_size_in_bytes");
        capacity = in.nextInt();
        LRUCache lru = new LRUCache(capacity);
        System.out.println("Numbers of URLS to appear in input");
        int size = in.nextInt();
        List<String> list = new ArrayList<>();
        while (size > 0) {
            String key = in.next();
            list.add(key);
            size--;
        }
        for (String s : list) {
            lru.check(s);
        }

    }
}