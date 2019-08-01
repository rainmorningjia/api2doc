package com.alibaba.api2doc.config;

import com.aliyun.openservices.aliyun.log.producer.Callback;
import com.aliyun.openservices.aliyun.log.producer.Result;
import com.aliyun.openservices.log.common.LogItem;

import java.util.List;

/**
 * Created by brucewu on 2018/1/5.
 */
public class LoghubAppenderCallback<E> implements Callback {

    protected LoghubAppender<E> loghubAppender;

    protected String project;

    protected String logstore;

    protected String topic;

    protected String source;

    protected List<LogItem> logItems;

    public LoghubAppenderCallback(LoghubAppender<E> loghubAppender, String project, String logstore, String topic,
                                  String source, List<LogItem> logItems) {
        super();
        this.loghubAppender = loghubAppender;
        this.project = project;
        this.logstore = logstore;
        this.topic = topic;
        this.source = source;
        this.logItems = logItems;
    }

    @Override
    public void onCompletion(Result result) {
        if (!result.isSuccessful()) {
            loghubAppender.addError(
                    "Failed to send log, project=" + project
                            + ", logStore=" + logstore
                            + ", topic=" + topic
                            + ", source=" + source
                            + ", logItem=" + logItems
                            + ", errorCode=" + result.getErrorCode()
                            + ", errorMessage=" + result.getErrorMessage());
        }
    }
}