package company.items.model;

public class Ztree {
    private Integer id;

	private Integer pid;

	private String name;

	private String checked;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	

	@Override
	public String toString() {
		return "Ztree [id=" + id + ", pid=" + pid + ", name=" + name + ", checked=" + checked + "]";
	}
    
}