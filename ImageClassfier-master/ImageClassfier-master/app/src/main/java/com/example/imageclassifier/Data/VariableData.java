package com.example.imageclassifier.Data;

import java.io.Serializable;

public class VariableData implements Serializable {
    private String variableName;
    private Integer variableData;

    public void setVariableName(String name){
        this.variableName = name;
    }

    public void setVariableData(Integer data){
        this.variableData = data;
    }

    public String getVariableName(){
        return variableName;
    }

    public Integer getVariableData(){
        return variableData;
    }
}
