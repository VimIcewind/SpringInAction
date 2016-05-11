package vimemacs.knights;

import com.vimemacs.exception.QuestException;
import com.vimemacs.knights.impl.BraveKnight;
import com.vimemacs.quests.Quest;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * Created by HWD on 2016/5/11.
 */
public class BraveKnightTest {
    @Test
    public void knightShouldEmbarkOnQuest() throws QuestException {
        Quest mockQuest = mock(Quest.class); // 创建 mock 的 Quest

        BraveKnight knight = new BraveKnight(mockQuest); // 注入 mock 的 Quest
        knight.embarkOnQuest();

        verify(mockQuest, times(1)).embark();
    }
}
