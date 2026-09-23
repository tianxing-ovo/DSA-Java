package 顺序表;


import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class SequenceList<T> implements Iterable<T> {

    /**
     * 存储元素的数组
     */
    transient T[] elementData;

    /**
     * 元素个数
     */
    private int size;

    public SequenceList(int capacity) {
        elementData = (T[]) new Object[capacity];
    }

    /**
     * 清空顺序表
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return elementData[index];
    }

    /**
     * 添加元素
     */
    public boolean add(T t) {
        grow();
        elementData[size++] = t;
        return true;
    }

    /**
     * 指定索引处添加元素
     */
    public void add(int index, T t) {
        grow();
        // 整体往后移动1个位置
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = t;
        size++;
    }

    /**
     * 删除指定索引处的元素,返回被删除的元素
     */
    public T remove(int index) {
        T oldValue = elementData[index];
        // 整体往前移动1个位置
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[--size] = null;
        decrease();
        return oldValue;
    }

    /**
     * 查找元素t第一次出现的索引
     */
    public int indexOf(T t) {
        if (t == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (t.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 扩容
     */
    public void grow() {
        if (size == elementData.length) {
            int newLength = size + size / 2;
            elementData = Arrays.copyOf(elementData, newLength);
        }
    }

    /**
     * 缩容
     */
    public void decrease() {
        if (size < elementData.length / 4) {
            int newLength = elementData.length / 2;
            elementData = Arrays.copyOf(elementData, newLength);
        }
    }

    /**
     * 遍历集合中的元素
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /**
             * 指针
             */
            private int cursor;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                return elementData[cursor++];
            }
        };
    }
}
