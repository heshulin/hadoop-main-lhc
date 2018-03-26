package org.apache.hadoop.mapred.checkpoint;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.TaskAttemptID;

/**
 * Created by HeShulin on 2018/3/7.
 */
public class UploadCheckpointHDFSThread extends Thread{
    private TaskAttemptID data1;
    private Path data2;
    private long data3;
    public boolean init(TaskAttemptID data1,Path data2,long data3)
    {
        try {
            this.data1 = data1;
            this.data2 = data2;
            this.data3 = data3;
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;

    }
    public void run() {
        try {
            System.out.println("开始尝试存储数据组");
            String data = data1.toString() + "\n" + data2 + "\n" + data3 + "\n";
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);
            FSDataOutputStream mout = fs.create(new Path("hdfs://127.0.0.1:9000/" + data1.toString()));
            mout.write(data.getBytes());
            mout.close();
            System.out.println("数据组存储成功");
            System.out.println("Done");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("检查点写出失败");
        }
    }
}
