package dataset;

public interface Dataset {
    public void addChangeListener(DatasetChangeListener listener);
    public void removeChangeListener(DatasetChangeListener listener);
    public Group getGroup();
    public void setGroup(Group group);
}
