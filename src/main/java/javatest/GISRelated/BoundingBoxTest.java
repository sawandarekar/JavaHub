package javatest.GISRelated;

import java.util.Arrays;

public class BoundingBoxTest {

    public static void main(final String[] args) {
        final double lat = -26.1955000;
        final double lon = 28.0309900;
        System.out.println("Point: " + lat + "," + lon);
        System.out.println("Bounding box : " + Arrays.toString(getBounds(lat, lon)));
    }

    private static double[] getBbox(final double lat, final double lon) {
        final double[] bbox = new double[4];
        final int MAX = 10000000;
        bbox[0] = lat * MAX;
        bbox[1] = lon * MAX;
        bbox[2] = lat * MAX + 50;
        bbox[3] = lon * MAX - 50;

        return bbox;
    }

    private static double[] getBoundsFromLatLng(final double lat, final double lon) {
        final double lat_change = 10 / 111.2;
        final double lon_change = Math.abs(Math.cos(lat * (Math.PI / 180)));
        final double[] bounds = {lat - lat_change, lon - lon_change, lat + lat_change, lon + lon_change};
        return bounds;
    }

    private static double[] getBounds(final double lat, final double lon) {
        final double R = 6371; // earth radius in km
        final double radius = 300 / 1000d; // km
        final double x1 = lon + Math.toDegrees(radius / R / Math.cos(Math.toRadians(lat)));
        final double x2 = lon - Math.toDegrees(radius / R / Math.cos(Math.toRadians(lat)));
        final double y1 = lat - Math.toDegrees(radius / R);
        final double y2 = lat + Math.toDegrees(radius / R);
        final double[] bounds = {y1, x1, y2, x2};
        return bounds;
    }
}
