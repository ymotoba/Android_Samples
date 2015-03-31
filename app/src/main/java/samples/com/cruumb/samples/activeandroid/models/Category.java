package samples.com.cruumb.samples.activeandroid.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

import java.util.List;

public class Category extends Model {
    @Column(name = "Name")
    public String name;

    public List<Item> items() {
        return getMany(Item.class, "Category");
    }
}
