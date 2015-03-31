package samples.com.cruumb.samples.activeandroid.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Itemsテーブルのmodel
 */
@Table(name = "Items")
public class Item extends Model {
    @Column(name = "Name")
    public String name;
    @Column(name = "Category")
    public Category category;

    /**
     * コンストラクタ
     */
    public Item(){
        super();
    }

    /**
     * コンストラクタ
     * @param name
     * @param category
     */
    public Item(String name, Category category) {
        super();
        this.name = name;
        this.category = category;
    }
}
