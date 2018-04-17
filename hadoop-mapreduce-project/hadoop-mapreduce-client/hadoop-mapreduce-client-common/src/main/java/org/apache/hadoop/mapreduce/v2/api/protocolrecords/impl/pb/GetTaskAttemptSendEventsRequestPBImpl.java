package org.apache.hadoop.mapreduce.v2.api.protocolrecords.impl.pb;

import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetTaskAttemptSendEventsRequest;
import org.apache.hadoop.mapreduce.v2.api.records.JobId;
import org.apache.hadoop.mapreduce.v2.api.records.impl.pb.JobIdPBImpl;
import org.apache.hadoop.mapreduce.v2.proto.MRProtos.JobIdProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetTaskAttemptSendEventsRequestProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetTaskAttemptSendEventsRequestProtoOrBuilder;
import org.apache.hadoop.yarn.api.records.impl.pb.ProtoBase;

/**
 * Created by HeShulin on 2018/4/11.
 */
public class GetTaskAttemptSendEventsRequestPBImpl extends ProtoBase<GetTaskAttemptSendEventsRequestProto> implements GetTaskAttemptSendEventsRequest {
    GetTaskAttemptSendEventsRequestProto proto = GetTaskAttemptSendEventsRequestProto.getDefaultInstance();
    GetTaskAttemptSendEventsRequestProto.Builder builder = null;

    boolean viaProto = false;

    private JobId jobId = null;

    public GetTaskAttemptSendEventsRequestPBImpl(GetTaskAttemptSendEventsRequestProto proto) {
        this.proto = proto;
        viaProto = true;
    }

    @Override
    public GetTaskAttemptSendEventsRequestProto getProto() {
        mergeLocalToProto();
        proto = viaProto ? proto : builder.build();
        viaProto = true;
        return proto;
    }

    private void mergeLocalToBuilder() {
        if (this.jobId != null) {
            builder.setJobId(convertToProtoFormat(this.jobId));
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
            builder = GetTaskAttemptSendEventsRequestProto.newBuilder(proto);
        }
        viaProto = false;
    }


    @Override
    public JobId getJobId() {
        GetTaskAttemptSendEventsRequestProtoOrBuilder p = viaProto ? proto : builder;
        if (this.jobId != null) {
            return this.jobId;
        }
        if (!p.hasJobId()) {
            return null;
        }
        this.jobId = convertFromProtoFormat(p.getJobId());
        return this.jobId;
    }
    @Override
    public void setJobId(JobId jobId) {
        maybeInitBuilder();
        if (jobId == null)
            builder.clearJobId();
        this.jobId = jobId;
    }
    @Override
    public int getFromEventId() {
        GetTaskAttemptSendEventsRequestProtoOrBuilder p = viaProto ? proto : builder;
        return (p.getFromEventId());
    }
    @Override
    public void setFromEventId(int fromEventId) {
        maybeInitBuilder();
        builder.setFromEventId((fromEventId));
    }

    @Override
    public int getMaxEvents() {
        GetTaskAttemptSendEventsRequestProtoOrBuilder p = viaProto ? proto : builder;
        return (p.getMaxEvents());
    }


    @Override
    public void setMaxEvents(int maxEvents) {
        maybeInitBuilder();
        builder.setMaxEvents((maxEvents));
    }

    private JobIdPBImpl convertFromProtoFormat(JobIdProto p) {
        return new JobIdPBImpl(p);
    }

    private JobIdProto convertToProtoFormat(JobId t) {
        return ((JobIdPBImpl)t).getProto();
    }

}
