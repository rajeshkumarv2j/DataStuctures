package com.jrk.ds.queue.test;

import com.jrk.ds.queue.ArrayQueueImpl;
import com.jrk.ds.queue.Queue;

public class ArrayQueueTest {
	public static void main(String[] args) {
		Queue<String> queue = new ArrayQueueImpl<String>();
		queue.enQueue("rajeh0");
		queue.enQueue("rajeh1");
		queue.enQueue("rajeh2");
		queue.enQueue("rajeh3");
		queue.enQueue("rajeh4");
		queue.enQueue("rajeh5");
		queue.enQueue("rajeh6");
		queue.enQueue("rajeh7");
		queue.enQueue("rajeh8");
		queue.enQueue("rajeh9");
		System.out.println(queue);
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		System.out.println(queue);
		queue.enQueue("rajeh8");
		queue.enQueue("rajeh9");
		System.out.println(queue);
	}
}
