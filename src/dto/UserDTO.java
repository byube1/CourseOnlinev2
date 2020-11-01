package dto;

public class UserDTO {
	private String id,email,pass,name,img,phone,resgisterDate;
	private int type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getResgisterDate() {
		return resgisterDate;
	}
	public void setResgisterDate(String resgisterDate) {
		this.resgisterDate = resgisterDate;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", email=" + email + ", pass=" + pass + ", name=" + name + ", img=" + img
				+ ", phone=" + phone + ", resgisterDate=" + resgisterDate + ", type=" + type + "]";
	}
	
	

}
