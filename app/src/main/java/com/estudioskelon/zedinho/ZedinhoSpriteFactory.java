package com.estudioskelon.zedinho;

import android.content.res.Resources;
import android.graphics.Point;

public class ZedinhoSpriteFactory {


    public static final String PELOTA = "PELOTA";
    public static final String CONO = "CONO";
    public static final String VALLA = "VALLA";
    public static final String T1 = "T1";
    public static final String T2 = "T2";

    private enum SpriteSwatch {
        PELOTA(1, R.drawable.pelota, ZedinhoSpriteFactory.PELOTA),

        ;

        SpriteSwatch(int value, int image, String tag) {

        }
    }

    private Resources mResources;

    public ZedinhoSpriteFactory(Resources r) {
        this.mResources = r;
    }

    public ZedinhoSprite getSprite(String spriteType) {
        if (spriteType.isEmpty() || spriteType.equals("")) {
            return null;
        } else if (spriteType.equalsIgnoreCase(PELOTA)) {
            return new ZedinhoSprite(mResources, R.drawable.pelota, PELOTA, 10, 10);
        } else if (spriteType.equalsIgnoreCase(CONO)) {
            return new ZedinhoSprite(mResources, R.drawable.cono, CONO, 10, 10);
        } else if (spriteType.equalsIgnoreCase(VALLA)) {
            return new ZedinhoSprite(mResources, R.drawable.valla, VALLA, 10, 10);
        } else if (spriteType.equalsIgnoreCase(T1)) {
            return new ZedinhoSprite(mResources, R.drawable.t1, T1, 10, 10);
        } else if (spriteType.equalsIgnoreCase(T2)) {
            return new ZedinhoSprite(mResources, R.drawable.t2, T2, 10, 10);
        }
        return null;
    }

    public ZedinhoSprite getSprite(String spriteType, int x, int y) {
        if (spriteType.isEmpty() || spriteType.equals("")) {
            return null;
        } else if (spriteType.equalsIgnoreCase(PELOTA)) {
            return new ZedinhoSprite(mResources, R.drawable.pelota, PELOTA, x, y);
        } else if (spriteType.equalsIgnoreCase(CONO)) {
            return new ZedinhoSprite(mResources, R.drawable.cono, CONO, x, y);
        } else if (spriteType.equalsIgnoreCase(VALLA)) {
            return new ZedinhoSprite(mResources, R.drawable.valla, VALLA, x, y);
        } else if (spriteType.equalsIgnoreCase(T1)) {
            return new ZedinhoSprite(mResources, R.drawable.t1, T1, x, y);
        } else if (spriteType.equalsIgnoreCase(T2)) {
            return new ZedinhoSprite(mResources, R.drawable.t2, T2, x, y);
        }
        return null;
    }

    public ZedinhoSprite getSprite(String spriteType, Point p) {
        if (spriteType.isEmpty() || spriteType.equals("")) {
            return null;
        } else if (spriteType.equalsIgnoreCase(PELOTA)) {
            return new ZedinhoSprite(mResources, R.drawable.pelota, PELOTA, p.x, p.y);
        } else if (spriteType.equalsIgnoreCase(CONO)) {
            return new ZedinhoSprite(mResources, R.drawable.cono, CONO, p.x, p.y);
        } else if (spriteType.equalsIgnoreCase(VALLA)) {
            return new ZedinhoSprite(mResources, R.drawable.valla, VALLA, p.x, p.y);
        } else if (spriteType.equalsIgnoreCase(T1)) {
            return new ZedinhoSprite(mResources, R.drawable.t1, T1, p.x, p.y);
        } else if (spriteType.equalsIgnoreCase(T2)) {
            return new ZedinhoSprite(mResources, R.drawable.t2, T2, p.x, p.y);
        }
        return null;
    }
}
