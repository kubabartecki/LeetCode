/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> array;
    private int currentIndex;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.currentIndex = 0;
        this.array = initializeList(nestedList);
    }

    private List<Integer> initializeList(List<NestedInteger> nest){
        List<Integer> localList = new ArrayList<>();
        for(NestedInteger n : nest){
            if(n.isInteger()) localList.add(n.getInteger());
            else localList.addAll(initializeList(n.getList()));
        }
        return localList;
    }

    @Override
    public Integer next() {
        return this.array.get(this.currentIndex++);
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex < this.array.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */