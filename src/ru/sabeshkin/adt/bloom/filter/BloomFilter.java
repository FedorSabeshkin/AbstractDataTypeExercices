package ru.sabeshkin.adt.bloom.filter;

import ru.sabeshkin.adt.parent.hash.store.ParentHashStore;


public abstract class BloomFilter extends ParentHashStore {
  public BloomFilter(int size){
    super(size);
  }
}
