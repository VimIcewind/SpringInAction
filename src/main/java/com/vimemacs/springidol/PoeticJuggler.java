package com.vimemacs.springidol;

import com.vimemacs.exception.PerformanceException;

/**
 * Created by HWD on 2017/5/23.
 */
public class PoeticJuggler extends Juggler {
    private Poem poem;

    public PoeticJuggler() {
    }

    public PoeticJuggler(Poem poem) {
        super();
        this.poem = poem;
    }

    public PoeticJuggler(int beanBags, Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    public void perform() throws PerformanceException {
        super.perform();
        System.out.println("While recting...");
        poem.recite();
    }

    public Poem getPoem() {
        return poem;
    }

    public void setPoem(Poem poem) {
        this.poem = poem;
    }
}
