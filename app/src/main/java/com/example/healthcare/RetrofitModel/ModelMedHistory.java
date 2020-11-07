 package com.example.healthcare.RetrofitModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelMedHistory {

    @SerializedName("prescriptionsAll")
    @Expose
    private List<ModelPrescriptions> prescriptionsAll = null;

    public List<ModelPrescriptions> getPrescriptionsAll() {
        return prescriptionsAll;
    }

    public void setPrescriptionsAll(List<ModelPrescriptions> prescriptionsAll) {
        this.prescriptionsAll = prescriptionsAll;
    }

}


