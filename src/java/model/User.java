package model;

public class User {
	private int id_User;     
	private String nickname;
	private String email;
	private String password;
        private int permission;
        
        public void setId_User(int id_User) {
            this.id_User = id_User;
        }
        public int getPermission() {
            return permission;
        }
        public void setPermission(int permission) {
            this.permission = permission;
        }	
	public int getId_Usuario() {
		return id_User;
	} 
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nick) {
		this.nickname = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String senha) {
		this.password = senha;
	}
}
