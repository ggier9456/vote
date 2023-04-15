package com.example.vote.model;

public class VoteItem {

    private Integer voteId;
    private String voteItemName;
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public String getVoteItemName() {
        return voteItemName;
    }

    public void setVoteItemName(String voteItemName) {
        this.voteItemName = voteItemName;
    }
}
