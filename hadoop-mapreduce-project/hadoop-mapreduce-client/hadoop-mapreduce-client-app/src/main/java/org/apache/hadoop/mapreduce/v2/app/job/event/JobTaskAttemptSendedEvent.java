package org.apache.hadoop.mapreduce.v2.app.job.event;

import org.apache.hadoop.mapreduce.v2.api.records.TaskAttemptCompletionEvent;

/**
 * Created by HeShulin on 2018/3/26.
 */
import org.apache.hadoop.mapreduce.v2.api.records.TaskAttemptCompletionEvent;


public class JobTaskAttemptSendedEvent extends JobEvent {

    private TaskAttemptCompletionEvent completionEvent;

    public JobTaskAttemptSendedEvent(TaskAttemptCompletionEvent completionEvent) {
        super(completionEvent.getAttemptId().getTaskId().getJobId(),
                JobEventType.JOB_SENDED);
        this.completionEvent = completionEvent;
    }

    public TaskAttemptCompletionEvent getCompletionEvent() {
        return completionEvent;
    }
}
