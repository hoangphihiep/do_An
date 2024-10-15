package vn.iotstar.models;

import java.io.Serializable;

public class CheckboxModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private boolean checked;
    private String label;
    
	public CheckboxModel(String label) {
		super();
		this.checked = false;
        this.label = label;
	}
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
