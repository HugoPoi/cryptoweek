package net.hugopoi;

import java.util.AbstractMap;
import java.util.Map;

/**
 * Created by hugo on 23/06/15.
 */
public class SimpleEntryClonable<K,V> implements Map.Entry<K,V>,Cloneable {

    K key;
    V value;

    SimpleEntryClonable(K k, V v){
        key = k;
        value = v;
    }

    private K setKey(K k){
        key = k;
        return key;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return value;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SimpleEntryClonable<K,V> o = (SimpleEntryClonable<K,V>) super.clone();
        o.setKey(this.key);
        o.setValue(this.value);
        return o;
    }

    @Override
    public String toString() {
        return key.toString()+","+value.toString();
    }
}
