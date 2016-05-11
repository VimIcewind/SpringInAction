package com.vimemacs.knights.impl;

import com.vimemacs.exception.QuestException;
import com.vimemacs.knights.Knight;
import com.vimemacs.quests.Quest;

/**
 * Created by HWD on 2016/5/11.
 */
public class BraveKnight implements Knight {
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest; // Quest 被注入进来
    }

    public void embarkOnQuest() throws QuestException {
        quest.embark();
    }
}
