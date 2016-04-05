package no.andeero.logback.ext.aws.cloudwatch;

import no.andeero.logback.ext.aws.AwsSupport;
import no.andeero.logback.ext.core.CommonEventAttributes;
import ch.qos.logback.access.spi.IAccessEvent;
import ch.qos.logback.core.filter.Filter;

public class CloudWatchAccessAppender extends AbstractCloudWatchAppender<IAccessEvent> {

    public CloudWatchAccessAppender() {
        super();
    }

    protected CloudWatchAccessAppender(AwsSupport awsSupport, Filter<IAccessEvent> sdkLoggingFilter) {
        super(awsSupport, sdkLoggingFilter);
    }

    @Override
    protected CommonEventAttributes applyCommonEventAttributes(final IAccessEvent event) {
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
