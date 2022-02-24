/**
 * @author ${Josiah Anderson} - janderson78@dmacc.edu
 * CIS175 - Fall 2021
 * ${2/17/2022}
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Table(name="gunInfo")
public class gunInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="gun_id")
	private int gunId;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "gun_id")
	private guns gun;
	
	@Column(name="AMMUNITION")
	private String ammo;
	
	public gunInfo() {
		super();
	}
	
	public gunInfo(guns gun, String ammo) {
		super();
		this.gun = gun;
		this.ammo = ammo;
	}
	
	public void setId(int ID) {
		this.gunId = ID;
	}
	public int getId() {
		return this.gunId;
	}
	
	public void setGun(guns gun) {
		this.gun = gun;
	}
	public guns getGun() {
		return this.gun;
	}
	
	public void setAmmo(String ammo) {
		this.ammo = ammo;
	}
	public String getAmmo() {
		return this.ammo;
	}
	
	public String gunInfoDisplay() {
		return getGun().gunDetails() + ", " + getAmmo();
	}
}
