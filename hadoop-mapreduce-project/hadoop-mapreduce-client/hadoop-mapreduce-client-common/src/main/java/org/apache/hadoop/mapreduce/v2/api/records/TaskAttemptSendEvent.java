package org.apache.hadoop.mapreduce.v2.api.records;

/**
 * Created by HeShulin on 2018/4/5.
 */
public interface TaskAttemptSendEvent {
    public abstract TaskAttemptId getAttemptId();
    public abstract TaskAttemptSendEventStatus getStatus();
    public abstract String getMapOutputServerAddress();
    public abstract int getAttemptRunTime();
    public abstract int getEventId();

    public abstract void setAttemptId(TaskAttemptId taskAttemptId);
    public abstract void setStatus(TaskAttemptSendEventStatus status);
    public abstract void setMapOutputServerAddress(String address);
    public abstract void setAttemptRunTime(int runTime);
    public abstract void setEventId(int eventId);
}
