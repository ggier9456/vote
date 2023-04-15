package com.example.vote.mapper;


import com.example.vote.model.VoteItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VoteItemRowMapper implements RowMapper<VoteItem>{

    @Override
    public VoteItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        VoteItem voteItem = new VoteItem();
        voteItem.setVoteId(rs.getInt("voteId"));
        voteItem.setVoteItemName(rs.getString("voteItemName"));
        voteItem.setCount(rs.getInt("collect"));
        return voteItem;
    }
}
