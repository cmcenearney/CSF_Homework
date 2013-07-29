import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Samples for the SimpleHashMap lab
 */
public class SimpleHashMap
{
    private class KeyValueTuple {
        public Object value;
        public String key;
    }
    public int capacity;
    private ArrayList<LinkedList<KeyValueTuple>> dataStore;

    public SimpleHashMap(int capacity) {
        this.dataStore = new ArrayList<LinkedList<KeyValueTuple>>(capacity);
        this.dataStore.ensureCapacity(capacity);
        this.capacity = capacity;

        for (int i = 0; i < capacity; i++){
            LinkedList<KeyValueTuple> empty_list = new LinkedList<KeyValueTuple>();
            this.dataStore.add(i, empty_list);
        }

    }

    public Object put(String key, Object value)
    {
        // TODO:
        // * Get the hash value of the key
        // * Insert the key/value tuple in the linked list at the desired index in the data store
        // * If something in that spot already exists, add it at the end of the linked list
        // * Return the value
        int hash = key.hashCode();
        int index = Math.abs(hash % this.capacity);
        KeyValueTuple tuple = new KeyValueTuple();
        tuple.value = value;
        tuple.key = key;
        /*
        if (dataStore.get(index) != null) {
            dataStore.set(index, new LinkedList<KeyValueTuple>());
        }
          */
        dataStore.get(index).add(tuple);

        return value;
    }

    public Object get(String key)
    {
        // TODO:
        // * Get the hash value of the key
        // * Look for the desired key in the LinkedList at the appropriate index
        // * Return the value
        int index = Math.abs(key.hashCode() % this.capacity);
        LinkedList<KeyValueTuple> list = dataStore.get(index);
        //KeyValueTuple x = list.getFirst();
        for (KeyValueTuple t : list) {
            if (t.key == key){
                return t.value;
            }
        }
        return null;
    }

    public Object remove(String key)
    {
        // TODO:
        // * Get the hash value of the key
        // * Remove the key/value tuple in the linked list at the appropriate index in the data store
        // * Return the value
        int index = Math.abs(key.hashCode() % this.capacity);
        LinkedList<KeyValueTuple> list = dataStore.get(index);
        for (KeyValueTuple t : list) {
            if (t.key == key){
                Object val =  t.value;
                list.remove(t);
                return val;
            }
        }
        return null;
    }

    /*
     * Debugging Helpers
     */

    /**
     * Prints out each bucket in the tree. Use for debugging purposes.
     */
    public void print()
    {
        for (LinkedList<KeyValueTuple> keysAndValues : this.dataStore)
        {
            System.out.println("Bin #" + this.dataStore.indexOf(keysAndValues));
            for (KeyValueTuple keyValueTuple : keysAndValues)
            {
                System.out.println("Key: " + keyValueTuple.key + ", Value: " + keyValueTuple.value);
            }
        }
    }

    public Collection<String> keySet()
    {
        ArrayList<String> keys = new ArrayList<String>();
        for (LinkedList<KeyValueTuple> keysAndValues : this.dataStore)
        {
            for (KeyValueTuple keyValueTuple : keysAndValues)
            {
                keys.add(keyValueTuple.key);
            }
        }
        return keys;
    }

    public Collection<Object> valueSet()
    {
        ArrayList<Object> values = new ArrayList<Object>();
        for (LinkedList<KeyValueTuple> keysAndValues : this.dataStore)
        {
            for (KeyValueTuple keyValueTuple : keysAndValues)
            {
                values.add(keyValueTuple.value);
            }
        }
        return values;
    }
}
