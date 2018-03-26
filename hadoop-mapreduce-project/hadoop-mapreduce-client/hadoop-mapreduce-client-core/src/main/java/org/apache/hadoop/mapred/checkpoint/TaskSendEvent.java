package org.apache.hadoop.mapred.checkpoint;

/**
 * Created by HeShulin on 2018/3/26.
 */
import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceAudience.Private;
import org.apache.hadoop.classification.InterfaceStability;
import org.apache.hadoop.mapred.TaskAttemptID;

/**
 * This is used to track task completion events on
 * job tracker.
 */
@InterfaceAudience.Public
@InterfaceStability.Stable
public class TaskSendEvent
        extends org.apache.hadoop.mapreduce.TaskCompletionEvent {
    @InterfaceAudience.Public
    @InterfaceStability.Stable
    /**
     *  Task Completion Statuses
     */
    static public enum Status {
        /**
         * Task Event Attempt failed but there are attempts remaining.
         */
        FAILED,
        /**
         * Task Event was killed.
         */
        KILLED,
        /**
         * Task Event was successful.
         */
        SUCCEEDED,
        /**
         * Used to Override a previously successful event status.
         * Example:  Map attempt runs and a SUCCEEDED event is sent. Later a task
         * is retroactively failed due to excessive fetch failure during shuffle
         * phase. When the retroactive attempt failure occurs, an OBSOLETE event is
         * sent for the map attempt indicating the prior event is no longer valid.
         */
        OBSOLETE,
        /**
         * Task Event attempt failed and no further attempts exist.
         * reached MAX attempts. When a reducer receives a TIPFAILED event it
         * gives up trying to shuffle data from that map task.
         */
        TIPFAILED
    }

    public static final org.apache.hadoop.mapred.TaskCompletionEvent[] EMPTY_ARRAY =
            new org.apache.hadoop.mapred.TaskCompletionEvent[0];
    /**
     * Default constructor for Writable.
     *
     */
    public TaskSendEvent() {
        super();
    }

    /**
     * Constructor. eventId should be created externally and incremented
     * per event for each job.
     * @param eventId event id, event id should be unique and assigned in
     *  incrementally, starting from 0.
     * @param taskId task id
     * @param status task's status
     * @param taskTrackerHttp task tracker's host:port for http.
     */
    public TaskSendEvent(int eventId,
                               TaskAttemptID taskId,
                               int idWithinJob,
                               boolean isMap,
                               org.apache.hadoop.mapred.TaskCompletionEvent.Status status,
                               String taskTrackerHttp){
        super(eventId, taskId, idWithinJob, isMap, org.apache.hadoop.mapreduce.
                TaskCompletionEvent.Status.valueOf(status.name()), taskTrackerHttp);
    }

    @Private
    public static org.apache.hadoop.mapred.TaskCompletionEvent downgrade(
            org.apache.hadoop.mapreduce.TaskCompletionEvent event) {
        return new org.apache.hadoop.mapred.TaskCompletionEvent(event.getEventId(),
                TaskAttemptID.downgrade(event.getTaskAttemptId()),event.idWithinJob(),
                event.isMapTask(), org.apache.hadoop.mapred.TaskCompletionEvent.Status.valueOf(event.getStatus().name()),
                event.getTaskTrackerHttp());
    }
    /**
     * Returns task id.
     * @return task id
     * @deprecated use {@link #getTaskAttemptId()} instead.
     */
    @Deprecated
    public String getTaskId() {
        return getTaskAttemptId().toString();
    }

    /**
     * Returns task id.
     * @return task id
     */
    public TaskAttemptID getTaskAttemptId() {
        return TaskAttemptID.downgrade(super.getTaskAttemptId());
    }

    /**
     * Returns {@link org.apache.hadoop.mapred.TaskCompletionEvent.Status}
     * @return task completion status
     */
    public org.apache.hadoop.mapred.TaskCompletionEvent.Status getTaskStatus() {
        return org.apache.hadoop.mapred.TaskCompletionEvent.Status.valueOf(super.getStatus().name());
    }

    /**
     * Sets task id.
     * @param taskId
     * @deprecated use {@link #setTaskAttemptId(TaskAttemptID)} instead.
     */
    @Deprecated
    public void setTaskId(String taskId) {
        this.setTaskAttemptId(TaskAttemptID.forName(taskId));
    }

    /**
     * Sets task id.
     * @param taskId
     * @deprecated use {@link #setTaskAttemptId(TaskAttemptID)} instead.
     */
    @Deprecated
    public void setTaskID(TaskAttemptID taskId) {
        this.setTaskAttemptId(taskId);
    }

    /**
     * Sets task id.
     * @param taskId
     */
    protected void setTaskAttemptId(TaskAttemptID taskId) {
        super.setTaskAttemptId(taskId);
    }

    /**
     * Set task status.
     * @param status
     */
    @Private
    public void setTaskStatus(org.apache.hadoop.mapred.TaskCompletionEvent.Status status) {
        super.setTaskStatus(org.apache.hadoop.mapreduce.
                TaskCompletionEvent.Status.valueOf(status.name()));
    }

    /**
     * Set the task completion time
     * @param taskCompletionTime time (in millisec) the task took to complete
     */
    @Private
    public void setTaskRunTime(int taskCompletionTime) {
        super.setTaskRunTime(taskCompletionTime);
    }

    /**
     * set event Id. should be assigned incrementally starting from 0.
     * @param eventId
     */
    @Private
    public void setEventId(int eventId) {
        super.setEventId(eventId);
    }

    /**
     * Set task tracker http location.
     * @param taskTrackerHttp
     */
    @Private
    public void setTaskTrackerHttp(String taskTrackerHttp) {
        super.setTaskTrackerHttp(taskTrackerHttp);
    }
}
