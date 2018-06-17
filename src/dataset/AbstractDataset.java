package dataset;

import javax.swing.event.EventListenerList;
import java.io.*;
import java.util.Arrays;
import java.util.EventListener;

public abstract class AbstractDataset implements Dataset, Serializable, ObjectInputValidation {

    private static final long serialVersionUID = -201205011208L;

    private Group group;

    private transient EventListenerList listenerList;

    protected AbstractDataset() {
        this.group = new Group();
        this.listenerList = new EventListenerList();
    }

    public Group getGroup() {
        return this.group;
    }

    public void setGroup(Group group) {
        if(group==null) {
            throw new IllegalArgumentException("Null 'group' argument.");
        }
        this.group = group;
    }

    public void addChangeListener(DatasetChangeListener listener) {
        this.listenerList.add(DatasetChangeListener.class, listener);
    }

    public void removeChangeListener(DatasetChangeListener listener) {
        this.listenerList.remove(DatasetChangeListener.class, listener);
    }

    public boolean hasListener(EventListener listener) {
        return Arrays.asList(this.listenerList.getListenerList()).contains(listener);
    }

    protected void fireDatasetChanged() {
        notifyListeners(new DatasetChangeEvent(this, this));
    }

    protected void notifyListeners(DatasetChangeEvent event) {
        Object[] listeners = this.listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == DatasetChangeListener.class) {
                ((DatasetChangeListener) listeners[i + 1]).datasetChanged(event);
            }
        }

    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.listenerList = new EventListenerList();
        stream.registerValidation(this, 10);
    }

    public void validateObject() throws InvalidObjectException {
        fireDatasetChanged();
    }

}
