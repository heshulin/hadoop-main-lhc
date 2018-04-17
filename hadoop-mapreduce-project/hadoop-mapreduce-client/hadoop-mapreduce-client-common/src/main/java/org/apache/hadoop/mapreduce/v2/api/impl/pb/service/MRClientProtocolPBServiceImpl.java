/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.mapreduce.v2.api.impl.pb.service;

import java.io.IOException;

import org.apache.hadoop.mapreduce.v2.api.protocolrecords.*;
import org.apache.hadoop.mapreduce.v2.api.MRClientProtocol;
import org.apache.hadoop.mapreduce.v2.api.MRClientProtocolPB;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.impl.pb.*;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.impl.pb.GetTaskAttemptSendEventsRequestPBImpl;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.impl.pb.GetTaskAttemptSendEventsResponsePBImpl;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.FailTaskAttemptRequestProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.FailTaskAttemptResponseProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetCountersRequestProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetCountersResponseProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetDiagnosticsRequestProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetDiagnosticsResponseProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetJobReportRequestProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetJobReportResponseProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetTaskAttemptSendEventsRequestProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetTaskAttemptSendEventsResponseProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetTaskAttemptCompletionEventsRequestProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetTaskAttemptCompletionEventsResponseProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetTaskAttemptReportRequestProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetTaskAttemptReportResponseProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetTaskReportRequestProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetTaskReportResponseProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetTaskReportsRequestProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.GetTaskReportsResponseProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.KillJobRequestProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.KillJobResponseProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.KillTaskAttemptRequestProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.KillTaskAttemptResponseProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.KillTaskRequestProto;
import org.apache.hadoop.mapreduce.v2.proto.MRServiceProtos.KillTaskResponseProto;
import org.apache.hadoop.security.proto.SecurityProtos.CancelDelegationTokenRequestProto;
import org.apache.hadoop.security.proto.SecurityProtos.CancelDelegationTokenResponseProto;
import org.apache.hadoop.security.proto.SecurityProtos.GetDelegationTokenRequestProto;
import org.apache.hadoop.security.proto.SecurityProtos.GetDelegationTokenResponseProto;
import org.apache.hadoop.security.proto.SecurityProtos.RenewDelegationTokenRequestProto;
import org.apache.hadoop.security.proto.SecurityProtos.RenewDelegationTokenResponseProto;
import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;

public class MRClientProtocolPBServiceImpl implements MRClientProtocolPB {

  private MRClientProtocol real;
  
  public MRClientProtocolPBServiceImpl(MRClientProtocol impl) {
    this.real = impl;
  }
  
