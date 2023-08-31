package Model;

import Dto.AddToCartDto;
import Dto.CartDto;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cart")


public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

    @Column(name = "user_id")
   private Integer userId;

    @Column(name = "product_id")
   private long productId;
    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
   private Product product;

   private int quantity;


    public Cart(){

    }

   public Cart(AddToCartDto addToCartDto, int userId){

   }

   public Cart(CartDto cartDto, Product product, int userId){
       this.userId = userId;
       this.product = product;
       this.createdDate = new Date();
   }

   public Cart(Integer userId, long productId, int quantity){

       this.userId = userId;
       this.productId = productId;
       this.createdDate = new Date();
       this.quantity = quantity;
   }
   public Cart(CartDto cartDto, Product product){
       this.quantity = cartDto.getQuantity();
       this.product = product;
       this.createdDate = new Date();
   }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
