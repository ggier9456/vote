package com.example.vote.dao;

import com.example.vote.mapper.VoteItemRowMapper;
import com.example.vote.model.VoteItem;
import com.example.vote.model.VoteLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class VoteItemDaoImpl implements VoteItemDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<VoteItem> getAllItem() {
        String sql ="CALL read_vote();";
        Map<String, Objects> map= new HashMap<>();
        List<VoteItem> list=namedParameterJdbcTemplate.query(sql, map, new VoteItemRowMapper());
        if (list.size()>0){
            return list;
        }else{
            return null;
        }
    }
    @Override
    public String insertVote(VoteLog voteLog){
        String sql ="CALL insert_vote(:voteName, :voteId)";
        Map<String, Object> map = new HashMap<>();
        map.put("voteName", voteLog.getVoteName());
        map.put("voteId", voteLog.getVoteId());
        namedParameterJdbcTemplate.update(sql, map);
        return "ok";
    }

    @Override
    public String insertVoteItem(String voteItemName) {
        String sql = "CALL insert_vote_item(:voteItemName)";
        Map<String,String> map = new HashMap<>();
        map.put("voteItemName", voteItemName);
        namedParameterJdbcTemplate.update(sql, map);
        return "ok";
    }

    @Override
    public String deleteVoteItem(Integer voteItemId) {
        String sql = "CALL del_vote_item(:voteItemId)";
        Map<String, Integer> map = new HashMap<>();
        map.put("voteItemId", voteItemId);
        namedParameterJdbcTemplate.update(sql, map);
        return "ok";
    }
}
