/**
 * 
 */
package mebiw.basic.smartbloomfilter.core;

/**
 * This interface defined the methods you can in your codes.
 * Because there are some different implements of BloomFilter,
 * so it's more convenient to use the interface instead of classes.
 * 
 * All implements of BloomFilter in this package follow this interface well.
 * @author MebiuW
 * @version 1.0
 *
 */
public interface IBloomFilter<T> {
	/**
	 * 
	 * @param key : what you want to put
	 * @return is successful?
	 */
	public boolean put(T key);
	/**
	 * 
	 * @param key : what you want to judge
	 * @return if the key has possibility that stored in system ,return true,if not false
	 */
	public boolean contains(T key);

	/**
	 * delete all index
	 * @return is successful?
	 */
	public boolean clear();
	/**
	 * the amount of the bits with value 0 in bit array.
	 * return 0: the BloomFilter has lost the it's ability to boost query
	 * return 1: the BloomFilter has not been used 
	 * To reach the best performance ,please pay attention to this value
	 * @return the amount range from 0.0 to 1.0
	 */
	public double getUsedAmount();
	

}
