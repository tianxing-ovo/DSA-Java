package list.linked;

import java.util.Iterator;
import java.util.Objects;

/**
 * 单向链表
 *
 * @author tianxing
 */
public class SinglyLinkedList<T> implements Iterable<T> {

    private int size;
    private final Node<T> head;

    public SinglyLinkedList() {
        head = new Node<>(null, null);
    }

    /**
     * 获取指定位置处的节点
     *
     * @param index 要获取的节点的位置
     * @return 要获取的节点
     */
    private Node<T> getNode(int index) {
        if (index < 0) {
            return head;
        }
        Node<T> node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /* 清空链表 */
    public void clear() {
        head.next = null;
        size = 0;
    }

    /**
     * 获取链表的大小
     *
     * @return 链表的大小
     */
    public int size() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return 链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取第一个元素
     *
     * @return 第一个元素
     */
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.item;
    }

    /**
     * 获取最后一个元素
     *
     * @return 最后一个元素
     */
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return getLastNode().item;
    }

    /**
     * 获取指定位置处的元素
     *
     * @param index 要获取的元素的位置
     * @return 要获取的元素
     */
    public T get(int index) {
        return getNode(index).item;
    }

    /**
     * 添加一个节点到链表的头部
     *
     * @param item 元素
     */
    public void addFirst(T item) {
        Node<T> next = head.next;
        head.next = new Node<>(item, next);
        size++;
    }

    /**
     * 添加一个节点到链表的末尾
     *
     * @param item 元素
     */
    public void addLast(T item) {
        Node<T> last = getLastNode();
        last.next = new Node<>(item, null);
        size++;
    }

    /**
     * 指定位置处添加节点
     *
     * @param index 要添加的节点的位置
     * @param item  元素
     */
    public void insert(int index, T item) {
        // 找到前一个节点和当前节点
        Node<T> pre = getNode(index - 1);
        Node<T> cur = pre.next;
        pre.next = new Node<>(item, cur);
        size++;
    }

    /**
     * 删除指定位置处的节点
     *
     * @param index 要删除的节点的位置
     * @return 被删除的元素
     */
    public T remove(int index) {
        Node<T> pre = getNode(index - 1);
        Node<T> cur = pre.next;
        pre.next = cur.next;
        cur.next = null;
        size--;
        return cur.item;
    }

    /**
     * 查找元素item第一次出现的位置
     *
     * @param item 元素
     * @return 元素第一次出现的位置(如果不存在则返回-1)
     */
    public int indexOf(T item) {
        Node<T> node = head.next;
        for (int i = 0; node != null; i++) {
            if (Objects.equals(item, node.item)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    /**
     * 获取最后一个节点
     *
     * @return 最后一个节点
     */
    private Node<T> getLastNode() {
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    /**
     * 获取链表的迭代器
     *
     * @return 链表的迭代器
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;
            int index;

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public T next() {
                node = node.next;
                index++;
                return node.item;
            }
        };
    }

    /**
     * 将链表转为字符串可视化格式
     *
     * @return 链表的字符串表示
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> cur = head.next;
        while (cur != null) {
            sb.append(cur.item);
            if (cur.next != null) {
                sb.append(" -> ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 节点
     */
    private static class Node<T> {
        T item;
        Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
