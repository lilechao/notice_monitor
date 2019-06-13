package com.apicloud.notice;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import android.os.Environment;


public class Public {
	public static String getFile(String fileName) {
        try {
            // �����ļ�
            File file = new File(Environment.getExternalStorageDirectory(),fileName);
            if(!file.exists()){
            	saveFile("",fileName);
            }
            // ����FileInputStream����
            FileInputStream fis = new FileInputStream(file);
            // �����ֽ����� ÿ�λ���1M
            byte[] b = new byte[1024];
            int len = 0;// һ�ζ�ȡ1024�ֽڴ�С��û�����ݺ󷵻�-1.
            // ����ByteArrayOutputStream����
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // һ�ζ�ȡ1024���ֽڣ�Ȼ�����ַ��������д��ȡ���ֽ���
            while ((len = fis.read(b)) != -1) {
                baos.write(b, 0, len);
            }
            // ����ȡ���ֽ����������ֽ�����
            byte[] data = baos.toByteArray();
            // �ر��ֽ������
            baos.close();
            // �ر��ļ�������
            fis.close();
            // �����ַ�������
            return new String(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    public static void saveFile(String str, String fileName) {
        // ����String���󱣴��ļ���·��
        try {
            // ����ָ��·�����ļ�
            File file = new File(Environment.getExternalStorageDirectory(), fileName);
            // ����ļ�������
            if (file.exists()) {
                // �����µĿ��ļ�
                file.delete();
            }
            file.createNewFile();
            // ��ȡ�ļ������������
            FileOutputStream outStream = new FileOutputStream(file);
            // ��ȡ�ַ��������byte���鲢д���ļ���
            outStream.write(str.getBytes());
            // ���ر��ļ������
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static void deletefile(String fileName) {
        try {
        	
            // �ҵ��ļ����ڵ�·����ɾ�����ļ�
            File file = new File(Environment.getExternalStorageDirectory(), fileName);
            if(!file.exists()){
            	file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
