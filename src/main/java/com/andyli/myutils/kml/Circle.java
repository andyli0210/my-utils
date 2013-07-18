/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.kml;

/**
 *
 * @author yan
 */
public class Circle {

//    #
//# Convert (x,y,z) on unit sphere
//# back to (long, lat)
//#
//# p is vector of three elements
//# 
    private double[] toEarth(double[] p) {
        double longitude;
        double latitude;
        double colatitude;
        if (p[0] == 0.0) {
            longitude = Math.PI / 2.0;
        } else {
            longitude = Math.atan(p[1] / p[0]);
        }

        colatitude = Math.acos(p[2]);
        latitude = Math.PI / 2.0 - colatitude;


        // select correct branch of arctan
        if (p[0] < 0.0) {
            longitude = -(Math.PI - longitude);
        } else {
            longitude = Math.PI + longitude;
        }

        double deg = 180.0 / Math.PI;

        return new double[]{longitude * deg, latitude * deg};

    }

//    #c
//# convert long, lat IN RADIANS to (x,y,z)
//# 
    public double[] toCart(double longitude, double latitude) {
        double theta = longitude;
        double phi = Math.PI / 2.0 - latitude;

        return new double[]{Math.cos(theta) * Math.sin(phi), Math.sin(theta) * Math.sin(phi), Math.cos(phi)};
    }

//    #
//# rotate point pt, around unit vector vec by phi radians
//# http://blog.modp.com/2007/09/rotating-point-around-vector.html
//# 
    private double[] rotPoint(double[] vec, double[] pt, double phi) {
        double u = vec[0];
        double v = vec[1];
        double w = vec[2];
        double x = pt[0];
        double y = pt[1];
        double z = pt[2];

        double a = u * x + v * y + w * z;
        double d = Math.cos(phi);
        double e = Math.sin(phi);

        return new double[]{(a * u + (x - a * u) * d + (v * z - w * y) * e),
            (a * v + (y - a * v) * d + (w * x - u * z) * e),
            (a * w + (z - a * w) * d + (u * y - v * x) * e)};
    }

//    # spoints -- get raw list of points in long,lat format
//#
//# meters: radius of polygon
//# n: number of sides
//# offset: rotate polygon by number of degrees
//#
//# Returns a list of points comprising the object
//#
    public double[][] spoints(double lon, double lat, int meters, int n, int offset) {

        double RAD = Math.PI / 180.0;

        double MR = 6378.1 * 1000.0;
        double offsetRadians = offset * RAD;

        double r = (meters / (MR * Math.cos(lat * RAD)));

        double[] vec = toCart(lon * RAD, lat * RAD);
        double[] pt = toCart(lon * RAD + r, lat * RAD);

        double[][] pts = new double[n + 1][];
        for (int i = 0; i < n; i++) {
            pts[i] = toEarth(rotPoint(vec, pt, offsetRadians + (2.0 * Math.PI / n) * i));
        }

        pts[n] = pts[0];

        return pts;
    }
}
