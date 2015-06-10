/**
 * 
 */
package mebiw.basic.smartbloomfilter.core;

/**
 * If there is an hash algorithm , and you want use it in BloomFilter,
 * you should add this interface to your class of algorithm
 * 
 * Particularly , by convenient , the type of hash code in SmartBloomFilter 
 * is Integer.
 * @author MebiuW
 * @version 1.0
 */
public interface IHash<T> {
	/**
	 * get the hashcode
	 * @param key:what you want to compute
	 * @param length: length of bit Array
	 * @return result
	 */
	public int getHashCode(T key,int length);

}
