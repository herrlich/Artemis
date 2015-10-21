/*
Implement an iterator to flatten a 2d vector. 

For example,
 Given 2d vector = 
[
  [1,2],
  [3],
  [4,5,6]
]



By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6]. 
*/

public class Vector2D {
    List<List<Integer>> list;
    int x = 0, y = 0;
    
    public Vector2D(List<List<Integer>> vec2d) {
        list = vec2d;
    }

    public int next() {
        int num = list.get(x).get(y);
        ++y;
        return num;
    }

    public boolean hasNext() {
        if (list == null || list.size() == 0) return false;
        while (y == list.get(x).size()) {
            ++x;
            y = 0;
            if (x == list.size()) return false;
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

// Another method using iterator
public class Vector2D {
    Iterator<List<Integer>> it = null;
    Iterator<Integer> itlist = null;
    
    public Vector2D(List<List<Integer>> vec2d) {
        it = vec2d.iterator();
        if (it.hasNext())
            itlist = it.next().iterator();
    }

    public int next() {
        return itlist.next();
    }

    public boolean hasNext() {
        if (itlist == null) return false;
        while (!itlist.hasNext()) {
            if (it.hasNext()) {
                itlist = it.next().iterator();
            }
            else return false;
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */