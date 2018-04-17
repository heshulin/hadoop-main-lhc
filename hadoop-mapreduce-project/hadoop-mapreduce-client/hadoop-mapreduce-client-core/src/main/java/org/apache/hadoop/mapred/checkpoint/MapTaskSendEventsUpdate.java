package org.apache.hadoop.mapred.checkpoint;

import org.apache.hadoop.mapred.TaskCompletionEvent;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by HeShulin on 2018/3/26.
 */
public class MapTaskSendEventsUpdate {
    TaskSendEvent[] events;
    boolean reset;

    public MapTaskSendEventsUpdate() { }

    public MapTaskSendEventsUpdate(TaskSendEvent[] events,
                                         boolean reset) {
        System.out.println(events.length+"何树林 sendevent事件长度，");
        this.events = events;
        this.reset = reset;
    }

    public boolean shouldReset() {
        return reset;
    }

    public TaskSendEvent[] getMapTaskSendEvents() {
        return events;
    }

    public void write(DataOutput out) throws IOException {
        out.writeBoolean(reset);
        out.writeInt(events.length);
        for (TaskSendEvent event : events) {
            event.write(out);
        }
    }

    public void readFields(DataInput in) throws IOException {
        reset = in.readBoolean();
        events = new TaskSendEvent[in.readInt()];
        for (int i = 0; i < events.length; ++i) {
            events[i] = new TaskSendEvent();
            events[i].readFields(in);
        }
    }
}
