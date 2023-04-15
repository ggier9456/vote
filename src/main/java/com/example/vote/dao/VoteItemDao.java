package com.example.vote.dao;

import com.example.vote.model.VoteItem;
import com.example.vote.model.VoteLog;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface VoteItemDao {

    List<VoteItem> getAllItem();
    String insertVote(VoteLog voteLog);
    String insertVoteItem(String voteItemName);

    String deleteVoteItem(Integer voteItemId);
}
