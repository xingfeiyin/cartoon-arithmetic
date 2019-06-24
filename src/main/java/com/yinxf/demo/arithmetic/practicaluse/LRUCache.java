package com.yinxf.demo.arithmetic.practicaluse;

import java.util.HashMap;

/**
 * LRU算法的应用
 * LRU最近最少使用
 */
public class LRUCache {
    private Node head;
    private Node end;
    //缓存大小
    private int limit;
    private HashMap<String,Node> map ;

    public LRUCache(int limit) {
        this.limit = limit;
        this.map = new HashMap<>();
    }

    private String get(String key){
        Node node = map.get(key);
        if (node == null){
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    private void put(String key,String value){
        Node node = map.get(key);
        if (node == null){
            //如果key不存在，则插入key-value
            if (map.size() >= limit){
                String oldNode = removeNode(head);
                map.remove(oldNode);
            }
            node = new Node(key,value);
            addNode(node);
            map.put(key,node);
        }else {
            //如果key存在，则刷新key-value
            node.value = value;
            refreshNode(node);
        }
    }

    public void remove(String key){
        Node node = map.get(key);
        removeNode(node);
        map.remove(key);
    }

    /**
     * 刷新被访问的节点位置
     * @param node  被访问的节点
     */
    private void refreshNode(Node node) {
        //如果访问的是尾节点，则无需移动节点
        if (node == end){
            return;
        }
        //移除节点
        removeNode(node);
        //重新插入节点
        addNode(node);
    }

    /**
     * 尾部插入节点
     * @param node
     */
    private void addNode(Node node) {
        if (end != null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }

        end = node;
        if (head == null){
            head = node;
        }
    }

    /**
     * 删除节点
     * @param node
     * @return
     */
    private String removeNode(Node node) {
        //移除唯一的节点
        if (node == head && node ==end){
            head = null;
            end = null;
        }else if (node == end){
            //移除尾节点
            end = end.pre;
            end.next = null;
        }else if (node == head){
            //移除头节点
            head = head.next;
            head.pre = null;
        }else {
            //移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        return node.key;
    }





    class Node{
        Node pre;
        Node next;
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("001","用户信息1");
        lruCache.put("002","用户信息2");
        lruCache.put("003","用户信息3");
        lruCache.put("004","用户信息4");
        lruCache.put("005","用户信息5");
        lruCache.get("002");
        lruCache.put("004","用户信息4更新");
        lruCache.put("006","用户信息6");
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
    }
}
