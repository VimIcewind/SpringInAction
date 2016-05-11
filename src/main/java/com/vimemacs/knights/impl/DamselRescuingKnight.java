package com.vimemacs.knights.impl;

import com.vimemacs.exception.QuestException;
import com.vimemacs.knights.Knight;
import com.vimemacs.quests.impl.RescueDamselQuest;

/**
 * Created by HWD on 2016/5/11.
 */
public class DamselRescuingKnight implements Knight {
    private RescueDamselQuest quest;

    public DamselRescuingKnight() {
        quest = new RescueDamselQuest(); // 与 RescueDamselQuest 紧耦合
    }

    public void embarkOnQuest() throws QuestException {
        quest.embark();
    }
}

