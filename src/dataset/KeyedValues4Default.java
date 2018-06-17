package dataset;

import java.util.List;

public interface KeyedValues4Default extends Values4Default {
    public String getRowKey(int row);
    public int getRowIndex(String key);
    public List<String> getRowKeys();
    public String getColumnKey(int column);
    public int getColumnIndex(String key);
    public List<String> getColumnKeys();
    public Number getValue(String rowKey, String columnKey);
}
