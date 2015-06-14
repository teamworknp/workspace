package com.project;

import java.util.Comparator;
import java.util.List;

public class HotelInfo {

	private String name;
	private int id;
	private String url;
	private String desc;
	private String img;
	private int score;
	List<HotelService> services;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public List<HotelService> getServices() {
		return services;
	}
	public void setServices(List<HotelService> services) {
		this.services = services;
	}
	
	/**
     * Comparator to sort hotel list or array in order of Score
     */
    public static Comparator<HotelInfo> ScoreComparator = new Comparator<HotelInfo>() {
 
        @Override
        public int compare(HotelInfo e1, HotelInfo e2) {
            return (int) (e2.getScore() - e1.getScore());
        }
    };
    
    /**
     * Comparator to sort hotel list or array in order of name
     */
    public static Comparator<HotelInfo> nameComparator = new Comparator<HotelInfo>() {
 
        @Override
        public int compare(HotelInfo e1, HotelInfo e2) {
            return (int) (e2.getName().compareTo(e1.getName()));
        }
    };
    
	@Override
	public String toString() {
		return "HotelInfo [name=" + name + ", id=" + id + ", url=" + url
				+ ", desc=" + desc + ", img=" + img + ", score=" + score
				+ ", services=" + services + "]";
	}
}
