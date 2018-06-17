package dataset;

public class DatasetChangeEvent extends java.util.EventObject {

	private static final long serialVersionUID = -201204142309L;
    private Dataset dataset;
    public DatasetChangeEvent(Object source, Dataset dataset) {
        super(source);
        this.dataset = dataset;
    }
    public Dataset getDataset() {
        return this.dataset;
    }
}
