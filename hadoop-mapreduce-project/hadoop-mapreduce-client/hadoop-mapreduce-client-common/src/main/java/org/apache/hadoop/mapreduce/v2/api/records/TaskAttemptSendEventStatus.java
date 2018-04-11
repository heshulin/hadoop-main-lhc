package org.apache.hadoop.mapreduce.v2.api.records;

/**
 * Created by HeShulin on 2018/4/5.
 */
public enum TaskAttemptSendEventStatus {
    FAILED,
    KILLED,
    SUCCEEDED,
    OBSOLETE,
    TIPFAILED,
    //SENDED
}
