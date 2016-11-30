package com.etoak.bbs.po.user;

import java.io.Serializable;

/**
 * 
 * @ClassName: EtoakUserVo
 * @Description: 用户类
 * @author 刘林
 * @date 2016年11月25日 上午11:10:59
 *
 */
public class EtoakUserPo implements Serializable {

	// 持久化对象
	private static final long serialVersionUID = -5989578764898804808L;

	private String username; // 用户名
	private String password; // 用户密码
	private String gender; // 性别
	private String phone; // 电话
	private String etoakNo; // 易途学员编号
	private String age; // 年龄

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEtoakNo() {
		return etoakNo;
	}

	public void setEtoakNo(String etoakNo) {
		this.etoakNo = etoakNo;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "EtoakUserVo [username=" + username + ", password=" + password + ", gender=" + gender + ", phone="
				+ phone + ", etoakNo=" + etoakNo + ", age=" + age + "]";
	}

}
