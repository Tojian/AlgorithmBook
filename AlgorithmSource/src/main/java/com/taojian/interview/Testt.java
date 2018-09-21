package com.taojian.interview;

import java.util.ArrayList;

import java.util.List;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-07 20:07
 **/
public class Testt {
    /**
     * 判断点是否在多边形内
     *
     * @param point 检测点
     * @param pts   多边形的顶点
     *
     * @return 点在多边形内返回true, 否则返回false
     */
    public static boolean IsPtInPoly(Point point, List<Point> pts) {

        int N = pts.size();
        boolean boundOrVertex = true; //如果点位于多边形的顶点或边上，也算做点在多边形内，直接返回true
        int intersectCount = 0;//cross points count of x
        double precision = 2e-10; //浮点类型计算时候与0比较时候的容差
        Point p1, p2;//neighbour bound vertices
        Point p = point; //当前点

        p1 = pts.get(0);//left vertex
        for (int i = 1; i <= N; ++i) {//check all rays
            if (p.equals(p1)) {
                return boundOrVertex;//p is an vertex
            }

            p2 = pts.get(i % N);//right vertex
            if (p.x < Math.min(p1.x, p2.x) || p.x > Math.max(p1.x, p2.x)) {//ray is outside of our interests
                p1 = p2;
                continue;//next ray left point
            }

            if (p.x > Math.min(p1.x, p2.x) && p.x < Math
                    .max(p1.x, p2.x)) {//ray is crossing over by the algorithm (common part of)
                if (p.y <= Math.max(p1.y, p2.y)) {//x is before of ray
                    if (p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)) {//overlies on a horizontal ray
                        return boundOrVertex;
                    }

                    if (p1.y == p2.y) {//ray is vertical
                        if (p1.y == p.y) {//overlies on a vertical ray
                            return boundOrVertex;
                        } else {//before ray
                            ++intersectCount;
                        }
                    } else {//cross point on the left side
                        double xinters = (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;//cross point of y
                        if (Math.abs(p.y - xinters) < precision) {//overlies on a ray
                            return boundOrVertex;
                        }

                        if (p.y < xinters) {//before ray
                            ++intersectCount;
                        }
                    }
                }
            } else {//special case when ray is crossing through the vertex
                if (p.x == p2.x && p.y <= p2.y) {//p crossing over p2
                    Point p3 = pts.get((i + 1) % N); //next vertex
                    if (p.x >= Math.min(p1.x, p3.x) && p.x <= Math.max(p1.x, p3.x)) {//p.x lies between p1.x & p3.x
                        ++intersectCount;
                    } else {
                        intersectCount += 2;
                    }
                }
            }
            p1 = p2;//next ray left point
        }

        if (intersectCount % 2 == 0) {//偶数在多边形外
            return false;
        } else { //奇数在多边形内
            return true;
        }

    }

    // 测试一个点是否在多边形内
    public static void main(String[] args) {

        Point point = new Point(3, 4);

        List<Point> pts = new ArrayList<Point>();
        pts.add(new Point(0, 0));
        pts.add(new Point(0, 2));
        pts.add(new Point(2, 2));
        pts.add(new Point(2, 0));

        if (IsPtInPoly(point, pts)) {
            System.out.println("yes,0");
        } else {
            int min = Integer.MAX_VALUE;
           for (int i = 0 ; i < pts.size()   ; i ++){
               double temp ;

               if (i == pts.size() - 1)
                  temp  = pointToLine(pts.get(i).x ,pts.get(i).y,pts.get(0).x,pts.get(0).y,point.x,point.y);
               else temp = pointToLine(pts.get(i).x ,pts.get(i).y,pts.get(i+1).x,pts.get(i+1).y,point.x,point.y);
               if (temp < min)
                   min = (int) temp;
           }
            System.out.println("no," + min);
        }
    }

    public static double pointToLine(int x1, int y1, int x2, int y2, int x0,

                               int y0) {

        double space = 0;

        double a, b, c;

        a = lineSpace(x1, y1, x2, y2);// 线段的长度

        b = lineSpace(x1, y1, x0, y0);// (x1,y1)到点的距离

        c = lineSpace(x2, y2, x0, y0);// (x2,y2)到点的距离

        if (c <= 0.000001 || b <= 0.000001) {

            space = 0;

            return space;

        }

        if (a <= 0.000001) {

            space = b;

            return space;

        }

        if (c * c >= a * a + b * b) {

            space = b;

            return space;

        }

        if (b * b >= a * a + c * c) {

            space = c;

            return space;

        }

        double p = (a + b + c) / 2;// 半周长

        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));// 海伦公式求面积

        space = 2 * s / a;// 返回点到线的距离（利用三角形面积公式求高）

        return space;

    }

    // 计算两点之间的距离

    public static double lineSpace(int x1, int y1, int x2, int y2) {

        double lineLength = 0;

        lineLength = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2)

                * (y1 - y2));

        return lineLength;

    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
