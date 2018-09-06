package POJO_MODEL.user_management;

public class Permission {
	private int permissionLevel;
	private String permissionType;
	
	public Permission() {}
	
	public Permission(int permissionLevel, String permissionType) {
		this.setPermissionLevel(permissionLevel);
		this.setPermissionType(permissionType);
	}
	
	public Permission(String permissionType) {
		this.setPermissionType(permissionType);
	}

	public void setPermissionLevel(int permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	public int getPermissionLevel() {
		return this.permissionLevel;
	}

	public String getPermissionType() {
		return this.permissionType;
	}
}
