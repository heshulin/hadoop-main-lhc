package org.apache.hadoop.mapreduce.v2.app.job.event;

import org.apache.hadoop.mapreduce.v2.api.records.TaskAttemptCompletionEvent;

/**
 * Created by HeShulin on 2018/3/26.
 */
import org.apache.hadoop.mapreduce.v2.api.records.TaskAttemptCompletionEvent;
import org.apache.hadoop.mapreduce.v2.api.records.TaskAttemptSendEvent;


public class JobTaskAttemptSendedEvent extends JobEvent {

    private TaskAttemptSendEvent sendEvent;

    public JobTaskAttemptSendedEvent(TaskAttemptSendEvent sendEvent) {
        super(sendEvent.getAttemptId().getTaskId().getJobId(),
                JobEventType.JOB_SENDED);
        this.sendEvent = sendEvent;
    }

    public TaskAttemptSendEvent getSendEvent() {
        return sendEvent;
    }
}
