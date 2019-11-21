package com.softtek.academy.jpa.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.softtek.academy.jpa.util.serializer.JsonDateTimeDeserializer;
import com.softtek.academy.jpa.util.serializer.JsonDateTimeSerializer;

@Entity
@Table(name = "CART")
public class CartEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id")
    private String userId;

	@Column(name = "lines_amount")
    private Double linesAmount;
    
	@OneToMany(mappedBy = "cart", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartLineEntity> cartLines;

	@Column(name = "status_id")
    private Long statusId;
	
	@Column(name = "create_user")
	private String createUser;
	
	


	
    
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @Column(name = "create_date")
    private Date createDate;


    public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getLinesAmount() {
        return this.linesAmount;
    }

    public void setLinesAmount(Double linesAmount) {
        this.linesAmount = linesAmount;
    }

   
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return String.format("CartEntity [id=%s, userId=%s, linesAmount=%s, status=%s, createUser=%s, createDate=%s]",
                id, userId, linesAmount, statusId, createUser, createDate);
    }

	public List<CartLineEntity> getCartLines() {
		return cartLines;
	}

	public void setCartLines(List<CartLineEntity> cartLines) {
		this.cartLines = cartLines;
	}

}
