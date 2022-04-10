package com.github.meshotron2.scriptPlugin.shapeDeserializadon;

import com.github.meshotron2.scriptPlugin.Room;
import com.github.meshotron2.scriptPlugin.shape.ShapeFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class JSONRoom {
    private String xg;
    private String yg;
    private String zg;
    private String f;
    private String file;

    private Map<String, RoomComponent> shapes;

    public void write(ShapeFactory shapeFactory) throws IOException {
        final Room r = new Room(file, Integer.parseInt(xg), Integer.parseInt(yg), Integer.parseInt(zg), Integer.parseInt(f));
        final Room room = new Room(file, Integer.parseInt(xg), Integer.parseInt(yg), Integer.parseInt(zg), Integer.parseInt(f));
        shapeFactory.setRoom(room);

        r.startWrite();

        shapes.forEach((s, rc) -> {
            final char coef = rc.getProperties().get("coefficient").charAt(0);
            final int[] args = new int[rc.getProperties().size() - 2];
            final AtomicInteger cnt = new AtomicInteger(0);
            rc.getProperties().forEach((s1, s2) -> {
                if (!s1.equals("type") && !s1.equals("coefficient"))
                    args[cnt.getAndIncrement()] = Integer.parseInt(s2);
            });

            try {
                shapeFactory.getInitializerFromClass(rc.getType()).initialize(coef, args);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Finished!");
        r.endWrite();
    }

    @Override
    public String toString() {
        return "JSONRoom{" +
                "xg='" + xg + '\'' +
                ", yg='" + yg + '\'' +
                ", zg='" + zg + '\'' +
                ", f='" + f + '\'' +
                ", file='" + file + '\'' +
                ", shapes=" + shapes +
                '}';
    }

//    private String mapToString(Map<String, RoomComponent> map) {
//        final StringBuilder sb = new StringBuilder();
//
//        map.forEach((s, rc) -> sb.append(s).append(": ").append(rc.toString()));
//
//        return sb.toString();
//    }

    public String getFile() {
        return file;
    }
}
