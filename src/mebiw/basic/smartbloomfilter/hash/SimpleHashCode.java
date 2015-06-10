package mebiw.basic.smartbloomfilter.hash;

import mebiw.basic.smartbloomfilter.core.IHash;
/**
 * Provide a Simple Hash Function:
 * HashCode=T.hashCode()*seed % range
 * @author MebiuW
 *
 * @param <T>
 */

public class SimpleHashCode<Integer> implements IHash<Integer> {
	private int seed;
	/**
	 * 
	 * @param seed choose a seed ,it will influence the result
	 */
	public SimpleHashCode(int seed){
		this.seed=seed;
	}
	@Override
	public int getHashCode(Integer intKey, int length) {
		int h = 0;
        int off = 0;
        String key=intKey+"";
        char val[] = key.toCharArray();
        int len = key.length();
        for (int i = 0; i < len; i++) {
            h = (30 + seed) * h + val[off++];
        }
		return Math.abs(h%length);
	}

}
