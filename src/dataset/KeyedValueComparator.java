package dataset;

import java.util.Comparator;

public class KeyedValueComparator implements Comparator<KeyedValues4Sort> {

    private KeyedValueComparatorType type;

    private SortOrder order;
    
    public KeyedValueComparator(KeyedValueComparatorType type, SortOrder order) {
        if(order==null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        this.type = type;
        this.order = order;
    }
    
    public KeyedValueComparatorType getType() {
        return this.type;
    }
    
    public SortOrder getOrder() {
        return this.order;
    }
    
    public int compare(KeyedValues4Sort keyedValues4Sort1, KeyedValues4Sort keyedValues4Sort2) {

        if(keyedValues4Sort2 ==null) {
            return -1;
        }
        
        if(keyedValues4Sort1 ==null) {
            return 1;
        }

        int result;

        if(this.type==KeyedValueComparatorType.BY_KEY) {
            if (this.order.equals(SortOrder.ASCENDING)) {
                result = keyedValues4Sort1.k().compareTo(keyedValues4Sort2.k());
            } else if (this.order.equals(SortOrder.DESCENDING)) {
                result = keyedValues4Sort2.k().compareTo(keyedValues4Sort1.k());
            } else {
                throw new IllegalArgumentException("Unrecognised sort order.");
            }
        } else if(this.type==KeyedValueComparatorType.BY_VALUE) {
            Number n1 = keyedValues4Sort1.v();
            Number n2 = keyedValues4Sort2.v();
            if(n2==null) {
                return -1;
            }
            if(n1==null) {
                return 1;
            }
            double d1 = n1.doubleValue();
            double d2 = n2.doubleValue();
            if(this.order.equals(SortOrder.ASCENDING)) {
                if(d1>d2) {
                    result = 1;
                } else if(d1<d2) {
                    result = -1;
                } else {
                    result = 0;
                }
            } else if(this.order.equals(SortOrder.DESCENDING)) {
                if(d1>d2) {
                    result = -1;
                } else if(d1<d2) {
                    result = 1;
                } else {
                    result = 0;
                }
            } else {
                throw new IllegalArgumentException("Unrecognised sort order.");
            }
        } else {
            throw new IllegalArgumentException("Unrecognised type.");
        }

        return result;
    }

}
