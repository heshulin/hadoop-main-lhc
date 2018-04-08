package org.apache.hadoop.mapreduce.v2.api.records.impl.pb;

import org.apache.hadoop.mapreduce.v2.api.records.*;
import org.apache.hadoop.mapreduce.v2.proto.MRProtos.TaskAttemptSendEventProto;
import org.apache.hadoop.mapreduce.v2.proto.MRProtos.TaskAttemptSendEventProtoOrBuilder;
import org.apache.hadoop.mapreduce.v2.proto.MRProtos.TaskAttemptSendEventStatusProto;
import org.apache.hadoop.mapreduce.v2.proto.MRProtos.TaskAttemptIdProto;
import org.apache.hadoop.mapreduce.v2.util.MRProtoUtils;
import org.apache.hadoop.yarn.api.records.impl.pb.ProtoBase;

/**
 * Created by HeShulin on 2018/4/8.
 */
public class TaskAttemptSendEventPBImpl extends ProtoBase<TaskAttemptSendEventProto> implements TaskAttemptSendEvent {
    TaskAttemptSendEventProto proto = TaskAttemptSendEventProto.getDefaultInstance();
    TaskAttemptSendEventProto.Builder builder = null;
    boolean viaProto = false;

    private TaskAttemptId taskAttemptId = null;


    public TaskAttemptSendEventPBImpl() {
        builder = TaskAttemptSendEventProto.newBuilder();
    }

    public TaskAttemptSendEventPBImpl(TaskAttemptSendEventProto proto) {
        this.proto = proto;
        viaProto = true;
    }

    public TaskAttemptSendEventProto getProto() {
        mergeLocalToProto();
        proto = viaProto ? proto : builder.build();
        viaProto = true;
        return proto;
    }

    private void mergeLocalToBuilder() {
        if (this.taskAttemptId != null) {
            builder.setAttemptId(convertToProtoFormat(this.taskAttemptId));
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
            builder = TaskAttemptSendEventProto.newBuilder(proto);
        }
        viaProto = false;
    }


    @Override
    public TaskAttemptId getAttemptId() {
        TaskAttemptSendEventProtoOrBuilder p = viaProto ? proto : builder;
        if (this.taskAttemptId != null) {
            return this.taskAttemptId;
        }
        if (!p.hasAttemptId()) {
            return null;
        }
        this.taskAttemptId = convertFromProtoFormat(p.getAttemptId());
        return this.taskAttemptId;
    }

    @Override
    public void setAttemptId(TaskAttemptId attemptId) {
        maybeInitBuilder();
        if (attemptId == null)
            builder.clearAttemptId();
        this.taskAttemptId = attemptId;
    }
    @Override
    public TaskAttemptSendEventStatus getStatus() {
        TaskAttemptSendEventProtoOrBuilder p = viaProto ? proto : builder;
        if (!p.hasStatus()) {
            return null;
        }
        return convertFromProtoFormat(p.getStatus());
    }

    @Override
    public void setStatus(TaskAttemptSendEventStatus status) {
        maybeInitBuilder();
        if (status == null) {
            builder.clearStatus();
            return;
        }
        builder.setStatus(convertToProtoFormat(status));
    }
    @Override
    public String getMapOutputServerAddress() {
        TaskAttemptSendEventProtoOrBuilder p = viaProto ? proto : builder;
        if (!p.hasMapOutputServerAddress()) {
            return null;
        }
        return (p.getMapOutputServerAddress());
    }

    @Override
    public void setMapOutputServerAddress(String mapOutputServerAddress) {
        maybeInitBuilder();
        if (mapOutputServerAddress == null) {
            builder.clearMapOutputServerAddress();
            return;
        }
        builder.setMapOutputServerAddress((mapOutputServerAddress));
    }
    @Override
    public int getAttemptRunTime() {
        TaskAttemptSendEventProtoOrBuilder p = viaProto ? proto : builder;
        return (p.getAttemptRunTime());
    }

    @Override
    public void setAttemptRunTime(int attemptRunTime) {
        maybeInitBuilder();
        builder.setAttemptRunTime((attemptRunTime));
    }
    @Override
    public int getEventId() {
        TaskAttemptSendEventProtoOrBuilder p = viaProto ? proto : builder;
        return (p.getEventId());
    }

    @Override
    public void setEventId(int eventId) {
        maybeInitBuilder();
        builder.setEventId((eventId));
    }

    private TaskAttemptIdPBImpl convertFromProtoFormat(TaskAttemptIdProto p) {
        return new TaskAttemptIdPBImpl(p);
    }

    private TaskAttemptIdProto convertToProtoFormat(TaskAttemptId t) {
        return ((TaskAttemptIdPBImpl)t).getProto();
    }

    private TaskAttemptSendEventStatusProto convertToProtoFormat(TaskAttemptSendEventStatus e) {
        return MRProtoUtils.convertToProtoFormathsl(e);
    }

    private TaskAttemptSendEventStatus convertFromProtoFormat(TaskAttemptSendEventStatusProto e) {
        return MRProtoUtils.convertFromProtoFormathsl(e);
    }


}
