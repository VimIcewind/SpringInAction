package com.vimemacs.springidol;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by HWD on 2017/5/31.
 */
@Component
@Aspect
public class ContestantIntroducer {
    @DeclareParents(value="com.vimemacs.springidol.Performer+", defaultImpl = GraciousContestant.class)
    public static Contestant contestant;
}
