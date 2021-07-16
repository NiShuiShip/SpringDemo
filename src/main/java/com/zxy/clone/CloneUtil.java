package com.zxy.clone;

import java.io.*;

public class CloneUtil {

    public static <T extends Serializable> T clone(T obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
        ObjectOutputStream outputStream2 = new ObjectOutputStream(outputStream1);
        outputStream2.writeObject(obj);

        ByteArrayInputStream inputStream1 = new ByteArrayInputStream(outputStream1.toByteArray());
        ObjectInputStream inputStream2 = new ObjectInputStream(inputStream1);
        return (T) inputStream2.readObject();

    }
}
