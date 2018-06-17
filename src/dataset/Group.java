package dataset;

import java.io.Serializable;

public class Group implements Serializable {

    private static final long serialVersionUID = -201205011211L;

    private String id;
    public Group() {
        super();
        this.id = "NOID";
    }

    public Group(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Null 'id' argument.");
        }
        this.id = id;
    }

    public String getID() {
        return this.id;
    }

    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Group)) {
            return false;
        }
        Group that = (Group) obj;
        if(!this.id.equals(that.id)) {
            return false;
        }
        return true;
    }
}
