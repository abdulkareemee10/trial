package Model;



import jakarta.persistence.*;


@Entity
@Table(name = "categories")
public class Category {

   @Id
   @GeneratedValue(strategy =  GenerationType.IDENTITY)
   private Integer id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "description")

    private  String description;




    public Category() {
    }

    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }



    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User {category id=" + id + ", category name='" + categoryName + "', description='" + description + "'}";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
