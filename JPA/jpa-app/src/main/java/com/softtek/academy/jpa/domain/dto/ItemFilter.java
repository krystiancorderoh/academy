package com.softtek.academy.jpa.domain.dto;

/**
 * @author jorge.gonzalezm
 *
 */
public class ItemFilter {

    private String description;

    private String uomId;

    private NumericRange<Double> unitPrice;

    private boolean outOfStock;

    private Long categoryId;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUomId() {
        return uomId;
    }

    public void setUomId(String uomId) {
        this.uomId = uomId;
    }

    public NumericRange<Double> getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(NumericRange<Double> unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(boolean outOfStock) {
        this.outOfStock = outOfStock;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }


    @Override
    public String toString() {
        return String.format("ItemFilter [description=%s, uomId=%s, unitPrice=%s, outOfStock=%s, categoryId=%s]", description, uomId,
                unitPrice, outOfStock, categoryId);
    }

}
