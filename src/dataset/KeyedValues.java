package dataset;

import java.util.List;

public interface KeyedValues extends Values {
    public String getKey(int index);
    public int getIndex(String key);
    public List<String> getKeys();
    public Number getValue(String key);
}