  @Override
  public GetJobReportResponseProto getJobReport(RpcController controller,
      GetJobReportRequestProto proto) throws ServiceException {
    GetJobReportRequestPBImpl request = new GetJobReportRequestPBImpl(proto);
    try {
      GetJobReportResponse response = real.getJobReport(request);
      return ((GetJobReportResponsePBImpl)response).getProto();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetTaskReportResponseProto getTaskReport(RpcController controller,
      GetTaskReportRequestProto proto) throws ServiceException {
    GetTaskReportRequest request = new GetTaskReportRequestPBImpl(proto);
    try {
      GetTaskReportResponse response = real.getTaskReport(request);
      return ((GetTaskReportResponsePBImpl)response).getProto();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetTaskAttemptReportResponseProto getTaskAttemptReport(
      RpcController controller, GetTaskAttemptReportRequestProto proto)
      throws ServiceException {
    GetTaskAttemptReportRequest request = new GetTaskAttemptReportRequestPBImpl(proto);
    try {
      GetTaskAttemptReportResponse response = real.getTaskAttemptReport(request);
      return ((GetTaskAttemptReportResponsePBImpl)response).getProto();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetCountersResponseProto getCounters(RpcController controller,
      GetCountersRequestProto proto) throws ServiceException {
    GetCountersRequest request = new GetCountersRequestPBImpl(proto);
    try {
      GetCountersResponse response = real.getCounters(request);
      return ((GetCountersResponsePBImpl)response).getProto();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetTaskAttemptCompletionEventsResponseProto getTaskAttemptCompletionEvents(
      RpcController controller,
      GetTaskAttemptCompletionEventsRequestProto proto)
      throws ServiceException {
    GetTaskAttemptCompletionEventsRequest request = new GetTaskAttemptCompletionEventsRequestPBImpl(proto);
    try {
      GetTaskAttemptCompletionEventsResponse response = real.getTaskAttemptCompletionEvents(request);
      return ((GetTaskAttemptCompletionEventsResponsePBImpl)response).getProto();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetTaskAttemptSendEventsResponseProto getTaskAttemptSendEvents(
          RpcController controller,
          GetTaskAttemptSendEventsRequestProto proto)
          throws ServiceException {
    GetTaskAttemptSendEventsRequest request = new GetTaskAttemptSendEventsRequestPBImpl(proto);

    try {
      GetTaskAttemptSendEventsResponse response = real.getTaskAttemptSendEvents(request);
      return ((GetTaskAttemptSendEventsResponsePBImpl)response).getProto();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetTaskReportsResponseProto getTaskReports(RpcController controller,
      GetTaskReportsRequestProto proto) throws ServiceException {
    GetTaskReportsRequest request = new GetTaskReportsRequestPBImpl(proto);
    try {
      GetTaskReportsResponse response = real.getTaskReports(request);
      return ((GetTaskReportsResponsePBImpl)response).getProto();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetDiagnosticsResponseProto getDiagnostics(RpcController controller,
      GetDiagnosticsRequestProto proto) throws ServiceException {
    GetDiagnosticsRequest request = new GetDiagnosticsRequestPBImpl(proto);
    try {
      GetDiagnosticsResponse response = real.getDiagnostics(request);
      return ((GetDiagnosticsResponsePBImpl)response).getProto();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }
  
  @Override
  public GetDelegationTokenResponseProto getDelegationToken(
      RpcController controller, GetDelegationTokenRequestProto proto)
      throws ServiceException {
    GetDelegationTokenRequest request = new GetDelegationTokenRequestPBImpl(proto);
    try {
      GetDelegationTokenResponse response = real.getDelegationToken(request);
      return ((GetDelegationTokenResponsePBImpl)response).getProto();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }
  
  @Override
  public KillJobResponseProto killJob(RpcController controller,
      KillJobRequestProto proto) throws ServiceException {
    KillJobRequest request = new KillJobRequestPBImpl(proto);
    try {
      KillJobResponse response = real.killJob(request);
      return ((KillJobResponsePBImpl)response).getProto();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public KillTaskResponseProto killTask(RpcController controller,
      KillTaskRequestProto proto) throws ServiceException {
    KillTaskRequest request = new KillTaskRequestPBImpl(proto);
    try {
      KillTaskResponse response = real.killTask(request);
      return ((KillTaskResponsePBImpl)response).getProto();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public KillTaskAttemptResponseProto killTaskAttempt(RpcController controller,
      KillTaskAttemptRequestProto proto) throws ServiceException {
    KillTaskAttemptRequest request = new KillTaskAttemptRequestPBImpl(proto);
    try {
      KillTaskAttemptResponse response = real.killTaskAttempt(request);
      return ((KillTaskAttemptResponsePBImpl)response).getProto();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public FailTaskAttemptResponseProto failTaskAttempt(RpcController controller,
      FailTaskAttemptRequestProto proto) throws ServiceException {
    FailTaskAttemptRequest request = new FailTaskAttemptRequestPBImpl(proto);
    try {
      FailTaskAttemptResponse response = real.failTaskAttempt(request);
      return ((FailTaskAttemptResponsePBImpl)response).getProto();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }
  
  @Override
  public RenewDelegationTokenResponseProto renewDelegationToken(
      RpcController controller, RenewDelegationTokenRequestProto proto)
      throws ServiceException {
    RenewDelegationTokenRequestPBImpl request =
        new RenewDelegationTokenRequestPBImpl(proto);
      try {
        RenewDelegationTokenResponse response = real.renewDelegationToken(request);
        return ((RenewDelegationTokenResponsePBImpl)response).getProto();
      } catch (IOException e) {
        throw new ServiceException(e);
      }
  }

  @Override
  public CancelDelegationTokenResponseProto cancelDelegationToken(
      RpcController controller, CancelDelegationTokenRequestProto proto)
      throws ServiceException {
    CancelDelegationTokenRequestPBImpl request =
        new CancelDelegationTokenRequestPBImpl(proto);
      try {
        CancelDelegationTokenResponse response = real.cancelDelegationToken(request);
        return ((CancelDelegationTokenResponsePBImpl)response).getProto();
      } catch (IOException e) {
        throw new ServiceException(e);
      }
  }
  
}
