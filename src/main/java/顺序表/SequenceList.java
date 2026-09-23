package 顺序表;


import java.util.Arrays;
import java.util.Iterator;

/**
 * 顺序表
 *
 * @author tianxing
 */
@SuppressWarnings("unchecked")
public class SequenceList<T> implements Iterable<T> {

    /**
     * 存储元素的数组
     */
    private T[] elementData;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 构造函数
     *
     * @param capacity 初始容量
     */
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

    /**
     * 判断顺序表是否为空
     *
     * @return 顺序表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取顺序表的元素个数
     *
     * @return 顺序表的元素个数
     */
    public int size() {
        return size;
    }

    /**
     * 获取指定索引处的元素
     *
     * @param index 索引
     * @return 指定索引处的元素
     */
    public T get(int index) {
        return elementData[index];
    }

    /**
     * 在顺序表末尾添加元素t
     *
     * @param t 元素
     * @return 是否添加成功
     */
    public boolean add(T t) {
        grow();
        elementData[size++] = t;
        return true;
    }

    /**
     * 指定索引处添加元素
     *
     * @param index 索引
     * @param t     元素
     */
    public void add(int index, T t) {
        grow();
        // 整体往后移动1个位置
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = t;
        size++;
    }

    /**
     * 删除指定索引处的元素
     *
     * @param index 索引
     * @return 被删除的元素
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
     *
     * @param t 元素
     * @return 元素t第一次出现的索引(不存在则返回-1)
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
    private void grow() {
        if (size == elementData.length) {
            int newLength = size + size / 2;
            elementData = Arrays.copyOf(elementData, newLength);
        }
    }

    /**
     * 缩容
     */
    private void decrease() {
        if (size < elementData.length / 4) {
            int newLength = elementData.length / 2;
            elementData = Arrays.copyOf(elementData, newLength);
        }
    }

    /**
     * 获取顺序表的迭代器
     *
     * @return 顺序表的迭代器
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /** 指针 */
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

    /**
     * 将顺序表转为字符串可视化格式
     *
     * @return 顺序表的字符串表示
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
