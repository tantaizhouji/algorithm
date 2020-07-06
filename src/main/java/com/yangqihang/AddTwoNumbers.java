package com.yangqihang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 两数相加
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 例 (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 得到 7 -> 0 -> 8
 */
public class AddTwoNumbers {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(node1.val);
        while (node1.next != null) {
            node1 = node1.next;
            list1.add(node1.val);
        }
        List<Integer> list2 = new ArrayList<>();
        list2.add(node2.val);
        while (node2.next != null) {
            node2 = node2.next;
            list2.add(node2.val);
        }
        System.out.println(list1.toString());
        System.out.println(list2.toString());

        List<Integer> last = new ArrayList<>();
        int flag = 0; // 进位标志位
        for (int i = 0; i < Math.max(list1.size(), list2.size()) || flag == 1; i++) {
            if (i >= list1.size() && i < list2.size()) {
                int val = flag;
                val += list2.get(i);
                if (val >= 10) {
                    flag = 1;
                    val = val % 10;
                } else {
                    flag = 0;
                }
                last.add(val);
                continue;
            }
            if (i >= list2.size() && i < list1.size()) {
                int val = flag;
                val += list1.get(i);
                if (val >= 10) {
                    flag = 1;
                    val = val % 10;
                } else {
                    flag = 0;
                }
                last.add(val);
                continue;
            }
            if (i >= list1.size() && i >= list2.size()) {
                last.add(flag);
                flag=0;
                continue;
            }
            int val = flag;
            val += list1.get(i) + list2.get(i);
            if (val >= 10) {
                flag = 1;
                val = val % 10;
            } else {
                flag = 0;
            }
            last.add(val);
        }
        ListNode node = new ListNode(last.get(0));
        ListNode root = node;
        for (int i = 1; i < last.size(); i++) {
            node.next = new ListNode(last.get(i));
            node = node.next;
        }

        return root;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(1);
        ListNode node1 = new ListNode(8);
//        ListNode node2 = new ListNode(3);
        root1.next = node1;
//        node1.next = node2;

        ListNode root2 = new ListNode(0);
//        ListNode node3 = new ListNode(6);
//        ListNode node4 = new ListNode(4);
//        root2.next = node3;
//        node3.next = node4;

        ListNode listNode = addTwoNumbers(root1, root2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
