package com.javen205.utils;

import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

/**
 * <pre>
 *     desc  : 对象序列化相关工具类
 * </pre>
 */

public class SerializeUtils {
    /**
     * 将String转化为Object
     * @param string
     * @return
     */
    public static Object String2Object(String string) {
        Object object = null;
        byte[] mobileBytes = Base64.decode(string.getBytes(),
                Base64.DEFAULT);
        ByteArrayInputStream bis = new ByteArrayInputStream(mobileBytes);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(bis);
            object = ois.readObject();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            CloseUtils.closeIO(bis,ois);
        }
        return object;
    }

    /**
     * 将Object转化为String
     * @param object
     * @return
     */
    public static String Object2String(Object object) {

        String string = null;
        // 实例化一个ByteArrayOutputStream对象，用来装载压缩后的字节文件。
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = null;
        try {

            // 将得到的字符数据装载到ObjectOutputStream
            os = new ObjectOutputStream(bos);
            // writeObject 方法负责写入特定类的对象的状态，以便相应的 readObject 方法可以还原它
            os.writeObject(object);
            // 最后，用Base64.encode将字节文件转换成Base64编码保存在String中
            string = new String(
                    Base64.encode(bos.toByteArray(), Base64.DEFAULT));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtils.closeIO(bos,os);
        }
        return string;
    }

}
