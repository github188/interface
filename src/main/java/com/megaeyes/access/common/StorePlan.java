package com.megaeyes.access.common;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 用于将字符串型的存储计划,转换为时间段型
 * @author lizhanjiang
 */
public class StorePlan {

    public static final int DAY = 0;//按天存储
    public static final int WEEK = 1;//按周存储
    public static final int MONTH = 2;//按月存储
    private List<RectArear> rectArearSet = new ArrayList<RectArear>();

    public StorePlan(String sPlan, int nType) {
        setStorePlan(sPlan, nType);
    }
    

    public List<String> getTimetable()
    {
        String pattern="00";
        DecimalFormat decFormate = new DecimalFormat(pattern);
        List<String> lstTimetable = new ArrayList<String>();
        for (Iterator<RectArear> it = rectArearSet.iterator(); it.hasNext();) {
            RectArear ra = it.next();
            StringBuffer sbuf = new StringBuffer(9);
            sbuf.append(decFormate.format(ra.getMinY()));//起始日期
            sbuf.append("-");
            sbuf.append(decFormate.format(ra.getMaxY()));//终止日期
            sbuf.append("@");            
            sbuf.append(decFormate.format(ra.getMinX()));//起始时间
            sbuf.append(":00:00");
            sbuf.append("-");
            sbuf.append(decFormate.format(ra.getMaxX()));//终止时间
            sbuf.append(":59:59");

            lstTimetable.add(sbuf.toString());
        }
        return lstTimetable;
    }

    private void setStorePlan(String sPlan, int nType) {
        if (sPlan == null || sPlan.length()<24) {
            return;
        }
        String[][] storePlan = null;
        switch (nType) {
            case DAY:
                storePlan = new String[1][24];
                for (int i = 0; i < 24; i++) {
                    storePlan[0][i] = String.valueOf(sPlan.charAt(i));
                }
                break;
            case WEEK:
                storePlan = new String[7][24];
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 24; j++) {
                        storePlan[i][j] = String.valueOf(sPlan.charAt(i * 24 + j));
                    }
                }
                break;
            case MONTH:
            	storePlan = new String[31][24];
                for (int i = 0; i < 31; i++) {
                    for (int j = 0; j < 24; j++) {
                        storePlan[i][j] = String.valueOf(sPlan.charAt(i * 24 + j));
                    }
                }
                break;
            default:
        }        
        doProcessPlan(storePlan);
    }

    public void doProcessPlan(String[][] planArrays)
    {
        for (int i = 0; i < planArrays.length; i++) {
            for (int j = 0; j < planArrays[i].length; j++) {
                if (planArrays[i][j].equals("1")) {
                    boolean processedFlag = false;
                    for (Iterator<RectArear> it = rectArearSet.iterator(); it.hasNext();) {
                        RectArear ra = it.next();
                        if (ra.containPoint(j, i)) {
                            processedFlag = true;
                            break;
                        }
                    }
                    if (!processedFlag) {
                        RectArear newRA = new RectArear();
                        newRA.setMinY(i);
                        newRA.setMinX(j);
                        boolean stopFlag = false;
                        int appendIndex = 0;
                        while (!stopFlag && (j + (++appendIndex)) < planArrays[i].length) {
                            if (planArrays[i][j + appendIndex].equals("0")) {
                                stopFlag = true;
                            }
                        }
                        newRA.setMaxX(j + appendIndex - 1);

                        stopFlag = false;
                        appendIndex = 0;
                        while (!stopFlag && (newRA.getMinY() + (++appendIndex)) < planArrays.length) {
                            for (int xIndex = newRA.getMinX(); xIndex <= newRA.getMaxX(); xIndex++) {
                                if (planArrays[newRA.getMinY() + appendIndex][xIndex].equals("0")) {
                                    stopFlag = true;
                                }
                            }
                        }
                        newRA.setMaxY(newRA.getMinY() + appendIndex - 1);

                        rectArearSet.add(newRA);
                    }
                }
            }
        }
    }
    
    public static String getDefaultFlag(int type, boolean isEmpty)
    {
        String result = "";
        String s = isEmpty ? "0" : "1";
        StringBuffer sbuf = null;
        switch(type)
        {
            case DAY://day
                sbuf = new StringBuffer(24);
                for(int ihour = 0;ihour < 24; ihour++)
                {
                    sbuf.append(s);
                }
                break;
            case WEEK://week;
                sbuf = new StringBuffer(7 * 24);
                for(int iDay = 0;iDay < 7 * 24;iDay++)
                {
                    sbuf.append(s);
                }
                break;
            case MONTH://month
                sbuf = new StringBuffer(31 * 24);
                for(int iDay = 0;iDay < 31 * 24;iDay++)
                {
                    sbuf.append(s);
                }
                break;
        }
        result = sbuf.toString();

        return result;
    }

    private static class RectArear {

        private int minX;
        private int maxX;
        private int minY;
        private int maxY;

        public int getMinX() {
            return minX;
        }

        public void setMinX(int minX) {
            this.minX = minX;
        }

        public int getMaxX() {
            return maxX;
        }

        public void setMaxX(int maxX) {
            this.maxX = maxX;
        }

        public int getMinY() {
            return minY;
        }

        public void setMinY(int minY) {
            this.minY = minY;
        }

        public int getMaxY() {
            return maxY;
        }

        public void setMaxY(int maxY) {
            this.maxY = maxY;
        }

        public boolean containPoint(int x, int y) {
            return (minY <= y && maxY >= y && minX <= x && maxX >= x);
        }
    }
}
