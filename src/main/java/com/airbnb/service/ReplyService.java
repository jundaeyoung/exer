package com.airbnb.service;

import com.airbnb.dao.ReplyDAO;
import com.airbnb.dto.ReplyDTO;

public class ReplyService {

	private ReplyDAO replyDAO;
	public ReplyService() {
		replyDAO = new ReplyDAO();
		
	}
	public ReplyDTO comentCount(int home_id) {
		ReplyDTO resultDTO = replyDAO.count(home_id);
		return resultDTO;
	}
	public ReplyDTO ratingCount(int home_id) {
		ReplyDTO resultDTO = replyDAO.rating(home_id);
		return resultDTO;
	}
}
