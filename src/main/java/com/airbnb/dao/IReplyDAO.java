package com.airbnb.dao;

import java.util.ArrayList;

import com.airbnb.dto.ReplyDTO;

public interface IReplyDAO {
	ArrayList<ReplyDTO> select(int home_id);
	int insert(String user_id, int home_id,String content, int rating);
	int update(int id, String user_id, int home_id,String content);
	int delete(String user_id, int id);
	ReplyDTO count(int home_id);
	ReplyDTO rating(int home_id);
}
