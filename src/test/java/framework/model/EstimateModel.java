package framework.model;

public class EstimateModel {
    private String numberOfInstances;
    private String operatingSystemOrSoftware;
    private String virtualMachineClass;
    private String machineType;
    private String addGPUs;
    private String numberOfGPUs;
    private String GPUType;
    private String localSSD;
    private String dataCenterLocation;
    private String committedUsage;
    private String estimatedTotalCost;

    public EstimateModel(String numberOfInstances, String operatingSystemOrSoftware,
                         String virtualMachineClass, String machineType, String addGPUs,
                         String numberOfGPUs, String GPUType, String localSSD,
                         String dataCenterLocation, String committedUsage,
                         String estimatedTotalCost) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystemOrSoftware = operatingSystemOrSoftware;
        this.virtualMachineClass = virtualMachineClass;
        this.machineType = machineType;
        this.addGPUs = addGPUs;
        this.numberOfGPUs = numberOfGPUs;
        this.GPUType = GPUType;
        this.localSSD = localSSD;
        this.dataCenterLocation = dataCenterLocation;
        this.committedUsage = committedUsage;
        this.estimatedTotalCost = estimatedTotalCost;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getOperatingSystemOrSoftware() {
        return operatingSystemOrSoftware;
    }

    public String getVirtualMachineClass() {
        return virtualMachineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getValueOfAddGPUsCheckbox() {
        return addGPUs;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getGPUType() {
        return GPUType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public String getEstimatedTotalCost() {
        return estimatedTotalCost;
    }
}