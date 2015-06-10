/**
 * 
 */
package mebiw.basic.smartbloomfilter;

import java.util.BitSet;
import java.util.List;

import mebiw.basic.smartbloomfilter.core.IBloomFilter;
import mebiw.basic.smartbloomfilter.core.IHash;

/**
 * This class is an implements of BloomFilter,
 * and it's also the most simple one
 * !!There are something you should attention:
 * 1 the bit width M : 
 * 2 the number K of hash functions:you are not asked tell the constructor ,just give the list of HashFunction
 * 3 how to set the hash functions:
 * method a:please put all the name of your class into a String[]
 * and you should ensure the name(path) is correct! 
 * for instance:
 * String hashFunctionNames[]=new Strings[] {"Name A","Name B"..};
 * all  classes should not ask for any parameter when the instance building(constructor asks no parameter).
 * method b:
 * give a instance ArrayList<IHash<T>>
 * 
 * 
 * 
 * @author MebiuW
 * @version 1.0
 */
public class BloomFilter<T> implements IBloomFilter<T> {
	private List<IHash<T>>  hashFunctions;
	private int M,K;
	private BitSet bitArray;
	
	/**
	 * Method B: construct with hash instances
	 * you should pay more attention to parameter 'm'
	 * @param hashFunctions
	 * @param m : length of Bit Array,m the real length will times 32 (32*m)
	 */
	public BloomFilter(List<IHash<T>>  hashFunctions, int m) {
		super();
		this.hashFunctions = hashFunctions;
		this.M = m;
		this.K=hashFunctions.size();
		//initializing 
		this.clear();
	
	}

	@Override
	public boolean put(T key) {
		int position;
		for(int i=0;i<this.K;i++){
			position=this.hashFunctions.get(i).getHashCode(key, this.M);
			this.bitArray.set(position,true);
		}
		return true;
	}

	@Override
	public boolean contains(T key) {
		int position;
		for(int i=0;i<this.K;++i){
			position=this.hashFunctions.get(i).getHashCode(key, this.M);
			if(this.bitArray.get(position)==false);
				return false;
		}
		return true;
	}

	@Override
	public boolean clear() {

		this.bitArray = new BitSet(this.M);
		this.bitArray.clear();
		return false;
	}
	/**
	 * the amount of the bits with value 0 in bit array.
	 * return 0: the BloomFilter has lost the it's ability to boost query
	 * return 1: the BloomFilter has not been used 
	 * To reach the best performance ,please pay attention to this value
	 * @return the amount range from 0.0 to 1.0
	 */
	@Override
	public double getUsedAmount() {
		int usedAmount=0;
		for(int i=0;i<this.M;i++){
			if(this.bitArray.get(i))
				usedAmount++;
				
		}
		return usedAmount/(this.M+0.0);
	}

}
