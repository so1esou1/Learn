package com.csu;

import java.util.Map;

/*
    手写一个HashMap
 */
public class HashMap<K,V> implements Map<K,V> {

    private Entry<K,V> table[] = null;
    int size = 0;

    public HashMap(){
        this.table = new Entry[16];
    }

    @Override
    public int size() {
        return size;
    }


    /**
     * 通过key，进行hash
     * index下标数组对象
     * 判断当前对象是否为空，如果不为空，进行判断是否相等，如果不相等，
     * 判断next是否为空，如果不为空，再判断是否相等，知道相等或者为空为止
     * @param key
     * @return
     */
    @Override
    public V get(K k) {
        if (size == 0){
            return null;
        }
        int index = hash(k);
        Entry<K, V> entry = findValue(table[index],k);


        return entry == null ? null : entry.getValue();
    }

    /**
     *
     * @param entry 取出下标4 结点
     * @param k 查询
     * @return
     */
    private Entry<K,V> findValue(Entry<K,V> entry, K k) {
        if (k.equals(entry.getKey()) || k == entry.getKey()){
            return entry;
        }else {
            if (entry.next != null){
                return findValue(entry.next,k);
            }
        }
        return null;
    }

    /**
     *  判断当前对象是否为空，为空，直接存储
     *  如果不为空，冲突 ，next链表
     * @param k
     * @param v
     * @return 返回当前结点对象
     */
    @Override
    public V put(K k, V v) {
        int index = hash(k);
        Entry<K, V> entry = table[index];
        if (null == entry){
            //可以往里面存
            table[index] = new Entry<>(k, v, index, null);
            size++;
        }else {
            //冲突了，不能往里存
            table[index] = new Entry<>(k,v,index,entry);
        }

        return table[index].getValue();
    }

    private int hash(K k){
        int index = k.hashCode() % 16;      //移位操作比取模性能高很多


        return index >= 0 ? index : -index;     //如果index为负，则改为正
    }


    class Entry<K,V> implements Map.Entry<K,V>{
        K k;
        V v;
        int hash;
        Entry<K,V> next;

        public Entry(K k, V v, int hash, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }
}
