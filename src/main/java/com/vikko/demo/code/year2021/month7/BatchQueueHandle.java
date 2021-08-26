package com.vikko.demo.code.year2021.month7;

import com.google.common.collect.Queues;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: vikko
 * @Date: 2021/2/25 16:31
 * @Description:
 */
public class BatchQueueHandle {

	/**
	 * 批量存入数量
	 */

	private static int NUM_ELEMENTS = 10;

	/**
	 * 等待超时时间(单位:秒)
	 */

	private static int TIME_OUT = 5;

	public static void main(String[] args) {
		final BlockingQueue queue = new LinkedBlockingQueue();

//模拟产生日志

		new Thread(() -> {
			long num = 1L;
			while (true) {
				try {
					queue.put(num);
					num++;
					long time = (long) (Math.random() * 1000);
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		).start();

		while (true) {
			try {
				List<Integer> list = new ArrayList(NUM_ELEMENTS);
				Queues.drain(queue, list, NUM_ELEMENTS, TIME_OUT, TimeUnit.SECONDS);
				System.out.println(list + ", size:" + list.size());
				//执行存库动作

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}