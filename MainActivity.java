package com.example.hcy.test;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();
        String str = "{\n" +
                "    \"result\": [\n" +
                "        {\n" +
                "            \"type\":\"视频\",\n" +
                "             \"materials\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"name\": \"放风筝\",\n" +
                "            \"filename\": \"放风筝\",\n" +
                "            \"duration\": \"00:03:25\",\n" +
                "            \"cover_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/image/201805241734058302.png\",\n" +
                "            \"type\": 2,\n" +
                "            \"content_type\": 3,\n" +
                "            \"content_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/video/201805131221324437.mp4\",\n" +
                "            \"swf_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/video/201805131221324437.mp4\",\n" +
                "            \"course_name\": \"逛逛动物园\",\n" +
                "            \"corner\": \"本地\", \n" +
                "            \"cover_path\": \"/box/materials/放风筝/放风筝.png\",\n" +
                "            \"content_path\": \"/box/materials/逛逛动物园/逛逛动物园.png\",\n" +
                "            \"swf_path\": \"/box/materials/放风筝/放风筝_解密.swf\",\n" +
                "            \"version\": 1 \n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"name\": \"好玩的吹画\",\n" +
                "            \"filename\": \"好玩的吹画\",\n" +
                "            \"duration\": \"00:03:25\",\n" +
                "            \"cover_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/image/201805241734058302.png\",\n" +
                "            \"type\": 2,\n" +
                "            \"content_type\": 2,\n" +
                "            \"content_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/video/201805131221324437.mp4\",\n" +
                "            \"swf_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/video/201805131221324437.mp4\",\n" +
                "            \"course_name\": \"逛逛动物园\",\n" +
                "            \"corner\": \"本地\", \n" +
                "            \"cover_path\": \"/box/materials/好玩的吹画/好玩的吹画.png\",\n" +
                "            \"content_path\": \"/box/materials/逛逛动物园/动物园里真有趣.mp3\",\n" +
                "            \"swf_path\": \"/box/materials/好玩的吹画/好玩的吹画.swf\",\n" +
                "            \"version\": 1 \n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3,\n" +
                "            \"name\": \"见面歌\",\n" +
                "            \"filename\": \"见面歌\",\n" +
                "            \"duration\": \"00:03:25\",\n" +
                "            \"cover_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/image/201805241734058302.png\",\n" +
                "            \"type\": 1,\n" +
                "            \"content_type\": 2,\n" +
                "            \"content_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/video/201805131221324437.mp4\",\n" +
                "            \"swf_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/video/201805131221324437.mp4\",\n" +
                "            \"course_name\": \"逛逛动物园\",\n" +
                "            \"corner\": \"本地\", \n" +
                "            \"cover_path\": \"/box/materials/见面歌/见面歌.png\",\n" +
                "            \"content_path\": \"/box/materials/见面歌/见面歌_高清.mp4\",\n" +
                "            \"swf_path\": \"\",\n" +
                "            \"version\": 1 \n" +
                "        }\n" +
                "\n" +
                "\n" +
                "\n" +
                "    ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\":\"音频\",\n" +
                "             \"materials\": [\n" +
                "        {\n" +
                "            \"id\": 16,\n" +
                "            \"name\": \"拔萝卜\",\n" +
                "            \"filename\": \"拔萝卜\",\n" +
                "            \"duration\": \"00:03:25\",\n" +
                "            \"cover_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/image/201805241734058302.png\",\n" +
                "            \"type\": 1,\n" +
                "            \"content_type\": 3,\n" +
                "            \"content_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/video/201805131221324437.mp4\",\n" +
                "            \"swf_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/video/201805131221324437.mp4\",\n" +
                "            \"course_name\": \"逛逛动物园\",\n" +
                "            \"corner\": \"本地\", \n" +
                "            \"cover_path\": \"/box/materials/拔萝卜/拔萝卜_03.png\",\n" +
                "            \"content_path\": \"/box/materials/拔萝卜/拔萝卜.mp3\",\n" +
                "            \"swf_path\": \"/box/materials/逛逛动物园/逛逛动物园.png\",\n" +
                "            \"version\": 1 \n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 17,\n" +
                "            \"name\": \"斑马线\",\n" +
                "            \"filename\": \"斑马线\",\n" +
                "            \"duration\": \"00:03:25\",\n" +
                "            \"cover_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/image/201805241734058302.png\",\n" +
                "            \"type\": 1,\n" +
                "            \"content_type\": 2,\n" +
                "            \"content_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/video/201805131221324437.mp4\",\n" +
                "            \"swf_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/video/201805131221324437.mp4\",\n" +
                "            \"course_name\": \"逛逛动物园\",\n" +
                "            \"corner\": \"本地\", \n" +
                "            \"cover_path\": \"/box/materials/斑马线/斑马线_03.png\",\n" +
                "            \"content_path\": \"/box/materials/斑马线/斑马线.mp3\",\n" +
                "            \"swf_path\": \"/box/materials/逛逛动物园/动物园里真有趣.mp3\",\n" +
                "            \"version\": 1 \n" +
                "        }\n" +
                "\n" +
                "\n" +
                "    ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\":\"图片\",\n" +
                "             \"materials\": [\n" +
                "        {\n" +
                "            \"id\": 31,\n" +
                "            \"name\": \"海的女儿\",\n" +
                "            \"filename\": \"海的女儿\",\n" +
                "            \"duration\": \"00:03:25\",\n" +
                "            \"cover_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/image/201805241734058302.png\",\n" +
                "            \"type\": 0,\n" +
                "            \"content_type\": 3,\n" +
                "            \"content_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/video/201805131221324437.mp4\",\n" +
                "            \"swf_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/video/201805131221324437.mp4\",\n" +
                "            \"course_name\": \"逛逛动物园\",\n" +
                "            \"corner\": \"本地\", \n" +
                "            \"cover_path\": \"/box/materials/海的女儿/海的女儿.png\",\n" +
                "            \"content_path\": \"/box/materials/逛逛动物园/逛逛动物园.png\",\n" +
                "            \"swf_path\": \"/box/materials/逛逛动物园/逛逛动物园.png\",\n" +
                "            \"version\": 1 \n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 32,\n" +
                "            \"name\": \"燕子来了\",\n" +
                "            \"filename\": \"燕子来了\",\n" +
                "            \"duration\": \"00:03:25\",\n" +
                "            \"cover_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/image/201805241734058302.png\",\n" +
                "            \"type\": 0,\n" +
                "            \"content_type\": 2,\n" +
                "            \"content_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/video/201805131221324437.mp4\",\n" +
                "            \"swf_url\":\n" +
                "                \"http://test-xsd.oss-cn-shenzhen.aliyuncs.com/familybox/video/201805131221324437.mp4\",\n" +
                "            \"course_name\": \"逛逛动物园\",\n" +
                "            \"corner\": \"本地\", \n" +
                "            \"cover_path\": \"/box/materials/燕子来了/燕子来了.png\",\n" +
                "            \"content_path\": \"/box/materials/逛逛动物园/动物园里真有趣.mp3\",\n" +
                "            \"swf_path\": \"/box/materials/逛逛动物园/动物园里真有趣.mp3\",\n" +
                "            \"version\": 1 \n" +
                "        }\n" +
                "\n" +
                "\n" +
                "    ]\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";
        MaterialsCenterBean materialsCenterBean = gson.fromJson(str, MaterialsCenterBean.class);

        Log.i("GGFF", materialsCenterBean.getResult().toString());
      /*  TextView tv = findViewById(R.id.tv);
        //所要申请的权限
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {//检查是否获取该权限
            Toast.makeText(MainActivity.this, "已经授权", Toast.LENGTH_SHORT).show();
            createFile() ;
        } else {
            ActivityCompat.requestPermissions(this, perms, 1);
        }*/
    }

    public void createFile() {

        //新建一个File，传入文件夹目录
        File file = new File("/system/sdcard/work/mywork");
        //判断文件夹是否存在，如果不存在就创建，否则不创建
        if (!file.exists()) {
            //通过file的mkdirs()方法创建<span style="color:#FF0000;">目录中包含却不存在</span>的文件夹
            file.mkdirs();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0) {
            EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
        }
    }


    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        Log.i("<<>>", "获取成功的权限" + perms);
        createFile();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Log.i("<<>>", "获取失败的权限" + perms);
        request();
    }

    private void request() {
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

        ActivityCompat.requestPermissions(this,
                perms, 1);
    }

}
