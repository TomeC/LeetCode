package com.wkr.other;

import com.wkr.Utils;

/**
 * @author 王锟
 * @Description:
 * @date 2021/10/2922:08
 */
public class C492ConstructRectangle {
    public static void main(String[] args) {
        C492ConstructRectangle rectangle = new C492ConstructRectangle();
        Utils.checkEqual(rectangle.constructRectangle(4), new int[]{2,2});
        Utils.checkEqual(rectangle.constructRectangle(1), new int[]{1,1});
        Utils.checkEqual(rectangle.constructRectangle(2), new int[]{2,1});
        Utils.checkEqual(rectangle.constructRectangle(50), new int[]{10,5});
        Utils.checkEqual(rectangle.constructRectangle(100), new int[]{10,10});
    }

    public int[] constructRectangle(int area) {
        int width = (int)Math.sqrt(area);
        int[] grides = new int[2];
        for (int i = width; i > 0; i--) {
            if (area % i == 0) {
                grides[0] = area/i;
                grides[1] = i;
                break;
            }
        }
        return grides;
    }

}
