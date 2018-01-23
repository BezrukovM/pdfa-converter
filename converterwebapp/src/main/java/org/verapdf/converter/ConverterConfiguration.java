package org.verapdf.converter;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class ConverterConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty("tempDir")
    private String tempDir;
    @NotEmpty
    @JsonProperty("officeDir")
    private String officeDir;
    @NotEmpty
    @JsonProperty("veraPDFPath")
    private String veraPDFPath;

    public ConverterConfiguration() {
    }

    public String getTempDir() {
        return tempDir;
    }

    public void setTempDir(String tempDir) {
        this.tempDir = tempDir;
    }

    public String getOfficeDir() {
        return officeDir;
    }

    public void setOfficeDir(String officeDir) {
        this.officeDir = officeDir;
    }

    public String getVeraPDFPath() {
        return veraPDFPath;
    }

    public void setVeraPDFPath(String veraPDFPath) {
        this.veraPDFPath = veraPDFPath;
    }
}
