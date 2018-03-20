
package ht7;

/**
 * @author Rodrigo Urrutia 16139
 * @author Kevin Macario 17369
 * @version 18.03.2018
 */

public class Association <K,V>{
    protected K theKey;
    protected V theValue;

    public Association(K key, V value)
    {
        
        theKey = key;
        theValue = value;
    }

    public Association(K key)
    {
        this(key,null);
    }

    @Override
    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }
    
    @Override
    public int hashCode()
    {
        return getKey().hashCode();
    }
    public V getValue()
    {
        return theValue;
    }

    public K getKey()
    {
        return theKey;
    }

    public V setValue(V value)
    {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }

   
    @Override
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("("+getKey()+","+getValue()+")");
        return s.toString();
    }
    
}