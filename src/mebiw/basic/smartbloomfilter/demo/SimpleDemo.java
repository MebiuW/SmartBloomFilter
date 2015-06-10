package mebiw.basic.smartbloomfilter.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mebiw.basic.smartbloomfilter.BloomFilter;
import mebiw.basic.smartbloomfilter.CountingBloomFilter;
import mebiw.basic.smartbloomfilter.core.IBloomFilter;
import mebiw.basic.smartbloomfilter.core.IHash;
import mebiw.basic.smartbloomfilter.hash.SimpleHashCode;
import mebiw.basic.smartbloomfilter.hash.SimpleHashCode2;

/**
 * input from keybord and test result
 * 
 * in my computer
 * CountingBloomFilter's(2 SimpleHashFunction+384length) performance is 100000 throughput per 0.006s
 * BloomFilter's Performance will be a little slower,100000 throughput per 0.007s
 * 
 * @author MebiuW
 * @version 1.0
 *
 */
public class SimpleDemo {

	public static void main(String[] args) {
		List<IHash<Integer>> hashFunctions = new ArrayList<IHash<Integer>>(3);
		hashFunctions.add(new SimpleHashCode<Integer>(13));
		hashFunctions.add(new SimpleHashCode<Integer>(55));
		hashFunctions.add(new SimpleHashCode<Integer>(158));
		Random ran = new Random();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 1000; i++)
			list.add(ran.nextInt(1000));
		IBloomFilter<Integer> bf = new BloomFilter<Integer>(
				hashFunctions, 2048);
		for (int i = 0; i < 1000; i++)
			bf.put(list.get(i));
		long time=System.currentTimeMillis();
		for (int i = 0; i < 1000; i++)
			bf.contains(list.get(i));
		time=System.currentTimeMillis()-time;
		System.out.println("Used Time: " + time);
		System.out.println("Used Amount: " + bf.getUsedAmount());

	}

}
