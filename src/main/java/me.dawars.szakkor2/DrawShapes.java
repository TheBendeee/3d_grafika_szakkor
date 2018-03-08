package me.dawars.szakkor2;

import processing.core.PApplet;
import processing.core.PShape;

public class DrawShapes extends PApplet {
    public static void main(String[] args) {
        PApplet.main(DrawShapes.class);
    }

    @Override
    public void settings() {
        size(400, 400, P3D);
    }

    PShape triangle;

    @Override
    public void setup() {
        triangle = createTriangle();
    }

    @Override
    public void draw() {
        background(0);

        translate(width / 2, height / 2);

        shape(triangle);
    }

    private PShape createTriangle() {
        PShape shape = createShape();

        shape.beginShape(TRIANGLES);
        shape.fill(0, 0, 255);
        shape.vertex(0, -100);
        shape.fill(0, 255, 0);
        shape.vertex(100, 100);
        shape.fill(255, 0, 0);
        shape.vertex(-100, 100);
        shape.endShape();

        return shape;
    }
}
