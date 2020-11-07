package com.example.healthcare.RetrofitModel; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelPrescriptions {

    @SerializedName("prescriptionId")
    @Expose
    private Integer prescriptionId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("doctorName")
    @Expose
    private String doctorName;

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

}