package model;

public class Computer implements Comparable{
	
	private int userId;
	private String computerName;
	private String brand;
	private int id;
	private int assignedDate;
	
	public Computer() {
		
	}
	
	public Computer(int userId, String computerName, String brand, int id, int assignedDate) {
		this.userId = userId;
		this.computerName = computerName;
		this.brand = brand;
		this.id = id;
		this.assignedDate = assignedDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(int assignedDate) {
		this.assignedDate = assignedDate;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		String computer = new String (this.userId +","+this.computerName+","+this.brand+","+this.id+","+this.assignedDate);
		return computer;
	}

}
