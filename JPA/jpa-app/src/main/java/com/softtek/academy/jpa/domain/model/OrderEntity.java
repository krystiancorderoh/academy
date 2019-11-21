package com.softtek.academy.jpa.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class OrderEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name= "cart_id")
	private Long cartId;
	
	@Column(name="ship_to_id")
	private Long shipToId;
	
	@Column(name="coupon_id")
	private Long couponId;
	
	@Column(name="order_date")
	private LocalDateTime orderDate;
		
	@Column(name="schedule_date")
	private LocalDateTime scheduleDate;
		
	@Column(name="delivery_date")
	private LocalDateTime deliveryDate;
	
	@Column(name="cancel_date")
	private LocalDateTime cancelDate;
		
	@Column(name="lines_amount")
	private Double linesAmount;
		
	@Column(name="shipping_amount")
	private Double shippingAmount;
	
	@Column(name="coupon_amount")
	private Double couponAmount;
	
	@Column(name="order_amount")
	private Double orderAmount;
	
	@Column(name="payment_method_id")
	private String paymentMethodId;
	
	@Column(name="payment_reference")
	private String paymentReference;
	
	@Column(name="notes")
	private String notes;
	
	@Column(name="status_id")
	private Long statusId;
	
	@Column(name="create_user")
	private String createUser;
	
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	@Column(name="update_user")
	private String updateUser;
	
	@Column(name="update_date")
	private LocalDateTime updateDate;
	
	public OrderEntity() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getShipToId() {
		return shipToId;
	}

	public void setShipToId(Long shipToId) {
		this.shipToId = shipToId;
	}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDateTime getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(LocalDateTime scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public LocalDateTime getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(LocalDateTime cancelDate) {
		this.cancelDate = cancelDate;
	}

	public Double getLinesAmount() {
		return linesAmount;
	}

	public void setLinesAmount(Double linesAmount) {
		this.linesAmount = linesAmount;
	}

	public Double getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(Double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public Double getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(Double couponAmount) {
		this.couponAmount = couponAmount;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", cartId=" + cartId + ", shipToId=" + shipToId + ", couponId=" + couponId
				+ ", orderDate=" + orderDate + ", scheduleDate=" + scheduleDate + ", deliveryDate=" + deliveryDate
				+ ", cancelDate=" + cancelDate + ", linesAmount=" + linesAmount + ", shippingAmount=" + shippingAmount
				+ ", couponAmount=" + couponAmount + ", orderAmount=" + orderAmount + ", paymentMethodId="
				+ paymentMethodId + ", paymentReference=" + paymentReference + ", notes=" + notes + ", statusId="
				+ statusId + ", createUser=" + createUser + ", createDate=" + createDate + ", updateUser=" + updateUser
				+ ", updateDate=" + updateDate + "]";
	}

	
	
	
}
