package framework.service;

import framework.model.EstimateModel;

public class EstimateCreator {
    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.number.instances";
    public static final String TESTDATA_OPERATING_SYSTEM_OR_SOFTWARE = "testdata.operating.system";
    public static final String TESTDATA_VIRTUAL_MACHINE_CLASS = "testdata.machine.class";
    public static final String TESTDATA_MACHINE_TYPE = "testdata.machine.type";
    public static final String TESTDATA_ADD_GPUS = "testdata.add.gpus";
    public static final String TESTDATA_NUMBER_OF_GPUS = "testdata.number.gpus";
    public static final String TESTDATA_GPU_TYPE = "testdata.gpu.type";
    public static final String TESTDATA_LOCAL_SSD = "testdata.local.ssd";
    public static final String TESTDATA_DATACENTER_LOCATION = "testdata.datacenter.location";
    public static final String TESTDATA_COMMITTED_USAGE = "testdata.committed.usage";
    public static final String TESTDATA_ESTIMATED_TOTAL_COST_USD = "testdata.total.cost.usd";

    public static EstimateModel createEstimateModelWithDataFromProperty() {
        return new EstimateModel(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM_OR_SOFTWARE),
                TestDataReader.getTestData(TESTDATA_VIRTUAL_MACHINE_CLASS),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
                TestDataReader.getTestData(TESTDATA_ADD_GPUS),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE),
                TestDataReader.getTestData(TESTDATA_ESTIMATED_TOTAL_COST_USD));
    }
}