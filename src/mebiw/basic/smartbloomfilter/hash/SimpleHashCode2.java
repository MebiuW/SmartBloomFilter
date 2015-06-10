package mebiw.basic.smartbloomfilter.hash;

import mebiw.basic.smartbloomfilter.core.IHash;
/**
 * Provide a Simple Hash Function:
 * HashCode=T.hashCode()*seed % range
 * @author MebiuW
 *
 * @param <T>
 */

public class SimpleHashCode2<Integer> implements IHash<Integer> {
	private int seed;
	/**
	 * 
	 * @param seed choose a seed ,it will influence the result
	 */
	public SimpleHashCode2(int seed){
		this.seed=seed;
	}
	@Override
	public int getHashCode(Integer key, int length) {
		return Math.abs(((int)key)*((int)key+seed)) % length;
	}

}
