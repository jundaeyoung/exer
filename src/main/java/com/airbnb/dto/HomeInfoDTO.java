package com.airbnb.dto;

public class HomeInfoDTO {

	String title;
	String location;
	String image1;
	String image2;
	String image3;
	String image4;
	String image5;
	String host;
	String info;
	String sideimage1;
	String sideInfo1;
	String sideInfo1_1;
	String sideimage2;
	String sideInfo2;
	String sideInfo2_1;
	String sideimage3;
	String sideInfo3;
	String sideInfo3_1;
	int home_id;

	
	
	public int getHome_id() {
		return home_id;
	}

	public void setHome_id(int home_id) {
		this.home_id = home_id;
	}

	public String getSideInfo1_1() {
		return sideInfo1_1;
	}

	public void setSideInfo1_1(String sideInfo1_1) {
		this.sideInfo1_1 = sideInfo1_1;
	}

	public String getSideInfo2_1() {
		return sideInfo2_1;
	}

	public void setSideInfo2_1(String sideInfo2_1) {
		this.sideInfo2_1 = sideInfo2_1;
	}

	public String getSideInfo3_1() {
		return sideInfo3_1;
	}

	public void setSideInfo3_1(String sideInfo3_1) {
		this.sideInfo3_1 = sideInfo3_1;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getImage5() {
		return image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getSideimage1() {
		return sideimage1;
	}

	public void setSideimage1(String sideimage1) {
		this.sideimage1 = sideimage1;
	}

	public String getSideInfo1() {
		return sideInfo1;
	}

	public void setSideInfo1(String sideInfo1) {
		this.sideInfo1 = sideInfo1;
	}

	public String getSideimage2() {
		return sideimage2;
	}

	public void setSideimage2(String sideimage2) {
		this.sideimage2 = sideimage2;
	}

	public String getSideInfo2() {
		return sideInfo2;
	}

	public void setSideInfo2(String sideInfo2) {
		this.sideInfo2 = sideInfo2;
	}

	public String getSideimage3() {
		return sideimage3;
	}

	public void setSideimage3(String sideimage3) {
		this.sideimage3 = sideimage3;
	}

	public String getSideInfo3() {
		return sideInfo3;
	}

	public void setSideInfo3(String sideInfo3) {
		this.sideInfo3 = sideInfo3;
	}


	public HomeInfoDTO(String title, String location, String image1, String image2, String image3, String image4,
			String image5, String host, String info, String sideimage1, String sideInfo1, String sideInfo1_1,
			String sideimage2, String sideInfo2, String sideInfo2_1, String sideimage3, String sideInfo3,
			String sideInfo3_1, int home_id) {
		super();
		this.title = title;
		this.location = location;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		this.host = host;
		this.info = info;
		this.sideimage1 = sideimage1;
		this.sideInfo1 = sideInfo1;
		this.sideInfo1_1 = sideInfo1_1;
		this.sideimage2 = sideimage2;
		this.sideInfo2 = sideInfo2;
		this.sideInfo2_1 = sideInfo2_1;
		this.sideimage3 = sideimage3;
		this.sideInfo3 = sideInfo3;
		this.sideInfo3_1 = sideInfo3_1;
		this.home_id = home_id;
	}
	
	
	@Override
	public String toString() {
		return "HomeInfoDTO [title=" + title + ", location=" + location + ", image1=" + image1 + ", image2=" + image2
				+ ", image3=" + image3 + ", image4=" + image4 + ", image5=" + image5 + ", host=" + host + ", info="
				+ info + ", sideimage1=" + sideimage1 + ", sideInfo1=" + sideInfo1 + ", sideInfo1_1=" + sideInfo1_1
				+ ", sideimage2=" + sideimage2 + ", sideInfo2=" + sideInfo2 + ", sideInfo2_1=" + sideInfo2_1
				+ ", sideimage3=" + sideimage3 + ", sideInfo3=" + sideInfo3 + ", sideInfo3_1=" + sideInfo3_1
				+ ", home_id=" + home_id + "]";
	}

	public HomeInfoDTO() {
		// TODO Auto-generated constructor stub
	}

	

}
