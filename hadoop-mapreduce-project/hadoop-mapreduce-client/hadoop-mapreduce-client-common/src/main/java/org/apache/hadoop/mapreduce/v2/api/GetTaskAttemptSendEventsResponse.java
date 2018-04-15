package org.apache.hadoop.mapreduce.v2.api;

import org.apache.hadoop.mapreduce.v2.api.records.TaskAttemptSendEvent;

import java.util.List;

/**
 * Created by HeShulin on 2018/4/11.
 */
public interface GetTaskAttemptSendEventsResponse {
    public abstract List<TaskAttemptSendEvent> getSendEventList();
    public abstract TaskAttemptSendEvent getSendEvent(int index);
    public abstract int getSendEventCount();
    public abstract void addAllSendEvents(List<TaskAttemptSendEvent> eventList);
    public abstract void addSendEvent(TaskAttemptSendEvent event);
    public abstract void removeSendEvent(int index);
    public abstract void clearSendEvents();
}
