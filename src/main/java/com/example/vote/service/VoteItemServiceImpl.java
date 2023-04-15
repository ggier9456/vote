package com.example.vote.service;

import com.example.vote.dao.VoteItemDao;
import com.example.vote.model.VoteItem;
import com.example.vote.model.VoteLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class VoteItemServiceImpl implements VoteItemService{

    @Autowired
    private VoteItemDao voteItemDao;

    @Override
    public List<VoteItem> getAllItem() {
        return voteItemDao.getAllItem();
    }

    @Override
    public String insertVote(VoteLog voteLog){
        return voteItemDao.insertVote(voteLog);
    }

    @Override
    public String insertVoteItem(String voteItemName) {
        return voteItemDao.insertVoteItem(voteItemName);
    }

    @Override
    public String deleteVoteItem(Integer voteItemId) {
        return voteItemDao.deleteVoteItem(voteItemId);
    }
}
