package no.cantara.logback.ext.aws.cloudwatch;

import no.cantara.logback.ext.core.CommonEventAttributes;
import no.cantara.logback.ext.aws.AwsSupport;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;

public class CloudWatchAppender extends AbstractCloudWatchAppender<ILoggingEvent> {

    public CloudWatchAppender() {
        super();
    }

    protected CloudWatchAppender(AwsSupport awsSupport, Filter<ILoggingEvent> sdkLoggingFilter) {
        super(awsSupport, sdkLoggingFilter);
    }

    @Override
    protected CommonEventAttributes applyCommonEventAttributes(final ILoggingEvent event) {
        return new CommonEventAttributes() {
            @Override
            public String getThreadName() {
                return event.getThreadName();
            }

            @Override
            public long getTimeStamp() {
                return event.getTimeStamp();
            }
        };
    }
}
