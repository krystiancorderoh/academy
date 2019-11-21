package com.softtek.academy.jpa.domain.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ITEM")
public class ItemEntity {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name= "description")
    private String description;
	
	@Column(name= "features")
    private String features;

	@Column(name= "uom_id")
    private String uom;

	@Column(name= "unit_price")
    private Double unitPrice;

	@Column(name= "image_path")
    private String imagePath;

	@Column(name= "stock")
    private Long stock;
	
	@Column(name= "active")
    private String active;

//    @JsonView(DataViews.Full.class)
//    private List<CategoryEntity> categories;


	public ItemEntity() {
		
	}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

   

    public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "ItemEntity [id=" + id + ", description=" + description + ", features=" + features + ", uom=" + uom
				+ ", unitPrice=" + unitPrice + ", imagePath=" + imagePath + ", stock=" + stock + ", active=" + active
				+ "]";
	}

//	public List<CategoryEntity> getCategories() {
//        return categories;
//    }
//
//    public void setCategories(List<CategoryEntity> categories) {
//        this.categories = categories;
//    }

   


}
