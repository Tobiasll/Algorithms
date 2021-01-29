package com.tobias.leetcode.other;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 *
 * Example:
 *
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 *
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */
public class S_284PeekingIterator {

    static class PeekingIterator implements Iterator<Integer> {

        private final Iterator<Integer> iterator;
        private Integer peek;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
             if (peek == null ) {
                 peek = iterator.next();
             }
             return peek;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (peek != null) {
                int temp = peek;
                peek = null;
                return temp;
            }
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return peek != null ||  iterator.hasNext();
        }
    }

    public static void main(String[] args) {

        /*["PeekingIterator","hasNext","peek","peek","next","next","peek","peek","next","hasNext","peek","hasNext","next","hasNext"]
[[[1,2,3,4]],[],[],[],[],[],[],[],[],[],[],[],[],[]]
Output
[null,true,1,1,1,2,3,3,3,true,4,false,4,false]
Expected
[null,true,1,1,1,2,3,3,3,true,4,true,4,false]*/
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        PeekingIterator peekingIterator = new PeekingIterator(list.iterator());
        System.out.println(peekingIterator.hasNext());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.hasNext());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.hasNext());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.hasNext());
    }
}
