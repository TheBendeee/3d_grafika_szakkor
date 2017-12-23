package me.dawars.szakkor1;

import org.joml.Matrix3x2f;
import org.joml.Vector3f;
import processing.core.PApplet;

public class RotateTransform extends PApplet {

    private float angle = 0;

    public static void main(String[] args) {
        PApplet.main(RotateTransform.class);
    }

    @Override
    public void settings() {
        size(1280, 720);
    }

    @Override
    public void setup() {
    }

    @Override
    public void draw() {
        background(200);
        // move (0, 0) to the center of the window
        translate(width / 2, height / 2);
        // calculate the length of a unit in pixels
        float unit = width / 2 / 10;
        scale(unit, -unit);

        pushMatrix(); // saves the current transformation

        rotate(angle); // TODO 1: comment out
        angle += 0.01f;

        drawOrdinaryShape();

        // P point
        int x = 0;
        int y = 1;

        // TODO 2: rotate P point with @angle here






        stroke(0xffff0000);
        strokeWeight(0.05f);
        line(0, 0, x, y);

        popMatrix(); // resets the previous transformation (removes rotation)

        drawCoord(unit);
    }

    /**
     * Draws a random shape
     */
    private void drawOrdinaryShape() {

        noStroke();
        fill(0, 210, 255);
        beginShape();
        curveVertex(-1, 2);
        curveVertex(5, 4);
        curveVertex(3, 0);
        curveVertex(4, -3);
        curveVertex(0, -2);
        curveVertex(-4, -3);
        curveVertex(-2, 0);
        curveVertex(-3, 3);
        curveVertex(-2, 4);
        curveVertex(0, 3);
        endShape();
    }

    /**
     * Draws the coordinate axes
     * Up and Right are the positive directions
     *
     * @param unit
     */
    private void drawCoord(float unit) {
        stroke(0);

        // coordinate axis
        strokeWeight(0.01f);
        color(0);
        line(-width / 2, 0, width / 2, 0);
        line(0, -height / 2, 0, height / 2);

        // arrows
        float side = 0.2f;
        fill(0f);
        noStroke();
        triangle(0, height / unit / 2, side, height / unit / 2 - side, -side, height / unit / 2 - side);
        triangle(width / unit / 2, 0, width / unit / 2 - side, -side, width / unit / 2 - side, side);

        // mark numbers
        fill(255f);
        stroke(0);
        strokeWeight(0.05f);
        for (int x = 0; x <= width / unit / 2; x++) {
            point(x, 0);
            point(-x, 0);
        }
        for (int y = 1; y <= height / unit / 2; y++) {
            point(0, y);

            point(0, -y);

        }
    }
}
