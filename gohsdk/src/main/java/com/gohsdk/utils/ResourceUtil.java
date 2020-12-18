package com.gohsdk.utils;

import android.content.Context;

public class ResourceUtil {

    public static int getResourceId(final Context context, final String name, final String defType) {
        return context.getResources().getIdentifier(name, defType, context.getPackageName());
    }

    public static int getAnimId(final Context context, final String name) {
        return getResourceId(context, name, "anim");
    }

    public static int getAnimatorId(final Context context, final String name) {
        return getResourceId(context, name, "animator");
    }

    public static int getAttrId(final Context context, final String name) {
        return getResourceId(context, name, "attr");
    }

    public static int getBoolId(final Context context, final String name) {
        return getResourceId(context, name, "bool");
    }

    public static int getColorId(final Context context, final String name) {
        return getResourceId(context, name, "color");
    }

    public static int getDimenId(final Context context, final String name) {
        return getResourceId(context, name, "dimen");
    }

    public static int getDrawableId(final Context context, final String name) {
        return getResourceId(context, name, "drawable");
    }

    public static int getViewId(final Context context, final String name) {
        return getResourceId(context, name, "id");
    }

    public static int getIntegerId(final Context context, final String name) {
        return getResourceId(context, name, "integer");
    }

    public static int getInterpolatorId(final Context context, final String name) {
        return getResourceId(context, name, "interpolator");
    }

    public static int getLayoutId(final Context context, final String name) {
        return getResourceId(context, name, "layout");
    }

    public static int getMipmapId(final Context context, final String name) {
        return getResourceId(context, name, "mipmap");
    }

    public static int getPluralsId(final Context context, final String name) {
        return getResourceId(context, name, "plurals");
    }

    public static int getStringId(final Context context, final String name) {
        return getResourceId(context, name, "string");
    }

    public static int getStyleId(final Context context, final String name) {
        return getResourceId(context, name, "style");
    }

    public static int getStyleableId(final Context context, final String name) {
        return getResourceId(context, name, "styleable");
    }

    public static int getXmlId(final Context context, final String name) {
        return getResourceId(context, name, "xml");
    }
}
