package com.gr.qrapi.ws.skeleton;

import java.util.ArrayList;
import java.util.List;

public class Click_Stat_Model {
	List<String> labelList = new ArrayList<>();
	List<Integer> dataList = new ArrayList<>();

	public List<String> getLabelList() {
		return labelList;
	}

	public void setLabelList(List<String> labelList) {
		this.labelList = labelList;
	}

	public List<Integer> getDataList() {
		return dataList;
	}

	public void setDataList(List<Integer> dataList) {
		this.dataList = dataList;
	}

}
