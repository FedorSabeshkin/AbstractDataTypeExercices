package ru.sabeshkin.adt.bloom.filter;

public class BloomFilterImpl extends BloomFilter {

  private int filter_len;
  private int intOnlyFilter;
  private int putStatus;
  private int isExistStatus;
  public BloomFilterImpl(int f_len) {
    super(f_len);
    filter_len = f_len;
    // filter = new int[filter_len];
    intOnlyFilter = 0x0_000_000_000;
  }

  private int change(int filter, int n) {
    return filter | n;
  }

  private int hash1(String str1) {
    int entropy = 17;
    return hashFun(str1, entropy);
  }


  private int hash2(String str1) {
    int entropy = 223;
    return hashFun(str1, entropy);
  }

  /*
   * return index of value
   */
  private int hashFun(String value, int entropy) {
    char[] charArr = new char[value.length()];
    int sum = 0;
    for (int i = 0; i < value.length(); i++) {
      charArr[i] = value.charAt(i);
      sum = ((sum * entropy) + charArr[i] - '0') % filter_len;
    }
    return sum;
  }

  @Override
  public void put(String value) {
    putStatus=1;
    int indexFirst = hash1(value);
    int indexSecond = hash2(value);
    intOnlyFilter = change(intOnlyFilter, indexFirst);
    intOnlyFilter = change(intOnlyFilter, indexSecond);

  }

  @Override
  public boolean isExist(String value) {
    isExistStatus=1;
    int indexFirst = hash1(value);
    int indexSecond = hash2(value);
    int mask = 0x0_000_000_000;
    mask = change(mask, indexFirst);
    mask = change(mask, indexSecond);
    if((intOnlyFilter & mask) ==  mask){
        return true;
    }else{
        return false;   
    }
  }

  @Override
  public int get_put_status() {
    return putStatus;
  }

  @Override
  public int get_is_exist_status() {
    return isExistStatus;
  }

}
