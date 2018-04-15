package org.apache.hadoop.mapreduce.v2.api.impl.pb.service;

import org.apache.hadoop.mapreduce.v2.api.GetTaskAttemptSendEventsResponse;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetTaskAttemptSendEventsResponse;
import org.apache.hadoop.mapreduce.v2.api.records.TaskAttemptSendEvent;
import org.apache.hadoop.mapreduce.v2.api.records.impl.pb.TaskAttemptSendEventPBImpl;
import org.apache.hadoop.yarn.api.records.impl.pb.ProtoBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by HeShulin on 2018/4/11.
 */
public class GetTaskAttemptSendEventsResponsePBImpl extends ProtoBase<GetTaskAttemptSendEventsResponseProto> implements GetTaskAttemptSendEventsResponse {

    GetTaskAttemptSendEventsResponseProto proto = GetTaskAttemptSendEventsResponseProto.getDefaultInstance();
    GetTaskAttemptSendEventsResponseProto.Builder builder = null;
    boolean viaProto = false;

    private List<TaskAttemptSendEvent> completionEvents = null;


    public GetTaskAttemptSendEventsResponsePBImpl() {
        builder = GetTaskAttemptSendEventsResponseProto.newBuilder();
    }

    public GetTaskAttemptSendEventsResponsePBImpl(GetTaskAttemptSendEventsResponseProto proto) {
        this.proto = proto;
        viaProto = true;
    }

    public GetTaskAttemptSendEventsResponseProto getProto() {
        mergeLocalToProto();
        proto = viaProto ? proto : builder.build();
        viaProto = true;
        return proto;
    }

    private void mergeLocalToBuilder() {
        if (this.completionEvents != null) {
            addSendEventsToProto();
        }
    }

    private void mergeLocalToProto() {
        if (viaProto)
            maybeInitBuilder();
        mergeLocalToBuilder();
        proto = builder.build();
        viaProto = true;
    }

    private void maybeInitBuilder() {
        if (viaProto || builder == null) {
            builder = GetTaskAttemptSendEventsResponseProto.newBuilder(proto);
        }
        viaProto = false;
    }


    @Override
    public List<TaskAttemptSendEvent> getSendEventList() {
        initSendEvents();
        return this.completionEvents;
    }
    @Override
    public TaskAttemptSendEvent getSendEvent(int index) {
        initSendEvents();
        return this.completionEvents.get(index);
    }
    @Override
    public int getSendEventCount() {
        initSendEvents();
        return this.completionEvents.size();
    }

    private void initSendEvents() {
        if (this.completionEvents != null) {
            return;
        }
        GetTaskAttemptSendEventsResponseProtoOrBuilder p = viaProto ? proto : builder;
        List<TaskAttemptSendEventProto> list = p.getSendEventsList();
        this.completionEvents = new ArrayList<TaskAttemptSendEvent>();

        for (TaskAttemptSendEventProto c : list) {
            this.completionEvents.add(convertFromProtoFormat(c));
        }
    }

    @Override
    public void addAllSendEvents(final List<TaskAttemptSendEvent> completionEvents) {
        if (completionEvents == null)
            return;
        initSendEvents();
        this.completionEvents.addAll(completionEvents);
    }

    private void addSendEventsToProto() {
        maybeInitBuilder();
        builder.clearSendEvents();
        if (completionEvents == null)
            return;
        Iterable<TaskAttemptSendEventProto> iterable = new Iterable<TaskAttemptSendEventProto>() {
            @Override
            public Iterator<TaskAttemptSendEventProto> iterator() {
                return new Iterator<TaskAttemptSendEventProto>() {

                    Iterator<TaskAttemptSendEvent> iter = completionEvents.iterator();

                    @Override
                    public boolean hasNext() {
                        return iter.hasNext();
                    }

                    @Override
                    public TaskAttemptSendEventProto next() {
                        return convertToProtoFormat(iter.next());
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();

                    }
                };

            }
        };
        builder.addAllSendEvents(iterable);
    }
    @Override
    public void addSendEvent(TaskAttemptSendEvent completionEvents) {
        initSendEvents();
        this.completionEvents.add(completionEvents);
    }
    @Override
    public void removeSendEvent(int index) {
        initSendEvents();
        this.completionEvents.remove(index);
    }
    @Override
    public void clearSendEvents() {
        initSendEvents();
        this.completionEvents.clear();
    }

    private TaskAttemptSendEventPBImpl convertFromProtoFormat(TaskAttemptSendEventProto p) {
        return new TaskAttemptSendEventPBImpl(p);
    }

    private TaskAttemptSendEventProto convertToProtoFormat(TaskAttemptSendEvent t) {
        return ((TaskAttemptSendEventPBImpl)t).getProto();
    }



}  
