package com.gohsdk.utils;

import android.content.Context;

import com.gohsdk.GohBaseApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceUtil {

    public static int getResourceId(final String name, final String defType) {
        Context context = GohBaseApplication.getContext();
        return context.getResources().getIdentifier(name, defType, context.getPackageName());
    }

    public static int getAnimId(final String name) {
        return getResourceId(name, "anim");
    }

    public static int getAnimatorId(final String name) {
        return getResourceId(name, "animator");
    }

    public static int getAttrId(final String name) {
        return getResourceId(name, "attr");
    }

    public static int getBoolId(final String name) {
        return getResourceId(name, "bool");
    }

    public static int getColorId(final String name) {
        return getResourceId(name, "color");
    }

    public static int getDimenId(final String name) {
        return getResourceId(name, "dimen");
    }

    public static int getDrawableId(final String name) {
        return getResourceId(name, "drawable");
    }

    public static int getViewId(final String name) {
        return getResourceId(name, "id");
    }

    public static int getIntegerId(final String name) {
        return getResourceId(name, "integer");
    }

    public static int getInterpolatorId(final String name) {
        return getResourceId(name, "interpolator");
    }

    public static int getLayoutId(final String name) {
        return getResourceId(name, "layout");
    }

    public static int getMipmapId(final String name) {
        return getResourceId(name, "mipmap");
    }

    public static int getPluralsId(final String name) {
        return getResourceId(name, "plurals");
    }

    public static int getStringId(final String name) {
        return getResourceId(name, "string");
    }

    public static int getStyleId(final String name) {
        return getResourceId(name, "style");
    }

    public static int getStyleableId(final String name) {
        return getResourceId(name, "styleable");
    }

    public static int getXmlId(final String name) {
        return getResourceId(name, "xml");
    }

    public static String readAssets2String(final String assetsFilePath) {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            inputStream = GohBaseApplication.getContext().getAssets().open(assetsFilePath);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
