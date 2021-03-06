package io.jenkins.plugins.servicenow.parameter;

import hudson.model.StringParameterValue;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

public class ServiceNowParameterValue extends StringParameterValue {

    private static final long serialVersionUID = 1327354888410861686L;

    public ServiceNowParameterValue(String name, String value) {
        super(name, value);
    }

    public String getCredentialsForPublishedApp() {
        return (String) JSONObject.fromObject(this.value).get("credentialsForPublishedApp");
    }

    public String getInstanceForPublishedAppUrl() {
        return (String) JSONObject.fromObject(this.value).get("instanceForPublishedAppUrl");
    }

    public String getCredentialsForInstalledApp() {
        return (String) JSONObject.fromObject(this.value).get("credentialsForInstalledApp");
    }

    public String getInstanceForInstalledAppUrl() {
        return (String) JSONObject.fromObject(this.value).get("instanceForInstalledAppUrl");
    }

    public String getSysId() {
        return (String) JSONObject.fromObject(this.value).get("sysId");
    }

    public String getAppScope() {
        return (String) JSONObject.fromObject(this.value).get("appScope");
    }

    public String getPublishedAppVersion() {
        return (String) JSONObject.fromObject(this.value).get("publishedAppVersion");
    }

    public String getRollbackAppVersion() {
        return (String) JSONObject.fromObject(this.value).get("rollbackAppVersion");
    }

    public Integer getProgressCheckInterval() {
        try {
            return Integer.parseInt(JSONObject.fromObject(this.value).getString("progressCheckInterval"));
        } catch(NumberFormatException | JSONException ex) {
        }
        return null;
    }

    public String getDescription() {
        String paramName = "description";
        return JSONObject.fromObject(this.value).has(paramName) ? JSONObject.fromObject(this.value).getString(paramName) : StringUtils.EMPTY;
    }
}
