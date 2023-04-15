package com.example.vote.controller;


import com.example.vote.model.VoteItem;
import com.example.vote.model.VoteLog;
import com.example.vote.service.VoteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class VoteController {

    @Autowired
    private VoteItemService voteItemService;

    @GetMapping("/vote")
    public String voteweb(Model model){
    List<VoteItem> list=voteItemService.getAllItem();
    model.addAttribute("voteItem",list);

        return "vote";
    }
    @PostMapping("/vote")
    public String get(@RequestParam("voteName") String voteName,
                      @RequestParam(value = "voteItemList",required=false) List<Integer> vodeIdList, Model model) {
        if (voteName.equals("")) {
            model.addAttribute("voteName", "null");
            List<VoteItem> list = voteItemService.getAllItem();
            model.addAttribute("voteItem", list);
            return "vote";
        } else if (vodeIdList == null) {
            model.addAttribute("voteItemId", "null");
            List<VoteItem> list = voteItemService.getAllItem();
            model.addAttribute("voteItem", list);
            return "vote";
        } else {
            VoteLog voteLog = new VoteLog();
            voteLog.setVoteName(voteName);
            for (int i = 0; i < vodeIdList.size(); i++) {
                voteLog.setVoteId(vodeIdList.get(i));
                voteItemService.insertVote(voteLog);
            }
            List<VoteItem> list = voteItemService.getAllItem();
            model.addAttribute("voteItem", list);
            model.addAttribute("insertOk", voteLog.getVoteId());
            return "vote";
        }
    }

    @GetMapping("voteBackstage")
    public String voteBackstage(Model model){
        List<VoteItem> list= voteItemService.getAllItem();
        model.addAttribute("voteItem", list);
        return "voteBackstage";
    }


    @PostMapping("/voteBackstage")
    public String insertvoteItem(@RequestParam("voteItemName") String voteItemName, Model model){
        if(voteItemName.equals("")){
            model.addAttribute("insertName", "null");
            List<VoteItem> list= voteItemService.getAllItem();
            model.addAttribute("voteItem", list);
            return "voteBackstage";
        }else{
            voteItemService.insertVoteItem(voteItemName);
            List<VoteItem> list= voteItemService.getAllItem();
            model.addAttribute("voteItem", list);
            model.addAttribute("insertOk","ok");
            return "voteBackstage";
        }
    }

    @GetMapping("/voteBackstage/del")
    public String del_item(@RequestParam(name = "delId") Integer voteItemId, Model model){
        voteItemService.deleteVoteItem(voteItemId);
        List<VoteItem> list= voteItemService.getAllItem();
        model.addAttribute("voteItem", list);
        return "voteBackstage";
    }
}
